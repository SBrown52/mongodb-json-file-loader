# MongoDB Json File Loaded
Really simple tool to load Json files from Java.

## How to run
Build the project
```mvn clean install```
Locate the uber jar that's built within the `target` directory

Run the jar, specifying the file to import, and the collection to import to
```java -jar mongodb-json-file-loader.jar --import=data.json --collection=sample```

NB: this program expects there to be one document (in json) per line, in the format:
```
{k: foo, v: bar}
{k: 123, v: xyz}
```

## Override Database connection
By default the application will connect to a local MongoDB on port 27017. You can however ovveride this by adding
```--spring.data.mongodb.uri=mongodb://user:password@server.url:port/database```
to the program arguments when you run the application