# OAuth2 resource server Lab
Workshop-Lab for OAuth2 resource server.

The resource server is configured to run on
[localhost:9094/resource](http://localhost:9094/resource)

If you locate your web browser to address above you should see a notice that you are browsing the resource server.

The protected resource of the resource server is configured to run on
[localhost:9094/resource/protected](http://localhost:9094/resource/protected)

The address above requires full authentication and is intended to be called from OAuth2 client app.
If you browse to this address you will get an error message:

``
Full authentication is required to access this resource
``

__Note: Before using this resource server from OAuth2 client make sure that you have started the authorization server__


