### How to use:

You can use an API Test application, Postman or Insomnia, to test the endpoints you'll clone the project
to your machine and run, you'll need Java 17 and Maven 3.8.1. The commands to clone and to run are the following:

#### Clone/ Download Code:

You can download the code from github repo or upload the .zip file in any IDE like intellij IDEA

#### Running application:
please run-  ```sh run_application.sh``` shell script. It will do the following:

- Create docker container ***spring-rest-api*** for backend application
- Create docker container ***postgres-db*** for postgres relational database

### Testing application:
- Application has spring security enabled and can be access through role based access control
- Two roles- ```ADMIN & USER``` has been defined
- user
   ```
  user: Test1
  password: 123
  roles: ADMIN, USER
  
  user: Test2
  password: 123
  roles: USER
  ```
- Application has two endpoints 
    - v1/userInfo/{phoneNumber} ***Accessible by Admin & User role***
    - v1/userInfo/all ***Accessible by only Admin role***
  
  
#### Step 1:
- Get Access token based on User & level of authorization
        ````curl --location 'http://localhost:8080/v1/auth/generateToken' \
      --header 'Content-Type: application/json' \
      --header 'Cookie: JSESSIONID=B14325415361B349806D342A26BD00BA' \
      --data '{
      "username": "Test1",
      "password": "123"
      }'````
    
### Step 2: Testing v1/userInfo/{phoneNumber}
- Paste the bearer token from step 1 into Authorization header of this curl request
    ``curl --location 'http://localhost:8080/v1/userInfo/6722939175' \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUZXN0MiIsImlhdCI6MTcxMjEzNDcyNiwiZXhwIjoxNzEyMTM2NTI2fQ.bVfMlV9YV-99yL__yXQhUXPcttgSeNgnNMKdJzGiixk' \
  --header 'Cookie: JSESSIONID=B14325415361B349806D342A26BD00BA'``

### Step 3: Testing v1/userInfo/all
- Paste the bearer token from step 1 into Authorization header of this curl request
  ``curl --location 'http://localhost:8080/v1/userInfo/all' \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUZXN0MSIsImlhdCI6MTcxMjEzMTIyMiwiZXhwIjoxNzEyMTMzMDIyfQ.EYqhYR7FhGWQzcZqSnGV5PcS9hIzQRwTKmYvrUxt9ws' \
  --header 'Cookie: JSESSIONID=B14325415361B349806D342A26BD00BA'``

### Step 4: Accessing v1/userInfo/all with Test2 user i.e. USER role
- Paste the bearer token from step 1 into Authorization header of this curl request, make sure you use ``Test2 user`` to generate token.
  
    ``curl --location 'http://localhost:8080/v1/userInfo/all' \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUZXN0MSIsImlhdCI6MTcxMjEzMTIyMiwiZXhwIjoxNzEyMTMzMDIyfQ.EYqhYR7FhGWQzcZqSnGV5PcS9hIzQRwTKmYvrUxt9ws' \
  --header 'Cookie: JSESSIONID=B14325415361B349806D342A26BD00BA'``

You will get ***403*** error code as role **USER** is not authorized to access this endpoint