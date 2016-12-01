# NotificationCentre

How to start the NotificationCentre application
---

1. Unzip "TheNotificationCentre.zip"
2. Change directory by running "cd TheNotificationCentre"
3. Run "mvn clean install" to build your application
4. Start application with "java -jar target/TheNotificationCentre-1.0-SNAPSHOT.jar server config.yml"
5. To check that your application is running enter url "http://localhost:9000"


Functional Requirements of the application
---

1. Display a list of notifications, ordered by Notification Date and grouped by type

The list can be displayed by opening any web browser and searching for the following url:
"http://localhost:9000/notifications/"
The link above sends the following GET request:
 "GET /notifications/ HTTP/1.1"

2. Display a detailed view to inspect an individual notification

In order to inspect an individual notification user needs to run the following url:
"http://localhost:9000/notifications/{notificationGuid}"
For example: "http://localhost:9000/notifications/532a20d3-aef0-4554-9bc1-9561dbd6151c"
The link above sends the following GET request:
"GET /notifications/532a20d3-aef0-4554-9bc1-9561dbd6151c HTTP/1.1"

3. Display whether the notification has been read or not

In order to check if a notification is displayed users need to use the following url:
"http://localhost:9000/notifications/isread/532a20d3-aef0-4554-9bc1-9561dbd6151c"
For every notification there is an extra value called "isRead" that is set False. It can be seen every time the user inspects a individual element ("isRead":false).
The link above sends the following GET request:
"GET /notifications/isread/532a20d3-aef0-4554-9bc1-9561dbd6151c HTTP/1.1" 

4. Provide a means of making a notification as read

In order to mark a notification as read a PUT request is needed. The url that must be used is:
http://localhost:9000/notifications/update/read/{notificationGuid}/true
or in our example
http://localhost:9000/notifications/update/read/532a20d3-aef0-4554-9bc1-9561dbd6151c/true

5. Provide a means to delete notifications

A means to delete a notification is provided as well. In this case a DELETE request is used. The link that should be used is:
http://localhost:9000/notifications/delete/{notificationGuid}
or in our example
http://localhost:9000/notifications/delete/532a20d3-aef0-4554-9bc1-9561dbd6151c


Health Check
---

To see your applications health enter url `http://localhost:9001/healthcheck`
