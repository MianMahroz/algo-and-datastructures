import org.junit.jupiter.api.DisplayName
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class StringAndArraysTest {


    @Test
    @DisplayName("Check if string contains all unique characters")
    fun test_is_unique(){

        val str = "Maahroz"

        val frequencyMap = mutableMapOf<Char,Int>()

        for (ch in str){

            if(frequencyMap.containsKey(ch)){
                frequencyMap[ch] = frequencyMap[ch]?: 1
            }else{
                frequencyMap[ch] = 1
            }

        }

        val totalFrequency = frequencyMap.values.sum()
        val uniqueCharSet = hashSetOf<Char>()
        uniqueCharSet.addAll(str.toList())

        assertEquals(uniqueCharSet.size,totalFrequency)

    }

    /**
     * permutation: process of changing the linear order of an ordered set
     */
    @Test
    fun test_isPermutation(){
        val str1 = "test"
        val str2 = "ttset"

        val str1FrequencyMap = hashMapOf<Char,Int?>()
        val str2FrequencyMap = hashMapOf<Char,Int?>()

        for (ch in str1){
            str1FrequencyMap[ch] = str1FrequencyMap[ch]?.plus(1)?:0
        }

        for (ch in str2){
            str2FrequencyMap[ch] = str2FrequencyMap[ch]?.plus(1)?:0
        }

        var match = true

        for ((ch,freq) in str1FrequencyMap){

            if(str2FrequencyMap[ch]!! < freq!!){
                match = false
                break
            }

        }

        assertTrue(match)





    }








}