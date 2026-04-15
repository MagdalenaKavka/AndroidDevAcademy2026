package Zadaća1

fun main() {
    val name: String
    val surname: String
    var email: String? = null
    val age: Int? = 22

    println("Duljina email adrese je ${email?.length}")

    email = "proba@gmail.com"

    println("Duljina email adrese je ${email?.length}")
}