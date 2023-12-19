package converters.interval

import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be, convertToAnyShouldWrapper, equal}

class LinearIntervalConverterTest extends FunSuite {

  test("Throws on illegal bounds") {
    def makeConverterWithBounds(from: Int, to: Int): Unit =
      an[IllegalArgumentException] should be thrownBy new LinearIntervalConverter[
        Int](Seq(1), from, to)

    makeConverterWithBounds(1, 0)
    makeConverterWithBounds(-100, -1000)
    makeConverterWithBounds(1000, 100)
  }

  test("Throws on empty elements") {
    an[IllegalArgumentException] should be thrownBy new LinearIntervalConverter[
      Int](Seq(), 0, 1)
  }

  test("Throws on trying to access out of interval") {
    val converterPos = new LinearIntervalConverter[Int](Seq(1, 2, 3), 0, 5)

    an[IllegalArgumentException] should be thrownBy converterPos.convert(10)
    an[IllegalArgumentException] should be thrownBy converterPos.convert(-10)


    val converterNeg = new LinearIntervalConverter[Int](Seq(1, 2, 3), -5, 0)

    an[IllegalArgumentException] should be thrownBy converterNeg.convert(10)
    an[IllegalArgumentException] should be thrownBy converterNeg.convert(-10)
  }

  test("Positive bounds: Equal spread") {
    val converter = new LinearIntervalConverter[Int](Seq(1, 2, 3), 0, 5)
    converter.convert(0) should equal(1)
    converter.convert(1) should equal(1)
    converter.convert(2) should equal(2)
    converter.convert(3) should equal(2)
    converter.convert(4) should equal(3)
    converter.convert(5) should equal(3)
  }
  test("Positive bounds: Unequal spread") {
    val converter = new LinearIntervalConverter[Int](Seq(1, 2, 3), 0, 7)
    converter.convert(0) should equal(1)
    converter.convert(1) should equal(1)
    converter.convert(2) should equal(1)
    converter.convert(3) should equal(2)
    converter.convert(4) should equal(2)
    converter.convert(5) should equal(2)
    converter.convert(6) should equal(3)
    converter.convert(7) should equal(3)
  }

  test("Negative bounds: Equal spread") {
    val converter = new LinearIntervalConverter[Int](Seq(1, 2, 3), -5, 0)
    converter.convert(-5) should equal(1)
    converter.convert(-4) should equal(1)
    converter.convert(-3) should equal(2)
    converter.convert(-2) should equal(2)
    converter.convert(-1) should equal(3)
    converter.convert(0) should equal(3)
  }
  test("Negative bounds: Unequal spread") {
    val converter = new LinearIntervalConverter[Int](Seq(1, 2, 3), -7, 0)
    converter.convert(-7) should equal(1)
    converter.convert(-6) should equal(1)
    converter.convert(-5) should equal(1)
    converter.convert(-4) should equal(2)
    converter.convert(-3) should equal(2)
    converter.convert(-2) should equal(2)
    converter.convert(-1) should equal(3)
    converter.convert(0) should equal(3)
  }

  test("Bounds equal on one element is ok") {
    val converter = new LinearIntervalConverter[Int](Seq(1), 0, 0)
    1 should equal(converter.convert(0))
  }

  test("Bounds equal on more than one element not ok") {
    an[IllegalArgumentException] should be thrownBy new LinearIntervalConverter[
      Int](Seq(1, 2, 3), 0, 0)
  }

  test("Bounds equal on zero elements not ok") {
    an[IllegalArgumentException] should be thrownBy new LinearIntervalConverter[
      Int](Seq(), 0, 0)
  }
}
