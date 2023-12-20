package asciiArtApp.converters.color.toAscii

import asciiArtApp.model.character.ascii.AsciiCharacter
import asciiArtApp.model.color.greyscale.Greyscale8BitColor
import converters.Converter
import converters.specific.SubstitutionConverter

/**
 * Converts Greyscale8BitColors onto AsciiCharacters
 */
trait Greyscale8BitToAsciiConverter
    extends Converter[Greyscale8BitColor, AsciiCharacter]
