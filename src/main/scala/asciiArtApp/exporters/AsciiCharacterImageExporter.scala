package asciiArtApp.exporters

import asciiArtApp.converters.image.ascii.AsciiImageToTextConverter
import asciiArtApp.model.character.ascii.AsciiCharacter
import asciiArtApp.model.image.grid.GridImage
import exporters.Exporter

class AsciiCharacterImageExporter extends Exporter[GridImage[AsciiCharacter]] {

  private val asciiImageToTextConverter = new AsciiImageToTextConverter
  override def `export`(what: GridImage[AsciiCharacter]): Unit = asciiImageToTextConverter.convert(what)
}
