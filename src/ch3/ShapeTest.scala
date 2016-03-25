import java.util.Date

import ch3._

object ShapeTest {
  def draw(s: Shape) = {
    s.area
  }

  def main(args: Array[String]) {
    var circle = draw(new Circle(3))
    var rec = draw(new Rectangle(2,3))

    println(circle)
    println(rec)

    var three = new Three();
    println(three.thing)

    val x3:String = {
      val d = new Date()
      d.toString
    }

    println(x3)
  }
}