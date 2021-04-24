package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x = 42
  val y = "Hello, Scala"
  println(y)

  // VALS ARE IMMUTABLE

  // Compiler can infer types;

  val aString: String = "hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 9348_7593_4857_9348L
  //  val aLong: Long = 9348759348579348L
  val aFloat: Float = 2.0f
  val asDouble: Double = 3.14

  //variables
  var aVariable: Int = 4

  aVariable = 5 // side effects


}
