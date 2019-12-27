import java.text.SimpleDateFormat
import java.util.Date

object ThreadSafeFormatter {

  def format(date: Date): String = {
    val dateFormat = new SimpleDateFormat("yyyy'年'MM'月'dd'日'E'曜日'H'時'mm'分'")
    dateFormat.format(date)
  }

}

object ThreadSafeFormatterMain extends App {
  for (i <- 1 to 100) {
    new Thread(() => println(ThreadSafeFormatter.format(new Date))).start()
  }
}