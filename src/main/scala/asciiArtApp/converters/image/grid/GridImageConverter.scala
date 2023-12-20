package asciiArtApp.converters.image.grid

import asciiArtApp.converters.image.ImageConverter
import asciiArtApp.model.image.grid.GridImage

trait GridImageConverter[T, V]
    extends ImageConverter[GridImage[T], GridImage[V]] {}
