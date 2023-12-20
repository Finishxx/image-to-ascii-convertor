package filters.grid.rotate

import helpers.TestWithSeq2D
import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be, convertToAnyShouldWrapper, equal}

class RotateSeq2DFilterTest extends FunSuite with TestWithSeq2D {

  val fullRotationsFrom: Int = -2
  val fullRotationsTo: Int = 2

  def checkExpect(
    degrees: Int,
    input: Seq[Seq[Int]],
    expect: Seq[Seq[Int]]): Unit = {
    val filter = new RotateSeq2DFilter[Int](degrees)
    filter.filter(input) should equal(expect)
  }

  // Check with some arbitrary rotations on top
  def checkExpectRotated(
    degrees: Int,
    input: Seq[Seq[Int]],
    expect: Seq[Seq[Int]]): Unit =
    for (i <- fullRotationsFrom to fullRotationsTo)
      checkExpect(degrees + 360 * i, input, expect)

  test("Fail on invalid degrees") {
    def checkThrow(degrees: Int): Unit =
      an[IllegalArgumentException] should be thrownBy new RotateSeq2DFilter[
        Int](degrees)

    def checkThrowAlsoNeg(degrees: Int): Unit = {
      checkThrow(degrees)
      checkThrow(-degrees)
    }

    checkThrowAlsoNeg(1)
    checkThrowAlsoNeg(91)
    checkThrowAlsoNeg(179)
    checkThrowAlsoNeg(181)
    checkThrowAlsoNeg(269)
    checkThrowAlsoNeg(271)
    checkThrowAlsoNeg(359)
    checkThrowAlsoNeg(361)
  }

  test("Rotate clockwise (negative) 90 degrees") {

    checkExpectRotated(-90, gridSeq1x1, gridSeq1x1)
    checkExpectRotated(-90, gridSeq2x2, Seq(Seq(3, 1), Seq(4, 2)))
    checkExpectRotated(
      -90,
      gridSeq3x3,
      Seq(Seq(7, 4, 1), Seq(8, 5, 2), Seq(9, 6, 3)))
  }

  test("Rotate counterclockwise (positive) 90 degrees") {
    checkExpectRotated(90, gridSeq1x1, gridSeq1x1)
    checkExpectRotated(90, gridSeq2x2, Seq(Seq(2, 4), Seq(1, 3)))
    checkExpectRotated(
      90,
      gridSeq3x3,
      Seq(Seq(3, 6, 9), Seq(2, 5, 8), Seq(1, 4, 7)))
  }

  test("Rotate by 180 degrees") {
    def checkExpectRotatedAlsoNeg(
      degrees: Int,
      input: Seq[Seq[Int]],
      expect: Seq[Seq[Int]]): Unit = {
      checkExpectRotated(degrees, input, expect)
      checkExpectRotated(-degrees, input, expect)
    }

    checkExpectRotatedAlsoNeg(180, gridSeq1x1, gridSeq1x1)
    checkExpectRotatedAlsoNeg(180, gridSeq2x2, Seq(Seq(4, 3), Seq(2, 1)))
    checkExpectRotatedAlsoNeg(
      180,
      gridSeq3x3,
      Seq(Seq(9, 8, 7), Seq(6, 5, 4), Seq(3, 2, 1)))
  }

}
