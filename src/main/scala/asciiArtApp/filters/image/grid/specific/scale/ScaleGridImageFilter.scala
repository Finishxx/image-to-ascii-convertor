package asciiArtApp.filters.image.grid.specific.scale

import asciiArtApp.filters.image.grid.specific.GridToGridImageFilterAdapter
import filters.grid.scale.ScaleGridFilter

class ScaleGridImageFilter(factor: Double)
    extends GridToGridImageFilterAdapter(new ScaleGridFilter(factor))
