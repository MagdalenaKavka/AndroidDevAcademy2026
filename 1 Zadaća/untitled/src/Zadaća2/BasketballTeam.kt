package Zadaća2

abstract class BasketballTeam (
    val name: String,
    val league: String,
) {
    lateinit var coach: String

    protected val roster = mutableListOf<Player>()

    fun AddPlayer(i: Player) = roster.add(i)
    fun removePlayer(player: Player) {
        roster.remove(player)
    }

    fun FindBestPlayer() {
        val best = roster.maxByOrNull { it.points }!!
        println("Najbolji strijelac tima $name je ${best.name} sa ${best.points} koševa.")
    }

    abstract fun TrajanjeCetvrtine() : Int
}
