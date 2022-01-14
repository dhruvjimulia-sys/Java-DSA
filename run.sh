# 1st command line argument must be any of the folder names
javac -sourcepath src/$1 -d out src/$1/*.java
java -cp out $1.App
