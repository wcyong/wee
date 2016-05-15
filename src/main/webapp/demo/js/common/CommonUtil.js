var MyLib = {};

/**
 * 继承
 */
MyLib.extend = function(sub, sup) {
	//目的：实现只继承父类的原型对象
	//1.创建一个空函数，目的是用一个空函数进行中转
	var F = new Function();
	//2.实现空函数原型对象和超类的原型对象转换
	F.prototype = sup.prototype;
	//3.原型继承
	sub.prototype = new F();
	//4.还原子类的构造器
	sub.prototype.constructor = sub;
	//5.保存一下父类的原型对象，一方方便解耦，另一方面方便获取父类的原型对象
	//自定义一个子类的静态属性,接收父类的原型对象
	sub.superClass = sup.prototype;
	//判断父类原型对象的构造器
	if(sup.prototype.constructor == Object.prototype.constructor) {
		//手动还原父类的原型对象的构造器
		sup.prototype.constructor = sup;
	}
};

/**
 * 跨浏览器的事件处理方法
 */
MyLib.EventUtil = {
	addHandler : function(element, type, handler) {
		if(element.addEventListener) {//FF
			element.addEventListener(type,handler,false);
		} else if(element.attachEvent) {//IE
			element.attachEvent('on'+type,handler);
		}
	},
	removeHandler : function(element, type, handler) {
		if(element.removeEventListener) {//FF
			element.removeEventListener(type,handler,false);
		} else if(element.detachEvent) {//IE
			element.detachEvent('on'+type,handler);
		}
	}
};

/**
 * 扩展Array的原型对象，遍历数组，支持多维数据
 * @param fn
 * @returns {Array}
 */
Array.prototype.each = function(fn) {
	try{
		//1.遍历数组的每一项
		this.i || (this.i = 0);//记录当前元素遍历的元素位置
		//数组长度大于0，并且参数是一个函数
		if(this.length > 0 && fn.constructor == Function) {
			//循环遍历数组的每一项
			while(this.i < this.length) {
				//获取数组的每一项
				var item = this[this.i];
				//如果当前元素获取到，并且当前元素是数组
				if(item && item.constructor == Array) {
					//递归操作
					item.each(fn);
				} else {
					//如果不是数组，即单个元素
					//执行传递的函数，把当前的元素传递给fn函数
					fn.apply(item,[item]);//执行函数
				}
				
				this.i++;
			}
			this.i = null;//释放内存
		}
		
	}catch(ex){
		//do something
	}
	return this;
}