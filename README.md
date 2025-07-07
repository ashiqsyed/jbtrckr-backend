# jbtrckr-backend

This is the backend for my personal project, jbtrckr, which is a job application tracker. It is built using Java Spring Boot in order to get more experience in using Java
for full stack development. I will be using a PostgreSQL database in a Docker container, and the Spring Boot application will be run on my local machine. This README will document my 
development/thinking/learning process as I develop this project to get more comfortable with full stack development using Java Spring Boot. This backend is being developed alongside the frontend
of the project.

## jbtrckr

The purpose of this application is to act as a job application tracker. I was thinking of various applications that I can build to improve my full stack development skills, more specifically various types of CRUD
apps. I was debating between an Album rating/sharing platform or this one. Since I am currently on the search for an entry level/new grad software engineering position, I decided to go with the one that could potentially
solve a problem that other new grads have - tracking job applications. I decided to use the tech stack I am currently using to build this application because I wanted to expand the types of technologies I work with. I have 
experience using Next.js through other projects, so I decided to stick with it for this project since I already have React experience. I chose Java Spring Boot over other backend languages/frameworks because I had more experience
with Java compared to other backend languages, and I am aware of Spring Boot being in higher demand than other backend frameworks (especially for entry level software engineering positions). Finally, after some project planning, I decided to use PostgreSQL for my
database (inside a docker container) because I believed that using a relational database would make implementing some of the things I would like to implement slightly easier. Along with this, I knew that I would gain proper 
experience with SQL, a relational database and an RDBMS.

## Development

### CRUD Operations

I started this whole project by developing the basic REST API that is needed for the core functionality of this application, with the intention of improving on it by adding authentication, etc. Watching an Amigos Code Spring Boot tutorial was an immense help
for getting familiar and learning Spring Boot. Watching that video allowed me to learn how to create the basic endpoints for this project. I tested the routes that I wrote using Postman. Once verifying that all the written routes worked, I threw together a very basic
UI using Figma and developed it as a Next.js project. The UI will be improved as I continue to develop this project as a whole. After developing the UI, I made sure that the CRUD operations worked across the entire stack (the request starting in the frontend, going to the backend,
retrieving something from the database and sending that information back to the frontend through the backend.) Once I verified that all of the CRUD operations worked across the stack, I decided that I should learn OAuth in Spring Boot.

### User Authentication and Authorization

User Authentication and Authorization using JWT (OAuth) was next for me. I already have experience using JWT-Based user authentication building a group project using the MERN stack, so I was aware of the general process (Token creation, verification, etc). I decided to go along with
this for securing the application. To learn more about Spring Security and OAuth, I watched YouTube videos and used ChatGPT to give me a tutorial on what to do, along with in depth explanations so that I was able to fully understand the process and what goes on in the Spring Boot backend.