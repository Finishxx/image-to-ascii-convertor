package `import`

import helpers.TestWithConsoleApplication
import org.scalatest.FunSuite
import org.scalatest.Matchers.{be, convertToAnyShouldWrapper, equal, not}

class GenerationTest extends FunSuite with TestWithConsoleApplication {

  test("No exception is thrown") {
    runWithArgs(Seq(randomImageFlag, bourkeTableFlag))
  }

  test("Something is generated") {
    assert(runWithArgs(Seq(randomImageFlag, bourkeTableFlag, outputConsoleFlag)).nonEmpty)

  }

  test("Images are different") {
    runWithArgs(Seq(randomImageFlag, bourkeTableFlag, outputConsoleFlag)) should not be runWithArgs(
      Seq(randomImageFlag, bourkeTableFlag, outputConsoleFlag))
  }
}
