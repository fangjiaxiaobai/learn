/**
 *  构建RESTful web服务，
 *  post：向待办清单中添加事项
 *  GET：显示当前事项列表
 *  DELETE：从待办事项中删除事项
 *  PUT：修改已有事项
 *   fxb:演示不成功。
 */
 
 var http = require('http');
 
 http.createServer(function(req,res){
	 var items = '';
	 req.setEncoding('utf8');
	 req.on('data',function(chunk){
		console.log(chunk);
		items += chunk;
	 });
	 req.on('end',function(){
		console.log('done parsing...');
		res.end(items+'OK');
	 });
 }).listen(8080);