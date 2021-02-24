# README #

This is a sample microservice.

It manages users and tokens. Admin users can create other users. Users (admin or not) can create and receive a token.

When the service starts there is a single admin user (password = admin). The admin user can create a token. Using this token, admin can create 
admin can request a token. Other users created by admin can the create or refresh tokens.

### Requirements ###

* any user can create a token if correct password is used, using POST /
* admin can create a token if correct password is used.

### Need help ? ###

* email or call the person who sent you the link to the page.
