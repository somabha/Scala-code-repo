

/**********************************************************************/
/************* First Spets to Scala ***********************************/
/**********************************************************************/


println("Hello from Scala !")

/*
args.foreach((arg: String) => println(arg))

args.foreach(println)

for(arg <- args)
	println(arg)
*/

var greetings: Array[String] = new Array[String](3)
greetings(0) = "Hello "
greetings(1) = "from "
greetings(2) = "Scala Mundo!"
for(i <- 0 to 2)
	print(greetings.apply(i))
	// Or println(greetings.apply(i))
println()


val greetStrings = new Array[String](3)

greetStrings.update(0, "Hello")
greetStrings.update(1, ", ")
greetStrings.update(2, "world!\n")

for (i <- 0.to(2))
  print(greetStrings.apply(i))



var listNumbers = List(1,2,3,4)

println(listNumbers)
println(listNumbers(2))

println(listNumbers(2)+1)
println(listNumbers(2))

var listNumbers2 = List(34,82,43,22)

var joint = listNumbers:::(listNumbers2.sorted)
println(joint)

var list = 1::2::45::Nil
println(list)

var list1 = List()
println(list1)


var tuple1 = (100, "Tuple 1", 20.3456, List(1,2,3))
println(tuple1._1)
println(tuple1._2)
println(tuple1._3)
println(tuple1._4)

import scala.collection.mutable.HashSet

val jetSet = new HashSet[String]
jetSet += "Lear"
jetSet += ("Boeing", "Airbus", "Cessna")
println(jetSet.contains("Cessna"))
println(jetSet)


import scala.collection.mutable.HashMap

var treasureMap = new HashMap[Int,String]
treasureMap += 1 -> "Go to the island"
treasureMap += 2 -> "Find big X on the ground"
treasureMap += 3 -> "Dig"


println(treasureMap(1))
println(treasureMap(2))
println(treasureMap(3))


var romanNumerals = Map(1 -> "I",2 -> "II",3 -> "III",4 -> "IV",5 -> "V")
println(romanNumerals)

class Greetings(greeting: String) {
	def greet() = { println(greeting)}

}

val gr = new Greetings("How are you?")
gr.greet()



class CarefulGreeter(greeting: String) {

	if(greeting == null) {throw new NullPointerException("geeting was null")}

	def greet() = println(greeting)
}

val f = new CarefulGreeter("Hellooooo!")
f.greet()


class RepeatGreeter(greeting: String, count: Int) {

	def this(greeting: String) = this(greeting, 1)

	def greet() = { 
		for(i <- 1 to count)
		  println(greeting)
	}
}

val g1 = new RepeatGreeter("Hello, greetings", 3)
g1.greet()
val g2 = new RepeatGreeter("Hi there!")
g2.greet()




class WorldlyGreeter(greeting: String) {
	
	if (greeting != null)println(greeting)
	def greet() = {
		val worldGreeting = WorldlyGreeter.worldify(greeting)
		println(worldGreeting)
	}

}

object WorldlyGreeter {
	def worldify(s: String) = s + ", World!"
}

val wdg = new WorldlyGreeter("Spark")
wdg.greet()


trait Friendly {
	def greet() = "Hi"
}

class Dog extends Friendly {
	override def greet() = "Woof"
}



trait ExclamatoryFriendly extends Friendly {
	override def greet() = super.greet + "!"
}


//var pet: Friendly = new Dog
var pet = new Dog with ExclamatoryFriendly
println(pet.greet())



/*******************************************************************/
/***** Intro to scala shell by AmpLab ****************/

val myNumbers = List(1,2,5,4,7,3)
println(myNumbers)

def cube (x: Int) = { if(x != null) (x*x*x)}

var c = cube(3)
println(c)


var res = myNumbers.map(x => cube(x))
println(res)

var ret = myNumbers.map{x => x * x * x}
println(ret)



def factorial(n: Int): Int = { 
	if(n==0) 1
	else {
		n*factorial(n-1)
	}
}

var fact = factorial(9)
println(fact)


/**** Do a wordcount of a textfile & map words to counts ******/

import scala.io.Source

val lines = Source.fromFile("README.md").getLines.toArray

val Counts = new collection.mutable.HashMap[String,Int].withDefaultValue(0)

lines.flatMap(lines => lines.split(" ")).foreach(word => Counts(word) += 1)

println(Counts)










