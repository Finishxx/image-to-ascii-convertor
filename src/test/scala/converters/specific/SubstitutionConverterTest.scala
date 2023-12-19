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

  test(
    "Throw on trying to substitute for something, which is not in substitution table") {
    val converter =
      new SubstitutionConverter(Map(1 -> "one", 2 -> "two", 3 -> "three"))

    an[IllegalArgumentException] should be thrownBy converter.convert(4)
    an[IllegalArgumentException] should be thrownBy converter.convert(0)

  }

  test("Empty is OK, but it should throw on everything") {
    val converter = new SubstitutionConverter[Byte, Byte](Map())

    for (i <- Byte.MinValue to Byte.MaxValue)
      an[IllegalArgumentException] should be thrownBy converter.convert(
        i.toByte)
  }

  test("Substitute there and back") {
    def testThereAndBackSubstitution[K, V](thereMap: Map[K, V]): Unit = {
      val backMap = thereMap.toSeq.map(_.swap).toMap

      val thereConverter: SubstitutionConverter[K, V] =
        new SubstitutionConverter(thereMap)
      val backConverter: SubstitutionConverter[V, K] =
        new SubstitutionConverter(backMap)

      for ((k, _) <- thereMap)
        backConverter.convert(thereConverter.convert(k)) should equal(k)
    }

    testThereAndBackSubstitution(
      Map(1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four"))

    testThereAndBackSubstitution(
      Map(
        "hello" -> "world",
        "it is" -> "cloudy today",
        "feels like" -> "christmas"))

    testThereAndBackSubstitution(
      Seq.range(1, 100).map(int => (int, int.toString)).toMap)

    testThereAndBackSubstitution(
      Seq.range(1, 100, 2).map(int => (int, int)).toMap)
  }

}
