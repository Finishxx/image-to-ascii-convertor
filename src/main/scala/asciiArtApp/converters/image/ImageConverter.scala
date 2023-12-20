package asciiArtApp.converters.image

import asciiArtApp.model.image.Image
import converters.Converter

/**
 * Converts Images to Images
 *
 * @tparam T Specific type of the Image we want to convert
 * @tparam V Specific type of the resulting image
 */
trait ImageConverter[T <: Image, V <: Image] extends Converter[T, V]
