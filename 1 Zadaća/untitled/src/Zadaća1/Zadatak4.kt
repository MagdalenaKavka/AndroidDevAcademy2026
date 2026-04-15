package Zadaća1

fun main() {
    var username : String = readln()

    var CorrectedUsername : String = usernameCorrection(username)

    if(isValid(CorrectedUsername)){
        println("Your name is correct")
    }
    else
        println("Your name is incorrect")
}

fun usernameCorrection(username : String) : String {
    return username.trim().lowercase()
}

fun isValid(username: String) : Boolean {
    if(username.length >=5 && username.length <=15
        || !username.isBlank()
        || username[0].isLetter()
        || username.all {it.isLetterOrDigit() || it == '_'}
        || !username.contains(' '))
        return true
    else
        return false
}