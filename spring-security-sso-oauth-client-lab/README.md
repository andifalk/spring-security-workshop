# OAuth2 resource server Lab
Workshop-Lab for OAuth2 single-sign-on client.

The SSO client is configured to run on
[localhost:9096/ssoclient](http://localhost:9096/ssoclient)

__Note: Before using this OAuth2 SSO client make sure that you have started the authorization server__

If you locate your web browser to address above you should get redirected to the
OAuth2 authorization server.

Here you can use following user accounts for login:

- Username: __user__, password: __secret__, roles: __USER__
- Username: __admin__, password: __admin__, roles: __ADMIN__

If all OAuth2 processing has been successful then you should be logged in and see something like this in the web browser:

``
Successfully authenticated user 'user', first name 'Mister', last name 'Mister'
``



