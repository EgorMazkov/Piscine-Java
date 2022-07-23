#1 - To compile a file
#2 - To compile a jar
#3 - To start the program
#4 - Checking what is in the jar
#5 - Example

#1
rm -rf target
mkdir target
javac -sourcepath src/java/ -d target/ src/java/edu/school21/printer/app/Program.java

#2
jar -cmf src/manifest.txt target/images-to-chars-printer.jar target src/resources

#3
java -jar target/images-to-chars-printer.jar --black=0 --white

#4
jar tf images-to-chars-printer.jar

#5
rm -rf target
mkdir target
javac -sourcepath src/java/ -d target/ src/java/edu/school21/printer/app/Program.java
jar -cmf src/manifest.txt target/images-to-chars-printer.jar target src/resources
java -jar target/images-to-chars-printer.jar --black=0 --white=.


