// 1.3 查找重复的行
// 演示bufio这个包
package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	/*
	   //  查找重复行-版本一
	   	counts := make(map[string]int)
	   	input := bufio.NewScanner(os.Stdin)
	   	for input.Scan(){
	   		counts[input.Text()]++
	   	}

	   	for line,n:=range counts{
	   		if n>1 {
	   			fmt.Printf("%d\t%s\n",n,line)
	   		}
	   	}
	*/

	/*
	// 计算重复行 --  版本二
	counts := make(map[string]int)
	files := os.Args[1:]
	if len(files) == 0 {
		countLines(os.Stdin, counts)
	} else {
		for _, arg := range files {
			f, err := os.Open(arg)
			if err != nil {
				fmt.Fprintf(os.Stderr, "dup2:%v\n", err)
				continue
			}
			countLines(f, counts)
			f.Close()
		}
	}

	for n, line := range counts {
		if n > 1 {
			fmt.Printf("%d\t%s\n", n, line)
		}
	}

	*/
}

/**
 * 计算行数
 */
func countLines(f *os.File, counts map[string]int) {
	input := bufio.NewScanner(f)
	for input.Scan() {
		counts[input.Text()]++
	}
}
