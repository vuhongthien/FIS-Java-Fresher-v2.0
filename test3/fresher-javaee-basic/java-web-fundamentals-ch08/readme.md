# Running

## Mac

1. `brew services start tomcat`
1. URLs
   1. <http://localhost:8080/simple/anything.do>
   1. <http://localhost:8080/simple/home?name=kevin>
1. Deploying
   1. From simple:Lifecycle
      1. `validate` `clean`, `package`
   1. From tomcat7
      1. `tomcat7:redeploy-only`

## Code for Events

