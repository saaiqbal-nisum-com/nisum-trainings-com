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
This page contains a welcome message and serves as the landing page for this app. Above the message is the navigation bar for Page 1, 2 and 3. This navigation bar is consistent on all pages of the application. 

#### Page 2
This page contains a simple two number addition function that is used to demonstrate jUnit test cases. HTML IDs for the two number texfields are n1 and n2 respectively. Upon clicking the Sum button, the function returns the answer. Both textfields accept only numeric values. This operation is handled by the serverside code and the answer is returned in JSON format which is later displayed on the same page.

#### Page 3
This page displays the list of files in /src/main/resources/ folder. FileService.java prepares a list of files which is then used by TrainingController.java to display it on our page. Thymeleaf is used as the front-end technology to display this data.

## Guide on test cases for this app
Test cases are run when a build is being created. But, if only test cases are required to be run, one may execute the following command in terminal `mvn test`.
Test cases are written in `src\test\java\com\nisum\training\TrainingApplicationTests.java`.
Three sample test cases are added, i.e. contextLoads(), testAddTwoNumbers() and testAddTwoNumbersForLargeValue().
Taking testAddTwoNumbers() as an example on how these test cases work, trainingController.addNumbers adds two numbers and return a value, we will give it two numbers and assertTrue the correct answer, if it is indeeed the answer returned, this test case has passed. 
If we delibrately want the test case to fail, we can replace the expected correct values with wrong ones. For eg. 
`	@Test
	public void testAddTwoNumbers() {
		Long result = trainingController.addNumbers(2L, 3L);
		assertTrue("Numbers should be equal", result == 5L);
	}`
  would pass but 
  `	@Test
	public void testAddTwoNumbers() {
		Long result = trainingController.addNumbers(2L, 5L);
		assertTrue("Numbers should be equal", result == 1000L);
	}`
  would fail.
