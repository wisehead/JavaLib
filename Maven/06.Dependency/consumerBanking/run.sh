#############################################################
#   File Name: run.sh
#     Autohor: Hui Chen (c) 2022
#        Mail: alex.chenhui@gmail.com
# Create Time: 2022/03/10-15:55:16
#############################################################
#!/bin/sh 
mvn clean compile
cd target/classes
java -cp . com.companyname.bank.App
