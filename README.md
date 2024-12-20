# 🚀🚀  Blogs Microservices project  🚀🚀

to run the project on your local environement make sure you have docker installed 
1. Open the terminal in the project folder.
2. (Optional) Make any necessary changes to the `docker-compose.yml` file.
3. Run the following command to start the services:

```bash
docker compose up -d
```
2. **Add the Existing Module**:
   - Make sure you select services folder with the cursor
   - In the top menu, click on **File** > **New** > **Module from Existing Sources...**
   - Browse to the directory of the existing Spring Boot module you want to add.
   - Select the pom.xml file  and click **OK**.
repeat for every microservice in the folder .
### important ⚠️
refer to the Userclient interface in the blog-service to understand how i implemented the microservices internal communication security 

⚠️ remove the dependecies of zipkin from every pom.xml file if you have deleted the zipkin from the docker-compose.yml file 
```xml
    <dependency>
			<groupId>io.micrometer</groupId>
			<artifactId>micrometer-tracing-bridge-brave</artifactId>
		</dependency>
		<dependency>
			<groupId>io.zipkin.reporter2</groupId>
			<artifactId>zipkin-reporter-brave</artifactId>
		</dependency>
```
after creating a realm and a client with names and id's microservices in keyclaok make sure to craete a role "ADMIN" & "USER" .
