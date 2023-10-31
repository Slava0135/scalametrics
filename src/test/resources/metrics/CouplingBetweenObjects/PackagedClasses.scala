package foo {
  package bar {
    class Referenced {
      val field = 0
    }
  }
  class Referenced {
    val field = 0
  }
}

class Referenced

class Coupled {
  def use(): Unit = {
    val ref = new Referenced
    println(ref.field)
    val foo = new foo.Referenced
    println(foo.field)
    val bar = new foo.bar.Referenced
    println(bar.field)
  }
}
