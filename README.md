# inseminaplus
*Insemina plus é marketplace de insumos bovinos e equinos para inseminação artificial*

## application.properties

**MongodbAtlas:**

   * spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<clusterName>.mongodb.net/< databaseName >

   * spring.data.mongodb.database=< databaseName >

## Apache Maven
```bash
mvn spring-boot:run
```
## Mongosh Mongodb
```bash
db.roles.insertMany([
   { name: "ROLE_COMPRADOR" },
   { name: "ROLE_VENDEDOR" },
   { name: "ROLE_ADMIN" },
])
```
## Endpoints

**POSTS:**
* /api/auth/signup|Create an account
* /api/auth/signin|Login into an account

**GETS:**
* 







