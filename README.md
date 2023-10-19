# inseminaplus
Precisa do maven
mvn spring-boot:run - Inicia 
//////////////////////////////////////
Precisa add as roles no database antes de tentar usar os endpoins caso não haja
db.roles.insertMany([
   { name: "ROLE_USER" },
   { name: "ROLE_MODERATOR" },
   { name: "ROLE_ADMIN" },
])
//////////////////////////////////////
Usos endpoints
POST 	/api/auth/signup 	signup new account
POST 	/api/auth/signin 	login an account
POST 	/api/auth/signout 	logout the account
GET 	/api/test/all 	retrieve public content
GET 	/api/test/user 	access User’s content
GET 	/api/test/mod 	access Moderator’s content
GET 	/api/test/admin 	access Admin’s content
//////////////////////////////////////
spring.data.mongodb.database=inseminaplus_db(nome database)
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
(por enquanto uso de mongodb local)
