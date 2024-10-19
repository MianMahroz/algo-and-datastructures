import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.ArrayList
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


    @Test
    fun test_find_second_max_number(){

        val numberList = mutableListOf(4,8,12,14,16,18)

        var max = Integer.MIN_VALUE
        var secondMax = Integer.MIN_VALUE

        for (num in numberList){

            if(num > max ){
                secondMax = max
                max = num
            }else if(num != max && num > secondMax){
                secondMax = num
            }
        }

        assertEquals(16,secondMax)
    }


    @Test
    fun test_reverse_list(){
        var numberList = arrayOf(1,2,3,4,5,6)

        var start =0
        var end = numberList.size-1


        while (start < end){

            val temp = numberList[start]
            numberList[start] = numberList[end]
            numberList[end] = temp

            start++
            end--
        }

        numberList.forEach {it-> println(it) }

    }


    @Test
    fun find_second_min_number(){

        var numArr = arrayOf(2,4,6,8)

        var min = Integer.MAX_VALUE
        var secondMin = Integer.MAX_VALUE

        for (i in numArr.indices){

            if(numArr[i] < min ){
                secondMin = min
                min = numArr[i]
            }else if(numArr[i] < secondMin && numArr[i]!=min){
                secondMin = numArr[i]
            }
        }

        assertEquals(4,secondMin)



    }


    @Test
    fun test_find_second_min_using_for_loop(){

        var numberArr = arrayOf(1,2,3,4,5,6)

        var min = Integer.MAX_VALUE

        for(i in numberArr.indices){
            if(numberArr[i] < min){
                min = numberArr[i]
            }
        }


        var secondMin = Integer.MAX_VALUE

        for(i in numberArr.indices){
            if(numberArr[i] < secondMin && numberArr[i]!=min){
                secondMin = numberArr[i]
            }
        }

        assertEquals(1,min);
        assertEquals(2,secondMin);

    }


    @Test
    fun test_reserve_string(){

        var str =  "mahroz".toCharArray()

        var startInd = 0
        var endInd = str.size-1

        while(startInd < endInd){

            val temp = str[startInd]
            str[startInd] = str[endInd]
            str[endInd] = temp


            startInd ++
            endInd--
        }

        str.forEach { it->println(it) }





    }

    /**
     * Use two pointer technique one should represent zero elements and other should represent non-zero
     * swap if one element is zero and other is non-zero
     * increment zero pointer if the current number is non-zero.
     */
    @Test
    fun test_move_all_zeros_to_the_end_of_array(){
        val numberList = arrayOf(0,1,0,4,12)

        var j = 0   // j represent zero elements

        // i represent non zero elements
        for (i in numberList.indices) {

            if (numberList[i] != 0 && numberList[j] == 0) {
                val temp = numberList[i];
                numberList[i] = numberList[j]
                numberList[j] = numberList[i]
            }

            if (numberList[j] != 0) {
                j++
            }
        }
        numberList.forEach { it-> println(it) }
    }


    /**
     * This method does not qualify for O(n) time complexity. It take O(n2)
     */
    @Test
    fun test_find_missing_number_from_given_arr(){

        val numberList = arrayOf(2,4,1,8,6,3,7)

        // find min number
        var min = Integer.MAX_VALUE
        for(i in numberList.indices){
            if(numberList[i]< min){
                min = numberList[i]
            }
        }

        // find max number
        var max = Integer.MIN_VALUE
        for (i in numberList.indices){
            if(numberList[i] > max){
                max = numberList[i]
            }
        }

        // sort number list
        var j=1
        for (i in numberList.indices){
            for(j in i+1 until numberList.size){
                if(numberList[i]>numberList[j]){
                    val temp = numberList[i]
                    numberList[i] = numberList[j]
                    numberList[j]  = temp
                }
            }
        }
        numberList.forEach { it->println(it) }

        //finding missing number
      var missingNumber = 0
        for (i in min-1 until max-1){
            if(numberList[i]!=i+1){
                missingNumber  = i+1
                break
            }
        }

        assertEquals(5,missingNumber)
        assertEquals(8,max)
        assertEquals(1,min)

    }

    @Test
    fun test_find_missing_number_from_given_arr_optimized() {

        val numberList = arrayOf(2, 4, 1, 8, 6, 3, 7)

        val num = numberList.size+1 // assuming that numbers are natural
        // calculating sum using formula n(n+1)/2
        var sum = num*(num+1)/2
        println(sum)

        var missingNumber = 0
        // now subtracting all available numbers from the sum to find the missing number
        for(i in numberList){
            sum = sum-i
            missingNumber=sum
        }
        assertEquals(5,missingNumber)

    }















    }