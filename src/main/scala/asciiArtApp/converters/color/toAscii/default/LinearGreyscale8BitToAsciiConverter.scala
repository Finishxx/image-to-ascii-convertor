package asciiArtApp.converters.color.toAscii.default

import asciiArtApp.converters.color.toAscii.Greyscale8BitToAsciiConverter
import asciiArtApp.model.character.ascii.AsciiCharacter
import asciiArtApp.model.color.greyscale.Greyscale8BitColor
import converters.interval.LinearIntervalConverter

/**
 * Maps the whole Greyscale8Bit value range onto given characters arguably as equally as possible
 *
 * If characters can't be mapped truly equally, meaning we can not map equal number
 * of greyscale values to each individual character, maps more greyscale values
 * onto first character and divides the rest equally.
 *
 * @param characters Characters which the Converter maps to
 */
class LinearGreyscale8BitToAsciiConverter(characters: Seq[AsciiCharacter])
    extends Greyscale8BitToAsciiConverter {

  private val linearConverter: LinearIntervalConverter[AsciiCharacter] =
    new LinearIntervalConverter(characters, 0, 255)
  override def convert(what: Greyscale8BitColor): AsciiCharacter =
    linearConverter.convert(what.intensity)
}
