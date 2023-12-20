package asciiArtApp.converters.image

import asciiArtApp.model.image.Image
import converters.Converter

trait ImageConverter[T <: Image, V <: Image] extends Converter[T, V]
