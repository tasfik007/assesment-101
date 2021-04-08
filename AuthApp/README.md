# Task-02: Build an Login Application.
<img src="https://i.ibb.co/5xMkF2F/dsi-authapp.png" alt="authapp" width="350"/>

## Things to note:
* The frontend (react) will be running in port 3000.
* And the backend (node server) will be running in port 5000.
* My mongodb connection strings are included to test the application.

## How to run the application in windows:
1. At first CD to AuthApp and open CMD
2. Then run "npm install" command to install the node app's dependencies.
3. After that CD to client folder and again run "npm install" command to install the react app's dependencies.
4. Then CD to AuthApp again by using "cd .." command.
5. Then type "npm run dev" without quotes. (this will start both the servers [react app at port 3000 and node app at port 5000] which I have done using concurrently)
6. If all goes well, login screen can be seen at the root url "http://localhost:3000/"
7. You can use the below credentials to get into the system:
    * Email: rahul@gmail.com
    * Password: rahul12345
8. After successful login, a welcome screen at the url "/profile" can be seen with the logged in user's name. If unsuccessful it will redirect to an error page.
9. User can logout from this page, and will be directed to root url "http://localhost:3000/", which is a login screen. If unsuccessful it will redirect to an error page.
10. By clicking in the "Create account?" link new user can be created.

## Bonus factors:
1. Responsive UI: Achieved through Bootstrap and custom CSS.
2. Framework: Express framework is used to build the nodejs backend.
3. Dependency Management: Done with the help of NPM module.
4. Version Control: Done using git and github.
5. Database: MongoDB Atlas platform used to integrate with MongoDB database.
6. Object Relation Mapping: Done with the help of Mongoose library.
7. Password is encrypted using bcrypt before saving user in database.

