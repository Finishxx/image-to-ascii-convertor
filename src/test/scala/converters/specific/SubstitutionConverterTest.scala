package converters.specific

import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be, convertToAnyShouldWrapper, equal}

class SubstitutionConverterTest extends FunSuite {

  test("Basic good path test") {
    val converter =
      new SubstitutionConverter(Map(1 -> "one", 2 -> "two", 3 -> "three"))

    converter.convert(1) should equal("one")
    converter.convert(2) should equal("two")
    converter.convert(3) should equal("three")
  }

  test("Throws when asked to convert what he can not") {
    val converter =
      new SubstitutionConverter(Map(1 -> "one", 2 -> "two", 3 -> "three"))

    an[IllegalArgumentException] should be thrownBy converter.convert(4)
    an[IllegalArgumentException] should be thrownBy converter.convert(0)

  }

}
