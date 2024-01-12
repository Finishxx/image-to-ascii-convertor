package `export`

import helpers.TestWithConsoleApplication
import org.scalatest.FunSuite

class ConsoleExportTest extends FunSuite with TestWithConsoleApplication {

  test("Something is written to the console") {
    assert(
      runWithArgs(Seq(randomImageFlag, bourkeTableFlag, outputConsoleFlag)).nonEmpty)
  }

}
