package asciiArtApp.filters.image.grid.specific.rotate

import asciiArtApp.filters.image.grid.specific.GridToGridImageFilterAdapter
import filters.grid.rotate.RotateGridFilter

class RotateGridImageFilter(degrees: Int)
    extends GridToGridImageFilterAdapter(new RotateGridFilter(degrees))
