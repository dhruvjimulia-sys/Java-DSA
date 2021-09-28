# 1st command line argument must be any of the folder names
cd $1
javac *.java
cd ..
java $1.App