# springboot
spring boot项目 代码整理

1.拉取分支
一、上传一个独立的分支（比如代码是从工程中直接DOWNLOAD ZIP文件如BowlingScore-test.zip，该文件与原MASTER分支是独立的）

1、Git init （在本地工程目录下），生成.git 文件夹
Git init

2、上传修改的文件
git add *
(*可替换成具体要上传的文件名，*表示提交所有有变化的文件) 

3、添加上传文件的描述  （”test“为分支名）
git commit -m "test" 

4、（创建分支）
git branch test

5、（切换分支）
git checkout test

6、与远程分支相关联 （”BowlingScore“ 为工程名）
git remote add origin https://github.com/yumindouzi/springboot.git
   
7、（将分支上传）
git push origin test

二、上传一个与MASTER相关的分支（该分支是从MASTER中git clone 得到，相关信息在 .git 文件中）

修改后源码后，在进行如下操作

1、git add .
2、git commit -m "test" &nbsp;（”test“为分支名）
3、git branch test（创建分支）
4、git checkout &nbsp;test （切换分支）
5、git push origin test:test