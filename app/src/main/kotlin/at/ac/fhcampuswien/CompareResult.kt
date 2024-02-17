package at.ac.fhcampuswien
/**
 * This class is a data structure which helps with bundling the result
 *
 * Look at the toSting() and use it in your output
 *
 * @param m The number of digits guessed correctly (regardless of their position)
 * @param n The number of digits guessed correctly and in the correct position.
 * @constructor creates an instance of the class.
 * @see ld.main
 */
data class CompareResult(val m: Int, val n: Int){
    override fun toString(): String {
        return "Output: $m:$n"
    }
}
