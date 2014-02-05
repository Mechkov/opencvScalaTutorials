import org.opencv.core.Core

/**
 * User: masinoa
 * Date: 1/26/14
 * Time: 5:32 PM
 * Copyright exit4b, LLC
 */

object HelloOpenCV {

  def main(args: Array[String]) = {
    println("Hello,OpenCV!")

    // Load the native library.
    //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    System.load("/home/vagrant/opencv/opencv-2.4.8/build/lib/libopencv_java248.so")
    val fd = new FaceDemo
    fd.run()

    println("All done.")
  }




}
