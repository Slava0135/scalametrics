class InnerDef {
  def outer(): Unit = {
    def inner(): Unit = {
      println()
    }
  }
}