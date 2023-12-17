package asciiArtApp.filters.image.grid.specific.rotate

import asciiArtApp.filters.image.grid.specific.GridToGridImageFilterAdapter
import filters.grid.rotate.RotateGridFilter

class RotateGridImageFilter[T](degrees: Int)
    extends GridToGridImageFilterAdapter[T](new RotateGridFilter(degrees))
