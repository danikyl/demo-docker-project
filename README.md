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
-Add a new service in docker-compose responsible for a database container. Currently the application is using the H2 bank directly in memory, which causes data to be lost every time the application closes. The initial plan is to orchestrate a container created from the MySQL image, however the communication between the application container and the MySQL container was failing, so I adopted the H2 database as a matter of time.


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

## Database Model

![Model](database_model.png)

## Execution

After the environment initialization (Docker/Rabbit/Application), run the Notifications sending script and it is expected that
the status of the subscription is in accordance with the notifications received, in addition it must contain the entire history of
notifications for each subscription for a possible audit.
