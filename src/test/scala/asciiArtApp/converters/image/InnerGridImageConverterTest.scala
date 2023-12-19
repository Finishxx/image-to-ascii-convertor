package asciiArtApp.converters.image

import asciiArtApp.model.image.grid.{GridImage, GridImageAs2DSeq}
import converters.Converter
import helpers.TestWithGridImage
import org.scalatest.FunSuite
import org.scalatest.Matchers.{convertToAnyShouldWrapper, equal}

class InnerGridImageConverterTest extends FunSuite with TestWithGridImage {
  class PlusOneConverter extends Converter[Int, Int] {
    override def convert(what: Int): Int = what + 1
  }

  val plusOneGridImageConverter =
    new InnerGridImageConverter[Int, Int](new PlusOneConverter)

  test("Mapping +1 on ints") {
    def testMapPlusOne(width: Int, height: Int, fill: Int): Unit = {
      val gridImage: GridImage[Int] =
        new GridImageAs2DSeq[Int](Seq.fill(width, height)(fill))

      val convertedGridImage = plusOneGridImageConverter.convert(gridImage)

      all[Int](convertedGridImage, x => x == fill + 1)

      convertedGridImage.height should equal(height)
      convertedGridImage.width should equal(width)
    }

    testMapPlusOne(10, 10, 0)
    testMapPlusOne(100, 10, -10)
    testMapPlusOne(10, 100, 500)
  }

  test("Mapping on empty grid does not fail") {
    val emptyGridImage: GridImage[Int] =
      new GridImageAs2DSeq[Int](Seq())

    plusOneGridImageConverter.convert(emptyGridImage)
  }

}
