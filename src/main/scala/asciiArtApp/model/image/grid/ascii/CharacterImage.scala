package asciiArtApp.model.image.grid.ascii

import asciiArtApp.model.character.TextCharacter
import asciiArtApp.model.image.grid.GridImage

trait CharacterImage[T <: TextCharacter] extends GridImage[T]
