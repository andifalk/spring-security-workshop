# spring-security-workshop
Workshop-Labs for Spring Security and Spring Boot

## Lab 1
This lab shows how to create a secure web application with
_secure by default_ configuration provided by spring security
in addition to spring boot. By using [start.spring.io](http://start.spring.io)
this is only a matter of a few minutes.
As result you get a web application with all endpoints secured by basic authentication filter,
session fixation protection, csrf protection and default security response headers.

The application is configured to run on:

[localhost:8080](http://localhost:8080)

Here you can use following user account for login:
- Username: __user__, password: __secure__, roles: __USER__

## Lab 2
This lab adds more in-memory users with different roles and adds a
auto-generated login form.

The application is configured to run on:

[localhost:8080](http://localhost:8080)

Here you can use following user accounts for login:
- Username: __user__, password: __secret__, roles: __USER__
- Username: __admin__, password: __admin__, roles: __ADMIN__

## Lab 3
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

## OAuth2 Labs
These labs show a full implementation of OAuth2
authorization including all roles like client, authorization server
and resource server.

### OAuth2 Authorization Server Lab
This lab implements a full OAuth2 compliant authorization server
issuing bearer access tokens.

The authorization server is configured to run on
[localhost:9090/uaa](http://localhost:9090/uaa)

User accounts for login are as follows:

- Username: __user__, password: __secret__, roles: __USER__
- Username: __admin__, password: __admin__, roles: __ADMIN__

### OAuth2 Resource Server Lab
This lab implements a simple resource server providing a protected
service that is called by OAuth2 client requiring a bearer access token.

The resource server is configured to run on
[localhost:9094/resource](http://localhost:9094/resource)

If you locate your web browser to address above you should see a notice that you are browsing the resource server.

The protected resource of the resource server is configured to run on
[localhost:9094/resource/protected](http://localhost:9094/resource/protected)

### OAuth2 Client Lab
This lab implements a simple OAuth2 client that calls the provided protected service
of the resource server and triggers an authorization code grant flow
with authorization server to be able to get the protected resource.

The client is configured to run on
[localhost:9092/client](http://localhost:9092/client)

If you locate your web browser to address above you should get redirected to the
OAuth2 authorization server.

Here you can use following user accounts for login:

- Username: __user__, password: __secret__, roles: __USER__
- Username: __admin__, password: __admin__, roles: __ADMIN__

### OAuth2 SSO Client Lab
This lab implements a simple client that uses OAuth2 for single-sign-on.

The SSO client is configured to run on
[localhost:9096/ssoclient](http://localhost:9096/ssoclient)

If you locate your web browser to address above you should get redirected to the
OAuth2 authorization server.

Here you can use following user accounts for login:

- Username: __user__, password: __secret__, roles: __USER__
- Username: __admin__, password: __admin__, roles: __ADMIN__
