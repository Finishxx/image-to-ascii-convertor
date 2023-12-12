package asciiArtApp.converters.color.toAscii

import asciiArtApp.model.character.TextCharacter
import asciiArtApp.model.color.greyscale.GreyscaleColor
import converters.specific.SubstitutionConverter

abstract class GreyscaleToCharacterConverter[T](
  substitution: Map[T, TextCharacter])
    extends SubstitutionConverter[GreyscaleColor[T], TextCharacter](
      substitution) {}
