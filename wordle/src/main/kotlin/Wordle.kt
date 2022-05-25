// Wordle class definition; an instance of Wordle is more or less just a game with a word

class Wordle(val word : String) { // Member variable in the constructor
    // Validate the user's guess against the word; assumes strings are same length and nonnull
    private fun validateWord(guess : String) : String {
        var code = ""
        for (i in 0 until word.length) {
            if (guess.get(i) == word.get(i)) {
                code = code.plus("!") //No appending in Kotlin? it returns another string object when you plus().
            }
            else {
                var foundAny = false
                for (j in 0 until word.length) {
                    if (guess.get(i) == word.get(j)) {
                        foundAny = true
                    }
                }
                if (foundAny) {
                    code = code.plus("*")
                } else {
                    code = code.plus("-")
                }
            }
        }
        return code
    }

    // A game loop that gets user input and checks it against the target word, giving feedback on degrees of success
    // as per the rules of the game
    fun play() {
        println("Enter your guess, or [q]uit early: ")
        var guess : String? = "guess"
        while (guess != "q") {
            guess = readLine()
            if (guess == null || guess.length != word.length) { // This checking ensures that validateWord will work
                println("Incorrect letter count; please enter a new word.")
            }
            else { // Quick check if they're the same; can be done here if so
                if (guess == word) {
                    println("Congratulations, you did it!")
                    return
                }

                //if not, time to look over each letter in the guess and tell the user how they did
                val code = validateWord(guess)
                for (i in 0 until word.length) {
                        print(code.get(i))
                        print(guess.get(i))
                        print(" ")
                }
                println("")
            }
        }
        return
    }
}