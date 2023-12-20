package filters.grid.flip

import helpers.TestWithSeq2D
import org.scalatest.FunSuite
import org.scalatest.Matchers.{convertToAnyShouldWrapper, equal}

class FlipSeq2DFilterTest extends FunSuite with TestWithSeq2D {

  val xFlipper = new FlipSeq2DFilter[Int](Axis.X)
  val yFlipper = new FlipSeq2DFilter[Int](Axis.Y)

  test("Flip by X") {
    xFlipper.filter(gridSeq1x1) should equal(gridSeq1x1)
    xFlipper.filter(gridSeq2x2) should equal(Seq(Seq(3, 4), Seq(1, 2)))
    xFlipper.filter(gridSeq3x3) should equal(
      Seq(7, 8, 9),
      Seq(4, 5, 6),
      Seq(1, 2, 3))
  }

  test("Flip by Y") {
    yFlipper.filter(gridSeq1x1) should equal(gridSeq1x1)
    yFlipper.filter(gridSeq2x2) should equal(Seq(Seq(2, 1), Seq(4, 3)))
    yFlipper.filter(gridSeq3x3) should equal(
      Seq(4, 2, 1),
      Seq(6, 5, 4),
      Seq(9, 8, 7))
  }
}
