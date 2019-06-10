import kotlin.random.Random

data class LotteryNumber(val num: Int = Random.nextInt(45) + 1) {
    init {
        if (num < 1 || num > 45) {
            throw IllegalArgumentException()
        }
    }

    override fun toString(): String {
        return num.toString()
    }
}