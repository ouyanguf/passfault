Welcome to OSWAP Passfault
==============
Our Objective: 

Do Passwords Better.

Passfault is licensed under Apache 2.0 license, and is a project at OWASP, the Open Web Application Security Project, a non-profit organization dedicated to building security tools and learning resources.

Building and Running
=================
The core library includes a command-line interface.  
1) install java and gradle
2) cd core 
3) gradle build
4) java -jar core/build/lib/core-0.7.jar

The JSON service is the same as is hosted on passfault.com.  It includes a javascript front-end that hits the json service with password analysis requests.
1) cd jsonService
2) gradle build jettyRunWar
3) browse to localhost:8080/jsonService

Other projects include a client side non-gui Applet (accessible via javascript and returns JSON), and a JavaFX 1.x client.  Those projects do not have a well established build and will likely require some tweaking.
