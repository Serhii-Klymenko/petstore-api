DESCRIPTION:

Project contains:
- automation tests for Swagger Petstore
- Split class folders: endPoint, model, test

Were implemented tests:
- pet API
- store API

SETUP:

Installing Intellij idea: (macOS)

1. Install ‘Homebrew’ (Package Manager for macOS)
1.1 Open https://brew.sh
1.2 Copy /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"
1.3 Paste the link in ‘Terminal’ and execute
1.4 Check that 'Homebrew' is installed. Execute brew -version

2. Install JDK (Java Development Kit) via 'Homebrew'
2.1 Paste 'brew cask install java’ in ’Terminal’ and execute
2.2 If you use macOS Catalina and have problem with security, execute brew cask reinstall java --no-quarantine
2.3 Check that java is installed. Execute java -version

3. Install Intellij idea
3.1 Open https://www.jetbrains.com/idea/download/#section=mac
3.2 Download ‘Community’ version
3.3 Install on your computer

4. Install Maven via Homebrew brew install maven
4.1 Verify that Maven was installed mvn -version

5. Install Serenity BDD (for RestAssured)
Choose version and copy in pom.xml from link
https://mvnrepository.com/artifact/net.serenity-bdd/serenity-rest-assured

6. Install Serenity BDD (for JUnit)
Choose version and copy in pom.xml from link
https://mvnrepository.com/artifact/net.serenity-bdd/serenity-junit

7. Install Serenity BDD (for Reports)
Choose version and copy in pom.xml from link
https://mvnrepository.com/artifact/net.serenity-bdd.maven.plugins/serenity-maven-plugin
7.1 View Serenity HTML report
After TestRunning execute:
    mvn serenity:aggregate
    
8. Install Lombok plugin (for Getter/Setter/Builder)
8.1 Choose version and copy in pom.xml from link
    https://projectlombok.org/setup/maven
8.2 Open Preferences
8.3 Choose 'Plugin'
8.4 Install 'Lombok'
