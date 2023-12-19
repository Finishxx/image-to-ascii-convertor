package helpers

import asciiArtApp.model.character.ascii.AsciiCharacter

trait TestWithAsciiConversions {

  def standardConversionChars: Seq[AsciiCharacter] =
    Seq('.', ':', '-', '=', '+', '*', '#', '%', '@').map(AsciiCharacter)

  def paulBourkeChars: Seq[AsciiCharacter] =
    "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ".toCharArray
      .map(AsciiCharacter)

}
