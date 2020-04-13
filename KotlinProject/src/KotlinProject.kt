const val STRING_CONST = "I'm a top level const"  // Java: public static final

fun main() {
    println(STRING_CONST)

    val greeting = when (14) {
        in 0..11 -> "Good morning!"
        12 -> "Time for lunch!"
        13, 14 -> {
            println("Yawn...")
            "Time for a nap!"
        }
        else -> "Good day!"
    }

    println(greeting)

    println(getMax(14, 100, 9))
    println(getMax(14, 10))
    println(getMax(14))
    println(getMax(9, remaining = *intArrayOf(2,3,4,5,6)))
    println(getMax(remaining = *intArrayOf(2,3,4,5,6)))

    greet(
        message = "Hi",
        name = "Hans",
        reps = 3
    )

    val array = intArrayOf(1, 2, 3, 4, 5, 6)

    println(getSum(10, 20, *array, 30, b = 40))
}


fun getMax(first: Int = 3, vararg remaining: Int): Int {
    var max = first

    for (i in remaining) {
        if (i > max) max = i
    }

    return max
}

fun greet(message: String, name: String = "User", reps: Int = 1) {
    println(STRING_CONST)
    for (i in 0 until reps) {
        println("Hello, $name! $message")
    }
}

fun getSum(a: Int, vararg numbers: Int, b: Int): Int {
    var sum = a + b

    for (number in numbers) sum += number

    return sum
}

fun max1(a: Int, b:Int): Int {       // this function has a block body.
    return if (a>b) a else b
}

fun max2(a: Int, b: Int): Int = if (a > b) a else b    // this function has an expression body.
//Note that omitting the return type is allowed only for functions with an expression body.
fun max3(a: Int, b: Int) = if (a > b) a else b  // type inference