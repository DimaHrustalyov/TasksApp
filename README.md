# TasksApp
## Pre-required
* Install PostgreSQL 9.2
* Edit username/password and DB name in TasksApp/dao/src/main/resources/ac-dao.xml file
* Create DB with name from ac-dao.xml in PostgreSQL

## How to run
* Build project using maven
* Run on Apache Tomcat
 
## App credentials
* Login: Admin
* Password: 1234

## Note
* Database table created automatically during app run
```
<prop key="hibernate.hbm2ddl.auto">create</prop>
```
