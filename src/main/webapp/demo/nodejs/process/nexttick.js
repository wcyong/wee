function compute() {
	console.log("i am is computer method");
}

function somethingComplited(args) {
	console.log("i am is somethingComplited method");
	console.log(args);
}

/*function  doSomething(args, callback) {
	somethingComplited(args);
	callback();
}*/
function doSomething(args, callback) {
	somethingComplited(args);
	process.nextTick(callback);
}



doSomething("123",function onEnd(){
	compute();
});
