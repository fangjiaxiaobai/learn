'''
@title 简单的使用urllib爬取web页面
@author fangjiaxiaobai
@date 2018-03-10 22:00
'''

import  urllib.request

# print(help(urllib.request))

page = urllib.request.urlopen("http://www.baidu.com");
# urllib.urlopen();
page.info();
page.getcode();
page.read();
page.geturl();
html = page.read().decode(encoding='utf-8',errors='strict') # .encode('utf-8')
# html = page.read()
print(html)

#  将爬取到的文本保存到指定的文件中
urllib.request.urlretrieve('http://www.baidu.com','E:\\temp_python\\baidu.com.html');
# print(help(urllib.request))


###############################################
# 封装的版本                                   #
###############################################

def getHtml(url):
    page = urllib.request.urlopen(url)
    code = page.getcode()
    if code == 200:
        print(page.info())
        print(page.read().decode('utf-8','strict'))
    else:
        print("url 不可访问!")

getHtml("https://www.baidu.com")



###############################################
# page.retrieve                               #
# retrieve方法的第三个参数是一个函数：          #
#    a: 此次传递的数据块的个数，第几个数据块。   #
#    b: 每个数据块的大小                       #
#    c: 远程文件的大小                         #
###############################################
def callback(a,b,c):

    print(a)
    print(b)
    print(c)

    down_process = 100.0*a*b/c
    if down_process > 100:
        down_process = 100
    print("%.2f%%" % down_process)

urllib.request.urlretrieve('http://blog.csdn.net/fengzhizi76506/article/details/59229846','E:\\temp_python\\baidu.com.html',callback)
