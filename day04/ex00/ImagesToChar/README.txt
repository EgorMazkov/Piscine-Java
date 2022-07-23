#1
javac -sourcepath src/java/ -d target/ src/java/edu/school21/printer/app/Program.java


#2
java -classpath target edu.school21.printer.app.Program --black=. --white=O --pathimage=/Users/ghumbert/Desktop/Piscine-Java/day04/ex00/image.bmp



java -classpath target edu.school21.Program --black=<symbol> --white=<symbol> --pathimage=<Absolute path>


--black<symbol> - here you specify the symbol that will replace the black color
--white<symbol> - this is the symbol that will replace the white color
--pathimage<Absolute path> - the absolute path of the black and white image is specified hereImagesToChar