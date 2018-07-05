# BlueHarvestAPI

The following assessment consists in two parts:
* Backend - REST API built with SpringBoot
* Frontend - Client app built with React JS framework and ES6 JavaScript


## Backend

At root, the project is created as a SpringBoot application. I used Maven as a software management tool, in order to manage all the dependencies involved. The `pom.xml` file is also created using [Spring Initializr](https://start.spring.io/) because it is tightly coupled with Groovy, so I needed to have a custom maven configuration in order to run on Groovy as well.

I chose Groovy's Spock framework to write the tests for the API, because Groovy is a very flexible language, as it is “weakly” typed. Also, I generally consider Groovy to have far better options in terms of `Collections` than Java. The `APITest` class runs the tests as standalone using `@SpringBootTest` configuration.

The three main entities of the API are: __User__, __Account__ and __Transaction__.

For each of these entities, I have followed a classic Spring web application architecture, by providing:

* __Model:__ Entity's class model with fields and methods
* __Service:__ Provides CRUD operations for the respective entity
* __Configuration:__ Provides the beans for entity's service, in order to be injected wherever they needed
* __Repository:__ As the challenge implied saving the objects in memory, I have created a `UserRepo` entity to store all the data during runtime. This proved to be also very useful when writing the tests as well.
* __Controller:__ Basic REST API which supports creating, updating and fetching the users based on different parameters.

An important notice is that inside the controller I had to use `@CrossOrigin(origins = "http://localhost:3000")` in order to bypass the cross-origin resource sharing, imposed by the Chrome browser and I also needed to install the [Allow-Control-Allow-Origin: *](https://chrome.google.com/webstore/detail/allow-control-allow-origi/nlfbmbojpeacfghkpbjhddihlkkiljbi) in order to allow network requests between the two ports.


## Frontend

The frontend module has been created using [create-react-app](https://github.com/facebook/create-react-app) for rapid prototyping. As I have mentioned before, I used ReactJS to build a very rudimentary SPA, in order to rapidly visualize the response data of the backend API.

The (user defined) root of the application is `BlueHarvestAPI` and it is the only component that stores state, so it's the only smart component in the module. The rest of the components are functional 'dumb' components, with the exception of `UserTable` component which is a class component, in order to access the `componentDidMount` lifecycle method. The HTTP requests are created with `axios` and are stored as a service inside `Service.js` file and are provided to the consumer through a revealing module pattern.

The web app offers the possibility of creating and updating a specific user and also to visualize the fetched data over a table component, reused from [Material-UI](https://v0.material-ui.com/#/).

### Steps to run the app:
* 1st - enable CORS (download CORS chrome extension and add `http://localhost:3000` and `http://localhost:8080` to _Intercepted URLs_) 
* 2nd - open a new terminal tab and `npm start` inside _BlueHarvestAPI/frontend_
* 3rd - open a new terminal tab and `mvn spring-boot:run` inside  _BlueHarvestAPI/_
* 4th - open a new chrome tab and access `http://localhost:3000`
* 5th - think about how tiny we are and how we sit on a tiny piece of rock in the endless universe

## Screenshot

![frontend](https://raw.githubusercontent.com/LutaGeorgeGabriel/BlueHarvestAPI/master/frontend/src/resources/frontend.png)
