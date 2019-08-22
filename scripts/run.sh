cd ..
javac -cp . Source\ Code/src/edu/rpi/cs/csci4963/u19/tumats/hw05/farmers_market/*.java
mkdir -p Source\ Code/out/production/edu/rpi/cs/csci4963/u19/tumats/hw05/farmers_market
mv Source\ Code/src/edu/rpi/cs/csci4963/u19/tumats/hw05/farmers_market/*.class Source\ Code/out/production/edu/rpi/cs/csci4963/u19/tumats/hw05/farmers_market
javadoc -private -splitindex -use -author -version -d ./docs -classpath "./Source Code/src:" edu.rpi.cs.csci4963.u19.tumats.hw05.farmers_market
java -cp "Source Code/out/production:./Source Code/mysql-connector-java-8.0.17.jar" edu.rpi.cs.csci4963.u19.tumats.hw05.farmers_market.DatabaseLoader