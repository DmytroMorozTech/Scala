package lectures.part1basics

import java.lang.Number

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2)) // l
  println(str.substring(7, 11)) // I am
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') //a2z
  println(str.reverse) // alacS gninrael ma I ,olleH
  println(str.take(2)) // He

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  println(greeting)
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline") // raw format ignores escape characters within the String
  // the output to console will be: This is a \n newline

  val escaped = "This is a \n newline"
  println(raw"$escaped")
  // If we insert some value into the raw format string and this value contains some escape characters
  // then they will be taken into account when printing to console.
  //Output here would be:
  // This is a
  // newline

}
