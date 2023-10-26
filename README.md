# inseminaplus

## MySql
```bash
sudo systemctl start mysqld
```
## application.properties

**MongodbAtlas:**

   * spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<clusterName>.mongodb.net/< databaseName >

   * spring.data.mongodb.database=< databaseName >

**MySql:**
   * spring.datasource.url= jdbc:mysql://localhost:3306/<database ame>?useSSL=false
   
   * spring.datasource.username= root
   
   * spring.datasource.password=< rootPassword >
   
   * spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQLDialect
   
   * spring.jpa.hibernate.ddl-auto= update

## Maven
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
* /api/client|Register client
* /api/clients/{clientId}/products|Register product
* /api/clients/{clientId}/orders|Register order
* /api/orders/{orderId}/items|Register item





