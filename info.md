Requirements
Build microservices 
Java,scala
Load balancing, monitoring  https://dzone.com/articles/7-things-to-consider-while-moving-to-a-microservic
Docker, kubernetees
Upload to gcp and try use for demo
| grep jpa look up linux things, refresh on pipes etc
Notes
You need an eureka service because it’s a discovery mechanism that your microservices can register and allows them to communicate.
 
Monolithic architecture – hard to make changes as application grows without affecting the rest of the code

Microservice architecture – load balancing, microservice problems are common/generic meaning that there are frameworks to deal with these issues.
Find common problems for microservices and try optimize project that way.
--
Service discovery is a design pattern.
Webservice vs microservice – webservices doesn’t know who or what it will be used for it just is there for people to use, microservice has an intended purpose and goal.
In Spring boot each microservice is a spring boot app.
To ensure APIs are backward compatible wrap things in an object when you return a list and an API is expecting an object you an compromise but when its expecting a list and you send it an object it will break, likewise when you change this any service depending on this 
ToDos
Find out how do you manage versioning in microservices
Find out how to not hard code urls
Do load balancing for example one service might be used often duplicate it several times, this is why hard coding urls is bad because now which url are you going to use ? they have to be allocated dynamically

