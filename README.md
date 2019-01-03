# Kommand2Web #
Kommand2Web is a very simple server which allows for the start of predefined shell
commands via an HTTP interface.
It can be used to implement a simple remote access or remote controll scenario

[![Build Status](https://travis-ci.org/systemkern/Kommand2Web.svg?branch=master)](https://travis-ci.org/systemkern/Kommand2Web)


# Application #

### Application Configuration
Application configuration is done via standard spring-boot config providers
* application.properties is used for technical configuration
* application.yml can be used for business configuration

### Logging Configuration
Logging is done via the [Logback](https://logback.qos.ch/documentation.html) framework.
Logging configuration currently is only availible at compile time.

### Assembly and Distribution
For distribution of the assembled zip file via ftp call:
`mvn clean package wagon:upload-single`

### Distribution configuration
Ftp login credentials need to be configured in you maven settings xml.
Usually be found at ~/.m2/settings.xml

A custom settings file can also be generated by a shell command.
See bitbucket-pipelines.yml for an example

```
<settings>
  <servers>
    <server>
      <id>launcher-ftp-distribution-server</id>
      <username>myuseraccount</username>
      <password>s3cret</password>
    </server>
  </servers>
</settings>
```
