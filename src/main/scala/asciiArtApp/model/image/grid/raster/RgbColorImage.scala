package asciiArtApp.model.image.grid.raster

import asciiArtApp.model.color.rgb.RgbColor

/**
 * Represents image storing RgbColors in a grid
 *
 * @tparam T Actual type of RgbColors stored in the image
 */
trait RgbColorImage[T <: RgbColor] extends RasterImage[T]
