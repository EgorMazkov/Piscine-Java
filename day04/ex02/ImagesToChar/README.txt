#1 - Library download
#2 - Unzipping libraries
#3 - Project Compilation
#4 - Creating a project archive
#5 - Program launch
#6 - Deleting the library and compiled files
#7 - Explanation

#1
mkdir lib
curl https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar -o lib/jcommander-1.82.jar
curl https://repo1.maven.org/maven2/com/diogonunes/JCDP/4.0.2/JCDP-4.0.2.jar -o lib/JCDP-4.0.2.jar

#2
mkdir target
cd target
jar -xf ../lib/jcommander-1.82.jar
jar -xf ../lib/JCDP-4.0.2.jar
rm -rf META-INF
cd ..

#3
javac -d target -cp lib/\* src/java/edu/school21/printer/*/*.java

#4
cp -R src/resources target
jar -cmf src/manifest.txt target/images-to-chars-printer.jar -C target .

#5
java -jar target/images-to-chars-printer.jar --white=RED --black=BLACK

#5-1
java -jar target/images-to-chars-printer.jar --white=<color> --black=<color>

#6
rm -rf target lib

#7
--white=<color> --black=<color> - Specify colors for rendering.
Colors can only be:
- BLACK
- RED
- GREEN
- YELLOW
- BLUE
- MAGENTA
- CYAN
- WHITE
- NONE