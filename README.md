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