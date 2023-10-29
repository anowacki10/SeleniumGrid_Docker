# Docker_SeleniumGrid
Parallel &amp; Cross-Browser testing project supported by Selenium Grid and Docker 	:whale:
<pre></pre>
## Content:
* [About](#about-project)
* [Technology Stack](#technology-stack)
* [Requirements](#requirements)
* [Samples](#samples)
  + [Grid Network Overwiev](#grid-network-overview)
  + [Parallel Test Execution [GIF] ](#parallel-test-execution)
  + [Docker-compose configuration [LINK]](#docker-compose-configuration)





## About
<pre>
Project contain multi-container testing app.
Docker containers are build and configurate automatticly from docker-compose.yml file.
Each node container has diffrent browser on linux OS.
This configuration allows parallel testing across browsers, and is easy to customize for more complex environments.
  
Check out the samples with gifs and screenshots of the built environment.  
</pre>
* [Samples](#samples)

## Technology Stack
-  <b><i>Maven</b></i> -  software bulding tool
-  <b><i>JAVA</b></i> -  main Language
-  <b><i>Docker</b></i> -  separate environments implementation
-  <b><i>docker-compose</b></i> -  automatic Docker environments building and configuration
-  <b><i>WebDriver</b></i> -  Selenium web framework used to execute remote UI tests

## Requirements
- Docker Desktop - installed and configurated for your OS
- Java version "17.0.9"  - installed and configurated
- Apache Maven 3.9.5 - installed and configurated

## Instruction 
<i>to build locally</i>

- **Clone this. repository using following command:**  <pre>git clone https://github.com/anowacki10/Docker_SeleniumGrid.git</pre>
- **Get to the repository PATH in cmd** <pre> "./Docker_SeleniumGrid"</pre>
- **Run docker-compose using following command in cmd:** <br><i> Make sure that docker desktop is running </i></br><pre>docker-compose -f docker-compose.yml up -d</pre>
- **Open your browser and get to this URL** <pre> http://localhost:4445/ </pre>
- **When containers are running you can execute testing file using command :** <pre>mvn clean test -DtestngName="testng.xml" </pre>



## Samples

- ### Grid Network Overview
  
<br>![Alt Text](.Attachments/grid_overwiev.png) </br>
<pre></pre>
<br>![Alt Text](.Attachments/gird_sessions.png)  </br>


- ### Parallel Test Execution
   <b>[GIF]</b>

<br>![Alt Text](.Attachments/parallel_test_GIF.gif) </br>

### Docker-compose configuration 
<i>[Docker File](https://github.com/anowacki10/Docker_SeleniumGrid/blob/master/docker-compose.yml)</i>

<br>![Alt text](.Attachments/docker-compose.png)</br>
