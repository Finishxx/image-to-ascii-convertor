package asciiArtApp.converters.image.ascii

import asciiArtApp.model.character.ascii.AsciiCharacter
import asciiArtApp.model.image.grid.{GridImage, GridImageAs2DSeq}
import asciiArtApp.model.image.grid.ascii.AsciiCharacterImage
import helpers.TestWithSeq2D
import org.scalatest.FunSuite
import org.scalatest.Matchers.{convertToAnyShouldWrapper, equal}

class AsciiImageToTextConverterTest extends FunSuite {

  val converter = new AsciiImageToTextConverter

  val seq1x1: GridImage[AsciiCharacter] = new GridImageAs2DSeq(
    Seq(Seq('a'))
      .map(_.map(AsciiCharacter)))

  val seq2x2: GridImage[AsciiCharacter] = new GridImageAs2DSeq(
    Seq(Seq('a', 'b'), Seq('c', 'd'))
      .map(_.map(AsciiCharacter)))

  val seq3x3: GridImage[AsciiCharacter] = new GridImageAs2DSeq(
    Seq(Seq('a', 'b', 'c'), Seq('d', 'e', 'f'), Seq('g', 'h', 'i'))
      .map(_.map(AsciiCharacter)))

  test("Converts as expected") {
    def checkExpect(input: GridImage[AsciiCharacter], output: String): Unit =
      converter.convert(input) should equal(output)

    checkExpect(seq1x1, "a\n")
    checkExpect(seq2x2, "ab\ncd\n")
    checkExpect(seq3x3, "abc\ndef\nghi\n")

  }
}
