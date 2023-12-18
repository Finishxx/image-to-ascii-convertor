package dataSource.generators.number.bounded

import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be}

class StandardLibraryBoundedIntGeneratorTest extends FunSuite {

  def testNTimesBounds(from: Int, to: Int, times: Int): Unit = {

    val generator = new StandardLibraryBoundedIntGenerator(from, to)

    for (_ <- 1 to times)
      assert((from to to).contains(generator.provide()))
  }

  test("Invalid bounds") {
    an[IllegalArgumentException] should be thrownBy new StandardLibraryBoundedIntGenerator(
      0,
      -1)
  }

  test("One value inside expected bounds is generated") {
    testNTimesBounds(0, 100, 1)
  }

  test("Thousand tests for bounds 0 to 10") {
    testNTimesBounds(0, 10, 1000)
  }

  test("Thousand tests for negative values") {
    testNTimesBounds(-10, 0, 1000)
  }

}
