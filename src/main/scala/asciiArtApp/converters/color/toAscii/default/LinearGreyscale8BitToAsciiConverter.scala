package asciiArtApp.converters.color.toAscii.default

import asciiArtApp.converters.color.toAscii.Greyscale8BitToAsciiConverter
import asciiArtApp.model.character.ascii.AsciiCharacter
import asciiArtApp.model.color.greyscale.Greyscale8BitColor
import converters.interval.LinearIntervalConverter

class LinearGreyscale8BitToAsciiConverter(chars: Seq[AsciiCharacter])
    extends Greyscale8BitToAsciiConverter {

  private val linearConverter: LinearIntervalConverter[AsciiCharacter] =
    new LinearIntervalConverter(chars, 0, 255)
  override def convert(what: Greyscale8BitColor): AsciiCharacter =
    linearConverter.convert(what.intensity)
}
