package asciiArtApp.model.image.grid.ascii

import asciiArtApp.model.character.TextCharacter
import asciiArtApp.model.image.grid.GridImage

/**
 * Represents image made out of characters
 * @tparam T Specific type of the image
 */
trait CharacterImage[T <: TextCharacter] extends GridImage[T]
