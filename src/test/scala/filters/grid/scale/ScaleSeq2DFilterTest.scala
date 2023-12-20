package filters.grid.scale

import helpers.TestWithSeq2D
import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be, convertToAnyShouldWrapper, equal}

class ScaleSeq2DFilterTest extends FunSuite with TestWithSeq2D {

  val quadrupleScale = new ScaleSeq2DFilter[Int](4)
  val quarterScale = new ScaleSeq2DFilter[Int](0.25)
  val identityScale = new ScaleSeq2DFilter[Int](1)

  test("Throws on invalid scales") {
    def expectThrow(scale: Double): Unit =
      an[IllegalArgumentException] should be thrownBy new ScaleSeq2DFilter[Int](
        scale)

    expectThrow(0)
    expectThrow(2)
    expectThrow(5)
    expectThrow(-1)
  }

  test("Deals with empty grid") {
    quadrupleScale.filter(Seq()) should equal(Seq())
    quarterScale.filter(Seq()) should equal(Seq())
    identityScale.filter(Seq()) should equal(Seq())
  }

  test("Quadruples") {
    quadrupleScale.filter(gridSeq2x2) should equal(
      Seq(Seq(1, 1, 2, 2), Seq(1, 1, 2, 2), Seq(3, 3, 4, 4), Seq(3, 3, 4, 4)))
  }

  test("Quarters") {
    quarterScale.filter(gridSeq2x2) should equal(Seq(Seq(1)))
  }

  test("Identity") {
    identityScale.filter(gridSeq2x2) should equal(gridSeq2x2)
  }

  test("Quarter 1x1") {
    quarterScale.filter(gridSeq1x1) should equal(Seq(Seq(1)))
  }

  test("Quadruple 1x1") {
    quadrupleScale.filter(gridSeq1x1) should equal(Seq(Seq(1, 1), Seq(1, 1)))
  }

  test("Quarter 3x3") {
    quarterScale.filter(gridSeq3x3) should equal(Seq(Seq(1, 3), Seq(7, 9)))
  }

  test("Quadruple 3x3") {
    quadrupleScale.filter(gridSeq3x3) should equal(
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
