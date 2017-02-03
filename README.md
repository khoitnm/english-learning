# English-learning
Personal Project which supports learning English.

With this project, a user can note his own vocabularies, phrases, idioms in any lessons, books.
After that, he can test his vocabularies. The test will show some explanations and then the user has to recall the correct vocabularies, phrases.
The user will get a score for each words, the words with the most failure answers will be more likely to appear in later tests.

# Run project
Build: 
cd resource/static/
npm install

cd ../..
mvn clean install -DskipTests

Deploy:
cp target/english-learning.war {TOMCAT_HOME}/webapp/

# Security
Now the project doesn't focus much on security, its main target is features implementation.
Now it's using Username - password authentication. The API only uses session to track authenticated user.
In the future, it should use OAuth2.

# Database
DB structure is still not good. However, as mentioned in Security, its main target is adding new features.
