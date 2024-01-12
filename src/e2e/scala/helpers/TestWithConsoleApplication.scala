package helpers

import scala.sys.process.Process

trait TestWithConsoleApplication {

  def resDir: String = "src/e2e/scala/results"
  def applicationPath: String = "src/e2e/scala/applicationJar/asciiart.jar"

  def escape(what: String): String = what.mkString("\"", "", "\"")

  def importImageFlag(path: String): String = s"--image ${escape(path)}"
  def randomImageFlag: String = "--image-random"
  def tableFlag(tableName: String): String = s"--table ${escape(tableName)}"
  def bourkeTableFlag: String = tableFlag("bourke")
  def bourkeSmallTableFlag: String = tableFlag("bourke-small")
  def nonLinearTableFlag: String = tableFlag("non-linear")
  def customTableFlag(table: String): String =
    s"--custom-table ${escape(table)}"
  def flipFlag(axis: String): String = s"--flip $axis"
  def rotate(degrees: String): String = s"--rotate $degrees"
  def scaleFlag(factor: String): String = s"--scale $factor"
  def outputConsoleFlag: String = "--output-console"
  def outputFileFlag(path: String): String = s"--output-file ${escape(path)}"

  def runWithArgs(args: Seq[String]): String = {
    val argString: String = args.mkString("", " ", "")
    println("java -jar \"" + applicationPath + "\" " + argString)
    Process("java -jar \"" + applicationPath + "\" " + argString).!!
  }

}
