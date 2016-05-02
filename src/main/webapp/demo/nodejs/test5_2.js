var myModule = require("./test5");
myModule.setName("wwss");
//不会重复加载模块
var myModule2 = require("./test5");
myModule2.setName("nekas");
myModule.sayHello();//-->nekas