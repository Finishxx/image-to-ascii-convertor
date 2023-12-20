package asciiArtApp.filters.image.grid.specific.flip

import asciiArtApp.filters.image.grid.flip.FlipGridImageFilter
import filters.grid.flip.Axis
import helpers.{TestWithGridImage, TestWithSeq2D}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{convertToAnyShouldWrapper, equal}

class FlipGridImageFilterTest extends FunSuite with TestWithGridImage {

  val xFlipper = new FlipGridImageFilter[Int](Axis.X)
  val yFlipper = new FlipGridImageFilter[Int](Axis.Y)

  test("Flip by X") {
    xFlipper.filter(grid1x1).toGrid should equal(gridSeq1x1)
    xFlipper.filter(grid2x2).toGrid should equal(Seq(Seq(3, 4), Seq(1, 2)))
    xFlipper.filter(grid3x3).toGrid should equal(
      Seq(Seq(7, 8, 9), Seq(4, 5, 6), Seq(1, 2, 3)))
  }

  test("Flip by Y") {
    yFlipper.filter(grid1x1).toGrid should equal(gridSeq1x1)
    yFlipper.filter(grid2x2).toGrid should equal(Seq(Seq(2, 1), Seq(4, 3)))
    yFlipper.filter(grid3x3).toGrid should equal(
      Seq(Seq(3, 2, 1), Seq(6, 5, 4), Seq(9, 8, 7)))
  }
}
