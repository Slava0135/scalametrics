class Class {
  val a, b, c, d, e = 1
  var x, y, z = 2

  def one(): Unit = {
    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
  }

  def two(): Unit = {
    println(a)
    println(b)
    println(e)
  }

  def three(): Unit = {
    println(x)
    println(y)
    println(z)
  }
}