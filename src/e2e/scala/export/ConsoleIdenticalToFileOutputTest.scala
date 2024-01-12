package `export`

import helpers.TestWithConsoleApplication
import org.scalatest.FunSuite

import scala.io.Source
import scala.util.{Failure, Success, Try, Using}

class ConsoleIdenticalToFileOutputTest
    extends FunSuite
    with TestWithConsoleApplication {

  def outputFile: String =
    "src/e2e/scala/results/fileIdenticalConsoleOutput.txt"

  test("Exported image is the same in console and in file") {
    def convertCRLFtoLF(input: String): String = {
      input.replaceAll("\r\n", "\n")
    }

    val consoleOutput: String = runWithArgs(
      Seq(
        randomImageFlag,
        bourkeTableFlag,
        outputFileFlag(outputFile),
        outputConsoleFlag))

    val tryFileContents: Try[String] =
      Using(Source.fromFile(outputFile))(content => content.mkString)

    tryFileContents match {
      case Success(content) =>
        assert(convertCRLFtoLF(consoleOutput) == convertCRLFtoLF(content))
      case Failure(_) => fail("Could not read file!")
    }
  }
}
