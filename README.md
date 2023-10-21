# inseminaplus

trocar no application.properties dentro do resources:

spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<clusterName>.mongodb.net/< databaseName >

spring.data.mongodb.database=< databaseName >

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Precisa do maven

mvn spring-boot:run - Inicia o programa

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Precisa add as roles no database antes de tentar usar os endpoins caso não haja

db.roles.insertMany([
   { name: "ROLE_COMPRADOR" },
   { name: "ROLE_VENDEDOR" },
   { name: "ROLE_ADMIN" },
])

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Usos endpoints - use postman

POSTS USE ARQUIVO DE REQUEST - inseminaPlus Requests.postman_collection.json

POST 	/api/auth/signout     logout the account

Header nos metodos get:

KEY : Authorization VALUE:Bearer [TOKEN]

GET 	/api/test/all retrieve public content

GET 	/api/test/comprador access Comprador content

GET 	/api/test/vendedor access Vendedor content

GET 	/api/test/admin access Admin content

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////


