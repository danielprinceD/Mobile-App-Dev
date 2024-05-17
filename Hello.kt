import java.util.Scanner
class Calculator {
    companion object {
    fun add(a : Int , b : Int) =
        println(a + b)
    }

}

// Singleton Class for single instance of a class

class Database private constructor() {
    companion object {
        private var inst : Database ?= null

        fun getInstance() : Database?{
            if(inst==null){
                inst = Database();
            }
            return inst
        }
    }
}

object Data{
    init{
        println("Database Created...!")
    }
    fun add() = println("Hello")
}

// Lazy Initialization

class User(var name : String ,var age : Int) : Any()
{
    init{
        println("user : $name is created")
    }
}

/*
main()=>

val user = User("daniel" , 20)
    val user2 by lazy {
        User("david" , 2)
    }
    user2.name
 */

// Enum Classes

enum class Direction(var value : Int){
    north(1) , south(2), east(3), west(4);
    fun printDetail() = println("Value : $value")
}
//    println(Direction.north.value)
//    Direction.west.printDetail()


// ListView

class ListView(val it : Array<String>) {

    inner class ListViewItems{
        fun displayItem(pos : Int) = println(it[pos])

    }
}
//    val listView = ListView(arrayOf("Daniel" , "David" ))
//    val it = listView.ListViewItems()
//    it.displayItem(0);


// Bank Account

class Account(var name : String )
{
    private var Balance : Double = 0.0;
    private var Transactions =  mutableListOf<String>()

    fun deposit(amount : Double){
        Balance += amount;
        println("Deposited Amount $amount")
        println("Balance Amount $Balance")
        updateTransaction("Deposit" , ""+amount)
    }

    fun withdraw(amount : Double){
        if(Balance-amount < 0)
        {
            println("Your Balance is low")
            return
        }
        Balance -= amount;
        println("Withdraw Amount $amount")
        println("Balance Amount $Balance")
        updateTransaction("Withdraw" , ""+amount)
    }

    private fun updateTransaction(operation : String , amount : String){
        Transactions.add("$operation : $amount")
    }
    fun history(){
        println("--------Transaction History-------")
        for(t in Transactions)
            println(t)
    }
    init{
        println("Welcome $name")
    }
}
//    var acc = Account("daniel")
//    acc.withdraw(200.0)
//    acc.deposit(900.0)
//    acc.deposit(200.0)
//    acc.withdraw(300.0)
//    acc.history()

