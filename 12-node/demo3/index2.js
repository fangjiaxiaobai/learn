/**
 * 文件上传
 * 计算上传速度
 */
var http = require('http');
var qs = require('querystring');
var formidable = require('formidable');

var items = [];
http.createServer(function(req,res){
	 if("/" == req.url){
		switch(req.method){
			case 'GET' : show(res);break;
			case 'POST' : upload(req,res);break;
			default : badRequest(res);
		}
	 }else{
		notFound(res);
	 }
}).listen(8000);

function show(res){
	var html = '<html><head><title>show page</title></head><body>'+
			'<h1>TO LIST</h1>' + 
			'<ul>' +
			items.map(function(item){
				return '<li>'+item+'</li>';
			}).join('') +
			'</ul>'+
			'<form method="post" action="/" enctype="multipart/form-data">'+
			'<p><input type="text" name="name"/></p>'+
			'<p><input type="file" name="file"/></p>'+
			'<p><input type="submit" name="btn"/></p>'+
			'</from></body></html>';
	res.setHeader('content-Type','text/html');
	res.setHeader('content-Length',Buffer.byteLength(html));
	res.end(html);
}

function upload(req,res){
	if(!isFormData(req)){
		res.statusCode = 400;
		res.end('Bad Request:expecting multipart/form-data');
		return ;
	}
	
	var form = formidable.IncomingForm();
	/*
	form.on('field',function(field,value){
		console.log(field);
		console.log(value);
	});
	
	form.on('file',function(name,file){
		console.log(name);
		console.log(file);
	});
	
	form.on('end',function(){
		res.end("upload complete");
	});
	
	form.parse(req);
	*/
	// 以上注释部分的优化版本
	form.parse(req,function(err,fields,files){
		console.log(fields);
		console.log(files);
		res.end('upload complete~!');
	});
	
	form.on('progress',function(byteReceived,byteExpect){
		var percent = Math.floor(byteReceived/byteExpect * 100);
		console.log(percent+"%d")
	});
}

function isFormData(req){
	var type = req.headers['content-type'] || '';
	return 0==type.indexOf('multipart/form-data');
}


