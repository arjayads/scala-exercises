object Print2 {
  def main(args: Array[String]) {
    for {i <- 1 to 10
         j <- 1 to 10}
      println(i * j)
  }
}