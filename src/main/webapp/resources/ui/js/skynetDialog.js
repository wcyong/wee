/*
 * skynetDialog  
 * 基于artDialog  使用成BootStrap模态对话框对其进行扩展和改造
 * Copyright (c) 2014 S_Autumn
 *
 * Licensed same as jquery - MIT License
 * http://www.opensource.org/licenses/mit-license.php
 *
 * email: magic_devil.@163.com
 * Date: 2014-12-27
 */
;(function ($, window) {
    var _box, _count = 0, _expando = "skynetDialog" + +new Date;
    var skynetDialog = function (config, ok, cancel) {
        var api, defaults = skynetDialog.defaults;
        config = config || {};
        /*若参数为文本或者html节点则重构config并赋值其content属性*/
        if (typeof config === "string" || config.nodeType === 1) {
            config = {content: config};
        }
        console.log(dom);
        /*初始化id*/
        config.id = config.id || _expando + _count;
        /*加入list容器，并给全局接口赋值，方便后续管理调用*/
        api = skynetDialog.list[config.id];
        console.log(this.api);
        /*若当前调用的对话框已经在接口中存在 把焦点设置在对话框上*/
        if (api) return api.zIndex().focus();
        /*合并默认配置*/
        for (var i in defaults) {
            if (config[i] === undefined) config[i] = defaults[i];
        }
        /*按钮队列 （若只写1个按钮拼装成数组）*/
        if (!$.isArray(config.button)) config.button = config.button ? [config.button] : [];
        /*确定按钮*/
        if (ok !== undefined) config.ok = ok;
        /*取消按钮*/
        if (cancel !== undefined) config.cancel = cancel;
        /*加入队列*/
        config.ok && config.button.push({
            id: config.id + "_btnOk",
            name: config.okVal,
            callback: function(){
        		var back=config.ok;
            	if(typeof config.ok==='function' ){
            		back=config.ok.apply(this,arguments);
            	}
            	
            	if(back!==false) {
					this.close();
				}          		
        	},
            className: "btn btn-ensure icofont-share-alt btn-sm"
        });
        config.cancel && config.button.push({
            id: config.id + "_btnCancel",
            name: config.cancelVal,
            callback: function(){
            		var back=config.cancel;
	            	if(typeof config.cancel==='function' ){
	            		back=config.cancel.apply(this,arguments);
	            	}
	            	
	            	if(back!==false) {
						this.close();
					}          		
            	},
            className: "btn btn-cancel icofont-remove btn-sm"
        });
        /*计数器用于生成随机ID*/
        _count++;
        /*若对话框对象存在  则重置属性事件 继续使用该对象，否则新new一个*/
        return skynetDialog.list[config.id] = _box ? _box._init(config) : new skynetDialog.fn._init(config);
    };

    skynetDialog.fn = skynetDialog.prototype = {
        /**
         * 对话框元素属性样式初始化 并返回元素
         */
        _getDOM: function () {
            var that = this;
            var id = (Math.random() * 90000 | 0 + 10000) + "_skynetDialog";
            var wrap = $(skynetDialog._templates);
            $(wrap).attr("class", "modal fade");
            $(wrap).attr("role", "dialog");
            $(wrap).attr("aria-labelledby", "myModalLabel");
            $(wrap).attr("data-backdrop", "static");
            $(wrap).attr("tabindex", that.config.zIndex);
            $(wrap).attr("aria-hidden", true);
            $(wrap).attr("id", id);
            $(wrap).find("[name='modal-header']").attr("id", id + "_header");
            $(wrap).find("[name='modal-title']").attr("id", id + "_title");
            $(wrap).find("[name='modal-body']").attr("id", id + "_body");
            $(wrap).find("[name='modal-footer']").attr("id", id + "_footer");
            var name,
                DOM = {wrap: $(wrap), dialog: $(wrap), close: $(wrap).find(".close")},
                els = $(wrap).find("[name]"),
                elsLen = els.length;
            /*动态塞入DOM对象*/
            for (var i = 0; i < elsLen; i++) {
                name = $(els[i]).attr("name").split("modal-")[1];
                if (name) DOM[name] = $(els[i]);
            }
            return DOM;
        },
        /**
         * 初始化
         */
        _init: function (config) {
            var that = this, DOM;
            that.closed = false;
            /*获得属性*/
            that.config = config;
            /*获得整个对话框元素对象*/
            that.DOM = DOM = that.DOM || that._getDOM();
            /*获得按钮*/
            that.button(config.button);
            /*获得对话框-标题旁边的关闭按钮*/
            that.tipsBtn(config.tipsBtn);
            /*获得对话框-标题*/
            that.title(config.title);
            /*获得对话框-内容*/
            that.content(config.content, true);
            /*获得对话框-脚*/
            that.foot(config.foot);
            /*设置对话框-大小*/
            that.size(config.width, config.height);
            /*绑定对话框事件*/
            that._addEvent();
            /*清空全局 变量初始化后不能重用*/
            _box = null;
            /*创建对话框*/
            that.create();
            return that;
        },
        /**
         * 设置内容
         * @param    {String, HTMLElement}    内容 (可选)
         * @return    {this, HTMLElement}        如果无参数则返回内容容器DOM对象
         */
        content: function (msg) {
            var that = this,
                DOM = that.DOM,
                $content = DOM.body,
                content = $content[0];
            /*有内容是文字直接innner内容，内容是Dom元素append*/
            if (msg === undefined) return content;
            if (typeof msg === "string") {
                $content.html(msg);
            } else if (msg && msg.nodeType === 1) {
                $content.html(msg);
                msg.style.display = "block";
            }
            return that;
        },
        /**
         * 设置标题按钮
         * @param    {Boolean}    标题按钮. 为false则隐藏标题栏关闭按钮
         */
        tipsBtn: function (flag) {
            var DOM = this.DOM,
                tipsBtn = DOM.closeBtn;
            if (flag === false) {
                tipsBtn.hide();
            } else {
                tipsBtn.show();
            }
            return this;
        },
        /**
         * 设置标题
         * @param    {String}    标题内容. 为false则隐藏标题栏
         * @return    {this, HTMLElement}    如果无参数则返回内容器DOM对象
         */
        title: function (text) {
            var DOM = this.DOM,
                title = DOM.title;
            if (text === undefined) return title[0];
            if (text === false) {
                title.hide().html("");
            } else {
                title.show().html(text || " ");
            }
            return this;
        },
        /**
         * 设置页脚
         * 容器容纳 Buttons队列中的Button
         */
        foot: function (flag) {
            var that = this, DOM = that.DOM;
            if (flag === false) {
                DOM.footer.remove();
            } else if (flag && flag.nodeType === 1) {
                DOM.footer.append(flag);
                flag.style.display = "block";
            }
        },
        /**
         * 自定义按钮
         * @example
         button({
					id 		  : config.id+"_btnOk",
					name      : config.okVal,
					callback  : config.ok,
					className : "btn btn-blue btn-sm"
				}, .., ..)
         */
        button: function () {
            var that = this,
                ags = arguments,
                DOM = that.DOM,
                buttons = DOM.footer,
                elem = buttons[0],
                listeners = that._listeners = that._listeners || {},
                list = $.isArray(ags[0]) ? ags[0] : [].slice.call(ags);
            if (ags[0] === undefined) return elem;
            $.each(list, function (i, val) {
                /*伪监听器 若是新按钮初始化按钮加入listeners中，否则则从其中取 */
                var name = val.name,attr=val.attr,
                    isNewButton = !listeners[name],
                    button = !isNewButton ? listeners[name].elem : document.createElement("button");
                /*若是新按钮 加入监听器中*/
                if (!listeners[name]) listeners[name] = {};
                /*按钮参数加入监听器*/
                if (listeners[name]) listeners[name].params = val.params || {};
                /*按钮事件加入监听器*/
                if (val.callback) listeners[name].callback = val.callback;
                /*按钮样式*/
                if (val.className) button.className = val.className;
                /*给Button 设置type 保证兼容性*/
                button.setAttribute("type", "button");
                /*给Button 添加扩展属性*/
                if(!isEmpty(attr)){
                	for(var i in attr){
                		if(!isEmpty(i))
                		button.setAttribute(i, attr[i]);
                	}
                }
                /*根据将按钮对象绑定到元素上*/
                button[_expando + "callback"] = name;
                /*IE8以下的兼容性 一定要设置绝对不禁用*/
                button.disabled = !!val.disabled;
                /*若是新按钮*/
                if (isNewButton) {
                    /*按钮id*/
                    if (isEmpty(val.id)) val.id = Math.uuid();
                    button.id = val.id;
                    /*设置按钮显示文字*/
                    button.innerHTML = name;
                    /*整个按钮 加入监听器*/
                    listeners[name].elem = button;
                    /*加入footer*/
                    elem.appendChild(button);
                }
            });
            return that;
        },
        /**
         *    尺寸
         *    @param    {Number, String}    宽度
         *    @param    {Number, String}    高度
         */
        size: function (width, height) {
            var that = this,
                DOM = that.DOM,
                main = DOM.dialog,
                content = DOM.body,
                header = DOM.header,
                footer = DOM.footer,
                wWidth = window.innerWidth || Math.min(document.documentElement.clientWidth, document.body.clientWidth),
                wHeight = window.innerHeight || Math.min(document.documentElement.clientHeight, document.body.clientHeight),
                trueW = that.config.trueW,
                trueH = that.config.trueH;
            /*留白单偏移量*/
            var stapH = 35;
            /*头高度*/
            var headerHeight = 34;
            /*脚高度*/
            var footH = footer.height();
            if (that.config.foot === true && footH == 0)footH = 50;
            /*设置宽度*/
            if (width) {
                var maxW = wWidth - (stapH * 2);
                main.css({maxWidth: maxW, width: "auto"});
                if (typeof width === "number") {
                    trueW = Math.max(that.config.minWidth, width);
                    if (trueW > wWidth) {
                        trueW = wWidth;
                        trueW = (trueW - (stapH * 2)) > 0 ? (trueW - (stapH * 2)) : wWidth;
                    }
                    main.width(trueW);
                } else if (typeof width === "string") {
                    if (width.indexOf("modal") > -1) {
                        main.addClass(width);
                        if (width == "modal-xs") trueW = wWidth * 0.24;
                        if (width == "modal-sm") trueW = wWidth * 0.3;
                        if (width == "modal-md") trueW = wWidth * 0.5;
                        if (width == "modal-lg") trueW = wWidth * 0.7;
                        main.width(trueW);
                    } else if (width.indexOf("%") > -1) {
                        var tmp = parseInt(width) > 90 ? 90 : parseInt(width);
                        tmp = tmp < 0 ? 0 : tmp;
                        if (tmp > 0) {
                            main[0].style.width = wWidth * (tmp / 100) + "px";
                            trueW = wWidth * (tmp / 100);
                        }
                        main.width(trueW);
                    } else if (width.indexOf("px") > -1) {
                        trueW = parseInt(width) < 0 ? 0 : parseInt(width);
                        trueW = Math.max(that.config.minWidth, width);
                        if (trueW > wWidth) {
                            trueW = wWidth;
                            trueW = (trueW - (stapH * 2)) > 0 ? (trueW - (stapH * 2)) : wWidth;
                        }
                        main.width(trueW);
                    }
                }
            }
            /*设置高度*/
            if (height) {
                var maxH = wHeight - (stapH * 3) - headerHeight - footH;
                content.css({maxHeight: maxH, height: "auto"});
                if (typeof height === "number") {
                    trueH = Math.max(that.config.minHeight, height);
                    var mainH = headerHeight + trueH + footH;
                    trueH = (wHeight - (stapH * 2) - mainH) > 0 ? trueH : (wHeight - (stapH * 3) - headerHeight - footH);
                    content.height(trueH);
                } else if (typeof height === "string") {
                    if (height.indexOf("%") > -1) {
                        var tmp = parseInt(height) > 90 ? 90 : parseInt(height);
                        tmp = tmp < 0 ? 0 : tmp;
                        if (tmp > 0) {
                            content[0].style.height = wHeight * (tmp / 100) + "px";
                            trueH = wHeight * (tmp / 100);
                        }
                    } else if (height.indexOf("px") > -1) {
                        trueH = parseInt(height) < 0 ? 0 : parseInt(height);
                        trueH = Math.max(that.config.minHeight, trueH);
                        var mainH = headerHeight + trueH + footH;
                        trueH = (wHeight - (stapH * 2) - mainH) > 0 ? trueH : (wHeight - (stapH * 3) - headerHeight - footH);
                        content.height(trueH);
                    }
                }
            }
            that.config.trueW = trueW;
            that.config.trueH = trueH;
            return that;
        },
        /** 置顶对话框 */
        zIndex: function () {
            var that = this,
                DOM = that.DOM,
                wrap = DOM.wrap,
                top = skynetDialog.focus,
                index = skynetDialog.defaults.zIndex++;
            /*让对话框层级置顶*/
            wrap.css("zIndex", index + 1);
            /*对象目标 设置为对话框*/
            skynetDialog.focus = that;
            return that;
        },
        /**设置位置居中*/
        site: function () {
            var that = this,
                wrap = that.DOM.wrap,
                main = that.DOM.dialog,
                content = that.DOM.body,
                footer = that.DOM.footer,
                trueW = that.config.trueW,
                trueH = that.config.trueH,
                stapH = 35,
                headerHeight = 34,
                footH = footer.height(),
                wWidth = window.innerWidth || Math.min(document.documentElement.clientWidth, document.body.clientWidth),
                wHeight = window.innerHeight || Math.min(document.documentElement.clientHeight, document.body.clientHeight);
            if (that.config.foot === true && footH == 0)footH = 50;
            /*设置水平居中*/
            trueW = trueW <= 0 ? main.width() : trueW;
            main.css({left: ((wWidth - trueW) / 2)});
            /*设置垂直居中*/
            trueH = trueH <= 0 ? content.height() : trueH;
            var mainH = headerHeight + trueH + footH;
            var htop = ((wHeight - mainH) / 3) > stapH ? ((wHeight - mainH) / 3) : ((wHeight - mainH) / 2);
            if (trueH == (wHeight - (stapH * 3) - headerHeight - footH)) htop = stapH;
            main.css({top: htop});
            that.config.trueW = trueW;
            that.config.trueH = trueH;
        },
        /** 创建对话框 */
        create: function () {
            if (this.DOM && this.DOM.wrap) {
                var that = this, 
	                win = window,
                	wrap = that.DOM.wrap, 
                	initShow = that.config.show,
                	$winBody = $("body");
                wrap.on('show.bs.modal', function () {
                	/* 锁屏  防止未提前设置居中属性 导致对话框出现时拖屏BUG
                	 * 预先计算一个居中位置放置滚动条拖屏
                	 * 同时设置一个锁屏CSS取消滚动条
                	 */
                	that.site();
                	if($winBody.is(".modal-open")!=true) $winBody.addClass("modal-open");
                });
                wrap.on('shown.bs.modal', function () {
                	var wrap  = that.DOM.wrap;
                	wrap.hide();
                	/*设置层级*/
                	that.zIndex();
                	/*给予对话框焦点*/
                	that.focus();
                	/*获得层级*/
                    var zIndex = parseInt(wrap.css("zIndex"));
                    /*设置遮罩层级*/
                    $("div.modal-backdrop[pid='" + wrap.attr("id") + "']").css("zIndex", zIndex - 1);
                    /*初始化执行 自定义init回调方法*/
                    that.config.init && that.config.init.call(that, win);
                    /* 此处内容才加载完成（init方法可能添加元素）
                     * 重新设置居中、设置显示、 执行显示完成回调
                     * 非iframe对话框都在这里完成操作
                     * iframe对话框由iframe自身load事件处理完成
                     */
                    if (that.config.isIframe != true) {
                    	that.site();
                    	wrap.show();
                    	/*初始化执行 自定义 显示完成回调方法*/
                    	that.config.shown && that.config.shown.call(that, window);
                    }
                });
                wrap.on('hide.bs.modal', function () {
                	/*移除自身遮罩*/
                	$("div.modal-backdrop[pid='" + wrap.attr("id") + "']").remove();
                	/*若页面已无显示的对话框并且全局body存在锁屏样式执行移除锁屏样式*/
                	if($winBody.is(".modal-open")==true&&$("div.modal-backdrop[pid]").length>0)
                		$winBody.removeClass("modal-open");
                });
                wrap.modal({show: initShow});
            }
            return this;
        },
        /** 显示对话框 */
        show: function () {
        	if (this.DOM && this.DOM.wrap) {
        		var that = this, wrap = that.DOM.wrap;
        		/*执行显示*/
        		wrap.modal('show');
        	}
        	return this;
        },
        /** 隐藏对话框 */
        hide: function (flag) {
            if (this.DOM && this.DOM.wrap) {
            	var that = this,fn=null,
            		wrap = that.DOM.wrap,
            		list = skynetDialog.list;
                if (flag === true) {
                	wrap.off('hidden.bs.modal');
                	/*若是关闭对话框，绑定影藏后事件*/
                    wrap.on('hidden.bs.modal', function () {
                    	/*若重写了关闭的回调函数则调用*/
                        that && that.config && that.config.close ? fn = that.config.close : fn;
                        /*若果close方法返回是false 则阻止关闭对话框*/
                        if (typeof fn === "function" && fn.call(that, window) === false) return that;
                        /*移除对象目标*/
                        if (skynetDialog.focus === that) skynetDialog.focus = null;
                        /*将该对话框从数据变量中移除*/
                        if (list && that && that.config && that.config.id) delete list[that.config.id];
                        /*清空元素*/
                        if (wrap) wrap[0].remove();
                        /*清空 对象，恢复到初始状态*/
                        for (var i in that) { if (that.hasOwnProperty(i)) delete that[i];}
                        /*关闭后 _box存在则清空 否则重用*/
                        _box ? null : _box = that;
                    });
                }else{
                	wrap.off('hidden.bs.modal');
                	/*若不是关闭对话框，清除绑定影藏后事件（不是事件卸载是用空强制覆盖）*/
                	wrap.on('hidden.bs.modal', function(){
                		/*若重写了关闭的回调函数则调用*/
                        that && that.config && that.config.close ? fn = that.config.close : fn;
                        /*若果close方法返回是false 则阻止关闭对话框*/
                        if (typeof fn === "function" && fn.call(that, window) === false) return that;
                	});
                }
            	/*执行影藏*/
            	wrap.modal('hide');
            }
            return this;
        },
        /** 关闭对话框 */
        close: function () {
            /*若已经关闭则直接返回*/
            if (this.closed) return this;
            var that = this;
            /*关闭对话框*/
            that.hide(true);
            return that;
        },
        /** 设置焦点 */
        focus: function () {
            // IE对不可见元素设置焦点会报错
            try {
                if (this.config.focus) {
                    var elem = this._focus && this._focus[0] || this.DOM.close[0];
                    elem && elem.focus();
                }
            } catch (e) {
            }
            return this;
        },
        /**按钮回调函数动态调用*/
        _click: function (name) {
            /*从我们的监听器中获得button 事件 统一处理点击事件*/
            var that = this,
                fn = that._listeners[name] && that._listeners[name].callback,
                params = that._listeners[name] && that._listeners[name].params;
            typeof fn === "function" && fn.call(that, window, params) ;
            return that;
           /* return typeof fn !== "function" || fn.call(that, window, params) !== false ? that.close() : that;*/
        },
        /**事件代理*/
        _addEvent: function () {
            var that = this,
                config = that.config,
                DOM = that.DOM;
            /*对话框元素监听点击*/
            DOM.wrap.bind("click.skynetDialog", function (event) {
                var target = event.target, callbackID;
                /*元素如果被禁用则直接返回 IE BUG*/
                if (target.disabled) return false;
                if (target === DOM.close[0] || $(target).parent()[0] === DOM.close[0]) {
                    /*元素是是关闭按钮*/
                    that.close();
                    return false;
                } else {
                    /*元素是不是关闭按钮 从元素中获得按钮对象*/
                    callbackID = target[_expando + "callback"];
                    /*执行回调*/
                    callbackID && that._click(callbackID);
                }
            });
        },
        /**卸载事件代理*/
        _removeEvent: function () {
            var that = this,
                DOM = that.DOM;
            DOM.wrap.unbind();
        }
    };
    /*设置对话框 方法中的init用于窗口回调*/
    skynetDialog.fn._init.prototype = skynetDialog.fn;
    /*兼容jquery用法*/
    $.fn.skynetdialog = $.fn.skynetDialog = function () {
        var config = arguments;
        this[this.live ? "live" : "bind"]("click.skynetDialog", function () {
            skynetDialog.apply(this, config);
            return false;
        });
        return this;
    };
    /*对象目标*/
    skynetDialog.focus = null;
    /*获取某对话框*/
    skynetDialog.get = function (id) {
        return id === undefined ? skynetDialog.list : skynetDialog.list[id];
    };
    /*全局对话框容器*/
    skynetDialog.list = {};
    /*对话框模板*/
    skynetDialog._templates =
        	  "<div name='modal-dialog' class=\"modal-dialog\">"
            + "<div name='modal-header' class='modal-header modal-blue'>"
            + "<button name='modal-closeBtn' type='button' "
            + "class='close' data-dismiss='modal'><i class=\"icofont-remove white font-18\"></i></button>"
            + "<h3 name='modal-title' class=\"white\" ></h3>"
            + "</div>"
            + "<div name='modal-dialogShadow'>"
            + "<div name='modal-body' class='modal-body'></div>"
            + "<div name='modal-footer' class='modal-footer'></div>"
            + "</div>"
            + "</div>";
    /*对话框属性*/
    skynetDialog.defaults = {
        content: "<div name='content'></div>",// 对话框内容
        title: "消息",						  // 标题. 默认'消息'
        tipsBtn: true,						  // 标题. 旁边的关闭按钮
        button: null,						  // 自定义按钮
        ok: null,							  // 确定按钮回调函数
        cancel: null,						  // 取消按钮回调函数
        init: null,							  // 对话框初始化后执行的函数
        shown: null,						  // 对话框显示后执行的函数
        close: null,						  // 对话框关闭前执行的函数
        okVal: "确定",						  // 确定按钮文本. 默认"确定"
        cancelVal: "取消",					  // 取消按钮文本. 默认"取消"
        width: "auto",						  // 内容宽度
        height: "auto",						  // 内容高度
        minWidth: 96,						  // 最小宽度限制
        minHeight: 32,						  // 最小高度限制
        trueW: 0,							  // 计算出的宽度
        trueH: 0,							  // 计算出的高度
        isIframe: false,					  // 是否是iframe对话框
        skin: "",						      // 皮肤名(预留接口,尚未实现)
        keyboard: false,					  // 是否按键监控
        show: true,							  // 初始化后是否显示对话框
        zIndex: 2000,						  // 层级关系z坐标(此值不能超过浏览器最大限制)
        foot: true,							  // 是否包含页脚
        resize: false,						  // 是否允许用户调节尺寸
        drag: true 							  // 是否允许用户拖动位置
    };
    /*将对话框存储于window中*/
    window.skynetDialog = $.skynetdialog = $.skynetDialog = skynetDialog;
}(this.sky || this.jQuery && (this.sky = jQuery), this));
//------------------------------------------------
//对话框模块-拖拽支持（可选外置模块）
//------------------------------------------------
(function ($) {
    var _dragEvent,
        _use,
        _$window = $(window),
        _$document = $(document),
        _elem = document.documentElement,
        _isIE6 = !('minWidth' in _elem.style),
        _isLosecapture = 'onlosecapture' in _elem,
        _isSetCapture = 'setCapture' in _elem;
    /**对象this交换并调用*/
    skynetDialog.dragEvent = function () {
        var that = this,
            proxy = function (name) {
                var fn = that[name];
                that[name] = function () {
                    return fn.apply(that, arguments);
                };
            };
        proxy('start');
        proxy('move');
        proxy('end');
    };
    /**拖拽属性定义*/
    skynetDialog.dragEvent.prototype = {
        /*开始拖拽 使用Jquery占位回调$.noop*/
        onstart: $.noop,
        /*正在拖拽 使用Jquery占位回调$.noop*/
        onmove: $.noop,
        /*结束拖拽 使用Jquery占位回调$.noop*/
        onend: $.noop,
        /*拖拽中 使用Jquery占位回调$.noop*/
        start: function (event) {
            /*绑定移动 和结束移动事件 */
            _$document.bind('mousemove.skynetDialog', this.move).bind('mouseup.skynetDialog', this.end);
            /*移动之前的坐标*/
            this._sClientX = event.clientX;
            this._sClientY = event.clientY;
            /*占位回调调用*/
            this.onstart(event.clientX, event.clientY);
            return false;
        },
        move: function (event) {
            /*获得当前移动的坐标*/
            this._mClientX = event.clientX;
            this._mClientY = event.clientY;
            /*占位回调调用*/
            this.onmove(
                event.clientX - this._sClientX,
                event.clientY - this._sClientY
            );
            return false;
        },
        end: function (event) {
            /*解绑鼠标事件*/
            _$document.unbind('mousemove.skynetDialog', this.move).unbind('mouseup.skynetDialog', this.end);
            /*占位回调调用*/
            this.onend(event.clientX, event.clientY);
            return false;
        }
    };
    /**拖拽行为实现*/
    _use = function (event) {
        var limit,
            startWidth,
            startHeight,
            startLeft,
            startTop,
            isResize,
            api = skynetDialog.focus,
            DOM = api.DOM,
            wrap = DOM.wrap,
            title = DOM.title,
            main = DOM.dialog;
        /*清除文本选择*/
        var clsSelect = 'getSelection' in window ? function () {
            window.getSelection().removeAllRanges();
        } : function () {
            try {
                document.selection.empty();
            } catch (e) {
            }
        };
        /*具体实现onstart回调函数 对话框准备拖动*/
        _dragEvent.onstart = function (x, y) {
            var wrap = api.DOM.wrap[0],
                fixed = wrap.style.position === 'fixed',
                dl = fixed ? 0 : _$document.scrollLeft(),
                dt = fixed ? 0 : _$document.scrollTop();
            /*初始化坐标*/
            if (isResize) {
                startWidth = main[0].offsetWidth;
                startHeight = main[0].offsetHeight;
            } else {
                ww = _$window.width(),
                    wh = _$window.height(),
                    startLeft = main[0].offsetLeft + dl;
                startTop = main[0].offsetTop + dt;
            }
            //_$document.bind('dblclick', _dragEvent.end);
            !_isIE6 && _isLosecapture ?
                title.bind('losecapture.skynetDialog', _dragEvent.end) :
                _$window.bind('blur.skynetDialog', _dragEvent.end);
            _isSetCapture && title[0].setCapture();
            /*设置对象目标*/
            api.focus();
        };
        /*具体实现onmove回调函数 对话框拖动进行中*/
        _dragEvent.onmove = function (x, y) {
            if (isResize) {
                var style = main[0].style,
                    width = x + startWidth,
                    height = y + startHeight;
                style.width = Math.max(0, width) + 'px';
                style.height = Math.max(0, height) + 'px';
            } else {
                var style = main[0].style,
                    tmpleft = Math.max(limit.minX, Math.min(limit.maxX, x + startLeft)),
                    tmptop = Math.max(limit.minY, Math.min(limit.maxY, y + startTop));
                main.offset({ top: tmptop, left: tmpleft });
            }
            clsSelect();
        };
        /*具体实现onend回调函数 对话框拖动结束*/
        _dragEvent.onend = function (x, y) {
            //_$document.unbind('dblclick', _dragEvent.end);
            !_isIE6 && _isLosecapture ?
                title.unbind('losecapture.skynetDialog', _dragEvent.end) :
                _$window.unbind('blur.skynetDialog', _dragEvent.end);
            _isSetCapture && title[0].releaseCapture();
            _isIE6 && !api.closed && api._autoPositionType();
        };
        /*是否允许改变窗口尺寸*/
        isResize = api.config.resize ? api.config.resize : false;
        /*拖拽范围*/
        limit = (function () {
            var maxX, maxY,
                wrap = api.DOM.wrap[0],
                fixed = wrap.style.position === 'fixed',
                ow = api.DOM.dialog[0].offsetWidth,
                oh = api.DOM.dialog[0].offsetHeight,
                ww = _$window.width(),
                wh = _$window.height(),
                dl = fixed ? 0 : _$document.scrollLeft(),
                dt = fixed ? 0 : _$document.scrollTop();
            // 坐标最大值限制
            maxX = ww - ow + dl;
            maxY = wh - oh + dt;
            return {
                minX: dl,
                minY: dt,
                maxX: maxX,
                maxY: maxY
            };
        })();
        /*初始化拖拽行为*/
        _dragEvent.start(event);
    };
    /**代理 mousedown 事件触发监听 完成对话框拖动*/
    _$document.bind('mousedown.skynetDialog', function (event) {
        var api = skynetDialog.focus;
        if (!api) return;
        var target = $(event.target),
            config = api.config,
            DOM = api.DOM;
        /*若点击到的元素是关闭 则关闭*/
        if (target.is("button[name='modal-closeBtn']") || target[0].tagName === "I") {
            api.close();
        } else {
            /*若点击到的元素不是对话框头 则强制设置对话框头为当前元素*/
            if (!target.is("div[name='modal-header']")) {
                target = $(target.parents("div[name='modal-header']")[0]);
            }
            /*若初始化元素属性允许拖拽，并且当前选择元素是当前操作的对话框头*/
            if (config.drag !== false && (target[0] === DOM.header[0])) {
                /*事件已经存在则使用 否则新new一个*/
                _dragEvent = _dragEvent || new skynetDialog.dragEvent();
                /*进行拖拽*/
                _use(event);
                return false;//防止firefox与chrome滚屏
            }
        }
    });
})(this.sky || this.jQuery && (this.sky = jQuery));
//------------------------------------------------
//api定义实现及iframe对话框处理
//------------------------------------------------
(function ($, window, skynetDialog, undefined) {
    var _topDialog, _proxyDialog, _zIndex,
        _data = "@skynetDialog.DATA",
        _open = "@skynetDialog.OPEN",
        _opener = "@skynetDialog.OPENER",
        _winName = window.name = window.name || "@skynetDialog.WINNAME" + +new Date,
        _isIE6 = window.VBArray && !window.XMLHttpRequest;
    /** 获取 skynetDialog 可跨级调用的最高层的 window 对象 */
    var _top = skynetDialog.top = function () {
        var top = window,
            test = function (name) {
        	/*跨域  是否 有权限（chrome本地安全限制） 测试*/
                try {
                    var doc = window[name].document;
                    doc.getElementsByTagName;
                } catch (e) {
                    return false;
                }
                //框架集无法显示第三方元素
                return window[name].skynetDialog && doc.getElementsByTagName("frameset").length === 0;
            };
        if (test("top")) {
            //若通过测试则获得顶层window
            top = window.top;
        } else if (test("parent")) {
            //否则则获得父window
            top = window.parent;
        }
        return top;
    }();
    /*获得顶层窗口*/
    skynetDialog.parent = _top;
    /*获得顶层窗口对话框对象*/
    _topDialog = _top.skynetDialog;
    /*获取顶层页面对话框 层级叠加值*/
    _zIndex = function () {
        return _topDialog.defaults.zIndex;
    };
    /**
     * 跨框架数据共享接口
     * @param    {String}    存储的数据名
     * @param    {Any}        将要存储的任意数据(无此项则返回被查询的数据)
     */
    skynetDialog.data = function (name, value) {
        /*获得顶层窗口，预先绑定的全局变量*/
        var top = skynetDialog.top,
            cache = top[_data] || {};
        /*若全局变量重新赋值（防止未创建）*/
        top[_data] = cache;
        if (value !== undefined) {
            /*若值存在 则认为是复制数据*/
            cache[name] = value;
        } else {
            /*若值不存在 则认为是取数据*/
            return cache[name];
        }
        return cache;
    };
    /**
     * 数据共享删除接口
     * @param    {String}    删除的数据名
     */
    skynetDialog.removeData = function (name) {
        var cache = skynetDialog.top[_data];
        if (cache && cache[name]) delete cache[name];
    };
    /** 跨框架普通对话框 */
    skynetDialog.through = _proxyDialog = function () {
        // 缓存从当前 window（可能为iframe）调出所有跨框架对话框，
        var api = _topDialog.apply(this, arguments);
        //若当前window不是顶层window
        //那么将《当前window对话框容器》中的《当前对话框》重新赋值为缓存中获得的对话框
        //因为iframe注销后也会从内存中删除其创建的对象，这样可以防止回调函数报错
        if (_top !== window) skynetDialog.list[api.config.id] = api;
        return api;
    };
    /**若当前窗口不是顶层窗口，框架页面卸载前（unload）关闭所有穿越的对话框*/
    _top !== window && $(window).bind("unload.skynetDialog", function () {
        var list = skynetDialog.list, config;
        for (var i in list) {
            if (list[i]) {
                config = list[i].config;
                list[i].close();
            }
        }
    });
    /**
     * iframe弹窗
     * @param    {String}    地址
     * @param    {Object}    配置参数. 这里传入的回调函数接收的第1个参数为iframe内部window对象
     * @param    {Boolean}    是否允许缓存. 默认true
     */
    skynetDialog.open = function (url, options, cache) {
        options = options || {};
        var api, DOM,
            $body, $dialog, $footer,
            iframe, $iframe, $idoc,
            iwin, ibody,
            top = skynetDialog.top,
            initCss = "position:absolute;left:-9999em;top:-9999em;border:none 0;background:transparent",
            loadCss = "width:100%;height:98%;border:none 0";
        /*不允许缓存时 使用时间戳随机码添加到url参数上*/
        if (cache === false) {
            var ts = +new Date,
                ret = url.replace(/([?&])_=[^&]*/, "$1_=" + ts);
            url = ret + ((ret === url) ? (/\?/.test(url) ? "&" : "?") + "_=" + ts : "");
        }
        /*iframe加载后回调（load）*/
        var load = function () {
            var iWidth, iHeight,
                aConfig = api.config;
            try {
                iwin = iframe.contentWindow;
                $idoc = $(iwin.document);
                ibody = iwin.document.body;
            } catch (e) {
                /*初始化iframe样式*/
                iframe.style.cssText = loadCss;
                /*初始化调用init方法*/
                options.init && options.init.call(api, iwin, top);
                options.init = null;
                return;
            }
            /*获得iframe宽*/
            iWidth = aConfig.width === 'auto' ? $idoc.width() + (_isIE6 ? 0 : parseInt($(ibody).css('marginLeft'))) : aConfig.width;
            iHeight = aConfig.height === 'auto' ? $idoc.height() : aConfig.height;
            /*+32是为了留出滚动条宽度*/
            api.size(iWidth + 32, iHeight);
            //适应iframe尺寸 setTimeout: 防止IE6~7对话框样式渲染异常
            setTimeout(function () {
                iframe.style.cssText = loadCss;
                //api.config.width-32是设置对话框动态计算出宽度后剪去滚动条的宽度  api.config.height同理
                $(iframe).css({width: api.config.trueW - 32, height: api.config.trueH});
                if (api.config.isIframe === true){
                	api.site();
                	api.DOM.wrap.show();
                	api.config.shown && api.config.shown.call(api, window);
                } 
            }, 0);
            options.init && options.init.call(api, iwin, top);
            options.init = null;
        };
        /*iframe对话框参数构造*/
        var config = {
            zIndex: _zIndex(),
            isIframe: true,
            init: function () {
                api = this;
                DOM = api.DOM;
                $dialog = DOM.dialog;
                $body = DOM.body;
                $footer = DOM.footer;
                $body.css({overflowY: "hidden"});
                iframe = api.iframe = top.document.createElement("iframe");
                iframe.src = url;
                iframe.name = "Open" + api.config.id;
                iframe.style.cssText = initCss;
                /*iframe边框强制为0*/
                iframe.setAttribute("frameborder", 0, 0);
                /*iframe透明内容透明属性设置*/
                iframe.setAttribute("allowTransparency", true);
                $iframe = $(iframe);
                /*对话框设置iframe内容*/
                api.content(iframe);
                /*iframe窗口对象*/
                iwin = iframe.contentWindow;
                if (!isEmpty(iwin))  iwin.name = iframe.name;
                /*设置全局顶层数据接口 iframe窗口（被打开的《对话框对象》）*/
                skynetDialog.data(iframe.name + _open, api);
                /*设置全局顶层数据接口 iframe窗口（打开iframe的《窗口对象》）*/
                skynetDialog.data(iframe.name + _opener, window);
                /*iframe绑定load事件*/
                $iframe.bind("load.skynetDialog", load);
            },
            close: function () {
                $iframe.css("display", "none").unbind("load.skynetDialog");
                if (options.close===false||(options.close && $.type(options.close)==='function'&& options.close.call(this, iframe.contentWindow, top) === false)) {
                    return false;
                }
                // 需要重置iframe地址，否则下次出现的对话框在IE6、7无法聚焦input
                // IE删除iframe后，iframe仍然会留在内存中出现上述问题，置换src是最容易解决的方法
                $iframe[0].src = "about:blank";
                $iframe.remove();
                try {
    				skynetDialog.removeData(iframe.name + _open);
    				skynetDialog.removeData(iframe.name + _opener);
    			} catch (e) {};
            }
        };
        // 回调函数第一个参数指向iframe内部window对象
        if (typeof options.ok === "function") config.ok = function () {
            return options.ok.call(api, iframe.contentWindow, top);
        }
        if (typeof options.cancel === "function") config.cancel = function () {
            return options.cancel.call(api, iframe.contentWindow, top);
        }
        delete options.content;
        for (var i in options) {
            if (config[i] === undefined) config[i] = options[i];
        }
        return _proxyDialog(config);
    };
    /** 引用open方法扩展方法(在open打开的iframe内部私有方法) */
    skynetDialog.open.api = skynetDialog.data(_winName + _open);
    /** 引用open方法触发来源页面window(在open打开的iframe内部私有方法) */
    skynetDialog.opener = skynetDialog.data(_winName + _opener) || window;
    skynetDialog.open.origin = skynetDialog.opener;
    /** skynetDialog.open 打开的iframe页面里关闭对话框快捷方法 */
    skynetDialog.close = function () {
        var api = skynetDialog.data(_winName + _open);
        api && api.close();
        return false;
    };
    // 点击iframe内容切换叠加高度
    _top != window && $(document).bind("mousedown.skynetDialog", function () {
        var api = skynetDialog.open.api;
        api && api.zIndex();
    });
    /**
     * Ajax填充内容
     * @param    {String}            地址
     * @param    {Object}            配置参数
     * @param    {Boolean}            是否允许缓存. 默认true
     */
    skynetDialog.load = function (url, options, cache) {
        cache = cache || false;
        var opt = options || {};
        var config = {
            zIndex: _zIndex(),
            init: function (here) {
                var api = this,
                    aConfig = api.config;
                $.ajax({
                    url: url,
                    success: function (content) {
                        api.content(content);
                        opt.init && opt.init.call(api, here);
                    },
                    cache: cache
                });

            }
        };
        delete options.content;
        for (var i in opt) {
            if (config[i] === undefined) config[i] = opt[i];
        }
        return _proxyDialog(config);
    };
    /**
     * 消息
     * @param    {String}    消息内容
     */
    skynetDialog.alert = function (content, callback) {
        return _proxyDialog({
            id: "Alert",
            zIndex: _zIndex(),
            content: "<table style='width:100%;height:100%;'>"
                + "<tr>"
                + "<td style='width:32px;'>"
                + "<image src=\"" + getBaseUrl() + "/common/images/dialog/msg.png" + "?t=" + Math.random() + "\" class=\"skynetMessager\" />"
                + "</td>"
                + "<td style='text-align:left;margin-left: 15px;'>"
                + content
                + "</td>"
                + "</tr>"
                + "<table>",
            width: 320,
            height: 60,
            ok: true,
            close: callback
        });
    };
    /**
     * 错误
     * @param    {String}    消息内容
     */
    skynetDialog.error = function (content, callback) {
        return _proxyDialog({
            id: "error",
            zIndex: _zIndex(),
            title: "错误",
            content: "<table style='width:100%;height:100%;'>"
                + "<tr>"
                + "<td style='width:32px;'>"
                + "<image src=\"" + getBaseUrl() + "/common/images/dialog/error.png" + "?t=" + Math.random() + "\" class=\"skynetMessager\" />"
                + "</td>"
                + "<td  style='text-align:left;margin-left: 15px;'>"
                + content
                + "</td>"
                + "</tr>"
                + "<table>",
            width: 320,
            height: 60,
            ok: true,
            close: callback
        });
    };
    /**
     * 警告
     * @param    {String}    消息内容
     */
    skynetDialog.warning = function (content, callback) {
        return _proxyDialog({
            id: "warning",
            zIndex: _zIndex(),
            content: "<table style='width:100%;height:100%;'>"
                + "<tr>"
                + "<td style='width:32px;'>"
                + "<image src=\"" + getBaseUrl() + "/common/images/dialog/warning.png" + "?t=" + Math.random() + "\" class=\"skynetMessager\" />"
                + "</td>"
                + "<td  style='text-align:left;margin-left: 15px;'>"
                + content
                + "</td>"
                + "</tr>"
                + "<table>",
            width: 320,
            height: 60,
            ok: true,
            close: callback
        });
    };
    /**
     * 成功
     * @param    {String}    消息内容
     */
    skynetDialog.success = function (content, callback) {
        return _proxyDialog({
            id: "success",
            zIndex: _zIndex(),
            content: "<table style='width:100%;height:100%;'>"
                + "<tr>"
                + "<td style='width:32px;'>"
                + "<image src=\"" + getBaseUrl() + "/common/images/dialog/success.png" + "?t=" + Math.random() + "\" class=\"skynetMessager\" />"
                + "</td>"
                + "<td  style='text-align:left;margin-left: 15px;'>"
                + content
                + "</td>"
                + "</tr>"
                + "<table>",
            width: 320,
            height: 60,
            ok: true,
            close: callback
        });
    };
    /**
     * 确认
     * @content    {String}    消息内容
     * @yes    {Function}    确定按钮回调函数
     * @no    {Function}    取消按钮回调函数
     */
    skynetDialog.confirm = function (content, yes, no) {
        return _proxyDialog({
            id: "Confirm",
            zIndex: _zIndex(),
            content: "<table style='width:100%;height:100%;'>"
                + "<tr>"
                + "<td style='width:32px;' class='skynetMessager-question'>"
                + "<image src=\"" + getBaseUrl() + "/common/images/dialog/confirm.png" + "?t=" + Math.random() + "\" class=\"skynetMessager\" />"
                + "</td>"
                + "<td style='text-align:left;margin-left: 15px;'>"
                + content
                + "</td>"
                + "</tr>"
                + "<table>",
            width: 320,
            height: 60,
            ok: function (here) {
                return yes.call(this, here);
            },
            cancel: function (here) {
                return no && no.call(this, here);
            }
        });
    };
    /**
     * 提问
     * @param    {String}    提问内容
     * @param    {Function}    回调函数. 接收参数：输入值
     * @param    {String}    默认值
     */
    skynetDialog.prompt = function (content, yes, value,placeholder) {
        value = value || "";
        var input;

        return _proxyDialog({
            id: "Prompt",
            zIndex: _zIndex(),
            content: [
                "<div style='text-align:left;margin-bottom:5px;font-size:12px'>",
                content,
                "</div>",
                "<div>",
                "<input value='",
                value,
                "' style='width:300px;padding:6px 4px'",
                "  placeholder='"+(placeholder||'')+"' />",
                "</div>"
            ].join(''),
            init: function () {
                input = this.DOM.body.find('input')[0];
                input.select();
                input.focus();
            },
            ok: function (here) {
                return yes && yes.call(this, input.value, here);
            },
            cancel: true
        });
    };
    /**
     * 信息
     * @param    {String}    内容
     * @param    {String}    类型
     * @param    {Function}    确认按钮回调
     * @param    {Function}    取消按钮回调
     */
    skynetDialog.msg = function (content, flag, okFun, closeFun) {
        var msgFg;
        switch (flag) {
            case 'success':
                msgFg = "success.png";
                break;
            case 'warning':
                msgFg = "warning.png";
                break;
            case 'error':
                msgFg = "error.png";
                break;
            case 'question':
                msgFg = "confirm.png";
                break;
            default:
                msgFg = "msg.png"
                break;
        }
        return _proxyDialog({
            id: "msg",
            zIndex: _zIndex(),
            content: "<table style='width:100%;height:100%;'>"
                + "<tr>"
                + "<td style='width:32px;'>"
                + "<image src=\"" + getBaseUrl() + "/common/images/dialog/" + msgFg + "?t=" + Math.random() + "\" class=\"skynetMessager\" />"
                + "</td>"
                + "<td><div style='text-align:left;margin-left: 15px;'>"
                + content
                + "</div></td>"
                + "</tr>"
                + "<table>",
            width: 320,
            height: 60,
            ok: function (here) {
                return okFun && okFun.call(this);
            },
            close: function (here) {
                return closeFun && closeFun.call(this);
            }
        });
    };
    /**
     * 验证提示
     * @param    {String}    内容
     * @param    {String}    宽度
     */
    skynetDialog.reg = function (content, width) {
        var w = (!isEmpty(width) && !isNaN(width)) && width > 0 ? width : 420;
        return _proxyDialog({
            id: "msg",
            content: "<table style='width:100%;height:100%;'>"
                + "<tr>"
                + "<td style='width:32px;'>"
                + "<image src=\"" + getBaseUrl() + "/common/images/dialog/warning.png?t=" + Math.random() + "\" class=\"skynetMessager\" />"
                + "</td>"
                + "<td><div class='skynetDialog-Reg' style='text-align:left;margin-left: 15px;'>"
                + content
                + "</div></td>"
                + "</tr>"
                + "<table>",
            width: w,
            ok: true,
            close: false
        });
    };
    //- 防止鼠标落入iframe导致拖拽不流畅
    //- 对超大对话框拖动优化
    $(function () {
        var event = skynetDialog.dragEvent;
        if (!event) return;
        //存在拖拽对象
        var $window = $(window),
            $document = $(document),
            positionType = _isIE6 ? 'absolute' : 'fixed',
            dragEvent = event.prototype,
            mask = document.createElement('div'),
            style = mask.style;
        style.cssText = 'display:none;position:' + positionType + ';left:0;top:0;width:100%;height:100%;'
            + 'cursor:move;filter:alpha(opacity=0);opacity:0;background:#FFF';
        //iframe页面白色遮罩
        document.body.appendChild(mask);
        //iframe拖拽start事件重写
        dragEvent._start = dragEvent.start;
        //iframe拖拽end事件重写
        dragEvent._end = dragEvent.end;
        dragEvent.start = function () {
            var DOM = skynetDialog.focus.DOM,
                main = DOM.body[0],
                iframe = main.getElementsByTagName('iframe')[0];
            if (isEmpty(iframe) && !isEmpty($(main).html())) {
                //隐藏验证提示框
                $(main).find("[reg]").each(function () {
                    var $Element = $(this);
                    if (!isEmpty($Element.data("bs.popover"))) $Element.popover("hide");
                });
            }
            dragEvent._start.apply(this, arguments);
            style.display = 'block';
            style.zIndex = skynetDialog.defaults.zIndex + 3;
            if (positionType === 'absolute') {
                style.width = $window.width() + 'px';
                style.height = $window.height() + 'px';
                style.left = $document.scrollLeft() + 'px';
                style.top = $document.scrollTop() + 'px';
            }
            if (iframe && main.offsetWidth * main.offsetHeight > 307200) {
                main.style.visibility = 'hidden';
            }
        };
        dragEvent.end = function () {
            var dialog = skynetDialog.focus,
                main = dialog.DOM.body[0],
                $Felement = $(document.activeElement),
                iframe = main.getElementsByTagName('iframe')[0];
            dragEvent._end.apply(this, arguments);
            style.display = 'none';
            if (dialog) dialog.DOM.body[0].style.visibility = 'visible';
            if (isEmpty(iframe) && !isEmpty($(main).html())) $Felement.focus();
        };
    });
})(this.sky || this.jQuery, this, this.skynetDialog);

