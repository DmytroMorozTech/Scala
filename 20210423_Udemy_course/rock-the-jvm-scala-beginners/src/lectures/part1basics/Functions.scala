package lectures.part1basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction) // unlike Java Script, where this syntax would mean
  // that we're dealing with the function's value without running it,
  // in Scala we may call parameterless functions this way! Without even parentheses ()

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Hello!", 5))

  // In another programming languages you basically use loops, while
  // in Scala (or in some other functional language) you should use recursive functions.

  // WHEN YOU NEED LOOPS -> USE RECURSION
  // The worst thing a Scala developer can do is to use an imperative code
  // with Scala Syntax!

  // We should always put return types into our functions' signatures,
  // especially if they are recursive

  def aFunctionWithSideEffect(aString: String): Unit = println(aString)
  // we usually may need functions with side effects in cases, when these functions
  // do not have to perform any computations (printing something to the screen; logging; etc)


  //code-blocks allow us to define not only auxiliary variables within them,
  // but we can also define auxiliary functions within them!

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  println(aBigFunction(3)) // 3 + 2 => 5 (result)

  ////////////
  // Tasks to be completed:
  // 1. Write a greeting function (name, age) => "Hi, my name is $name and I am $age years old."

  def aGreetingFunction(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }

  println(aGreetingFunction("John", 35))

  // 2. Factorial function 1 * 2 * 3 * ... * n

  def factorial(n: Int): Long = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  println(factorial(5)) //120
  println(factorial(10)) //3628800

  /*
      3. A Fibonacci function
          f(1) = 1
          f(2) = 1
          f(n) = f(n-1) + f(n -2)
   */

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(10)) // 55
  println(fibonacci(30)) // 832040


  /*
      3. To write a function that tests if a number is prime.
      //In math, prime numbers are whole numbers greater than 1,
        that have only two factors – 1 and the number itself.
        Prime numbers are divisible only by the number 1 or itself.
        For example, 2, 3, 5, 7 and 11 are the first few prime numbers.
   */

  def isPrime(n: Int): Boolean = {
    // this auxiliary function helps us to find out whether n has any divisors until t
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
    // why do we use n/2 ?
    // Because no numbers are divisible without remainder by numbers
    // that are in the range [n/2 ... n-1]
    // e.g. 20/2 = 10   -> The range above n/2 would be [11,12,13,...,19]
    // And we can clearly see, that 20 will not be divisible by any of these numbers without remainder
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))

}
