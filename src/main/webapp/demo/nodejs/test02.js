var fs = require('fs');
//fs.readFile('file.txt','UTF-8',function(err,data){
fs.readFile('file.txt','UTF-8',function(err,data){
	if(err) {
		console.log('文件读取错误');
	} else {
		console.log(data);
	}
});
console.log("end");