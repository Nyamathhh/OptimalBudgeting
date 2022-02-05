<div id="top"></div>

[![LinkedIn][linkedin-shield]][linkedin-url]

<div align="center">
  <h3 align="center">Optimal Campaign Budgeting</h3>

  <p align="center">
     Optimising the performance of campaigns would be to allocate budgets according to impressions 
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#API-Usage">Guidelines</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

What we would like you to do is implement a system that takes a group of campaigns,
associated within a campaign group, and performs an optimisation on them based on some
criteria - for example:

A group of 5 campaigns each have a budget of €20 per week.
* Campaign 1 budget: 20
* Campaign 2 budget: 20
* Campaign 3 budget: 20
* Campaign 4 budget: 20
* Campaign 5 budget: 20

The impressions per campaign are as follows:

* Campaign 1 impressions: 100
* Campaign 2 impressions: 200
* Campaign 3 impressions: 400
* Campaign 4 impressions: 200
* Campaign 5 impressions: 100

One approach to optimising the performance of campaigns would be to allocate budgets
according to impressions, where impressions are seen as an indication of a campaign’s
success.
So then with impressions as the criteria of success, then budgets are distributed according to
which campaigns perform better.
So, for example, the recommended budget allocation based on the impressions would be as
follows:

```sh 
Budgets[x] = (Impressions[x] / sum(impressions)) * sum(budgets)
```

So the new budget allocations based on the recommendations made by the optimisation system
would be as follows:

* Campaign 1 budget: 10
* Campaign 2 budget: 20
* Campaign 3 budget: 40
* Campaign 4 budget: 20
* Campaign 5 budget: 10


<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

This section lists out all the required Technologies & Frameworks used to build the project.

* Java 17
* Sprint Boot 2.5.6
* H2 Database (In-memory )
* Maven
* RESTFul Web services 
* Swagger 2
* Junits
* Postman
* JAVA IDE (Eclipse)


<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Getting Started

You can run the application by running runMe.bat on Windows only. however, you can modify it to .sh accordingly to run the same. 

But running please follow the below steps:

```sh
* Create a file localH2.mv in C:/Users/{username} folder 
* Copy h2-1.4.200.jar to C:/Optily/bin
* Copy OptimalBudgeting-0.0.1-SNAPSHOT.jar to C:/Optily/bin
```

Once the above steps are complete, you are good to run runMe.bat file. The file will do the following:

* runMe.bat file will start the H2 database and OptimalBudgeting Project
* It opens up 2 windows in your default browser.
	1. H2 database connection

	<img src="images/H2Console.JPG" alt="H2 Console" width="80" height="80">


	2. Swagger entry point, listing all the available APIs.

	<img src="images/SwaggerConf.jpg" alt="Swagger Configuration" width="80" height="80">

* Before connecting to H2 database, Please make sure to enter the JDBC URL correctly as below
	* jdbc:h2:~/localH2
	* please keep the rest as it is and Connect. 

	<img src="images/H2Console.jpg" alt="H2 Console" width="80" height="80">


* Once connected, you will have create a default Schema "Optily" as below:

	```sh 
	Create Schema Optily` 
	```

* Great, You are now ready to use the application. 

### Guidelines

This section will help you understand how to use the list of provided APIs 

* npm
  ```sh
  npm install npm@latest -g
  ```

### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Get a free API Key at [https://example.com](https://example.com)
2. Clone the repo
   ```sh
   git clone https://github.com/your_username_/Project-Name.git
   ```
3. Install NPM packages
   ```sh
   npm install
   ```
4. Enter your API in `config.js`
   ```js
   const API_KEY = 'ENTER YOUR API';
   ```

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [x] Add Changelog
- [x] Add back to top links
- [ ] Add Additional Templates w/ Examples
- [ ] Add "components" document to easily copy & paste sections of the readme
- [ ] Multi-language Support
    - [ ] Chinese
    - [ ] Spanish

See the [open issues](https://github.com/othneildrew/Best-README-Template/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Your Name - [@your_twitter](https://twitter.com/your_username) - email@example.com

Project Link: [https://github.com/your_username/repo_name](https://github.com/your_username/repo_name)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Use this space to list resources you find helpful and would like to give credit to. I've included a few of my favorites to kick things off!

* [Choose an Open Source License](https://choosealicense.com)
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
* [Malven's Flexbox Cheatsheet](https://flexbox.malven.co/)
* [Malven's Grid Cheatsheet](https://grid.malven.co/)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)
* [React Icons](https://react-icons.github.io/react-icons/search)

<p align="right">(<a href="#top">back to top</a>)</p>



[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/nyamath/
