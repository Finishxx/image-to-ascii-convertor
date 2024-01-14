package `import`

import helpers.TestWithConsoleApplication

trait TestWithImport extends TestWithConsoleApplication {
  def tryAllTablesWithImage(imagePath: String): Unit =
    for (table <- Seq(
           bourkeTableFlag,
           bourkeSmallTableFlag,
           nonLinearTableFlag))
      println(runWithArgs(Seq(importImageFlag(imagePath), table)))
}
