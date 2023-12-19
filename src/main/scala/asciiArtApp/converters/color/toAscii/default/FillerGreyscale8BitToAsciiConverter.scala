package asciiArtApp.converters.color.toAscii.default

import asciiArtApp.converters.color.toAscii.Greyscale8BitToAsciiConverter
import asciiArtApp.model.character.ascii.AsciiCharacter
import asciiArtApp.model.color.greyscale.Greyscale8BitColor
import converters.interval.{FillerIntervalConverter, LinearIntervalConverter}

// Last element of the chars is the filler
class FillerGreyscale8BitToAsciiConverter(chars: Seq[AsciiCharacter])
    extends Greyscale8BitToAsciiConverter {
  require(chars.length <= 256, "Please provide up to 256 values!")
  require(chars.nonEmpty, "Please provide at least one character!")

  private val fillerConverter: FillerIntervalConverter[AsciiCharacter] =
    new FillerIntervalConverter(chars.init, chars.last, 0, 255)
  override def convert(what: Greyscale8BitColor): AsciiCharacter =
    fillerConverter.convert(what.intensity)
}
