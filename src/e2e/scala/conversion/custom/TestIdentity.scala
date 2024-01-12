package conversion.custom

import helpers.TestWithConsoleApplication
import org.scalatest.FunSuite
import org.scalatest.Matchers.{be, convertToAnyShouldWrapper}

trait TestIdentity extends FunSuite with TestWithConsoleApplication {

  def testIdentity(
    importFlag: String,
    conversionFlag1: String,
    conversionFlag2: String): Unit =
    runWithArgs(Seq(importFlag, conversionFlag1, outputConsoleFlag)) should be(
      runWithArgs(Seq(importFlag, conversionFlag2, outputConsoleFlag)))

}
