# OAuth2 client Lab
Workshop-Lab for OAuth2 client.

The client is configured to run on
[localhost:9092/client](http://localhost:9092/client)

__Note: Before using this client make sure that you have started the authorization server and the resource server__

If you locate your web browser to address above you should get redirected to the
OAuth2 authorization server.

Here you can use following user accounts for login:

- Username: __user__, password: __secret__, roles: __USER__
- Username: __admin__, password: __admin__, roles: __ADMIN__

If all OAuth2 processing has been successful then you should see something like this in the web browser:

``
Accessed protected resource using user 'spring.workshop.oauth.resource.User@76d0570[name=user,firstName=Mister,lastName=User]'
``

