package converters.interval

import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be, convertToAnyShouldWrapper, equal}

class FillerIntervalConverterTest extends FunSuite {

  test("Constructing with invalid bounds") {
    def shouldThrow(from: Int, to: Int): Unit =
      an[IllegalArgumentException] should be thrownBy new FillerIntervalConverter[
        Int](Seq(), 0, from, to)

    shouldThrow(0, -1)
    shouldThrow(1, 0)
  }

  test("Trying to get element out of bounds") {
    val converter = new FillerIntervalConverter[Int](Seq(), 0, 0, 5)

    an[IllegalArgumentException] should be thrownBy converter.convert(-1)
    converter.convert(0)
    converter.convert(5)
    an[IllegalArgumentException] should be thrownBy converter.convert(6)
  }

  test("Equal bounds and empty elements is OK") {
    val converter = new FillerIntervalConverter[Int](Seq(), 1, 0, 0)

    converter.convert(0) should equal(1)
  }

  test("Equal bounds and non empty elements with size 1 is OK") {
    val converter = new FillerIntervalConverter[Int](Seq(1), filler = 2, 0, 0)

    converter.convert(0) should equal(1)
  }

  test("Equal bounds and non empty elements with size 2 is not OK") {
    an[IllegalArgumentException] should be thrownBy new FillerIntervalConverter[
      Int](Seq(1, 2), 3, 0, 0)
  }

  test("Positive bounds: Filler not used") {
    val converter = new FillerIntervalConverter[Int](Seq(1, 2, 3), 4, 0, 2)
    converter.convert(0) should equal(1)
    converter.convert(1) should equal(2)
    converter.convert(2) should equal(3)
  }
  test("Positive bounds: Filler used") {
    val converter = new FillerIntervalConverter[Int](Seq(1, 2, 3), 4, 0, 5)
    converter.convert(0) should equal(1)
    converter.convert(1) should equal(2)
    converter.convert(2) should equal(3)
    converter.convert(3) should equal(4)
    converter.convert(4) should equal(4)
    converter.convert(5) should equal(4)
  }

  test("Negative bounds: Filer used") {
    val converter = new FillerIntervalConverter[Int](Seq(1, 2, 3), 4, -5, -3)
    converter.convert(-5) should equal(1)
    converter.convert(-4) should equal(2)
    converter.convert(-3) should equal(3)
  }
  test("Negative bounds: Filler not used") {
    val converter = new FillerIntervalConverter[Int](Seq(1, 2, 3), 4, -7, -2)
    converter.convert(-7) should equal(1)
    converter.convert(-6) should equal(2)
    converter.convert(-5) should equal(3)
    converter.convert(-4) should equal(4)
    converter.convert(-3) should equal(4)
    converter.convert(-2) should equal(4)
  }
}
