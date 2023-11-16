# White Box testing with Junit 
This is a simple white-box testing using junit tools. <br>

> Disclaimer: This testing is for educational purposes and not designated for production. The code and test cases may contain bugs.

## Technologies 
- Java SE
- Junit
- Maven 

## Prerequisites 
- IDE (Preferably IntelliJ. <a href="https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC">Download IDE</a>.)
- Maven setup (<a href="https://www.jetbrains.com/help/idea/maven-support.html">IntelliJ setup</a>)

### Setup 

> I assume that the IDE being used is **IntelliJ Idea**. <br>

This java project is built using `Maven`. Read more about `Maven` <a href="https://maven.apache.org/what-is-maven.html">here</a>. <br> 
I already included the necessary configurations for this testing project inside `pom.xml`.
 - Clone the repository - `git clone https://github.com/YU88John/whitebox-junit.git`
 - Install necessary `junit` packages - `mvn clean install` <br>
 - Compile the source file - `javac Utils.java`
<br>
    *Note:* The `JDK` used for Maven is `JDK 17`. If any error comes up, ensure you have the same `JDK` version.
   - Check your `JDK` version - `java -version`
   - If it's different, install `JDK 17` - `sudo apt-get update` and `sudo apt install openjdk-17-jdk`
   - (or) Not recommended but you can change `pom.xml` - `<maven.compiler.source>17</maven.compiler.source>` replace `17` with your `JDK` version. 
<br> <br>
 - Right click on `UtilsTest.java` > `Run 'UtilsTest'`
   - `testSumFile()` is written to be failed intentionally.

