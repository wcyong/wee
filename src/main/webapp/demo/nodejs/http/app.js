//引入模块
var http = require("http");
// 创建服务
var server = http.createServer(function(req,res){
	console.log(req.url);
	//响应头
	res.writeHead(200,{'Content-Type':'text/html'});
	//响应内容
	res.write("<h1>NODEJS</h1>");
	//结束响应
	res.end("<p>end</p>");
}).listen(3000);//监听端口

server.on("connection",function(){
	console.log(".....");
});
console.log("http server is listening at port 3000");