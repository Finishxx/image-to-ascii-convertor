package converters.specific

import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be, convertToAnyShouldWrapper, equal}

class ChainedConverterTest extends FunSuite {

  test("Substitute there and back should be identity") {
    def testThereAndBackSubstitution[K, V](thereMap: Map[K, V]): Unit = {
      val backMap = thereMap.toSeq.map(_.swap).toMap

      val thereConverter: SubstitutionConverter[K, V] =
        new SubstitutionConverter(thereMap)
      val backConverter: SubstitutionConverter[V, K] =
        new SubstitutionConverter(backMap)

      val chainedConverter = new ChainedConverter(thereConverter, backConverter)

      for ((k, _) <- thereMap)
        chainedConverter.convert(k) should equal(k)
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
