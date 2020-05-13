fun main() {
    val user1 = User("      Hans", 30)
    val user2 = User("  Jen", 60)
    val user3 = User(age = 60)
    val user4 = User("     ", age = 20)
}

class User(name: String = "No Name", var age: Int) {
    val name: String

    init {
        if (name.isBlank()) {
            this.name = "No Name"
        }
        else {
            this.name = name.trim()
        }
        println("New user created. Name: ${this.name}, Age: $age")
    }
}