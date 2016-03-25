trait Shape {
  def area: Double
}


object Shape {
  private class Circle(radius: Double) extends Shape {
    override val area = 3.14*radius*radius
  }

  private class Rectangle(h: Double, w: Double) extends Shape {
    override val area = h*w
  }

  def apply(h: Double, w: Double): Shape = new Rectangle(h, w)
  def apply(radius: Double): Shape = new Circle(radius)
}


object Main extends  App {
  val circle = Shape(1)
  println(circle.area)

  val rec = Shape(1,2)
  println(rec.area)
}