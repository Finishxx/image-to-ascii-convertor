package `export`

import helpers.TestWithConsoleApplication
import org.scalatest.FunSuite

import scala.io.Source
import scala.util.{Failure, Success, Try, Using}

class FileExportTest extends FunSuite with TestWithConsoleApplication {

  def outputFile: String = "src/e2e/scala/results/fileNotEmpty.txt"

  test("File is not empty") {
    runWithArgs(
      Seq(randomImageFlag, bourkeTableFlag, outputFileFlag(outputFile)))
    val tryFileContents: Try[String] =
      Using(Source.fromFile(outputFile))(content => content.mkString)

    tryFileContents match {
      case Success(content) => assert(content.nonEmpty)
      case Failure(_)       => fail("Could not read file!")
    }
  }
}
