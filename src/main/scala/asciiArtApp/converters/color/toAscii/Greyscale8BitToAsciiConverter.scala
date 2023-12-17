package asciiArtApp.converters.color.toAscii

import asciiArtApp.model.character.ascii.AsciiCharacter
import asciiArtApp.model.color.greyscale.Greyscale8BitColor
import converters.specific.SubstitutionConverter

class Greyscale8BitToAsciiConverter(
  table: Map[Greyscale8BitColor, AsciiCharacter])
    extends SubstitutionConverter[Greyscale8BitColor, AsciiCharacter](table)
