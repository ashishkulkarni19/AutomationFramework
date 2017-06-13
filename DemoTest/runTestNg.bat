set projectLocation=D:\ProjectForJenkin\ProjectForJenkin\DemoTest
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause