package ch3

import java.util.Date

/**
 * Created by TSI Admin on 3/25/2016.
 */
abstract class Base {
  def thing: String
}

class One extends Base {
  def thing = "Moof"
}

class Two extends One {
  override  val thing = (new Date()).toString
}

class Three extends One {
  override lazy val thing = super.thing + (new Date()).toString
}