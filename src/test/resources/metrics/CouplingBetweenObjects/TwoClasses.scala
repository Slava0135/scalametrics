class Referenced {
  val field = 0
}

class Coupled {
  def use(): Unit = {
    val o = new Referenced
    println(o.field)
  }
}
