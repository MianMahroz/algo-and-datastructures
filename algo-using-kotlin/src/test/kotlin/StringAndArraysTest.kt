import org.junit.jupiter.api.DisplayName
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringAndArraysTest {


    @Test
    @DisplayName("Check if string contains all unique characters")
    fun test_is_unique(){

        val str = "Maahroz"
        var isUnique = true
        val frequencyMap = mutableMapOf<Char,Int>()

        for (ch in str){

            if(frequencyMap.containsKey(ch)){
                frequencyMap[ch] = frequencyMap[ch]?: 1
                isUnique = false
                break
            }else{
                frequencyMap[ch] = 1
            }
        }

        assertFalse(isUnique)

//        val totalFrequency = frequencyMap.values.sum()
//        val uniqueCharSet = hashSetOf<Char>()
//        uniqueCharSet.addAll(str.toList())
//        assertEquals(uniqueCharSet.size,totalFrequency)



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


    /**
     * Replace all spaces in a string with '%20'
     * and attach a count as well of how many spaces are there i.e 4 and 1 in given string
     */
    @Test
    fun test_urlify(){

        var str = "Mr    3ohn Smith"
        val expectedResult = "Mr4%203ohn1%20Smith"

        var count = 0
        for (ch in str.indices){
            if(str[ch].isWhitespace()){
                count++
            }else{
                if(count!=0){
                    str = str.replaceRange(ch-count,ch,"$count%20")
                    count = 0
                }
            }
        }

        assertEquals(expectedResult,str)

    }


    /**
     * Given two strings, write a function to check if they are one edit (or zero edits) away
     * you can perform these operations: insert a character,remove a character, or replace a character
     */
    @Test
    fun test_oneAway(){

        var actualStr = "pale"
        val expectedStr  = "pie"

        var count = 0

        for (i in 0 .. expectedStr.length.minus(1)){
            if(actualStr[i]!=expectedStr[i]){
                // if missing char is available in actual string
                if(actualStr.contains(expectedStr[i])){
                    val index = actualStr.indexOf(expectedStr[i])
                    actualStr = actualStr.replaceRange(i,i+1,actualStr[index].toString())
                    count++
                }else{
                    actualStr = actualStr.replaceRange(i,i+1,expectedStr[i].toString())
                    count++
                }
            }
        }

        // remove extra char`s
        if(actualStr.length > expectedStr.length){
            actualStr = actualStr.removeRange(expectedStr.length,actualStr.length)
            count++
        }

        assertEquals(expectedStr,actualStr)
        assertFalse(count<=1)

    }




}