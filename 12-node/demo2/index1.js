/**
	Http服务器的基础知识
*/
var http = require('http);

/**
 * 展示一下Http请求
 * 响应Helloworld
 */
http.createServer(function(req,res){
	res.write("hello world");
	res.end();
}).listen(8000);

http.createServer(function(req,res){
	res.end("fangjiaxiaobai");
}).listen(8888);

/**
 * 根据请求设置 响应头
 */
http.createServer(function(req,res){
	var body = "wangsu";
	res.setHeader("Context-length",body.length);
	res.setHeader("Context-type","text/plain")
	res.end(body);
}).listen(8887);

// 跳转
http.createServer(function(req,res){
	setTimeout(function(){
		var url = "https://www.baidu.com";
		res.setHeader("location",url);
		res.statusCode=302;
		res.end("wangxiyue");
	},3000);
}).listen(8886);
