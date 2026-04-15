package Zadaća2

fun main() {

    val barca = FibaTeam("FC Barcelona", "Euroliga")
    val gsw = NBATeam("Golden State Warriors")

    barca.coach = "Joan Peñarroya"
    gsw.coach = "Steve Kerr"

    barca.AddPlayer(Player("Kevin Punter", 118))
    barca.AddPlayer(Player("Jan Vesely", 122))
    barca.AddPlayer(Player("Nicolas Laprovittola", 145))
    barca.AddPlayer(Player("Jabari Parker", 163))
    barca.AddPlayer(Player("Willy Hernangomez", 120))

    gsw.AddPlayer(Player("Stephen Curry", 282))
    gsw.AddPlayer(Player("Draymond Green", 81))
    gsw.AddPlayer(Player("Andrew Wiggins", 115))
    gsw.AddPlayer(Player("Buddy Hield", 14))
    gsw.AddPlayer(Player("Brandin Podziemski", 93))

    barca.play()
    gsw.play()

    println("Barcelona: ")
    barca.TeamInfo()
    println("Golden State Warriors: ")
    gsw.TeamInfo()

    barca.FindBestPlayer()
    gsw.FindBestPlayer()

}