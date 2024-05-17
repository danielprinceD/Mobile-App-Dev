import java.util.Scanner

// Lambda Function

//    val num = setOf(1 , 2 ,  3)
//    println( num.map{
//        it * 10
//    })

//    val num = mapOf<Int , String>(1 to "One" , 3 to "Two" , 0 to "Three")
//    num.map{
//        println("${it.key}  to  ${it.value} ")
//    }
//
//    val mapKey = num.mapKeys {
//        "Key :  ${it.key}"
//    }
//    println(mapKey)
//
//    val nu = num.toSortedMap()
//    println(nu)


// Zip Function

//    val colors = listOf("Red" ,"Black" , "Blue")
//    val animal = listOf("Gorilla" , "Tiger" , "Cat")
//    val zipped = colors zip animal
//    for(z in zipped)
//    {
//        println(z.first + " is " + z.second)
//    }
//    val unzipped = zipped.unzip()
//    println(unzipped.first)
//    println(unzipped.second)


// Map Associated Properties

//    val map = listOf("One" , "Two" , "Three")
//    var t = 0;
//    val associatedBy = map.associateBy { t++ }
//    val associatedWith = map.associateWith { --t }
//
//    val associatedByFunction = map.associateBy(keySelector = {it[1].uppercase()} , valueTransform = {it.length})
//    println(associatedBy)
//    println(associatedWith)
//    println(associatedByFunction)

// Flatten

//    val twoD = listOf(listOf(1 ,2 , 3) , listOf(4 , 5 ,6) , listOf(7 ,8 ,9))
//    val it = twoD.listIterator()
//    while(it.hasNext())
//        println(it.next())
//    val flattened = twoD.flatten()
//    println(flattened)

// String Representation

//    val numString = listOf<String>("One" , "Two" , "Three")
//    println(numString.joinToString())
//
//    val buffer = StringBuffer("The List of Number : ")
//    println(numString.joinTo(buffer))
//    println(numString.joinToString(separator = " " , prefix = "List : " , postfix = " |" ))
//
//
//    val onetohund = (1 .. 100 ).toList()
//    println(onetohund)
//    println(onetohund.joinToString(limit = 10 , truncated = "... 100 |" , separator = "  | "))
//
//    println(numString.joinToString {
//        "Element : ${it.lowercase()}"
//    })

// Filtering

//    // LIST
//    val numbers = listOf<String>("One" , "Two" , "Three" , "Four")
//    val gt3 = numbers.filter { it.length > 3 }
//    println(gt3)
//
//    //MAP
//    val map = mapOf(1 to "One" , 2 to "Two" , 3 to "Three")
//    println(map.filter { it.value.length > 3 })
//
//    // Index Filtering
//    val index = numbers.filterIndexed{
//        ind , s ->(ind!=numbers.size-1) && s.length > 3
//    }
//    println(index)
//
//    // MIXED
//
//    val mixed = listOf("One" , 2 , false , 'A')
//    mixed.filterIsInstance<String>().forEach{
//        println(it.uppercase())
//    }
//
//    // Partition
//
//     val (match , notMatch) = numbers.partition { it.length > 3 }
//    println(match)
//    println(notMatch)
//
//    println(numbers.any{
//        it.endsWith("e")
//    })
//    println(numbers.none{
//        it.endsWith("a")
//    })
//    println(numbers.all{
//        it.endsWith("e")
//    })

// Grouping

//    val alpha = mutableListOf("Apple" , "Ball" , "Cat" , "Dog")
//
//    // Group by {}
//    println(alpha.groupBy { it.length })
//
//    //Group By ()
//    var t = 0
//    println(alpha.groupBy(keySelector = {it[1] } , valueTransform = {it.lowercase()}))
//

// List Collection

