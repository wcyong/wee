(function($, window){
	var _count = 0;
	var MyDialog = {
		init: function(el, options, ok, cancel) {
			var that = this;
			options = options || {};
			//如果参数为文本或者html节点，则重构options并赋值content
			if(typeof options === "string" || options.nodeType === 1) {
				options = {content : options}
			}
			//合并默认配置
			that.options = $.extend(true, {}, $.fn.mydialog.options,options);
			
			that.initProp();
			that.dom = that.initDom();
			
			var _expando = "auk-dialog" + +new Date;
			//初始化id
			that.options.id = that.options.id || _expando + _count;
			//加入list容器，并给全局接口赋值
			var api = that.list[that.options.id];
			
			//若当前调用的对话框已经在接口中存在 把焦点设置在对话框上
			if(api) {
				return that.zIndex().focus();
			}
			
			 //按钮组
		    if (!$.isArray(that.options.button)) {
		        that.options.button = [];
		    }
		    //确定按钮
		    if (ok !== undefined) {
		        that.options.ok = ok;
		    }
		    if (that.options.ok) {
		    	that.options.button.push({
		    		id: that.options.id + "_btnOk",
		            name: that.options.okVal,
		            callback: function(){
		        		var back = that.options.ok;
		            	if(typeof that.options.ok==='function'){
		            		back = that.options.ok.apply(this,arguments);
		            	}
		            	if(back!==false) {
		            		that.close();
						}          		
		        	},
		            className: "btn btn-ensure icofont-share-alt btn-sm"
		        });
		    }
		    // 取消按钮
		    if (cancel !== undefined) {
		        that.options.cancel = cancel;
		    }
		    if (that.options.cancel) {
		    	that.options.button.push({
		    		id: that.options.id + "_btnCancel",
		    		name: that.options.cancelVal,
		    		callback: function(){
	            		var back = that.options.cancel;
		            	if(typeof that.options.cancel==='function'){
		            		back = that.options.cancel.apply(this,arguments);
		            	}
		            	
		            	if(back!==false) {
							that.close();
						}          		
	            	},
	            	className: "btn btn-cancel icofont-remove btn-sm"
		        });
		    }
		    
		    /*计数器用于生成随机ID*/
		    _count++;
		    return that.list[that.options.id] = that.create(that.options);
		    
		},
		//创建对话框
		create: function(options) {
			var that = this;
			var wrap = that.dom.wrap;
			var initShow = that.options.show;
			var $body = $("body");
			wrap.on("show.bs.modal", function() {
				/* 锁屏  防止未提前设置居中属性 导致对话框出现时拖屏BUG
            	 * 预先计算一个居中位置放置滚动条拖屏
            	 * 同时设置一个锁屏CSS取消滚动条
            	 */
				that.setPos();
			});
			if($body.is(".modal-open")!=true) {
				$body.addClass("modal-open");
			}
			wrap.on("shown.bs.modal", function() {
				wrap.hide();
				//设置层级
				that.zIndex();
				//设置对话框焦点
				that.focus();
				/*获得层级*/
                var zIndex = parseInt(wrap.css("zIndex"));
                /*设置遮罩层级*/
                $("div.modal-backdrop[pid='" + wrap.attr("id") + "']").css("zIndex", zIndex - 1);
                /*初始化执行 自定义init回调方法*/
                that.options.init && that.options.init.call(that);
                /* 此处内容才加载完成（init方法可能添加元素）
                 * 重新设置居中、设置显示、 执行显示完成回调
                 * 非iframe对话框都在这里完成操作
                 * iframe对话框由iframe自身load事件处理完成
                 */
                if (that.options.isIframe != true) {
                	that.setPos();
                	wrap.show();
                	/*初始化执行 自定义 显示完成回调方法*/
                	that.options.shown && that.options.shown.call(that);
                }
			});
			wrap.on('hide.bs.modal', function() {
            	/*移除自身遮罩*/
            	$("div.modal-backdrop[pid='" + wrap.attr("id") + "']").remove();
            	/*若页面已无显示的对话框并且全局body存在锁屏样式执行移除锁屏样式*/
            	if($body.is(".modal-open")==true && $("div.modal-backdrop[pid]").length>0)
            		$body.removeClass("modal-open");
            });
            wrap.modal({show: initShow});
		},
		//设置位置居中
		setPos: function() {
			var that = this;
			console.log(that.dom);
		},
		//初始化属性
		initProp: function() {
			var that = this;
			//全局对话框容器
			that.list = {};
			that.focus = null;
			/*对话框模板*/
			that.template =
		        	  "<div name='modal-dialog' class=\"modal-dialog\">"
		            + 		"<div name='modal-header' class='modal-header modal-blue'>"
		            + 			"<button name='modal-closeBtn' type='button' class='close' data-dismiss='modal'>"
		            +				"<i class=\"icofont-remove white font-18\"></i>" +
		            +			"</button>"
		            + 			"<h3 name='modal-title' class=\"white\" ></h3>"
		            + 		"</div>"
		            + 		"<div name='modal-dialogShadow'>"
		            + 			"<div name='modal-body' class='modal-body'></div>"
		            + 			"<div name='modal-footer' class='modal-footer'></div>"
		            + 		"</div>"
		            + "</div>";
		},
		//对话框元素属性样式初始化,并返回元素
		initDom: function() {
			var that = this;
			var id = (Math.random() * 90000 | 0 + 10000) + "_auk-Dialog";
			var $template = $(that.template);
			$template.attr("class", "modal fade");
			$template.attr("role", "dialog");
			$template.attr("aria-labelledby", "myModalLabel");
			$template.attr("data-backdrop", "static");
            $template.attr("tabindex", that.options.zIndex);
            $template.attr("aria-hidden", true);
            $template.attr("id", id);
            $template.find("[name='modal-header']").attr("id", id + "_header");
            $template.find("[name='modal-title']").attr("id", id + "_title");
            $template.find("[name='modal-body']").attr("id", id + "_body");
            $template.find("[name='modal-footer']").attr("id", id + "_footer");
            
            var dom = {wrap: $template, dialog: $template, close: $template.find(".close")};
            var els = $template.find("[name]");
            var elsLen = els.length;
            
            /*动态塞入dom对象*/
            for (var i = 0; i < elsLen; i++) {
                var name = $(els[i]).attr("name").split("modal-")[1];
                if (name) {
                	dom[name] = $(els[i]);
                }
            }
            return dom;
		},
		//置顶对话框
		zIndex: function() {
			var that = this;
			var index = that.options.zIndex;
			var wrap = that.dom;
			//对话框层级置顶
			wrap.css("zIndex", index + 1);
			//对象目标 设置为对话框
			that.focus = that;
			return that;
		},
		//设置焦点
		focus: function() {
			var that = this;
			//IE对不可见元素设置焦点会报错
            try {
                if (that.options.focus) {
                    var elem = that._focus && that._focus[0] || that.DOM.close[0];
                    elem && elem.focus();
                }
            } catch (e) {
            }
            return this;
		}
	};
	
	$.fn.mydialog = function(options, ok, cancel) {
		var md = Object.create(MyDialog);
		md.init(this, options, ok, cancel);
	};
	
	//对话框默认属性
	$.fn.mydialog.options = {
		//对话框标题
		title: "消息",
		//对话框内容
		content: "<div class='auk-dialog-content'></div>",
		//对话框关闭按钮
		tipsBtn: true,
		//自定义按钮
		button: null,
		//确定按钮回调函数
		ok: null,
		//取消按钮回调函数
		cancel: null,
		//对话框初始化后执行的函数
		init: null,
		//初始化后是否显示对话框
		show: true,
		//对话框显示后执行的函数
		shown: null,
		//对话框关闭前执行的函数
		close: null,
		//确定按钮文本. 默认"确定"
		okVal: "确定",
		//取消按钮文本. 默认"取消"
		cancelVal: "取消",
		//内容宽度
		width: "auto",
		//内容高度
		height: "auto",
		//最小宽度
		minWidth: 96,
		//最小上高度
		minHeight: 32,
		//对话框自定义className
		skin: '',
		//是否是iframe对话框
		isIframe: false,
		//是否按键监听
		keyboard: false,
		//对话框叠加高度值(重要：此值不能超过浏览器最大限制)
		zIndex: 2000,
		//是否包含页脚
		foot: true,
		//是否允许调节尺寸
		resize: false,
		//是否允许拖动位置
		drag: true
	};
	
	//将对话框存储于window中
	window.mydialog = $.mydialog = $.fn.mydialog;
	
})(jQuery, window);