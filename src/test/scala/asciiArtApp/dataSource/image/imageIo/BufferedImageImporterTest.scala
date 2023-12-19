package asciiArtApp.dataSource.image.imageIo

import helpers.TestWithImages
import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be, noException}

import java.awt.image.BufferedImage
import java.io.File

class BufferedImageImporterTest extends FunSuite with TestWithImages {

  def printBufferedImageContents(bufferedImage: BufferedImage): Unit = {
    val intArray: Array[Int] = bufferedImage.getRGB(
      0,
      0,
      bufferedImage.getWidth,
      bufferedImage.getHeight,
      null,
      0,
      bufferedImage.getWidth)
    print(intArray.map(_.toOctalString).mkString("Array(", ", ", ")"))
  }

  def loadFile(fileName: String): Unit = {
    val importer = new BufferedImageImporter(new File(fileName))
    noException should be thrownBy importer.provide()
    // printBufferedImageContents(importer.provide())
  }

  test("Nonexistent file") {
    an[IllegalArgumentException] should be thrownBy new BufferedImageImporter(
      new File("asdasedgfgfddfdfjhgdfgdsfjgsdjlkghsdfhdfg"))
  }

  test("We can load gif") {
    loadFile(white4x4Gif)
  }

  test("We can load png") {
    loadFile(white4x4Png)
  }

  test("We can load jpg") {
    loadFile(white4x4Jpg)
  }

}
