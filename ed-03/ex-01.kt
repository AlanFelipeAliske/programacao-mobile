fun main(args: Array<String>) {

    open class BankAccount(
        val customer: String,
        var balance: Double,
        val number: String,
        val agency: String
    ) {

        fun deposit(amount: Double) {
            balance += amount
        }

        fun withdraw(amount: Double) {
            if (balance >= amount) {
                balance -= amount
            } else {
                println("Fundos insuficientes")
            }
        }

        fun transfer(amount: Double, targetAccount: BankAccount) {
            if (balance >= amount) {
                balance -= amount
                targetAccount.deposit(amount)
            } else {
                println("Fundos insuficientes")
            }
        }

        fun printExtract() {
            println("Cliente: $customer")
            println("Numero da conta: $number")
            println("Agencia: $agency")
            println("Saldo: $balance")
        }
    }

    //-------------------------------------------

    val account1 = BankAccount("Jow", 500.0, "12345-6", "ABC")
    val account2 = BankAccount("Jaine", 1000.0, "67890-1", "DEF")

    account1.deposit(200.0)
    println("Saldo da conta 1 apos o deposito: ${account1.balance}")

    account2.withdraw(500.0)
    println("Saldo da conta 2 apos o deposito: ${account2.balance}")

    account1.transfer(100.0, account2)
    println("Saldo da conta 1 apos transferir: ${account1.balance}")
    println("Saldo da conta 2 apos transferir: ${account2.balance}")

    println("----- Extrato 1 -----")
    account1.printExtract()
    println("----- Extrato 2 -----")
    account2.printExtract()

    //-------------------------------------------

    val accounts = listOf(
        BankAccount("Jow", 500.0, "12345-6", "ABC"),
        BankAccount("Jaine", 1000.0, "67890-1", "DEF"),
        BankAccount("Bub", 750.0, "13579-2", "GHI"),
        BankAccount("Alice", 250.0, "24680-3", "JKL"),
        BankAccount("Charles", 1250.0, "97531-4", "MNO")
    )

    val sortedByBalance = accounts.sortedBy { it.balance }

    println("----- Contas classificadas por saldo -----")
    sortedByBalance.forEach { it.printExtract() }

    val sortedByName = accounts.sortedBy { it.customer }

    println("----- Contas classificadas por nome do cliente -----")
    sortedByName.forEach { it.printExtract() }

    //-------------------------------------------

    class SavingsAccount(
        customer: String,
        balance: Double,
        number: String,
        agency: String
    ) : BankAccount(customer, balance, number, agency) {

        fun applyInterest() {
            balance *= 1.003
        }
    }
}