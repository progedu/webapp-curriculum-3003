import java.text.SimpleDateFormat
import java.util.Date

object ThreadSafeFormatter {
  def format(date: Date) = {
    val formatter = new SimpleDateFormat("yyyy'年'MM'月'dd'日'E'曜日'H'時'mm'分'")
    formatter.format(date)
  }
}