SMS API

The API exposes four endpoints:

a. signin [POST] - to get your jwt token

b. generate-token [GET]- to get your call limit

c. inbound/sms [POST] - to send inbound sms

d. outbound/sms [POST] - to send outbound sms.

ARCHITECTURE OVERVIEW

1. domain - defining the models
2. Dto - defining the data transfer objects
3. redisconfig - defines configuration properties for our redis server
4. repository - data access for both MySQL and redis
5. security - spring security configurations
6. service - business logic
7. controller - routes for API calls

The application uses Bucket4j for rate limiting

DATABASE MIGRATION

The application uses liquibase for database migration. Kindly ensure queries for all schema changes are created in a file in the resource classpath and registered in the liquibase dbchangelog master.xml file.

SETUP

The application is built with Java 17, it can however be compiled with Java 8 upwards.

If you dont want to setup the code on your machine, please skip to #6

1. If you want to setup the code on your host, install JDK 8 or 17 (both are LTS Java versions).

2. Install mysql https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/

3. Install Redis. you can get the zip archive at https://github.com/microsoftarchive/redis/releases/tag/win-3.2.100

4. Install IntelliJ IDEA or any fully-featured Java IDE of your choice.

5. Clone this repository to your IDE of choice.

6. You can run the run the build with having to setup the code yourself.

7. Just install JRE 8 or 17 on your host

8. Copy the fat jar from target/accounts-0.0.1-SNAPSHOT.jar

9. On your windows shell or mac or linux, navigate to the path you copied the jar to and execute the command "Java -jar accounts-0.0.1-SNAPSHOT.jar"
10. Try it out from the swagger at http://localhost:9999/account-mmk/swagger-ui/index.html


SAMPLE REQUEST

First, get your jwt token

http://localhost:9999/users/signin

{
"username":"azr1",
"auth_id":"20S0KPNOIM"
}

For everyother calls, pass the token in header as Authorization parameter. prefix with "Bearer "
Token expires in 10mins. Generate another one.

http://localhost:9999/inbound/sms

{
"from":"34356765444",
"to":"4924195509198",
"text":"STOP"
}

For outbound/sms API, you need to first call the limit throtlling endpoint first.

http://localhost:9999/outbound/sms/generate-token

Then;

http://localhost:9999/outbound/sms

{
"from":"34356765444",
"to":"4924195509198",
"text":"STOP"
}
