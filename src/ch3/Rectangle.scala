package ch3



class  Rectangle(val width: Double, val height:Double) extends Shape {
  override def area: Double = width * height
}