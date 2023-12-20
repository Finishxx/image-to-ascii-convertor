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

  test("Should be able to deal with 4 characters") {
    def checkExpect(greyscaleIntensity: Int, expectedChar: Char, converter: LinearGreyscale8BitToAsciiConverter): Unit = {
      converter.convert(Greyscale8BitColor(greyscaleIntensity)) should be(AsciiCharacter(expectedChar))
    }

    val chars = "abcd".toCharArray.map(AsciiCharacter)
    val converter = new LinearGreyscale8BitToAsciiConverter(chars)
    checkExpect(0, 'a', converter)
    checkExpect(20, 'a', converter)
    checkExpect(63, 'a', converter)

    checkExpect(64, 'b', converter)
    checkExpect(90, 'b', converter)
    checkExpect(127, 'b', converter)

    checkExpect(128, 'c', converter)
    checkExpect(190, 'c', converter)
    checkExpect(191, 'c', converter)

    checkExpect(192, 'd', converter)
    checkExpect(250, 'd', converter)
    checkExpect(255, 'd', converter)
  }


  test("Should be able to deal with 3 characters") {
    def checkExpect(greyscaleIntensity: Int, expectedChar: Char, converter: LinearGreyscale8BitToAsciiConverter): Unit = {
      converter.convert(Greyscale8BitColor(greyscaleIntensity)) should be(AsciiCharacter(expectedChar))
    }

    val chars = "abc".toCharArray.map(AsciiCharacter)
    val converter = new LinearGreyscale8BitToAsciiConverter(chars)
    checkExpect(0, 'a', converter)
    checkExpect(20, 'a', converter)
    checkExpect(85, 'a', converter)

    checkExpect(86, 'b', converter)
    checkExpect(90, 'b', converter)
    checkExpect(170, 'b', converter)

    checkExpect(171, 'c', converter)
    checkExpect(190, 'c', converter)
    checkExpect(255, 'c', converter)
  }


  test("Should be able to deal with 5 characters") {
    def checkExpect(greyscaleIntensity: Int, expectedChar: Char, converter: LinearGreyscale8BitToAsciiConverter): Unit = {
      converter.convert(Greyscale8BitColor(greyscaleIntensity)) should be(AsciiCharacter(expectedChar))
    }

    val chars = "abcde".toCharArray.map(AsciiCharacter)
    val converter = new LinearGreyscale8BitToAsciiConverter(chars)
    checkExpect(0, 'a', converter)
    checkExpect(20, 'a', converter)
    checkExpect(51, 'a', converter)

    checkExpect(52, 'b', converter)
    checkExpect(75, 'b', converter)
    checkExpect(102, 'b', converter)

    checkExpect(103, 'c', converter)
    checkExpect(109, 'c', converter)
    checkExpect(153, 'c', converter)

    checkExpect(154, 'd', converter)
    checkExpect(200, 'd', converter)
    checkExpect(204, 'd', converter)

    checkExpect(205, 'e', converter)
    checkExpect(250, 'e', converter)
    checkExpect(255, 'e', converter)
  }

  // Now I realize that this test does use the logic in the tested
  // class itself, and now who tested that this test is correct, so
  // I will hardcode some values too
  test("Should be able to deal with even spread") {
    def testEvenSpread(charCount: Int): Unit = {
      require(128 % charCount == 0)
      val range: Int = 256 / charCount
      val chars = Seq.range(0, charCount).map(int => AsciiCharacter(int.toChar))

      val converter = new LinearGreyscale8BitToAsciiConverter(chars)

      for ((from, to) <- 0 until range * (charCount - 1) by range zip (range - 1 until range * charCount by range))
        for (intensity <- from to to)
          converter.convert(Greyscale8BitColor(intensity)) should equal(
            chars(from / range))
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
