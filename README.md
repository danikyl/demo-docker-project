### Installing

```
git clone https://github.com/danikyl/demo-docker-project.git
cd demo-docker-project
``` 

### Compiling and running the application

```
docker-compose up --build -d
``` 

### Running python script to send the requests containing data from the file "notificacoes.txt" and show the current state from the subscriptions in the database, along with the history of the events

```
python sendNotifications.py
``` 

or

```
python3 sendNotifications.py
``` 

### To do

-Add a new service in docker-compose responsible for a database container. Currently the application is using the H2
bank directly in memory, which causes data to be lost every time the application closes. The initial plan is to
orchestrate a container created from the MySQL image, however the communication between the application container and
the MySQL container was failing, so I adopted the H2 database as a matter of time.

# Java Backend Challenge

## The Challenge

### The challenge is about updating the user's signature according to notifications.

<img src="DesafioFila.png" width="500" height="500">

#### Types of Notifications:

- SUBSCRIPTION_PURCHASED - The Purchase has been made and the subscription must have an active status.

- SUBSCRIPTION_CANCELED - The Purchase has been canceled and the subscription must have a canceled status.

- SUBSCRIPTION_RESTARTED - Purchase has been retrieved and subscription must be in active status.

### Steps

- Receiving HTTP Notification
- Queuing
- Processing and Persistence

## General considerations

You should use this repository as the main project repo, i.e., all your commits must be logged here because we want to
see how you work.

This problem has some constraints:

1. Language: Java 8 or higher

2. Framework: Spring

3. Database: Any relational database

4. It should be possible to be able to run your code on Mac OS X OR Ubuntu;

5. RabbitMQ must be inside a compose(Docker)

6. We should be able to run your code in a local environment in some automated way:

   ``` git clone seu-repositorio
    cd seu-repositorio
    ./configure (ou algo similar)
    docker-compose up -d
    make run (ou algo similar como java -jar desafio.jar)
    make sendNotifications 
    
    
    obs: It doesn't necessarily have to be that way, but it needs to be automated and documented.
   ```

7. We should have automated calls to the api with notifications attached in the file [notificacoes.txt], obligatorily
   following the file order (NOTE: It can be done in any programming language).

These commands should be enough to start up RabbitMQ, the Java application and the API calls. can if consider that we
have installed on my system: Java, Python and Ruby and Docker. Any other dependencies I need you have to provide.

## Database Model

![Model](database_model.png)

## Execution

After the environment initialization (Docker/Rabbit/Application), run the Notifications sending script and it is
expected that the status of the subscription is in accordance with the notifications received, in addition it must
contain the entire history of notifications for each subscription for a possible audit.
