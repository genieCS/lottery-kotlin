import java.lang.IllegalArgumentException

const val LOTTERY_PRICE = 1000
class LottoGame {
    private val lotteries: ArrayList<Lottery> = ArrayList()
    init {
        val count = toCount(getPurchaseAmount())
        println("%d개를 구매했습니다.".format(count))
        for (x in 0 until count) lotteries.add(Lottery())
        val winning = WinningLottery()
        winning.match(lotteries)
    }

    private fun getPurchaseAmount() : Int {
        println("구입금액을 입력해주세요.")
        val amount = readLine()
        return Integer.parseInt(amount)
    }

    private fun toCount(amount: Int): Int {
        if (amount < LOTTERY_PRICE) {
            throw IllegalArgumentException()
        }
        return amount / LOTTERY_PRICE
    }
}
