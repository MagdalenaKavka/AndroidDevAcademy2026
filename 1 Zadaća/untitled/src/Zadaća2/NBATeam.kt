package Zadaća2

class NBATeam(name: String)
    : BasketballTeam(name,"NBA"), IPlay {
    override fun play() {
        println("NBA team is playing.")
    }

    override fun TrajanjeCetvrtine() = 12

     fun TeamInfo() {
        roster.forEach { println("•${it.name} ") }
    }
}