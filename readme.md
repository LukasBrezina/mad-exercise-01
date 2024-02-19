# MAD - Exercise 01
## Tasks
* Watch the Kotlin Crashcourse Video in Moodle or complete the tutorials **[Introduction to programming in Kotlin](https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-1)** and **[Kotlin fundamentals](https://developer.android.com/courses/pathways/android-basics-compose-unit-2-pathway-1
)**.
* Answer the questions inside this Readme.md file and push it to your repository.
* Submit your coding solution of the Number Guessing Game inside the repository.
* Submit the link to your repository in Moodle.

## Questions
### Describe how Kotlin handles null safety. What are nullable types and non-null types in Kotlin? (0,5 points)

<span style="color:blue"> Kotlin uses different operators to handle null safety. One possible operator is "?." which are the "safe calls", which allow accessing an nullable object safely and it will return
"null" after begin called instead of throwing a null pointer exception. Another possible operator is the "Elvis operator" which is "?:", which makes it possible to add a default value in case of a nullable expression being null. Also using the safe
cast operator is an opportunity which looks like "as?", which allows casting a variable to a nullable type, returning null if the cast is impossible. The operator "!!" can be used to declare that an specific expression will never
be null and tells the compiler to throw a null pointer exception in case it is null.

Nullable Types are marked by an "?" which indicate that the variable can either hold a reference to an object or a null value. Examples below -> </span>

````kotlin
// non null type
var nonNullType: String = "Hello"
// null type
var nullType1: String? = null
// example for safe calls -> we have a Person class with an attribute: val name: String? (safe call = "?." operator)
val personName = person?.name
// elvis operator
val nullType2: String? = null
val elvisExample = nullType2 ?: "Default"
````

### What are lambda expressions and higher order functions in Kotlin? Why would you store a function inside a variable? (0,5 points)

<span style="color:blue">Lamda expressions in Kotlin are used to create functions without declaring a name for them. They are mostly used when you need to pass a function to another function as a parameter
 or when you want to simplify a function declaration. It is declared with "{}" and "->" to separate parameters from the function.
Higher order functions are functions that accept/take other functions as a parameter and/or return functions. Examples below -></span>

````kotlin
// lambda expression (simple)
val addition: (Int, Int) -> Int = {x,y -> x+y}
// higher order function
fun calculation(x: Int, y: Int, operation: (Int,Int) -> Int): Int { return operation(x,y) }
````

### Provide a solution for the following number guessing game inside `App.kt`. (3 points)

## Number Guessing Game in Kotlin
The game is a simple number guessing game. The task is to generate a random, max 9-digit, number. The number must **not contain repeating digits**. Valid digits are 1-9.
Ask the user to guess the max 9-digit number. The game is finished when the user guesses the correct digits in the correct order.
In each round, the user gets feedback about the number of correct digits and the number of correct digits in the correct position.
The output should be in the format "n:m", where "n" is the number of digits guessed correctly regardless of their position, 
and "m" is the number of digits guessed correctly at their correct position. Here are some examples:

This example shows the game flow with 4-digits to guess (the default argument)

Generated number: 8576
-	User input: 1234, Output: 0:0
-	User input: 5678, Output: 4:1
-	User input: 5555, Output: 1:1
-	User input: 3586, Output: 3:2
-	User input: 8576, Output: 4:4 -> user wins

Take a look into the provided code structure in `src/main/kotlin/App.kt`. Implement the following methods (lambda expressions):
- _playNumberGame(digitsToGuess: Int = 4)_ (1 point): The main game loop that handles user input and game state. Make use of _generateRandomNonRepeatingNumber_ and _checkUserInputAgainstGeneratedNumber_ here. This function also utilizes a default argument 
- _generateRandomNonRepeatingNumber_ (1 point): A lambda expression that generates a random number with non-repeating digits of a specified length.
- _checkUserInputAgainstGeneratedNumber_ (1 point): A lambda expression that compares the user's input against the generated number and provides feedback.

``CompareResult.kt`` This class is a data structure which helps with bundling the result of the comparison of the user input and the generated number. Look at the toSting() and use it in your output.

Run the project with `./gradlew run` and test your implementation with the provided tests in `src/test/kotlin/AppTest.kt` with `./gradlew test`.

# Project Structure
The project is structured into two main Kotlin files:

**App.kt**: Contains the main game logic and functions.

**AppTest.kt**: Contains unit tests for the various functions in App.kt.

