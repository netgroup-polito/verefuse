# Verifuse (VERInet FUnction SElection and placement)
The Extension of Verifuse framework is composed by two modules:

1. **RDF** (Requirement Driven Functionality) which has the task of analyzing each requirement against all VNFs inside catalog and produce an entity called Functionality that represent  how a vnf can satisfy requirment and to send data to LER module.

2. **LER** (Logic Enforce Requirements) which has the task to receive the data form the RDF module and identify which are the combination fo functionality that guaratee enforce the requirement.


Contact: cosimo.manisi@studenti.polito.it
   
        
# Project Setup
## Folders organization
Project folders are organized this way:

1.  The **src** folder contains all the packages regarding the framework;

    In particular:
    * The package **it.polito.verifuse.main** contains the entry point of the framework;
    * The package **it.polito.verifuse.modules** contains the classes of the two modules;
    * The package **it.polito.verifuse.functionality** contains the classes to create and manage fucntionality object;
    * The package **it.polito.verifuse.neo4jClient** contains the classes push data on graph db;
    * The package **it.polito.verifuse.utility** contains the classes for manage particular data ex. the input;
    * The package **it.polito.verifuse.framework.test** contains the tests regarding the two modules;
    

2.  The **xsd** folder contains XML schemas representing the data structures used;
3.  The **gen-src** folder will contain all data structures generated by the JAXB framework starting from the XML schemas;
4.  The **lib** folder contains the libraries used by the framework;
5.  The **test** folder contains the packages which the tests;
6.  The **outputChain** folder contains the XML file produced by the Marshalling operation of Functionality selected;

Files for building the project are:

1.  The **build.xml** file allows to start the framework;
2.  The **service-build.xml** file allows to manage the deployment of the framework;
3.  The **neo4j-build.xml** file allows to manage neo4j;
3.  The **tools.xml** file allows to manage activation/deactivation of services;

  
## Prerequisites

### GUROBI
[Download](https://www.gurobi.com/downloads/) the correct version of Gurobi according to your OS and your JVM endianness. 
To properly execute the application, you must obtain a license (free of charge for students), set the GUROBI_HOME variable 
and have the gurobi native library including it to Java Library Path. 
The most convenient way to do this is add the path that the library to the dynamic linking library path.

    In Linux is LD_LIBRARY_PATH
    
    e.g.,
    1. 
       sudo nano /etc/environment
       GUROBI_HOME = /opt/gurobi911/linux64
		
    2. 
       sudo nano ~/.bashrc
	   export GUROBI_HOME = /opt/gurobi911/linux64
	   export LD_LIBRARY_PATH = ${LD_LIBRARY_PATH}:${GUROBI_HOME}/lib
	   export PATH = $PATH:${GUROBI_HOME}/bin
		
    3. 
       You need to copy the file "libgurobi81.so" and "libGurobiJni81.so" to the folder /usr/lib/

		
    In MacOS is DYLD_LIBRARY_PATH
    
    In Windows is PATH
        e.g.,
        1.
            GUROBI_HOME = C:\gurobi811\win64
            
        2.
            PATH =  C:\gurobi811\win64\bin

For compatibility problems, `version 8.1.1` is recommended.

### JAVA JDK
* Install  [jdk1.8X YY](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
    
    Documentation available at this [link](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html#A1096936).
* Set environmental variable: JAVA_HOME to the directory where you installed JDK

    `e.g.,
    ${JAVA_HOME} = C:\Program Files\Java\jdk1.8.0_212`

### ANT
* Install [Ant 1.10.x](https://ant.apache.org/).
    
    Documentation available at this [link](https://ant.apache.org/manual/install.html).
* Set environmental variable: ANT_HOME to the directory where you installed Ant

     `e.g.,
    ${ANT_HOME} = C:\Program Files\Java\apache-ant-1.10.6`
* Add the *${ANT_HOME}/bin* to your PATH

### APACHE TOMCAT
* Install Apache Tomcat 8, `version 8.5.35` is recommended for compatibility with the libraries used.
* Set environmental variable: CATALINA HOME to the directory where you installed Apache;
* (optional) configure Tomcat Manager:
* open the file %CATALINA_HOME%\conf\tomcat-users.xml
* under the tomcat-users tag place, initialize an user with roles "tomcat, manager-gui, manager-script".
 An example is the following content:
  
>
>  `<role rolename="manager-gui"/>`
>
>  `<role rolename="manager-script"/>`
>
>  `<role rolename="admin"/>`
>
>  `<user username="tomcat" password="tomcat" roles="admin,manager-gui,manager-script"/>`



* edit the "to_be_defined" fields in tomcat-build.xml with the before defined credentials;

### NEO4J
* Install [Neo4j Community Edition version 3.5.x](https://neo4j.com/download-center/#community)
    
    Documentation available at this [link](https://neo4j.com/docs/operations-manual/current/installation/).
* Install its service 

    Starting from the Neo4j folder go to the **bin** folder ed exec **neo4j** with the argument **install-service**.
  
* Set environmental variable: NEO4J_HOME to the directory where you installed Neo4J;

     `e.g.,
    ${NEO4J_HOME} = C:\neo4j-community-3.5.5`
* Go to the installation folder, then open file /conf/neo4j.conf and uncomment the following line if it is not.
> dbms.security.auth_enabled=false
    
# Execution
## Main
The execution from the entry point is done by the following **Ant task**:
* **clean** to erase all
* **generate-bindings** to generate artifacts starting from the XML Schemas
* **compile** to compile the classes
* **run** to exec the Main.java

    > The **run** task depends on **compile**
    
    > The **compile** task depends on **generate-bindings**

## Test framework
The execution of the tests regarding the framework are done by the following **Ant task**:
* **clean** to erase all
* **generate-bindings** to generate artifacts starting from the XML Schemas
* **compile** to compile the classes
* **test** to exec the tests

    > Before running **test** make sure you started neo4j using the task **start-neo4j** and 
    to have waited a few seconds for the service to start completely.
     
    This is because there are two tests that control the connection to db.
  
