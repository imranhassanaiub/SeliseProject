# SELISE Project (OrangeHRM Demo)

#### To Run this Project

1. Go to Eclipse > Right Click > Import > Projects From Git > Clone URI > Provide URL of Github project
2. It will Download all the necessary dependencies and prepare the project to run in Eclipse
3. Go to src/main/java > com.bitm.SeliseProject.Utilities > DriverManager.java  and change the local path of gecko driver in static block and save the file.
4. Go to Suite.xml > Right click > Run As > TestNG Suite
5. The project will run and show details in console

#### To see the Screenshot of Failed Page

1. Please Create a folder on Desktop (windows OS) named "Screenshot" and after failing deliberately it will take a screenshot on the desire folder.

OR

2. Go to Go to src/main/java > com.bitm.SeliseProject.Utilities > TestNGReporting.java and on onTestFailure() method change the desfile variable value to your desired path.

#### To see the Dependencies related to the project

Please Go to the pom.xml file, there all the necessary version details are present
