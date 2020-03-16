# Geo Distance Invitation List

## Problem Statement

### Summary
There is a list of customers, each having
- customer ID
- latitude
- longitude
- name

We need to find all customers within 100KM radius of
Dublin office, and order them by their customer ID
so that we can send them invitations

### Specifications

**Dataset:** `customers.txt` located in

`src/main/resources/customers.txt`

User object format

```json
{"latitude": "54.1225", "user_id": 27, "name": "Enid Gallagher", "longitude": "-8.143333"}
```

## Solution

### Technologies

- Language Used: [Kotlin](https://kotlinlang.org)
- JSON (de)serialization: [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization)
- Build System: [Gradle](https://gradle.org)



## Requirements

1. Java (JDK 8 or above)
2. Kotlin (not needed to install separately)

## Compile and Run

Compile project

```shell
./gradlew jar
```

Run Program

```shell
java -jar build/libs/IntercomGeoDist-1.0-SNAPSHOT.jar
```

## Run Tests

```shell
./gradlew check 
```