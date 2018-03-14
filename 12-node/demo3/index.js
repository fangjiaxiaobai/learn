/**
 * 从表单接收用户输入
 */
 
var http = require('http');
var qs = require('querystring');
var items = [];
http.createServer(function(req,res){
	 if("/" == req.url){
		switch(req.method){
			case 'GET' : show(res);break;
			case 'POST' : add(req,res);break;
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
			'<form method="post" action="/">'+
			'<p><input type="text" name="item"/></p>'+
			'<p><input type="submit" name="btn"/></p>'+
			'</from></body></html>';
	res.setHeader('content-Type','text/html');
	res.setHeader('content-Length',Buffer.byteLength(html));
	res.end(html);
}

function notFound(res){
	res.statusCode = 404;
	res.setHeader('Content-Type','text/plain');
	res.end('not Found');
}

function badRequest(res){
	res.statusCode = 400;
	res.setHeader('Content-Type','text/plain');
	res.end('Bad Request');
}

function add(req,res){
	var body = '';
	req.setEncoding('utf8');
	req.on('data',function(tunk){body+=tunk});
	req.on('end',function(){
		var obj = qs.parse(body);
		items.push(obj.item);
		show(res);
	});
}



