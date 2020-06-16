package swingaux.fileops

import java.io.File

import org.junit.jupiter.api.Test

class SLCFileFilterTest {

  private val filter = new SLCFileFilter

  @Test def testAcceptDirectory(): Unit = {
    val homeDir = System.getProperty("user.home")
    val dir = new File(homeDir)
    val msg = s"SLCFileFilter should accept directory $homeDir"
    assert(filter.accept(dir), msg)
  }

  @Test def testAccept(): Unit = {
    println("accept")
    val tempDir = System.getProperty("java.io.tmpdir")
    val fileName = "Example.slc"
    val path = s"$tempDir$fileName"
    val file = new File(path)
    val msg = s"SLCFileFilter should accept file $path"
    assert(filter.accept(file), msg)
  }

  @Test def testRejectSOKFile(): Unit = {
    val tempDir = System.getProperty("java.io.tmpdir")
    val fileName = "Example.sok"
    val path = s"$tempDir$fileName"
    val file = new File(path)
    val msg = s"SLCFileFilter should reject file $path"
    assert(!filter.accept(file), msg)
  }

  @Test def testRejectJPEGFile(): Unit = {
    val homeDir = System.getProperty("user.home")
    val fileName = "picture.jpg"
    val path = s"$homeDir$fileName"
    val file = new File(path)
    val msg = s"SLCFileFilter should reject file $path"
    assert(!filter.accept(file), msg)
  }

  @Test def testRejectWordDocument(): Unit = {
    val homeDir = System.getProperty("user.home")
    val fileName = "essay.doc"
    val path = s"$homeDir$fileName"
    val file = new File(path)
    val msg = s"SLCFileFilter should reject file $path"
    assert(!filter.accept(file), msg)
  }

    @Test def testAcceptNotCaseSensitive(): Unit = {
    val tempDir = System.getProperty("java.io.tmpdir")
    val fileName = "Example.SLC"
    val path = s"$tempDir$fileName"
    val file = new File(path)
    val msg = s"SLCFileFilter should accept file $path"
    assert(filter.accept(file), msg)
  }

  @Test def testGetDescription(): Unit = {
    println("getDescription")
    val description = filter.getDescription.toLowerCase
    val msgA = "Filter description should contain \"Sokoban Level Collection\""
    assert(description.contains("sokoban level collection"), msgA)
    val msgB = "Filter description should contain \"slc\" or \"SLC\""
    assert(description.contains("slc"), msgB)
  }

}
