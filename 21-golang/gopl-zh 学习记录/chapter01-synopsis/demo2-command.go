//1.命令行参数交互
/*
	输入来源：文件，网络连接，其他程序输入，键盘
	命令行。

	命令行参数：
	os包。
	os 包以跨平台的方式，提供了一些与操作系统交互的函数和变量。程序的命令行参数可从os包的Args变量获取；os包外部使用os.Args访问该变量。
	os.Args变量是一个字符串（string）的切片（slice）
*/

package main

//import "os"
//import "fmt"

//import ("fmt";"os")
// 或者(go自动将换行符转换成;)
import (
	"fmt"
	"os"
	"strings"
)

func main() {
	// fmt.Println(os.Args);
	var s, sep string
	// 第一种方案
	for i := 1; i < len(os.Args); i++ {
		s += sep + os.Args[i]
		sep = "  "
	}
	fmt.Println(s)

	// 第二种方案
	for _, arg := range os.Args[1:] {
		s += sep + arg
		sep = "  "
	}
	fmt.Println(s)

	// 第三种方案
	fmt.Println(strings.Join(os.Args[1:], "  "))

	// Args
	fmt.Println(os.Args[0])
}
