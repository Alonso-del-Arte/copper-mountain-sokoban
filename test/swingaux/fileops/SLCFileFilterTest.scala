package swingaux.fileops

import java.io.File

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class SLCFileFilterTest {

  val filter = new SLCFileFilter

  @Test def testAcceptDirectory(): Unit = {
    val homeDir = System.getProperty("user.home")
    val dir = new File(homeDir)
    val msg = s"SLCFileFilter should accept directory $homeDir"
    assert(filter.accept(dir), msg)
  }

}