/**
 * 简单弹出一个iframe对话框，支持重载
 * @param url       地址
 * @param tittle   标题
 * @param width       对话框的宽度
 * @param height   对话框的高度
 * @param closeFun 关闭对话框回调函数
 * @param id       设置对话框的id
 */
function openDialog(url, tittle, width, height, closeFun, id) {
    var option = null;
    if (arguments.length == 1) {
        option = {
            title: "",
            foot: false
        };
    } else if (arguments.length == 2) {
        option = {
            title: tittle,
            foot: false
        };
    } else if (arguments.length == 3) {
        option = {
            title: tittle,
            width: width,
            foot: false
        };
    } else if (arguments.length == 4) {
        option = {
            title: tittle,
            width: width,
            height: height,
            foot: false
        };
    } else if (arguments.length == 5) {
        option = {
            title: tittle,
            width: width,
            height: height,
            close: closeFun,
            foot: false
        };
    } else if (arguments.length == 6) {
        option = {
            id: id,
            title: tittle,
            width: width,
            height: height,
            close: closeFun,
            foot: false
        };
    }
    sky.skynetDialog.open(url, option, false);
}

/*浏览器版本提示框*/
function browserCheck() {
    if (isEmpty(navigator.userAgent.toLowerCase().match(/chrome/))) {
        skynetDialog.through({
            id: "msg",
            content: "<table style='width:100%;height:100%;'>"
                + "<tr>"
                + "<td style='width:32px;'>"
                + "<image src=\"" + getBaseUrl() + "/common/images/dialog/warning.png?t=" + Math.random() + "\" class=\"skynetMessager\" />"
                + "</td>"
                + "<td>"
                + "<div style='text-align:left;margin-left: 15px;'>"
                + "<table>"
                + "<tr>"
                + "<th>警告！请使用专用浏览器进行访问！</th>"
                + "</tr>"
                + "<tr>"
                + "<td>在其他浏览器下（IE,FireFox,Safari,360等)可能出现显示或功能不正常！</td>"
                + "</tr>"
                + "<tr>"
                + "<td><a href='/ChromeStandaloneSetup.exe'>Chrome浏览器下载</a></td>"
                + "</tr>"
                + "<table>"
                + "</div>"
                + "</td>"
                + "</tr>"
                + "<table>",
            width: 500,
            height: 120,
            ok: function (here) {
                return true;
            }
        });
    }
}