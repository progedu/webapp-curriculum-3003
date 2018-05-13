object MemoryVisibilityProblem2 extends App {
  var runner = new AsyncRunner2("Runner 0", () => true)

  for (i <- 1 to 10) {
    runner.asyncRun((name) => println(s"${name} is finished."))
    runner = new AsyncRunner2(s"Runner ${i}", runner.canNextStart)
  }

  runner.asyncRun((name) => println(s"${name} is finished. Totally finished."))
}

class AsyncRunner2(private[this] val name: String, private[this] val canStart: () => Boolean) {
  private[this] var _isFinished = false

  def asyncRun(f: String => Unit): Unit = {
    new Thread(() => {
      while (!canStart()) {
        Thread.`yield`()
      }
      f(name)
      isFinished = true
    }).start()
  }

  def canNextStart: () => Boolean = () => {
    this.isFinished
  }

  // getter
  private[this] def isFinished = _isFinished

  // setter
  private[this] def isFinished_= (newValue: Boolean) = synchronized {
    _isFinished = newValue
  }
}
