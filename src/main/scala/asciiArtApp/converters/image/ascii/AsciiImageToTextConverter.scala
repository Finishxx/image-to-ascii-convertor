package asciiArtApp.converters.image.ascii

import asciiArtApp.model.character.ascii.AsciiCharacter
import asciiArtApp.model.image.grid.GridImage
import converters.Converter

/**
 * Converts AsciiImage to text
 */
class AsciiImageToTextConverter
    extends Converter[GridImage[AsciiCharacter], String] {

  /**
   * Converts an item
   *
   * @param what What is being converted
   * @return Result of conversion
   */
  override def convert(what: GridImage[AsciiCharacter]): String =
    what.toGrid
      .map(_.map(_.char).mkString("", "", "\n"))
      .foldLeft("")((acc, next) => acc + next)
}
