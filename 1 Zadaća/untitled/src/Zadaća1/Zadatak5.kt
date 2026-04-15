package Zadaća1

object TransactionLogger {
    fun log(msg: String) {
        println(msg)
    }
}

class BankAccount(var accountNumber: String) {
    var balance: Double = 0.0

    init {
        numberOfAccounts++
    }
    fun uplata(money: Double) {
        balance += money
        TransactionLogger.log("Stigla je uplata na račun. Stanje na računu: $balance")

    }

    fun isplata(money: Double) {
        if (money > balance) {
            TransactionLogger.log("Nedovoljno sredstava na računu $accountNumber. Pokušaj isplate: $money, Stanje: $balance")
        } else {
            balance -= money
            TransactionLogger.log("Isplata $money s računa $accountNumber. Novo stanje: $balance")
        }
    }

    companion object{
        var numberOfAccounts = 0
    }

}

fun main() {
    var account1 = BankAccount("1")
    var account2 = BankAccount("2")

    account1.uplata(100.00)
    account2.uplata(100.00)

    account1.isplata(110.00)

    println("Account ${account1.accountNumber} balance: ${account1.balance}")
    println("Account ${account2.accountNumber} balance: ${account2.balance}")

    println("Total account created: ${BankAccount.numberOfAccounts}")


}