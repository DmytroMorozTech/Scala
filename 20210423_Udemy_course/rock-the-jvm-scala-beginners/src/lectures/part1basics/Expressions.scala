package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >>  >>> (right shift with zero extension)

  println(1 == x) //false
  // ==  !=  >  >=  <  <=

  println(!(1 == x)) //true
  // ! && ||   logical operators

  var aVariable = 2
  aVariable += 3 // also works with -= *= /=   ... side effects
  println(aVariable)

  // Instruction (DO) vs expressions (VALUE)
  // Every single bit of your code will compute a value

  // IF expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  // Java equivalent:
  // final aConditionedValue = aCondition ? 5 : 3;

  // if (aCondition) 5 else 3   -> this is called an IF EXPRESSION (NOT INSTRUCTION)
  // because it gives back a value!
  println(if (aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  println("--------------------------------")
  while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER WRITE THIS AGAIN
  // The worst thing a programmer can do is to write an imperative code with Scala syntax:
  // we should avoid using while loops in Scala.
  // EVERYTHING IN SCALA IS AN EXPRESSION!

  val aWeirdValue = (aVariable = 3) // Unit === void;
  // means that expression on the right side doesn't return anything meaningful;
  println(aWeirdValue)
  // Side effects in Scala are actually expressions returning Units (void)

  // side effects: println(), whiles, reassigning (like aVariable = 3)
  // all these return Unit (void)
  // in other languages these operations are rather instructions, but in Scala they
  // are expressions returning Unit.

  // Code blocks

  // Code-block is an expression in Scala!
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
    // the value of the whole code-block is the value of this expression,
    // because it occurs last in this code-block
  }

  // 1. difference between "hello world" println("hello world") ?
  // "hello world" is a value, it is a String literal, while
  // println("hello world")  - > is an expression returning Unit (i.e. side effect)

  // 2. What's the value of code-block below?
  val someValue = {
    2 < 3
  }
  println(someValue)
  // this code-block returns Boolean  -> true

  // 3. What's the value of code-block below?
  val someOtherValue = {
    if (someValue) 239 else 987 // this line of code is completely irrelevant
    42 // the value of code block will be 42
    // because the value of the code-block is the value, stated in the last line of block
  }
  println(someOtherValue)

}
