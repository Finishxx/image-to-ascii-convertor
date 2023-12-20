package asciiArtApp.converters.color.toRgb

import asciiArtApp.model.image.Image
import converters.Converter

import java.awt.image.BufferedImage

trait BufferedImageToImageConverter[V <: Image]
    extends Converter[BufferedImage, V]
