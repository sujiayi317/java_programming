import kotlin.collections.toTypedArray as toTypedArray1

fun main() {
    val g = Greeter()
    g.greet("Hello OOP Hello World")

    println(getSum(listOf(1,2,3,4,5,6)))

    var b = "Hello there abc".split(" ")

    manyParams(1,2,3,4,5)
    manyParams("From", "Gallifrey", "to", "Trenzalore")
    manyParams("non-vararg-position", *"Hello there abc".split(" ").toTypedArray1())
}

fun getSum(values: List<Int>): Int {
    var total = 0
    for (i in values) total += i
    return total
}

fun<T> manyParams(a: T, vararg va : T) {
    println(a)
    for (i in va) {
        println(i)
    }
}
