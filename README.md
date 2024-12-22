# Pair Sum Application

## Overview
This project is a **Spring Boot Kotlin application** that finds pairs of integers in an array whose sum equals a given target value.

## Features
- Accepts user input via the **command line**.
- Handles **negative numbers**, **duplicates**, and **trailing spaces**.
- Supports **multiple pairs**
- Includes **unit tests**

## Technologies Used
- **Kotlin** (Language)
- **Spring Boot** (Framework)
- **Maven** (Build Tool)
- **JUnit 5** (Testing Framework)

## Prerequisites
- **Java 17** or later installed.
- **Maven 3.4.1** installed.

## Setup and Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/beheidary/kotlinProject.git
   cd kotlinProject
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Usage
### Input Format
```
<array of integers> <target sum>
```
### Example
Input:
```
4 6 -11 1 8 2 56 26 36 10
```
Output:
```
Input Array: 4, 6, -11, 1, 8, 2, 56, 26, 36
Target Sum: 10
Pair found: 4 and 6
Pair found: -11 and 1
Pair found: 8 and 2
```
### Exit the Application
Type:
```
exit
```

## Testing
Run all tests:
```bash
mvn test
```
Sample test cases include:
- Finding multiple pairs.
- Handling invalid inputs.
- Managing edge cases like duplicates and negative numbers.

