package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {


  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }
  }

  //  factorial(10)

  //  factorial(5000)
  //  with an argument of 5000 we will get a StackOverflowError
  //  such an error happens when the recursive depth is too big

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factHelper(10,1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1)
    = factHelper(1, 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10)
    = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10

   */

  //  println(anotherFactorial(20000)) // this one works well!
  // because with TAIL RECURSION Call Stack frames are not stored in Call Stack

  // WHEN YOU NEED LOOPS, USE TAIL RECURSION

  /*
      1. Concatenate a string n times (using tail recursion)
  */

  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n - 1, accumulator + aString)
  }

  println(concatenateTailrec("Hi everyone! ", 5, ""))

  /*
      2. IsPrime function tail recursive.
  */

  // HEAD RECURSIVE
  def isPrimeHeadRecursive(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  //TAIL RECURSIVE
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailRec(n / 2, true)
  }

  println(isPrime(2003)) //true
  println(isPrime(629)) //false

  /*
    3. Fibonacci function tail recursive.
*/

  def fibonacci(n: Int): BigInt = {
    def fiboTailrec(i: Int, last: BigInt, nextToLast: BigInt): BigInt =
      if (i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8)) // 1 1 2 3 5 8 13  -> SUM: 21
  println(fibonacci(30)) // 832040
  println(fibonacci(100)) // 354224848179261915075

}
