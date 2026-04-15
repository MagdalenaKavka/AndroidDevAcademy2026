package Zadaća1

fun main() {
    var stepsPerDay = listOf(4500, 12000, 8000, 15000, 3000, 11000, 9500)
    var sum = 0

    for(i in stepsPerDay) {
        sum += i
    }

    println("Ukupan zbroj koraka je: $sum")

    var index=0
    var i=0
    while(i < stepsPerDay.size) {
        if(stepsPerDay[i]>=10000){
            index = i+1
            break
        }
        i++
    }

    println("Korisnik je $index. dan premašio 10k koraka")


}