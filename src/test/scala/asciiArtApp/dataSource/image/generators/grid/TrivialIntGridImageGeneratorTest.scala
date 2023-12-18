package asciiArtApp.dataSource.image.generators.grid

import dataSource.generators.number.{IntGenerator, StandardLibraryIntGenerator}
import helpers.TestWithGridImage
import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be}

import scala.language.postfixOps

class TrivialIntGridImageGeneratorTest extends FunSuite with TestWithGridImage {

  test("Generated image is correct for different sizes") {
    testGridImageDimensions(
      new TrivialIntGridImageGenerator(
        100,
        100,
        new StandardLibraryIntGenerator()).provide())
    testGridImageDimensions(
      new TrivialIntGridImageGenerator(
        1,
        100,
        new StandardLibraryIntGenerator()).provide())
    testGridImageDimensions(
      new TrivialIntGridImageGenerator(
        100,
        1000,
        new StandardLibraryIntGenerator()).provide())
  }

  test("Throw on invalid dimensions") {
    def testThis(width: Int, height: Int) =
      an[IllegalArgumentException] should be thrownBy new TrivialIntGridImageGenerator(
        width,
        height,
        new StandardLibraryIntGenerator()
      )
    testThis(-1, 100)
    testThis(-1, -1)
    testThis(100, -1)
  }

  test("When generator generates only zeroes, the GridIMage is full of zeroes") {
    class FakeGenerator extends IntGenerator {
      override def provide(): Int = 0
    }
    val zeroedGridImage = new TrivialIntGridImageGenerator(
      100,
      100,
      new FakeGenerator()
    ).provide()

    all[Int](zeroedGridImage, x => 0 == 0)
  }
}
