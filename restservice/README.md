This project is made following the tutorial on spring.io/guides/gs/rest-service to build a service that takes get requests at http://localhost:8080/greeting?name=User to responde with a Json like this:
{"id":1,"content":"Hello, User!"}
if no name is provided (http://localhost:8080/greeting), the string "Hello, User!" will take a dafault value of "Hello, world"