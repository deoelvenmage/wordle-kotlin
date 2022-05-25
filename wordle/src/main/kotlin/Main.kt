// Import statements
import java.util.Random

/*
* Welcome to Wordle (again)! A little more capable in some ways than the last one.
* */

// Randomly select a word from a set list of strings
fun getWord() : String {
    val wordList = mutableListOf("magic", "rocks", "stick", "laser", "blade")
    val random = Random()
    val randIndex = random.nextInt(wordList.size)
    return wordList[randIndex]
}

// Continuously get player input before every game on whether they want to play or quit.
fun gameloop() {
    var choice : String? = "p"
    while (choice != "q") {
        print("[p]lay or [q]uit? ")
        choice = readLine()
        if (choice == "p") {
            val game = Wordle(getWord())
            game.play()
        }
    }
}

// Basic instructions for the beginning that tell user how to play.
fun displayOpeningText() {
    println("Welcome to Wordle!")
    println("How to play:")
    println("When prompted, guess a 5-letter word until you get it correct.")
    println("Each guess will be displayed back to you with feedback. If you guess a letter...")
    println("   - correctly and in the right position, a ! will be next to it.")
    println("   - correctly but in the wrong position, a * will be next to it.")
    println("   - entirely incorrectly, a - will be next to it.")
    println("Make sure all inputs are lowercase and the exact expected length for the time being.")
}

// Main; this is very important, as it is in most languages.
fun main(args : Array<String>) { //these args are present in most examples I see; reminiscent of Java, I think?
    displayOpeningText()
    gameloop()
}