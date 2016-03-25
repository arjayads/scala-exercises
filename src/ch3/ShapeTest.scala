import ch3.{Rectangle, Circle, Shape}

object ShapeTest {
  def draw(s: Shape) = {
    s.area
  }

  def main(args: Array[String]) {
    var circle = draw(new Circle(3))
    var rec = draw(new Rectangle(2,3))

    println(circle)
    println(rec)
  }
}