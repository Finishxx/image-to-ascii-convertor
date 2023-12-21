package commandParser

import commandParser.model.{CommandFlag, CommandName}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{
  contain,
  convertToAnyShouldWrapper,
  theSameElementsAs
}

class CommandParserImplTest extends FunSuite {

  val example1: Seq[String] = Seq(
    "run",
    "--image",
    "../images/test-image.jpg",
    "--rotate",
    "+90",
    "--scale",
    "0.25",
    "--invert",
    "--output-console")
  val example2: Seq[String] = Seq(
    "run",
    "--image",
    "test-image.jpg",
    "--output-file",
    "../outputs/output.txt")
  val example3: Seq[String] = Seq(
    "run",
    "--image",
    "test-image.jpg",
    "--rotate",
    "+90",
    "--invert",
    "--output-file",
    "../outputs/output.txt",
    "--output-console",
    "--table",
    "bourke-small")

  val commandParser: CommandParser = new CommandParserImpl

  test("Parses example1") {
    val result = commandParser.parse(example1)

    print(result.flags)

    result.names.names shouldBe Seq("run")

    result.flags shouldBe Seq(
      CommandFlag("image", Seq("../images/test-image.jpg")),
      CommandFlag("rotate", Seq("+90")),
      CommandFlag("scale", Seq("0.25")),
      CommandFlag("invert", Seq.empty),
      CommandFlag("output-console", Seq.empty)
    )
  }

  test("Parses example2") {
    val result = commandParser.parse(example2)

    result.names.names shouldBe Seq("run")

    result.flags shouldBe Seq(
      CommandFlag("image", Seq("test-image.jpg")),
      CommandFlag("output-file", Seq("../outputs/output.txt")))

  }

  test("Parses example3") {
    val result = commandParser.parse(example3)

    result.names.names shouldBe Seq("run")

    result.flags shouldBe Seq(
      CommandFlag("image", Seq("test-image.jpg")),
      CommandFlag("rotate", Seq("+90")),
      CommandFlag("invert", Seq.empty),
      CommandFlag("output-file", Seq("../outputs/output.txt")),
      CommandFlag("output-console", Seq.empty),
      CommandFlag("table", Seq("bourke-small"))
    )

  }

}
