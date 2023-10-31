package foo {
  class Referenced {
    val field = 0
  }
}

package bar {
  class Referenced {
    val field = 0
  }
}

class Coupled {
  def use(): Unit = {
    val foo = new foo.Referenced
    println(foo.field)
    val bar = new bar.Referenced
    val boo = new foo.bar.num.TEST
    println(bar.field)
  }
}
