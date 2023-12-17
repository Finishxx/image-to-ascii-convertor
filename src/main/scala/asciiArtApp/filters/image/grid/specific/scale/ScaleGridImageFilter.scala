package asciiArtApp.filters.image.grid.specific.scale

import asciiArtApp.filters.image.grid.specific.GridToGridImageFilterAdapter
import filters.grid.scale.ScaleGridFilter

class ScaleGridImageFilter[T](factor: Double)
    extends GridToGridImageFilterAdapter[T](new ScaleGridFilter(factor))
