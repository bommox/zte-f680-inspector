## Installation

```
git clone https://github.com/bommox/zte-f680-inspector.git
```
```
cd zte-f680-inspector
```
```
sh mvnw clean compile assembly:single
```

Then you are rady!

## Run

```
java -jar target/ZteF680-0.0.1-SNAPSHOT-jar-with-dependencies.jar 2>/dev/null
```

Will output the info about connected devices to your network

