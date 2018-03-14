var fxb = require('./fxb');
var fxb2 = require('./fxb2');

console.log("转换开始：");
var demo1 = fxb.toUpperCases('fangjiaxiaobai')
console.log(demo1)
var demo2 = fxb.toLowerCases('FANGXIAOBAI')
console.log(demo2)
console.log("-----------装换结束------------");

console.log("******** test2 ************");
var demo1 = fxb2.toUpperCases('fangjiaxiaobai')
console.log(demo1)
var demo2 = fxb2.toLowerCases('FANGXIAOBAI')
console.log(demo2)

