package asciiArtApp.model.character.ascii

import asciiArtApp.model.character.TextCharacter

case class AsciiChar(char: Char) extends TextCharacter {
  require(
    char >= 0 && char <= 127,
    s"Please provide character with code in the ASCII range [0, 127]. Character provided: $char")
}
