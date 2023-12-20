package asciiArtApp.model.character.ascii

import asciiArtApp.model.character.TextCharacter

/**
 * Represents original ASCII character i.e. byte with values ranging from 0 to 127
 * @param char Character being represented
 */
case class AsciiCharacter(char: Char) extends TextCharacter {
  require(
    char >= 0 && char <= 127,
    s"Please provide character with code in the ASCII range [0, 127]. Character provided: $char")
}
