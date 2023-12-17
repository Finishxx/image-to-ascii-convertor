package exporters.text

import java.io.{File, FileOutputStream}

// Taken from example semester work by Martin Drozdík
class FileOutputExporter(file: File)
    extends StreamTextExporter(new FileOutputStream(file))
