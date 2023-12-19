package asciiArtApp.converters.color.toAscii.default

import asciiArtApp.model.character.ascii.AsciiCharacter
import helpers.{TestWithAsciiConversions, TestWithColor}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be, convertToAnyShouldWrapper, equal}

class FillerGreyscale8BitToAsciiConverterTest
    extends FunSuite
    with TestWithColor
    with TestWithAsciiConversions {

  def testConversion(chars: Seq[AsciiCharacter]): Unit = {
    val converter = new FillerGreyscale8BitToAsciiConverter(chars)
    for (greyscaleColor <- getAllGreyscale8BitColors) {
      val converted = converter.convert(greyscaleColor)
      converted should equal(
        chars(Math.min(greyscaleColor.intensity, chars.length - 1)))
    }
  }

  test("Should throw on characters outnumbering 256 values") {
    an[IllegalArgumentException] should be thrownBy
      new FillerGreyscale8BitToAsciiConverter(
        Seq.fill(257)(AsciiCharacter('a')))
    an[IllegalArgumentException] should be thrownBy
      new FillerGreyscale8BitToAsciiConverter(
        Seq.fill(500)(AsciiCharacter('a')))
  }

  test("Should not be able to deal with zero characters") {
    an[IllegalArgumentException] should be thrownBy
      new FillerGreyscale8BitToAsciiConverter(Seq())
  }

  test("Should be able to deal with just one character") {
    val converter =
      new FillerGreyscale8BitToAsciiConverter(Seq(AsciiCharacter('a')))

    for (greyscaleColor <- getAllGreyscale8BitColors)
      converter.convert(greyscaleColor) should equal(AsciiCharacter('a'))
  }

  test("Standard chars") {
    testConversion(standardConversionChars)
  }

  test("Paul Bourke's chars") {
    testConversion(paulBourkeChars)
  }
}
