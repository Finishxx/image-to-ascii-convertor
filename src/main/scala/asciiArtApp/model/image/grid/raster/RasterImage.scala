package asciiArtApp.model.image.grid.raster

import asciiArtApp.model.color.Color
import asciiArtApp.model.image.grid.GridImage

/**
 * Represents image storing colors in a grid
 * @tparam T Type of elements stored in the image
 */
trait RasterImage[T <: Color] extends GridImage[T]
