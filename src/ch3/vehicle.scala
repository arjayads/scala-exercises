trait flying {
  def fly() = println("flying")
}

trait gliding {
  def glide() = println("gliding")
}

class Vehicle (speed: Int) {
  val mph: Int = speed
  def race() = println("Racing")
}

class Car(speed: Int) extends Vehicle(speed) {
  override val mph: Int = speed
  override def race() = println("Racing Car")
}

class Bike(speed: Int) extends Vehicle(speed) {
  override val mph: Int = speed
  override def race() = println("Racing Bike")
}

class Batmobile(speed: Int) extends Vehicle(speed) with flying with gliding {
  override val mph: Int = speed
  override def race() = println("Racing Batmobile");
  override def fly() = println("Flying Batmobile")
  override def glide() = println("Gliding Batmobile")
}