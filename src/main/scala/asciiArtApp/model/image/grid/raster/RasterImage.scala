package asciiArtApp.model.image.grid.raster

import asciiArtApp.model.color.Color
import asciiArtApp.model.image.grid.GridImage

trait RasterImage[T <: Color] extends GridImage[T]
