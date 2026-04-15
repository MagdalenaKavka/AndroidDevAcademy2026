package Zadaća2

class FibaTeam(name: String, league: String)
    : BasketballTeam(name, league), IPlay {
    override fun play() {
        println("Fiba team is playing.")
    }


    override fun TrajanjeCetvrtine() = 10

    fun TeamInfo() {
        roster.forEach { println("•${it.name} ") }
    }
}