package asciiArtApp.model.image.grid

import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be}

import java.lang

class GridImageAs2DSeqTest extends FunSuite {

  test("Rejects malformed grids") {

    an[IllegalArgumentException] should be thrownBy new GridImageAs2DSeq[Int](
      Seq(Seq(1), Seq(1, 2)))
    an[IllegalArgumentException] should be thrownBy new GridImageAs2DSeq[Int](
      Seq(Seq(1), Seq(1), Seq(1, 2)))
    an[IllegalArgumentException] should be thrownBy new GridImageAs2DSeq[Int](
      Seq(Seq(1, 2), Seq(1), Seq(1, 2)))
  }
}
