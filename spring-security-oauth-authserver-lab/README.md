# OAuth2 Authorizationserver Lab
Workshop-Lab for OAuth2 authorization server.

The authorization server is configured to run on
[localhost:9090/uaa](http://localhost:9090/uaa)

User accounts for login are as follows:

- Username: __user__, password: __secret__, roles: __USER__
- Username: __admin__, password: __admin__, roles: __ADMIN__

You may check to get an access token by using for example curl:

``
curl -L http://localhost:9090/uaa/oauth/token -d grant_type=password -d username=user -d password=secret -u myclient:clientsecret
``

Then you should get something like this as result:

``
{"access_token":"bf6986d0-5b0d-449a-9ed5-9c8ee289b123","token_type":"bearer","refresh_token":"1c4b4cfd-aab5-48d7-b734-04f3fd18ac15","expires_in":42513,"scope":"myscope"}
``
