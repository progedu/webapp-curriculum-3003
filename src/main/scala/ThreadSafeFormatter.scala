import java.util.Date

object ThreadSafeFormatter {

  def format(date: Date) = new SimpleDateFormat(" yyyy年MM月dd日E曜日H時mm分").format(date)

}
