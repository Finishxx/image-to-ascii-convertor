package asciiArtApp.dataSource.image.generators

import asciiArtApp.model.image.Image
import dataSource.generators.Generator

trait ImageGenerator[T <: Image] extends Generator[T]
