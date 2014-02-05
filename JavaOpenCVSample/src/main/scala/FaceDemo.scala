import org.opencv.core.{Core, MatOfRect, Point, Scalar}
import org.opencv.highgui.Highgui
import org.opencv.objdetect.CascadeClassifier

/**
 * User: masinoa
 * Date: 2/3/14
 * Time: 4:23 PM
 * Copyright exit4b, LLC
 */
class FaceDemo {

  def run() = {
    println("running face demo")

    // Create a face detector from the cascade file in the resources directory.

    val faceDetector = new CascadeClassifier(getClass.getResource("/lbpcascade_frontalface.xml").getPath)
    val image = Highgui.imread(getClass.getResource("/lena.png").getPath)

    // Detect faces in the image.
    // MatOfRect is a special container class for Rect.
    val faceDetections = new MatOfRect();
    faceDetector.detectMultiScale(image, faceDetections);

    println("Detected %s faces".format(faceDetections.toArray.length))

    // Draw a bounding box around each face.
    faceDetections.toArray.foreach{rect =>
      Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0))
    }

    // Save the visualized detection.
    val filename = "faceDetection.png"
    println("Writing %s".format(filename))
    Highgui.imwrite(filename, image)
  }
}
