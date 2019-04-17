println("UW Complex Kotlin homework")

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15)
// use map to return a list with "", "FIZZ" or "BUZZ" as necessary
// use fold to compress the array of strings down into a single string
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ
//
val resultList = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
val mapresult  = resultList.map{it ->
    if (it % 5==0 && it%3==0) {
        "FIZZBUZZ"
    } else if (it %5==0) {
        "BUZZ"
    } else if (it %3==0) {
        "FIZZ"
    } else {
        ""
    }

}

val mapFoldResults = mapresult.fold("", {a, b -> a+b})

// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: () -> String): String {
    for (it in 1..this) {
        block()
    }
    return ""
}

fun block(intake: Int):String {
    if (intake % 3 == 0 && intake % 5 == 0) {
        return "FIZZBUZZ"
    } else if (intake % 3 == 0) {
        return "FIZZ"
    } else if (intake % 5 == 0) {
        return "BUZZ"
    } else {
        return ""
    }
}
// Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}
var mes = "Bar"
val r1= process("FOO", {
    mes ->
     "BAR"})

var mes2= "WOOGA"
val r2= process("FOO", {
    mes2 -> "WOOGAWOOGAWOOGA"})


val r2_message = "wooga"



// write an enum-based state machine between talking and thinking
enum class Philosopher {
    THINKING {
        override fun signal() = TALKING
        override fun toString(): String {
            return "Deep thoughts...."
        }
    },

    TALKING {
        override fun signal() = THINKING
        override fun toString(): String {
            return "Allow me to suggest an idea..."
        }
    };
    abstract fun signal():Philosopher
}

// create an class "Command" that can be used as a function (provide an "invoke()" function)
// that takes a single parameter ("message" of type String)
// primary constructor should take a String argument ("prompt")
// when called, the Command object should return a String containing the prompt and then the message
class Command(val prompt: String) {
    operator fun invoke(message: String): String {
        return prompt + message;
    }
}




// ================================
println("map fold test: " + if (mapFoldResults == "FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ") "." else "!")

println("r1 test: " + if (r1 == ">>> FOO: {BAR}") "." else "!")

println("r2 test: " + if (r2 == ">>> FOO: {WOOGAWOOGAWOOGA}") "." else "!")

var seneca = Philosopher.THINKING
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")
print("Seneca, think! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Deep thoughts....") "." else "!")
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")

print("Command tests: ")
print(if (Command("")("") == "") "." else "!")
print(if (Command("> ")("Hello!") == "> Hello!") "." else "!")
println("")



