package swingaux.fileops

import java.io.File
import javax.swing.filechooser.FileFilter

class SLCFileFilter extends FileFilter {

  override def accept(file: File): Boolean = {
    file.isDirectory || file.getName.toLowerCase.endsWith(".slc")
  }

  override def getDescription: String = "Sokoban Level Collection (*.slc)"

}
