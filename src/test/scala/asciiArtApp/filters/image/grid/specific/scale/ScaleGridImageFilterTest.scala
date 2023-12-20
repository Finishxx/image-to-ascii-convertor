package asciiArtApp.filters.image.grid.specific.scale

import asciiArtApp.filters.image.grid.scale.ScaleGridImageFilter
import asciiArtApp.model.image.grid.{GridImage, GridImageAs2DSeq}
import helpers.TestWithGridImage
import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be, convertToAnyShouldWrapper, equal}

class ScaleGridImageFilterTest extends FunSuite with TestWithGridImage {
  val quadrupleScale = new ScaleGridImageFilter[Int](4)
  val quarterScale = new ScaleGridImageFilter[Int](0.25)
  val identityScale = new ScaleGridImageFilter[Int](1)

  val emptyGridImage: GridImage[Int] = new GridImageAs2DSeq(Seq())

  test("Throws on invalid scales") {
    def expectThrow(scale: Double): Unit =
      an[IllegalArgumentException] should be thrownBy new ScaleGridImageFilter[
        Int](scale)

    expectThrow(0)
    expectThrow(2)
    expectThrow(5)
    expectThrow(-1)
  }

  test("Deals with empty grid") {
    quadrupleScale.filter(emptyGridImage).toGrid should equal(Seq())
    quarterScale.filter(emptyGridImage).toGrid should equal(Seq())
    identityScale.filter(emptyGridImage).toGrid should equal(Seq())
  }

  test("Quadruples") {
    quadrupleScale.filter(grid2x2).toGrid should equal(
      Seq(Seq(1, 1, 2, 2), Seq(1, 1, 2, 2), Seq(3, 3, 4, 4), Seq(3, 3, 4, 4)))
  }

  test("Quarters") {
    quarterScale.filter(grid2x2).toGrid should equal(Seq(Seq(1)))
  }

  test("Identity") {
    identityScale.filter(grid2x2).toGrid should equal(gridSeq2x2)
  }

  test("Quarter 1x1") {
    quarterScale.filter(grid1x1).toGrid should equal(Seq(Seq(1)))
  }

  test("Quadruple 1x1") {
    quadrupleScale.filter(grid1x1).toGrid should equal(
      Seq(Seq(1, 1), Seq(1, 1)))
  }

  test("Quarter 3x3") {
    quarterScale.filter(grid3x3).toGrid should equal(Seq(Seq(1, 3), Seq(7, 9)))
  }

  test("Quadruple 3x3") {
    quadrupleScale.filter(grid3x3).toGrid should equal(
      Seq(
        Seq(1, 1, 2, 2, 3, 3),
        Seq(1, 1, 2, 2, 3, 3),
        Seq(4, 4, 5, 5, 6, 6),
        Seq(4, 4, 5, 5, 6, 6),
        Seq(7, 7, 8, 8, 9, 9),
        Seq(7, 7, 8, 8, 9, 9)
      )
    )
  }
}
