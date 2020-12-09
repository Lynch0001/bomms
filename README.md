[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/lynch0001/bomms">
    <img src="/Capture.PNG" alt="Logo" width="400" height="80">
  </a>

  <h3 align="center">Bookstore Microservice Project</h3>

  <p align="center">
    App to facilitate learning Microservice development with Spring
    <br />
    <a href="https://github.com/lynch0001/bomms"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/lynch0001/bomms">View Demo</a>
    ·
    <a href="https://github.com/lynch0001/bomms">Report Bug</a>
    ·
    <a href="https://github.com/lynch0001/bomms/issues">Request Feature</a>
  </p>




<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)
* [Acknowledgements](#acknowledgements)



<!-- ABOUT THE PROJECT -->
## About The Project

[![Product Name Screen Shot][product-screenshot]](https://example.com)




### Built With

* []() Java 8
* []() Spring Cloud Hoxton.SR1
* []() Netflix Eureka
* []() Netflix Zuul
* []() Angular 8.3.4
* []() Spring Boot 2.3.0
* []() PostgreSQL/MySQL/Derby/H2
* []() Flyway
* []() RabbitMQ
* []() Maven


<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.

* RabbitMQ (For messaging between Order-Service and Acknowledgement-Service)
```sh
Follow download and install instructions from https://www.rabbitmq.com/download.html
```

* npm
```sh
npm install npm@latest -g
```

### Installation
 
1. Clone the repo
```sh
git clone https://github.com/lynch0001/bomms.git
```
2. Install NPM packages
```sh
npm install
```
3. Install and run RabbitMQ server 
```sh
Follow instructions at instructions from https://www.rabbitmq.com/download.html
```
4. Run Each of the Spring Services staring with the Discovery-Service and Ending with the Gateway-Service 
```sh
mvn spring-boot:run
```
5. Run the Frontend 
```sh
ng serve
```

<!-- USAGE EXAMPLES -->
## Usage

Functionality allows users to:

*	View catalog of books available from My Mock Bookstore
* Search for books using provided links
* Search for books based on user search input
*	See details of each book
*	Add books to a cart
*	Review the contents of the cart
*	Submit the cart as a new book order


## Selected Views

![Product Screen Shot1][product-screenshot1]

Figure 1: Catalog View

![Product Screen Shot2][product-screenshot2]

Figure 2: Book Detail View

![Product Screen Shot3][product-screenshot3]

Figure 3: Cart View

<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/lynch0001/bomms/issues) for a list of proposed features (and known issues).



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Tim Lynch 
* LinkedIn [timothy-j-lynch](https://www.linkedin.com/in/timothy-j-lynch/)
* Medium [@lynch0001](https://medium.com/@lynch0001) 
* Dev [@lynch0001](https://dev.to/lynch0001) 
* Stackoverflow [tim-lynch](https://stackoverflow.com/users/11063468/tim-lynch)
* Email Lynch0001@gmail.com

Project Link: [https://github.com/lynch0001/bomms](https://github.com/lynch0001/bomms)



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements


* []() John Thompson at https://springframework.guru/
* []() Koushik Kothagal at https://javabrains.io/
* []() Angular University at https://angular-university.io/
* []() Jason Watmore at https://jasonwatmore.com/





<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/lynch0001/bomms.svg?style=flat-square
[contributors-url]: https://github.com/lynch0001/bomms/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/lynch0001/bomms.svg?style=flat-square
[forks-url]: https://github.com/lynch0001/bomms/network/members
[stars-shield]: https://img.shields.io/github/stars/lynch0001/bomms.svg?style=flat-square
[stars-url]: https://github.com/lynch0001/bomms/stargazers
[issues-shield]: https://img.shields.io/github/issues/lynch0001/bomms.svg?style=flat-square
[issues-url]: https://github.com/lynch0001/bomms/issues
[license-shield]: https://img.shields.io/github/license/lynch0001/bomms.svg?style=flat-square
[license-url]: https://github.com/lynch0001/bomms/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/timothy-j-lynch/
[product-screenshot]: https://user-images.githubusercontent.com/35854692/101530850-72c3a480-3960-11eb-9220-1b7594c3f646.PNG
[product-screenshot1]: https://user-images.githubusercontent.com/35854692/101530850-72c3a480-3960-11eb-9220-1b7594c3f646.PNG
[product-screenshot2]: https://user-images.githubusercontent.com/35854692/101686547-33b45280-3a37-11eb-8bd9-5f7074919c34.PNG
[product-screenshot3]: https://user-images.githubusercontent.com/35854692/101686624-4cbd0380-3a37-11eb-9e03-1ca9d1583746.PNG
