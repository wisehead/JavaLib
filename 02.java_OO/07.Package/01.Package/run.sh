#############################################################
#   File Name: run.sh
#     Autohor: Hui Chen (c) 2022
#        Mail: chenhui13@xxx.com
# Create Time: 2022/03/01-14:15:02
#############################################################
#!/bin/sh 
java animals/MammalInt
#Java 中带包（创建及引用）的类的编译

#只有一个文件时编译：

#javac A.java
#一个包的文件都在时编译：

javac -d . *.java
#运行：编译之后会自己生成文件夹，不要进入这个文件夹，直接运行 java -cp /home/test test.Run，其中源文件在 test 文件夹中，包名为 test，启动文件为 Run.java。
