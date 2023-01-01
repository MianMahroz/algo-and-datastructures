import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class CommonAlgoTest {

    @Test
    fun test_find_first_And_second_max_number(){

        // find the first max number
        val randomIntegerArr = listOf(2,5,6,9,12,100)

        var maxNumber = Integer.MIN_VALUE
        for (no in randomIntegerArr){
            if(no > maxNumber){
                maxNumber = no
            }
        }


        // find the second max number
        var secondMaxNumber = Integer.MIN_VALUE
        for (no in randomIntegerArr){
            if(no > secondMaxNumber && no < maxNumber){
                secondMaxNumber = no
            }
        }

        assertEquals(12,secondMaxNumber)
        assertEquals(100,maxNumber)
    }



    @Test
    @DisplayName("test, find minimum operations required to convert w1 into w2")
    fun test_find_min_ops(){

        var w1 = "intention"
        val w2  = "execution"

        var count  = 0

        for (i in w1.indices){

            if(w1[i] != w2[i]){

                // check if that char is available in w1
                // if not insert new or get from w2
                if(w1.contains(w2[i])){
                    val missingChar =  w1[w1.indexOf(w2[i])]
                    w1 = w1.replaceRange(i,(i+1), missingChar.toString())
                    count ++
                }else {
                    w1 = w1.replaceRange(i,(i+1), w2[i].toString())
                    count++
                }
            }

            if((i+1)==w2.length){
                w1 = w1.removeRange(i+1,w1.length)
                count ++
            }
        }

        assertEquals(w2,w1)

    }


    @Test
    fun test_sort_integer_array(){

        val numberList = mutableListOf(4,1,2,3,5)

        for (i in numberList.indices){
            for (j in i until numberList.size){
                if(numberList[i] > numberList[j]){
                    val temp = numberList[i]
                    numberList[i] = numberList[j]
                    numberList[j] = temp
                }
            }
        }

        assertContentEquals(mutableListOf(1,2,3,4,5), numberList)

    }





}