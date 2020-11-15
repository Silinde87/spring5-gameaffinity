[![CircleCI](https://circleci.com/gh/Silinde87/spring5-gameaffinity.svg?style=svg)](https://app.circleci.com/pipelines/github/Silinde87/spring5-gameaffinity)
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- PROJECT LOGO -->
<p align="center">
  <h1 align="center">GameAffinity - CRUD WebApp</h1>
  <p align="center">
    A CRUD Operation WebApp using Spring Framework 5, Vaadin Framework and MySQL on Docker Container.
    <br />
    <a href="https://github.com/Silinde87/spring5-gameaffinity"><strong>Explore the docs</strong></a>
    <br />
    <br />
    <a href="https://github.com/Silinde87/spring5-gameaffinity/issues">Report Bug</a>
    or
    <a href="https://github.com/Silinde87/spring5-gameaffinity/issues">Request Feature</a>
  </p>
</p>




<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [Contact](#contact)
* [Acknowledgements](#acknowledgements)



<!-- ABOUT THE PROJECT -->
## About The Project

[![Watch the video](https://raw.githubusercontent.com/Silinde87/spring5-gameaffinity/master/src/main/resources/static/images/MainScreenshot.png)](https://www.youtube.com/watch?v=T-EfOEPmDmI)


This is a web application that has been developed for learning purposes, in this you can handle CRUD operations in a SQL database.
During development, I've deployed a docker container creating a local MySQL server.

I've being using Test Development Driven and Continuous Integration during the process to check everything is fine. 
Check the tests [here](https://github.com/Silinde87/spring5-gameaffinity/tree/master/src/test/java/spring5/silinde87/gameaffinity/backend).


Features:
* CRUD Operations in Games, Developers, Producers, Genres and Platforms Columns from DB.



### Built With

* [Spring Framework 5](https://spring.io/)
* [Vaadin Framework](https://vaadin.com/)




<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

* Deploy a MySQL instance on a Docker Container. [More information](https://hub.docker.com/_/mysql)
```sh
$ docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag
```
* Create and configure the DB using the scripts included in repository.
  * [MySQL Configuration](https://github.com/Silinde87/spring5-gameaffinity/blob/master/src/main/resources/scripts/configure-mysql.sql)
  * [MySQL Table Creation](https://github.com/Silinde87/spring5-gameaffinity/blob/master/src/main/resources/scripts/database-create.sql)

* Populate the Database with some demo information about Genres, Platforms, developers and Producers.
  * [Demo data Query](https://github.com/Silinde87/spring5-gameaffinity/blob/master/src/main/resources/data-h2.sql)

### Installation & use

* Clone the repo
```sh
git clone https://github.com/Silinde87/spring5-gameaffinity.git
```
* Install NPM packages
```sh
npm install
```
* Run the App
```sh
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```


<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/Silinde87/spring5-gameaffinity/issues) for a list of proposed features (and known issues).



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


<!-- CONTACT -->
## Contact

Pau Rodríguez Molina - [LinkedIn](https://www.linkedin.com/in/paurodriguezmolina/) - paurodriguezmolina@gmail.com

Project Link: [https://github.com/Silinde87/spring5-gameaffinity](https://github.com/Silinde87/spring5-gameaffinity)



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [CircleCI](https://circleci.com/)
* [Docker](https://www.docker.com/)
* [MySQL](https://www.mysql.com/)






<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=flat-square
[issues-url]: https://github.com/Silinde87/spring5-gameaffinity/issues
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/paurodriguezmolina/
[product-screenshot]: images/screenshot.png


<!--
Thanks othneildrew for this README Template.
https://github.com/othneildrew/Best-README-Template/blob/master/README.md
-->