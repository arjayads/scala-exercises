package ch3

class Circle(val radius: Double) extends Shape {
  override def area: Double = math.Pi*radius*radius
}