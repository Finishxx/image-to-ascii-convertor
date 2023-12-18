package dataSource.generators.number

import org.scalatest.FunSuite
import org.scalatest.Matchers.{be, noException}

class StandardLibraryIntGeneratorTest extends FunSuite {

  test("Something is generated and we do not throw") {
    val generator = new StandardLibraryIntGenerator()

    noException should be thrownBy generator.provide()
  }

  test("We can generate multiple values") {
    val generator = new StandardLibraryIntGenerator()

    assert {
      for (i <- 0 to 100)
        noException should be thrownBy generator.provide()
      true
    }
  }

}
