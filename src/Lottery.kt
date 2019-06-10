class Lottery {
    val numbers: MutableCollection<LotteryNumber> = HashSet()

    init {
        generateRandomNumbers()
        printNumbers()
    }

    private fun printNumbers() {
        println(numbers)
    }

    private fun generateRandomNumbers() {
        while (numbers.size != 6) {
            numbers.add(LotteryNumber())
        }
    }
}
