package lectures.part1basics

object CBNvsCBV extends App {
  def calledByValue(x: Long): Unit = {
    println("by value: " + x); // 708859726786300
    println("by value: " + x); // 708859726786300
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x) // 708859788905200
    println("by name: " + x) // 708859788941200
  }
  // when we call function by name (parameter syntax is different then usually: x: => Long)
  // this little arrow =>  delays evaluation of the expression that was passed to function as a parameter
  // so every time, when x is encountered in program, the expression of x will be reevaluated
  // in this case our expression is: System.nanoTime()

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

//  printFirst(infinite(), 34)
  // this one will crash due to StackOverFlowError

  printFirst(34, infinite()) // here in function signature second parameter (y) is called by name
  // that's why it's evaluation is delayed until this parameter is encountered withing the program code
  // so, this function call will not crash, because infinite() is never evaluated in this function call

}
