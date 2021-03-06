import java.util.Date

import ch3._

object ShapeTest {
  def draw(s: Shape) = {
    s.area
  }

  def nano() = {
    println("Getting nano")
    System.nanoTime()
  }

  def delayed(t: => Long) = {
    println("Indelayed method")
    println("Param:"+t)
    t
  }

  def main(args: Array[String]) {
    delayed(nano())

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