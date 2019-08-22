Srikanth Tumati
===============

Instructions
------------

1) Confirm MySQL is running on default port (port 3306) and if not, change it to the default port 

2) Execute run.sh. This will initialize the database needed for the application. A database titled "farms" will be created and tables titled "locationData" and "farmData" will be created inside of this database. Wait for the script to terminate and print "done!" on the last line and then move on.

3) Download the binary distribution of "Core" of Tomcat 9 (though previous versions should work as well) from https://tomcat.apache.org/download-90.cgi and then also unzip the file after downloading. 

4) Then, move both files in the "Web Application Files" folder to the "webapps" directory that is inside of the Tomcat folder. 

5) Lastly, open SQLCredentials.txt inside of the "farms" directory enter your particular SQL Credentials with the username on the first line and the password on the second line. Then simply start Tomcat by running "./catalina.sh run".

6) Go to 127.0.0.1/farms/hello.jsp

Tested on the following Operating Systems
-----------------------------------------

Mac OS Catalina 10.15 Oracle JDK 12

Additional Directories
----------------------

The "Source Files" directory was made so the "src' folder, the data files, and the sql connector could be on the same level while keeping the root folder of the project clean.

Troubleshooting
---------------

If run.sh is not executable, move into the directory in which it is placed and run
the following command. 'chmod +x run.sh'