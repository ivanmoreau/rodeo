package rodeo

import zio.test.assertTrue

import scala.collection.mutable.{Seq => MutableSeq}

object Variables extends Chapter {

  // Variables are references used to assign meaningful names to values.
  // Naming variables is one of the most important skills in programming.

  // A name assignment in Scala is defined using the keyword 'val' or 'var'.
  // `val` (Values) are immutable, that means they cannot change once they are assigned.
  // `var` (Variables) are mutable, that means they can be made to reference a different value.

  // Generally we encourage you to try to use immutable values, as they prevent you
  // from common pitfalls, such as race conditions, especially when dealing with structured concurrent programs,
  // as multiple processes may read/write values

  // The type of a value is inferred by the Scala compiler.
  // In this example, the Scala compiler infers that the type of `youAreLearning` is String.
  val youAreLearning = "Scala"

  // Exercise: Try uncommenting the following line and see the compiler error message. Then comment it again.
  // youAreLearning = "To fall"

  // The type of a value can also be explicitly specified using a colon and the type name.
  // Exercise: Try changing the type annotation to String and see compiler error messages. Then fix it again.
  val youAreAwesome: Boolean = true

  Exercise(
    "Assign your age to the `yourAge` variable"
  ) {
    // Replace the `???` placeholder with the correct code.
    val yourAge: Int = ???

    assertTrue(yourAge > 0)
  }

  // Curly brackets in vals or Brackets
  // Multiple expressions

  // Values can be eager or lazy.
  //
  // Eager values are evaluted when the containing object is created. The two previous examples
  // are computed when the `Variables` object is created.
  //
  // Lazy values are evaluated only when they are first accessed. Lazy values are useful when
  // computation is expensive or when the value is not needed until later in the program.
  lazy val someExpensiveComputation = {
    // some expensive computation here
    42
  }

  // Most of the time immutable variables are the kind you will be using on Scala,
  // However there are special occasions when you actually need *mutable references*
  // IMPORTANT: As noted before these type of variables are discouraged from functional programming principles.
  Exercise("Make the beers variable to hold a value of 99") {
    var beers: Int = 0
    beers += 1
    beers = beers * 2
    // TODO: assign 99 to the beers variable.

    assertTrue(beers == 99) // DO NOT touch this assert.
  }

  // Caveat: Values can have internal mutable variables
  //
  // As such even if something appears as an immutable val it could still mutate! Dx
  Exercise("Change a mutable object stored in an immutable value") {
    val rodeo: MutableSeq[Int] = MutableSeq(0)

    // Exercise: Using MutableSeq#update, change the first value on rodeo to be 99
    rodeo.update(0, 20)

    assertTrue(rodeo.headOption.contains(99))
  }
}
