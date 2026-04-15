package Zadaća1

fun main() {
    var code: Int = readln().toInt()
    var price: Double = 5.00
    var moneyGiven: Double = readln().toDouble()

    var drink = when(code) {
        1 -> "Voda"
        2 -> "Cola"
        3 -> "Sok"
        4 -> "Kava"
        else -> "Kod nije dobar"
    }

    if(moneyGiven >= price) {
        var change = price - moneyGiven
        println("Drink: $drink, Change: $change")
    }
    else {
        var moneyMissing = price - moneyGiven
        println("Fali vam $moneyMissing $ za odabrano piće")
    }


}