<h1> Pivotal Assignment - Created by pas Apicella </h1>

The following demo is a java based web application which binds to a MySQL database instance. It returns hello 
world plus a default web page and some rest end points as described below.

Access as follows

```
http://pas-assignment.cfapps.io/
```

![alt tag](https://dl.dropboxusercontent.com/u/15829935/pivotal-assignment.png)

Rest Endpoints for Hello World

```
pasapicella@Pas-MacBook-Pro:~$ curl http://pas-assignment.cfapps.io/hello
Hello World!!!!
```

Rest Endpoint for data bound customer access

```
pasapicella@Pas-MacBook-Pro:~$ curl http://pas-assignment.cfapps.io/allcustomers
[{"id":1,"name":"customer 1"},{"id":2,"name":"customer 2"},{"id":3,"name":"customer 3"},{"id":4,"name":"customer 4"}]
```

- Examine logs [Must be logged in from command line]

```
pasapicella@Pas-MacBook-Pro:~$ cf logs pas-assignment --recent
Connected, dumping recent logs for app pas-assignment in org apples-org / space development as lucia78@tpg.com.au...

2015-12-24T12:01:36.88+1100 [API/4]      OUT Created app with guid 92431a14-b9ad-4fe1-b92a-698e10d0709d
2015-12-24T12:01:44.50+1100 [API/1]      OUT Updated app with guid 92431a14-b9ad-4fe1-b92a-698e10d0709d ({"route"=>"622eb53d-5186-45d8-a284-c6b893cfedb9"})
2015-12-24T12:03:02.05+1100 [API/2]      OUT Updated app with guid 92431a14-b9ad-4fe1-b92a-698e10d0709d ({"state"=>"STARTED"})
2015-12-24T12:03:02.36+1100 [STG/0]      OUT Creating container
2015-12-24T12:03:03.74+1100 [STG/0]      OUT Successfully created container

....

```

Scale Application from CLI as follows [Must be logged in from command line]

```
pasapicella@Pas-MacBook-Pro:~$ cf scale pas-assignment -i 2
Scaling app pas-assignment in org apples-org / space development as lucia78@tpg.com.au...
OK

pasapicella@Pas-MacBook-Pro:~$ cf app pas-assignment
Showing health and status for app pas-assignment in org apples-org / space development as lucia78@tpg.com.au...
OK

requested state: started
instances: 2/2
usage: 512M x 2 instances
urls: pas-assignment.cfapps.io
last uploaded: Thu Dec 24 01:02:45 UTC 2015
stack: cflinuxfs2
buildpack: java-buildpack=v3.3.1-https://github.com/cloudfoundry/java-buildpack.git#063836b java-main open-jdk-like-jre=1.8.0_65 open-jdk-like-memory-calculator=2.0.1_RELEASE spring-auto-reconfiguration=1.10.0_RELEASE

     state     since                    cpu      memory           disk           details
#0   running   2015-12-24 12:04:11 PM   0.1%     437.7M of 512M   185.2M of 1G
#1   running   2015-12-24 12:13:39 PM   110.3%   417.9M of 512M   185.2M of 1G

```
