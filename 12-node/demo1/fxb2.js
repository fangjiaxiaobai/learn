var fxb = function(string){
	this.string = string;
}
fxb.prototype.toUpperCases=function(string){
	return string.toUpperCase();
}

fxb.prototype.toLowerCases = function(string){
	return string.toLowerCase();
}

module.exports = exports = fxb