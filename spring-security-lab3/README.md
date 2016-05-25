# spring-security Lab 3
This lab shows a more realistic secure web application.
This includes:
- Multiple security configurations
- Persistent user storage with encrypted passwords
- A user defined login form
- Optional: SSL transport security
- Role hierarchy
- Role based UI and method layer authorization

The application is configured to run on:

[localhost:9090](http://localhost:9090)

Here you can use following user accounts for login:

- Username: __user__, password: __geheim__, roles: __USER__
- Username: __admin__, password: __admin__, roles: __ADMIN__

To see database entries in H2 in-memory db the H2 console is also enabled.
To see H2 console browse to [localhost:9090/h2-console](http://localhost:9090/h2-console).

You may enable SSL transport security by uncommenting all ssl related lines in file
_src/main/resources/application.properties_.

Then you should be able to browse here:

[https://localhost:9090](https://localhost:9090)

