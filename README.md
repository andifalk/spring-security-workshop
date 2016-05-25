# spring-security-workshop
Workshop-Labs for Spring Security and Spring Boot

## Lab 1
This lab shows how to create a secure web application with
_secure by default_ configuration provided by spring security
in addition to spring boot. By using [start.spring.io](http://start.spring.io)
this is only a matter of a few minutes.
As result you get a web application with all endpoints secured by basic authentication filter,
session fixation protection, csrf protection and default security response headers.

## Lab 2
This lab adds more in-memory users with different roles and adds a
auto-generated login form.

## Lab 3
This lab shows a more realistic secure web application.
This includes:
- Multiple security configurations
- Persistent user storage with encrypted passwords
- A user defined login form
- Optional: SSL transport security
- Role hierarchy
- Role based UI and method layer authorization

## OAuth2 Labs
These labs show a full implementation of OAuth2
authorization including all roles like client, authorization server
and resource server.

### OAuth2 Authorization Server Lab
This lab implements a full OAuth2 compliant authorization server
issuing bearer access tokens.

### OAuth2 Resource Server Lab
This lab implements a simple resource server providing a protected
service that is called by OAuth2 client requiring a bearer access token.

### OAuth2 Client Lab
This lab implements a simple OAuth2 client that calls the provided protected service
of the resource server and triggers an authorization code grant flow
with authorization server to be able to get the protected resource.

### OAuth2 SSO Client Lab
This lab implements a simple client that uses OAuth2 for single-sign-on.
