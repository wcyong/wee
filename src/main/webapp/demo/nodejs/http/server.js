var http = require("http");
var server = new http.Server();
server.on("request",function(req,res){
	console.log(req);
	res.writeHead(200,{"Context-Type":"text/html"});
	res.write("<h1>xxxxxxxx</h1>");
	res.end("<p>over</p>");
});
server.listen(4000);