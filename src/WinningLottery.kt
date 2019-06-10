class WinningLottery {
    private val numbers: Set<LotteryNumber>
    private val bonus: LotteryNumber
    private val matchPrice = mapOf(3 to 5000, 4 to 5_0000, 5 to 150_0000, 6 to 20_0000_0000, 7 to 3000_0000)
    private val BONUS = 7

    init {
        numbers = getLotteryNumbers()
        bonus = getBonusNumber()
    }

    private fun getBonusNumber(): LotteryNumber {
        println("보너스 볼을 입력해주세요.")
        return LotteryNumber(num = readLine()!!.toInt())
    }

    private fun getLotteryNumbers(): Set<LotteryNumber> {
        println("지난 주 당첨 번호를 입력해주세요.")
        val numbers = readLine()!!
            .split(",")
            .map{ it.trim().toInt() }
            .map{ LotteryNumber(it) }
            .toSet()
        if (numbers.size != 6) {
            throw IllegalArgumentException()
        }
        return numbers
    }

     fun match(lotteries: ArrayList<Lottery>) {
        val matchResult: HashMap<Int, Int> = HashMap()
        lotteries.asSequence().forEach { lottery ->
            val idx = this.match(lottery)
            if (idx < 3) return@forEach
            val count = matchResult.getOrDefault(idx, 0)
            matchResult[idx] = count + 1
        }
        for (idx in 3..5)
            println(String.format("%d개 일치(%d원)- %d개", idx, matchPrice[idx], matchResult.getOrDefault(idx, 0)))
        println(String.format("5개 일치, 보너스 볼 일치(%d원)- %d개", matchPrice[BONUS], matchResult.getOrDefault(BONUS, 0)))
        println(String.format("%d개 일치(%d원)- %d개", 6, matchPrice[6], matchResult.getOrDefault(6, 0)))
    }

    private fun match(other: Lottery) :Int {
        var count = numbers.intersect(other.numbers).size
        if ( count == 5 && other.numbers.contains(bonus)) count = 7
        return count
    }
}