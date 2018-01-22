/**
 *  3.提供静态文件服务
 * 	创建一个静态的文件服务器。
 *  用pipe()优化数据传输
 *  通过设定的状态码处理用户和文件系统错误
 *  
 */
 
 var http = require('http');
 var parse = require('url').parse;
 var join = require('path').join;
 var fs = require('fs');
 
 //在静态服务器上会有一个root变量，代表静态文件服务器的根目录。
 var root = __dirname; // 代表文件所在目录的路径。
 
 
 http.createServer(function(req,res){
	 	 req.setEncoding('utf8');
	var url = parse(req.url);
	var path = join(root,url.pathname);
	var stream = fs.createReadStream(path);
	try{
		if(null == stream){
			console.log(path+"文件不存在");
			res.end(path+"文件不存在");
		}
		stream.on('data',function(chunk){
			res.write(chunk);
		});
		stream.on('end',function(){
			res.end('OK');
		})
	}catch(error){
		res.end('OK');
	}
 }).listen(8080);
 
 /**
  *  使用Stream.pipe()优化数据传输。
  *    stream.on('error',....)不起作用。
  */
 http.createServer(function(req,res){
	 req.setEncoding('utf8');
	var url = parse(req.url);
	var path = join(root,url.pathname);
	console.log(path);
	var stream = fs.createReadStream(path);
	res.setHeader("contentType","text/html;charset=utf-8");
	stream.pipe(res);
	stream.on('error',function(err){
		res.statusCode=500;
		res.end('server iner error!');
	});
 }).listen(8081);
 
 
 /**
  * 使用fs.stat() 实现先发制人的错误处理。
  */
http.createServer(function(req,res){
	try{
		req.setEncoding('utf8');
		var url = parse(req.url);
		var path = join(root,url.pathname);
		console.log(path);
		fs.stat(path,function(err,stat){  //检查文件是否存在
			if(err){
				if('ENOENT'==err.code){
					res.statusCode = 404;
					res.end('file is not exists');
				}else{
					res.statusCode = 500;
					res.end('Internal server error');
				}
			}else {
				res.setHeader('Content-Length',stat.size);
				var stream  = fs.createReadStream(path);
				stream.pipe(res);
				stream.on('error',function(err){
					res.statusCode = 500 ;
					res.end('Server iner ERrror');
				});
			}
		});
	}catch(err){
		console.log('catch a error'+err);
	}
 }).listen(8082);
 
 