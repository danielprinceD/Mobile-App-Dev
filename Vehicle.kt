open class Vehicle(var name : String ,private var color : String){

    open fun start() = println("$color $name is starting")
    fun move() = println("$name is moving")
}


class Car(name : String  , color : String) : Vehicle(name , color) {

}
class Plane(n : String  , c : String) : Vehicle( n , c){
    override  fun start(){
        println("${super.name} is flying")
    }
}
//    val car = Plane("AirPlane" , "Black")
//    car.start()
//    car.move()


// Creating Button
open class View{
    open fun draw(){
        println("Drawing View")
    }
}

interface onClickListener {
    fun onClick()
}



open class Button(val text : String , val orientation : String , onClickListener: onClickListener ) : View()
{

    override fun draw(){
        println("Drawing Button")
        super.draw()
    }
}

class RoundedDutton(t : String, o : String , val corner : String , on : onClickListener) : Button(t , o , on){
    override fun draw(){
        println("Drawing Rounded Button")
        super.draw()
    }
}
//    val r = RoundedDutton("Submit" , "Center" , "50px")
//    r.draw()

// Sealed Class

sealed class Result(val message : String){

    fun show(){
        println("Result : $message")
    }

    class Success(message: String) : Result(message )
    class Error(message: String) : Result(message )

}
fun getDetail(res : Result) {
    when(res)
    {
        is Result.Success -> res.show()
        is Result.Error -> res.show()
    }
}

//     val suc = Result.Success("Success")
//     val err = Result.Error("Failed")
//
//    getDetail(suc)
//    getDetail(err)

// Abstract Classes

abstract class Things{
    open fun take() = println("Think is Taken")
}

class One(var name : String) : Things() {
    override fun take(){
        super.take()

    }
}
//    val user1 = User("Daniel" , 20)
//    val user2 = User("Daniel" , 20)
//    println(user1==user2)


// Interface Classes

interface Alphabets{
     fun spell(){
        println("A to Z")
    }
}
open class B {
    open fun spell(){
        println("B")
    }
}
class A : Alphabets , B(){
    override fun spell() {
        println("A")
        super<B>.spell()
    }

}

//    var Login = Button("Login" , "center" , object : onClickListener{
//        override fun onClick() {
//            println("Button Clicked")
//        }
//    })


// Delegation

interface Parent{
    fun print(){
        println("Function 1")
    }
    fun getValue(a : Any? , b : Any?)
}

interface  Child{
    fun print2(){
        println("Function 2")
    }
}

class First : Child{
    override fun print2() {
        super.print2()
    }
}

open class Second : Parent{
    override fun print() {
        println("Function 1")
    }

    override fun getValue(a: Any?, b: Any?) {
    }

}

open class Merger : Child by First() ,Parent by Second()
{
    override fun print() {
        super.print()
    }
    operator override fun getValue(a : Any? , b : Any?){

    }

    override fun print2() {
        super.print2()
    }
}

//    val user by Merger()
//    with(user){
//
//    }


// List
//    val name = listOf<String>("One" , "Two" , "Three" , "Four")
//    val name = mutableListOf<String>("One" , "Two" , "Three" , "Four")
//    name[0] = "Daniel"
//    println(name[0])
//    name += "Five"  // Append
//    name -= "Two"   // Remove
//    name.removeLast()  // Remove Last
//    name.add(0, "Added Front")  // Add Front
//    name.forEach { println(it) } // Iterate Element

// Set

//    val set = mutableListOfableSetOf("One" , 1 , 70.0 , 1)
//    set.addAll(setOf(1 , 2 , 3 ))
//    for(s in set)
//        println(s)

// Data Class
data class Passport(var name : String , var age : Int = 18)
//    val p = Passport("Daniel")
//    println( p.toString())


// Map

//    val map = mutableMapOf<Int , String>(1 to "Daniel" , 2 to "David")
//    map[3] = "Three"
//    println(map[3])
//    map.forEach{
//        k , v -> println("$k and $v")
//    }
//    for((k , v) in map)
//        println("Key : $k , Value : $v")




fun main() {

}