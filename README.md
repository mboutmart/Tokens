# README #

This is a sample microservice.

It manages users and tokens. Admin users can create other users. Users (admin or not) can create and receive a token.

When the service starts there is a single admin user (password = admin). The admin user can create a token. Using this token, admin can create 
admin can request a token. Other users created by admin can the create or refresh tokens.

### Specification ###

## Token creation/refresh ##

POST /tokens

JSON payload :  `{    "username": "<user name>",    "password": "<password>"  }`

HTTP response status
* 201 (Created) : successful token creation
* 200 (OK) : successful token refresh
* 401 (Unauthorized) : incorrect username/password combination is used

Response : `{"token": "String", "creationDate": "yyyy-MM-dd HH:mm:ss", "expirationDate": "yyyy-MM-dd HH:mm:ss"}`

Notes:
* any user can create a token if correct username/password combination is used
* if token is not expired, the existing token is refreshed; no new token created. In case of refresh the expiration date is extended.


## User creation ##

POST /users

Headers: `Authorization: bearer <valid token>`

JSON payload :  `{    "username": "<user name>", "password": "<password>"  }`

HTTP response status
* 201 (Created) : successful user creation
* 409 (Conflict) : if attempting to create a duplicate user
* 401 (Unauthorized) : call without a valid unexpired token
* 403 (Forbidden) : call with a valid unexpired non-admin token

Response : `{"token": "String", "creationDate": "yyyy-MM-dd HH:mm:ss", "expirationDate": "yyyy-MM-dd HH:mm:ss"}`
