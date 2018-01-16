# Simple javascript error logging example

- In the error.js there is an EventListener, that POSTs the error details with
  some additional information to the backend
- The backend saves the error to mongodb
  (Configured in the application.properties)

- There is a faulty inline script in the index.html and the "imported" dummy.js
  also has an error

## Try it out

1, Start a mongodb
    I started in a docker container: docker run --name mongo -d mongo
2, Start the spring bootapp
    ./gradlew bootRun
3, Go to http://localhost:8080 in you browser
4, Check in the mongodb that the errors are logged
    If you used started the mongo in docker container, then:
        - docker exec -it mongo mongo
        - use jserrors
        - db.error.find()
