# uqaas
Unnecessary Quotes as a Service

A SaaS service for applying unnecessary quotes to words in a sentence.

The most "valuable" service brought to the "market" in "years".

# Running

Development is done using IntelliJ IDEA using the Spring application plugin.  Import the `build.gradle` to open the project, then run `Application.java`

To build the docker image, from a command line:
1. ./gradlew build
2. docker build -t cajohannsen/uqaas .

To run the docker image locally: `docker run -p 8080:8080 cajohannsen/uqaas`

# Usage

## Swagger
Run the application as shown above, and then access the embedded Swagger2 UI in a browser [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## REST API
* POST to `/enquotify` with a JSON payload matching the following structure
```
{
  "maximumReplacementCount": 1,
  "minimumReplacementCount": 1,
  "sourceSentence": "The sentence you wish to process."
}
```

The service will return a payload that maches the above and additionally contains a key `"resultSentence"` which maps to a value storing the result of the operation.
