### Spring and RabbitMQ Integration.
This example walks you through the integration of Spring with RabbitMQ AMQP server that helps in asynchronous communication.

AMQP (Advanced Message Queuing Protocol) is an open standard application layer protocol for message-oriented middleware. The defining features of AMQP are message orientation, queuing, routing (including point-to-point and publish-and-subscribe), reliability and security. RabbitMQ is an open source message broker that supports the AMQP standard. 


### Dependencies
```
		<dependency>
			<groupId>org.springframework.amqp</groupId>
			<artifactId>spring-amqp</artifactId>
			<version>1.5.3.RELEASE</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.integration</groupId>
			<artifactId>spring-integration-amqp</artifactId>
			<version>2.1.3.RELEASE</version>
		</dependency>
```
###Requirements
* RabbitMQ `https://www.rabbitmq.com/install-standalone-mac.html`

### Steps to Run
```
mvn spring-boot:run
```
The spring boot application will start on port 8080. There is a rest endpoint _/message_ which takes the message as a plain text and publishes to the message and there is a listener which listens the queue and logs the message published.

