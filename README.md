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
### Techonlogies Used
* RabbitMQ `https://www.rabbitmq.com/install-standalone-mac.html`
* Java 
* Maven
* Spring Boot

### Steps to Run
```
mvn spring-boot:run
```
This command will start the application on port 8080. There is a rest endpoint _/message_ which takes the message as a plain text and publishes to the message and there is a listener which listens the queue and logs the published message in the console.

### Project Structure
java
    |_	com
	|_ spring
		|_ rabbitmq
			|_ controller
			|	|_ MessageController
			|_ service
				|_ MessageListenerService
				|_ MessageSenderService
			DemoApplication
resources
	|_ context.xml
	|_ rabbitmq_context.xml
	
`MessageController` is the rest end point which consumes plain text and helps in publishing the messaging on the queue. The services helps in subcribing and publishing the message. `rabbitmq_context.xml` has the rabbitmq configuration. 

### Configuring RabbitMQ
```
    <rabbit:topic-exchange id="my.first.exchange" name="my.first.exchange">
        <rabbit:bindings>
            <rabbit:binding queue="my.first.queue" pattern="my.#.*"/>
        </rabbit:bindings>
    </rabbit:topic-exchange>
```
This creates the exchange called `my.first.exchange` and binds the queue called `my.first.queue`. The pattern is used for defining the routing key. This means, the queue will accept all the message with routing key starts with "my". 

```
    <bean id="messageListener" class="com.spring.rabbitmq.service.MessageListenerService" />

    <rabbit:listener-container connection-factory="connectionFactory">
        <rabbit:listener ref="messageListener" queues="my.first.queue" />
    </rabbit:listener-container>
```
This makes the MessageListenerService to listen on the queue `my.first.queue`. 

###rabbitmq-context.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:rabbit="http://www.springframework.org/schema/rabbit"
       xsi:schemaLocation="http://www.springframework.org/schema/rabbit
           http://www.springframework.org/schema/rabbit/spring-rabbit.xsd
           http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <rabbit:connection-factory id="connectionFactory" host="localhost" username="guest" password="guest" />

    <rabbit:admin connection-factory="connectionFactory" />

    <rabbit:template id="messageSender" connection-factory="connectionFactory"  exchange="my.first.exchange"/>

    <rabbit:queue id="my.first.queue" name="my.first.queue" />

    <rabbit:topic-exchange id="my.first.exchange" name="my.first.exchange">
        <rabbit:bindings>
            <rabbit:binding queue="my.first.queue" pattern="my.#.*"/>
        </rabbit:bindings>
    </rabbit:topic-exchange>

    <bean id="messageListener" class="com.spring.rabbitmq.service.MessageListenerService" />

    <rabbit:listener-container connection-factory="connectionFactory">
        <rabbit:listener ref="messageListener" queues="my.first.queue" />
    </rabbit:listener-container>

</beans>
```

### MessageListener
`MessageListenerService` class implements the interface provided by spring called `org.springframework.amqp.core.MessageListener` and the method `onMessage` has to be defined (Here, the published message properties and body is been logged)

### MessageSender
`MessageSenderService` serves the prupose of publishing the message. It uses `org.springframework.amqp.core.AmqpTemplate` for converting and send the message.

###References
`https://keyholesoftware.com/2013/04/01/rabbitmq-with-spring-tutorial/`






