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

## General Git instructions
`git clone https://github.com/shasham-nisumtest-com/nisum-trainings-com.git`
To clone a git repository using its web URL.

`git pull`
To pull any changes from remote repository to your local repository. Also if you are in a separate branch and wish to pull changes from another branch for eg. master branch to your current branch you can use `git pull master` .

`git checkout -b [branch name]`
To create a branch and switch to it.

`git status`
Checks status, useful to know if you have any uncommitted changes.

`git add example.java`
Used to add files that you wish to later commit.

`git commit -m “Added updated version of example.java.”`
Commit your changes with a message.

`git push`
Push your changes to remote.

A more detailed git command list is as follows:


### Getting & Creating Projects

| Command | Description |
| ------- | ----------- |
| `git init` | Initialize a local Git repository |
| `git clone ssh://git@github.com/[username]/[repository-name].git` | Create a local copy of a remote repository |

### Basic Snapshotting

| Command | Description |
| ------- | ----------- |
| `git status` | Check status |
| `git add [file-name.txt]` | Add a file to the staging area |
| `git add -A` | Add all new and changed files to the staging area |
| `git commit -m "[commit message]"` | Commit changes |
| `git rm -r [file-name.txt]` | Remove a file (or folder) |

### Branching & Merging

| Command | Description |
| ------- | ----------- |
| `git branch` | List branches (the asterisk denotes the current branch) |
| `git branch -a` | List all branches (local and remote) |
| `git branch [branch name]` | Create a new branch |
| `git branch -d [branch name]` | Delete a branch |
| `git push origin --delete [branchName]` | Delete a remote branch |
| `git checkout -b [branch name]` | Create a new branch and switch to it |
| `git checkout -b [branch name] origin/[branch name]` | Clone a remote branch and switch to it |
| `git checkout [branch name]` | Switch to a branch |
| `git checkout -` | Switch to the branch last checked out |
| `git checkout -- [file-name.txt]` | Discard changes to a file |
| `git merge [branch name]` | Merge a branch into the active branch |
| `git merge [source branch] [target branch]` | Merge a branch into a target branch |
| `git stash` | Stash changes in a dirty working directory |
| `git stash clear` | Remove all stashed entries |

### Sharing & Updating Projects

| Command | Description |
| ------- | ----------- |
| `git push origin [branch name]` | Push a branch to your remote repository |
| `git push -u origin [branch name]` | Push changes to remote repository (and remember the branch) |
| `git push` | Push changes to remote repository (remembered branch) |
| `git push origin --delete [branch name]` | Delete a remote branch |
| `git pull` | Update local repository to the newest commit |
| `git pull origin [branch name]` | Pull changes from remote repository |
| `git remote add origin ssh://git@github.com/[username]/[repository-name].git` | Add a remote repository |
| `git remote set-url origin ssh://git@github.com/[username]/[repository-name].git` | Set a repository's origin branch to SSH |

### Inspection & Comparison

| Command | Description |
| ------- | ----------- |
| `git log` | View changes |
| `git log --summary` | View changes (detailed) |
| `git diff [source branch] [target branch}` | Preview changes before merging |
