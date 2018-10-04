# nisum-trainings-com
## Steps for build creation

#### 1. Prepare build with maven

Run `mvn clean package`
This command will create a war file in the `target` folder i.e., `training.war`

#### 2. Deployment to tomcat

Copy the `training.war` file from target folder and paste it into `webapps` folder of tomcat.

## How to run the application

Start your tomcat server if it is not operational and navigate to the following address on your web browser: `http://localhost:8080/training/page1`.

## Guide on various components of Training App

#### Page 1
This page contains a welcome message and serves as the landing page for this app. Above the message is the navigation bar for Page 1, 2 and 3.

#### Page 2
This page contains a simple two number addition function that is used to demonstrate jUnit test cases. HTML IDs for the two number texfields are n1 and n2 respectively. Upon clicking the Sum button, the function returns the answer. Both textfields accept only numeric values. This operation is handled by the serverside code and the answer is returned in JSON format which is later displayed on the same page.

#### Page 3
This page displays the list of files in /src/main/resources/ folder. FileService.java prepares a list of files which is then used by TrainingController.java to display it on our page. Thymeleaf is used as the front-end technology to display this data.

## Guide on test cases for this app
