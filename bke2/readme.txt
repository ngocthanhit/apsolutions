A Building Servlets
-------------------
Typing ant from the root bke2 folder compiles all java codebase including the Servlet and util folder. 

Modifying JSPs
--------------
JSPs, JavaScripts, Images and AJAX components can be modified under the folder /webapps/..
Once the contents of this folder is copied over to bke2 application context in Tomcat a complete application is ready to run.

Modifying DelApplet.jar
----------------------
CD to "jarsign.local" folder and make apt changes and then type ant to build.
Move the new DelApplet.jar file to the Tomcat Webapps folder .../bke2/
