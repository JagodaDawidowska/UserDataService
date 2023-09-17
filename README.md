# FileUploadingSystem

## Overview

### Functionalities
* JSON data file uploading, parsing and saving to database
* displaying the data from database with pagination, sorting, and searching functions

### Technologies, tools, frameworks, libraries used
* Java 8+
* SpringBoot
* Hibernate
* JUnit
* Lombok
* Maven
* MySQL DB
* HTML5 + JavaScript
* Bootstrap
* Postman

## Running the application locally
* install MySQL database and create a schema for application to use, example `myschema`
* set proper values for database connection in `application.properties`
* build the .jar file using Maven and run with `java -jar app.jar` or launch the app via IntelliJ
* enter `http://localhost:8091/index.html` in a web browser and use the application
* use `input_data.json` file located in `data` folder to upload the data to the program
* additionally test the API using provided Postman collection in `data` folder

* ## View



<body>
  <div style="float:right">
    Main page
       <img src="https://github.com/JagodaDawidowska/FileUploadingSystem/assets/107955890/75a6a78f-86ea-4570-a82d-def09f1db5fd" width="120%" title="Patch: 1" />
  </div> 
  <div style="float:right">
    Uploading file success
       <img src="https://github.com/JagodaDawidowska/FileUploadingSystem/assets/107955890/37fdf553-7da6-40a3-aa01-1c17a37017f4" width="120%" title="Patch: 1" />
  </div> 
  <div style="float:right">
    Uploading fail, incorrect file format
       <img src="https://github.com/JagodaDawidowska/FileUploadingSystem/assets/107955890/17415a4f-dcd8-40e3-8bf1-5abdc7c1bfbc" width="120%" title="Patch: 1" />
  </div> 
</body>
<body>
 <div style="float:right">
   Uploading file success, waiting process
       <img src="https://github.com/JagodaDawidowska/FileUploadingSystem/assets/107955890/237a04ba-3a16-47c6-ad8a-2d37e1e8416c" width="120%" title="Patch: 1" />
  </div> 
  <div style="float:right">
    Data presentation 
      <img src="https://github.com/JagodaDawidowska/FileUploadingSystem/assets/107955890/0dfbd235-c62a-42eb-a00f-fc06b37ca3b8" width="120%" title="Patch: 1" />
      </div> 
  <div style="float:right">
   Sort Options
       <img src="https://github.com/JagodaDawidowska/FileUploadingSystem/assets/107955890/abf6607a-8840-4c7f-8b32-cd3fdadb9897" width="120%" title="Patch: 1" />
  </div> 
</body>
<body>
 <div style="float:right">
   Sort ascending by first name
       <img src="https://github.com/JagodaDawidowska/FileUploadingSystem/assets/107955890/cabfc609-59c7-4f95-870e-74f85ef5e8c3" width="120%" title="Patch: 1" />
  </div> 
  <div style="float:right">
    Sort descending by first name
       <img src="https://github.com/JagodaDawidowska/FileUploadingSystem/assets/107955890/5e2b42cc-b5b9-45b1-bf79-9516b98e9366" width="120%" title="Patch: 1" />
      </div> 
  <div style="float:right">
     Sort ascending by last name 
       <img src="https://github.com/JagodaDawidowska/FileUploadingSystem/assets/107955890/6b0035a0-429c-4837-8de5-51c1532d4f8c" width="120%" title="Patch: 1" />
  </div> 
</body>
<body>
   <div style="float:right">
    Sort descending by last name
       <img src="https://github.com/JagodaDawidowska/FileUploadingSystem/assets/107955890/d5dcb0ac-ba8c-4058-946b-86a8681e5859" width="120%" title="Patch: 1" />
  </div>
 <div style="float:right">
   Sort ascending by login
       <img src="https://github.com/JagodaDawidowska/FileUploadingSystem/assets/107955890/8d8704c4-3a75-4b0c-a113-cfc067350425" width="120%" title="Patch: 1" />
  </div> 
  <div style="float:right">
    Sort descending by login
       <img src="https://github.com/JagodaDawidowska/FileUploadingSystem/assets/107955890/c3cc5944-076c-4249-a9c2-ade175ff8044" width="120%" title="Patch: 1" />
      </div> 
</body>
