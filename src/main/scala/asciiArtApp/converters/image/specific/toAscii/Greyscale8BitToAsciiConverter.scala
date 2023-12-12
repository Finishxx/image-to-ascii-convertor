package asciiArtApp.converters.image.specific.toAscii

import asciiArtApp.model.character.ascii.AsciiCharacter
import asciiArtApp.model.color.greyscale.Greyscale8BitColor
import converters.specific.SubstitutionConverter

class Greyscale8BitToAsciiConverter(
  table: Map[AsciiCharacter, Greyscale8BitColor])
    extends SubstitutionConverter[AsciiCharacter, Greyscale8BitColor](table)