//    println(num.slice(0..2))
//    println(num.slice(0..2 step  2))
//    println(num.slice(listOf(1 , 0 , 0)))
//
//    println("--------------DROP & TAKE ---------------------")
//    println(num.take(2))  // takeWhile{}
//    println(num.takeLast(2)) // takeLastWhile{}
//    println(num.drop(2))    // dropWhile{}
//    println(num.dropLast(2))  // dropLastWhile{}
//    println("----------------- CHUNKED ------------------")
//
//    val numbers = (1..10).toList()
//    println(numbers.chunked(2))
//    println(numbers.chunked(2){it.reversed()})
//
//    println("----------------- WINDOWED ------------------")
//
//    println(numbers.windowed(3 ,2))
//
//    val num = listOf("one" , "two" , "three")
//    println(num.first())
//    println(num.first{ it.length > 3 })
//
//    println(num.random())

// List functions
//    println(number.sum())
//    println(number.count())
//    println(number.average())
//    println(number.maxOrNull())
//    println(number.minOrNull())
//    println(number.sumOf { it * 2 })


data class Laptop(var name : String , var price : Double , var ram : Int) : Comparable<Laptop>{

    override fun compareTo(other: Laptop): Int {
        return if(this.price > other.price) 1
            else if(this.price < other.price) -1
            else 0
    }
}

class SortByRam : Comparator<Laptop>
{
    override fun compare(lap1 : Laptop , lap2: Laptop): Int {
        return if(lap1.ram > lap2.ram) 1
        else if(lap1.ram < lap2.ram) -1
        else 0
    }
}
//    val range = (1..100).toList()
//    val number = mutableListOf<Int>()
//    for(i in 1..10)
//        number.add(range.random())
//    println(number)
//    number.sorted().forEach{ print("$it ") }
//    println()
//    // Class Sorting
//    val laptops = mutableListOf<Laptop>(
//        Laptop("DELL" , 1000.0 , 8) ,
//        Laptop("DELL" , 2000.0 , 8) ,
//        Laptop("ASUS" , 2000.0 , 4),
//        Laptop("HP" , 1300.0 , 16) )
//    laptops.sorted().forEach{ print("$it ") }
//    println()
//    laptops.sortedWith(SortByRam()).forEach{ print("$it ")}
//    println()
//    println("-----------Compare By Function----------------")
//    laptops.sortedWith(compareBy({it.name})).forEach{ println(it) }
//    laptops.sortedWith(compareBy({it.price})).forEach{ println(it) }
//
//    println("-----------Sorted By { } ----------------")
//    laptops.sortedBy { it.ram }.forEach{ println(it) }
//
//    println("-----------SortedWith() thenBy { } ----------------")
//
//    laptops.sortedWith(compareBy<Laptop>{it.name}.thenBy { it.price }).forEach{ println(it) }

// Binary Search

//    val number = (1..10).toMutableList()
//    println(search(10 , number))


private fun search(ele : Int ,  list : MutableList<Int>) : Int{
    return if ( list.binarySearch(ele) < 0 ) 0
    else 1
}


// Generic Class

class Team<T>( private val tname : String , private val Players : MutableList<T>) {
    fun addPlayer(player: T){
        if(Players.contains(player)) println("Player : ${(player as Player).name} is already exists")
        else{
            Players.add(player)
            println("Player : ${(player as Player).name} is added")
        }
    }
    fun getPlayer(){
        println("$tname Players are : ")
        Players.forEach{ println((it as Player).name) }
    }
}


open class Player(val name : String , var game : String)

class FootBall(name : String , game : String ) : Player(name , game)
class Cricket(name : String , game : String ) : Player(name , game)

//    val fb1 = FootBall("Messi" , "Football")
//    val fb2 = FootBall("Ronaldo" , "Football")
//    val cr1 = Cricket("Maxwell" , "Cricket")
//    val fb_team = Team<FootBall>("Foot Blasters" , mutableListOf())
//    fb_team.addPlayer(fb1)
//    fb_team.addPlayer(fb2)
//    fb_team.getPlayer()

fun main(args : Array<String>) {
    val number = arrayOf<Int>(1 , 20 , 3 , 200 , 60, 40 , 70)

}
