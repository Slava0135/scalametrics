class Referenced {
  val field = 0
}

class Coupled {
  def use(): Unit = {
    val o1 = new Referenced
    println(o1.field)
    val o2 = new Referenced
    println(o2.field)
  }
}
