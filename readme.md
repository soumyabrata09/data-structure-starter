## This starter Package is housing the Data structure concepts
### This package can be added a dependency to build files

**Pre-Requisite**
 - Maven in local
 - JDK 1.8 minimum
 
 ````
 mvn clean compile
 ````
 And then
 ````
 mvn clean install
 ````
**Usage Guide**

To run Locally:
After successful build add the following dependency into your Reference Application's pom file

````
 <dependency>
  <groupId>com.sam09.lib</groupId>
  <artifactId>datastructure-starter</artifactId>
  <version>1.0.0-SNAPSHOT</version>
 </dependency>
````

**Jfrog Integration**
````
<!--Jfrog artifactory integration-->
	<distributionManagement>
		<repository>
			<id>central</id>
			<name>a0guqxkvavcvp-artifactory-primary-0-releases</name>
			<url>https://soumyabrata09.jfrog.io/artifactory/sam09-libs-release</url>
		</repository>
		<snapshotRepository>
			<id>snapshots</id>
			<name>a0guqxkvavcvp-artifactory-primary-0-snapshots</name>
			<url>https://soumyabrata09.jfrog.io/artifactory/sam09-libs-snapshot</url>
		</snapshotRepository>
	</distributionManagement>
````

**To publish artifact to jfrog**
> mvn clean install deploy
> 
> Snapshots will be published to
> (https://soumyabrata09.jfrog.io/artifactory/sam09-libs-snapshot/com/sam09/lib/datastructure-starter/)

> **stack size can be provided through externalized configuration. add the following property value to application.properties/yaml file**

````
ds.stack.size=100
````

> **Queue capacity can be provided through externalized configration.**
````
#Define capacity of the Queue
ds.queue.capacity=10
````

**See Also `How to pass a function as a parameter in java`**
> [see the article here](https://www.delftstack.com/howto/java/how-to-pass-a-function-as-a-parameter-in-java/)

_Action Items_
 - [x] Create a Generic SLF4J logger which can be injected to gereric bean generator and can be used across the project 
 - [x] Onboard the artifact onto Jfrog/Nexus
 - [x] Singly Linked List implemented
 - [x] Doubly Linked List
 - [x] stack, Queue and Priority Queue
 - [x] Binary Tree & Binary Search Tree
 - [ ] Heap
 - [ ] Map
 
[Guidance to write well formatted readme file](https://docs.github.com/en/github/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)