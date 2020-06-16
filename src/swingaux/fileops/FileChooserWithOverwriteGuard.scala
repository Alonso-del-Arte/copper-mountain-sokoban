package swingaux.fileops

import javax.swing.JFileChooser
import javax.swing.JOptionPane

class FileChooserWithOverwriteGuard extends JFileChooser {

  override def approveSelection(): Unit = {
    val file = this.getSelectedFile
    if (file.exists()) {
      val confResp = JOptionPane.showConfirmDialog(this,
        "Do you want to overwrite the existing file?",
        s"${file.getName} already exists",
        JOptionPane.YES_NO_CANCEL_OPTION)
      confResp match {
        case JOptionPane.YES_OPTION => super.approveSelection()
        case JOptionPane.NO_OPTION => // No action
        case JOptionPane.CANCEL_OPTION | JOptionPane.CLOSED_OPTION =>
          super.cancelSelection()
      }
    } else super.approveSelection()

  }

}
