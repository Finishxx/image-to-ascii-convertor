package asciiArtApp.model.image.grid.ascii

import asciiArtApp.model.character.ascii.AsciiCharacter
import asciiArtApp.model.image.grid.GridImageAs2DSeq

/**
 * Image made out of ASCII characters stored in a grid
 * @param grid The grid containing the characters
 */
class AsciiCharacterImageAs2DSeq(grid: Seq[Seq[AsciiCharacter]])
    extends GridImageAs2DSeq[AsciiCharacter](grid)
    with AsciiCharacterImage
