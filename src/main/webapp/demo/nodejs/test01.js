var http=require('http');
http.createServer(function(req,res){
	res.writeHead(200,{'Content-Type':'text/html'})
	res.write('<h1>NodeJsdddd</h1>');
	res.end('<p>test</p>');
}).listen(8000);
console.log('HTTP server is listening at port 8000');