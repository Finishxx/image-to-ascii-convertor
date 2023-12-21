package asciiArtApp.console.dataSource

import asciiArtApp.console.dataSource.ImageExtension.ImageExtension

case class ImportFromFileAction(path: String, extension: ImageExtension)
    extends DataSourceAction
