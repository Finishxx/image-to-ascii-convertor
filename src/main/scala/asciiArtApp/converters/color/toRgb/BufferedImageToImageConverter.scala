package asciiArtApp.converters.color.toRgb

import asciiArtApp.model.image.Image
import converters.Converter

import java.awt.image.BufferedImage

/**
 * Converts BufferedImage to Image
 *
 * @tparam V Actual type of the Image
 */
trait BufferedImageToImageConverter[V <: Image]
    extends Converter[BufferedImage, V]
