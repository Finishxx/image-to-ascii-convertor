package asciiArtApp.converters.color.toAscii.default

import asciiArtApp.converters.color.toAscii.Greyscale8BitToAsciiConverter
import asciiArtApp.model.character.ascii.AsciiCharacter
import asciiArtApp.model.color.greyscale.Greyscale8BitColor
import converters.interval.{FillerIntervalConverter, LinearIntervalConverter}

/**
 * Maps the whole Greyscale8Bit value range onto given characters filling the gaps
 * with last character in characters
 *
 * First tries to map one greyscale value onto onto unique one character, if that is not possible
 * maps one-to-one greyscale values from 0 to characters.size - 2 with all but last character
 * in characters and maps rest of greyscale values to the last character.
 *
 * @param characters Characters which the Converter maps to
 */
class FillerGreyscale8BitToAsciiConverter(characters: Seq[AsciiCharacter])
    extends Greyscale8BitToAsciiConverter {
  require(characters.length <= 256, "Please provide up to 256 values!")
  require(characters.nonEmpty, "Please provide at least one character!")

  private val fillerConverter: FillerIntervalConverter[AsciiCharacter] =
    new FillerIntervalConverter(characters.init, characters.last, 0, 255)
  override def convert(what: Greyscale8BitColor): AsciiCharacter =
    fillerConverter.convert(what.intensity)
}
