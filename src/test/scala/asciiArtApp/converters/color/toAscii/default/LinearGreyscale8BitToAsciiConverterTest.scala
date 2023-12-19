package asciiArtApp.converters.color.toAscii.default

import asciiArtApp.model.character.ascii.AsciiCharacter
import asciiArtApp.model.color.greyscale.Greyscale8BitColor
import helpers.TestWithAsciiConversions
import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be, convertToAnyShouldWrapper, equal}

class LinearGreyscale8BitToAsciiConverterTest
    extends FunSuite
    with TestWithAsciiConversions {

  test("Should not be able to deal with 0 characters") {
    an[IllegalArgumentException] should be thrownBy new LinearGreyscale8BitToAsciiConverter(
      Seq())
  }

  test("Should be able to deal with up to 256 characters") {
    for (i <- 1 to 256) {
      val converter = new LinearGreyscale8BitToAsciiConverter(
        Seq.fill(i)(AsciiCharacter('a')))

      for (j <- 0 to 255)
        converter.convert(Greyscale8BitColor(j)) == AsciiCharacter('a')
    }
  }

  test("Should be able to deal with even spread") {
    def testEvenSpread(charCount: Int): Unit = {
      require(128 % charCount == 0)
      val equalRangeSize = 128 / charCount
      val chars =
        Seq.range(0, 127).map(it => AsciiCharacter(it.toChar)).take(charCount)
      print(s"taking $charCount = $chars")

      val converter = new LinearGreyscale8BitToAsciiConverter(chars)

      for (i <- 0 until charCount) {
        val from: Int = i * equalRangeSize
        val to: Int = (i + 1) * equalRangeSize

        for (j <- from until to)
          converter.convert(Greyscale8BitColor(j)) should equal(chars(i))
      }
    }

    testEvenSpread(1)
    testEvenSpread(2)
    testEvenSpread(4)
    testEvenSpread(8)
    testEvenSpread(16)
    testEvenSpread(32)
    testEvenSpread(64)
    testEvenSpread(128)
  }

}
