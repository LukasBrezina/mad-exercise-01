/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package at.ac.fhcampuswien

class App {
    fun playNumberGame(digitsToGuess: Int = 4) {
        //TODO: build a menu which calls the functions and works with the return values

        println("LET THE GAMES BEGIN")
        println("You have unlimited guesses, so take your time and use your brain...")
        println("Enter your first guess, you will receive feedback in a form of -> 2:1 for example " +
                "which stands for 2 right digits (not knowing if they are on the right position) and 1 " +
                "right digit which is also on the right position!")
        println("The number to guess contains " + digitsToGuess + " digits")

        try {
            // throw IllegalArgumentException when too many or too less digits given
            if (digitsToGuess < 1 || digitsToGuess > 9) {
                throw IllegalArgumentException("Too many or too less digits")
            }

            val number = generateRandomNonRepeatingNumber(digitsToGuess)
            var printed = 0

            // playing the game until generated number is the same as the input
            while (printed.toString() != number.toString()) {
                //"!!" means value will never be null
                printed = readlnOrNull()!!.toInt()

                if (printed.toString().length != number.toString().length) {
                    println("Input does not have the same length as the given random number: please try " +
                            "again with a number with the length: " + number.toString().length)
                    continue
                }
                println(checkUserInputAgainstGeneratedNumber(printed, number))
            }
            println("You Won")

        } catch (e: Exception) {
            println("Something went wrong... Try again")
        }
    }

    /**
     * Generates a non-repeating number of a specified length between 1-9.
     *
     * Note: The function is designed to generate a number where each digit is unique and does not repeat.
     * It is important to ensure that the length parameter does not exceed the maximum possible length
     * for non-repeating digits (which is 9 excluding 0 for base-10 numbers).
     *
     * @param length The length of the non-repeating number to be generated.
     *               This dictates how many digits the generated number will have.
     * @return An integer of generated non-repeating number.
     *         The generated number will have a number of digits equal to the specified length and will
     *         contain unique, non-repeating digits.
     * @throws IllegalArgumentException if the length is more than 9 or less than 1.
     */
    val generateRandomNonRepeatingNumber: (Int) -> Int = { length ->
        val result = mutableListOf<String>()

        if (length >= 1 && length <= 9) {
            while (result.size < length) {
                val random = (1..9).random().toString()
                if (!(random in result)) {
                    result.add(random)
                }
            }
        } else {
            throw IllegalArgumentException("Too long or too short")
        }
        result.joinToString("").toInt()
    }

    /**
     * Compares the user's input integer against a generated number for a guessing game.
     * This function evaluates how many digits the user guessed correctly and how many of those
     * are in the correct position. The game generates number with non-repeating digits.
     *
     * Note: The input and the generated number must both be numbers.
     * If the inputs do not meet these criteria, an IllegalArgumentException is thrown.
     *
     * @param input The user's input integer. It should be a number with non-repeating digits.
     * @param generatedNumber The generated number with non-repeating digits to compare against.
     * @return [CompareResult] with two properties:
     *         1. `m`: The number of digits guessed correctly (regardless of their position).
     *         2. `n`: The number of digits guessed correctly and in the correct position.
     *         The result is formatted as "Output: m:n", where "m" and "n" represent the above values, respectively.
     * @throws IllegalArgumentException if the inputs do not have the same number of digits.
     */
    val checkUserInputAgainstGeneratedNumber: (Int, Int) -> CompareResult = { input, generatedNumber ->
        //TODO implement the function

        // variables
        var rightDigits = 0
        var completedDigits = 0
        var inputString = input.toString()
        val generatedNumberString = generatedNumber.toString()

        // list containing seen characters
        val alreadyAdded = mutableListOf<Char>()

        try {
            // catching if the length of input and generated number is not the same
            if (inputString.length != generatedNumberString.length) {
                throw IllegalArgumentException("Input and generated Number not same length!")
            }
            // increasing completedDigits and rightDigits in case of guessing the correct number + position
            for (i in generatedNumberString.indices) {
                if (inputString[i] == generatedNumberString[i]) {
                    completedDigits++
                }
                if (inputString[i] in generatedNumberString && !(inputString[i] in alreadyAdded)) {
                    rightDigits++
                    alreadyAdded.add(inputString[i])
                }
            }
        } catch (e: Exception) {
            throw IllegalArgumentException("Oops.. something went wrong..")
        }
        CompareResult(rightDigits, completedDigits)
    }
}

fun main() {
    // TODO: call the App.playNumberGame function with and without default arguments

    println("How many generated digits? Please enter a number from 1 to 9")
    val digits = readlnOrNull()!!.toInt()
    val app = App()
    app.playNumberGame(digits)

}
