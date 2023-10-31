class Zero {
  val zero = 0
}

class One {
  val one = 1
  def use(): Unit = {
    val z = new Zero
    println(z.zero)
  }
}

class Two {
  def use(): Unit = {
    val z = new Zero
    println(z.zero)
    val o = new One
    println(o.one)
  }
}
