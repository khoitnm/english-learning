# Project Improve (17/Feb/2017)
After a while, I understand more clearly what I want, it will need much more complicated relationships between entities. 
So MongoDB is not suitable anymore for the future. The GraphDB, particular Neo4j, will be a suitable solution no handle it.
Besides that, I will redesign the entities structure of the whole project, all the business entities are going to be changed. 
Therefore, this project is stopped here, it will be replaced by another project: https://github.com/khoitnm/language-note

# English-learning
Personal Project which supports learning English.

With this project, a user can note his own vocabularies, phrases, idioms in any lessons, books.
After that, he can test his vocabularies. The test will show some explanations and then the user has to recall the correct vocabularies, phrases.
The user will get a score for each words, the words with the most failure answers will be more likely to appear in later tests.

# Run project
Build:
````
cd resource/static/
npm install

cd ../..
mvn clean install -DskipTests
````

Deploy:
````
cp target/english-learning.war {TOMCAT_HOME}/webapp/
````

MongoDB server start:
````
mongod -port 27117
````

# Security
The current main target is features implementation, the security will be improve later.
Now it's using Username - password authentication. The API only uses session to track authenticated user.
In the future, it should use OAuth2.

# Database
DB structure is still not good. However, as mentioned in Security, its main target is adding new features.

