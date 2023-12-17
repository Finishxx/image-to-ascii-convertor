package exporters.text

import java.io.OutputStream

// Taken from example semester work by Martin Drozdík
class StreamTextExporter(outputStream: OutputStream) extends TextExporter {

  var closed: Boolean = false

  protected def exportToStream(text: String): Unit = {
    if (closed)
      throw new Exception("Stream is already closed!")

    outputStream.write(text.getBytes("UTF-8"))
    outputStream.flush()
  }

  def close(): Unit = {
    if (closed)
      return

    outputStream.close()
    closed = true
  }
  override def export(what: String): Unit = exportToStream(what)

}
