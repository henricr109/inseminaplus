# inseminaplus

trocar no application.properties dentro do resources:

MongodbAtlas(Em nuvem, portanto não é necessário abrir o servidor do database):

spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<clusterName>.mongodb.net/< databaseName >

spring.data.mongodb.database=< databaseName >

MySql(servidor local é necessário subir servidor):

Subir servidor MySql

spring.datasource.url= jdbc:mysql://localhost:3306/<database ame>?useSSL=false

spring.datasource.username= root

spring.datasource.password=< rootPassword >

spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQLDialect

spring.jpa.hibernate.ddl-auto= update

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

POSTS-USE ARQUIVO DE POST PARA TESTAR SIGN UP E SIGN IN DO MONGODB->inseminaPlus Requests.postman_collection.json

POST 	/api/auth/signout     logout the account

Header nos metodos de autorização get:

KEY : Authorization

VALUE:Bearer [TOKEN]

GET 	/api/test/all retrieve public content

GET 	/api/test/comprador access Comprador content

GET 	/api/test/vendedor access Vendedor content

GET 	/api/test/admin access Admin content

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////




