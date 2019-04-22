import java.text.SimpleDateFormat
import java.util.Date

object ThreadSafeFormatter {

  def format(date: Date) = {
    val dateFormat = new SimpleDateFormat("yyyy年MM月dd日E曜日H時mm分")
    dateFormat.format(date)
  }

}
