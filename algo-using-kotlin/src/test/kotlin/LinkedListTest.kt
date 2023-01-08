import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class Node (var next:Node?, var data:Int){

}



class LinkedListTest {


    @Test
    fun appendData_test(){

        val newDataPoint = Node(null,10)
        val myLinkedList = Node(Node(Node(null,8),4),2)

        var current = myLinkedList

        while (current.next!=null){
            current = current.next!!
        }

        current.next = newDataPoint

        assertTrue(current.next!!.data==10)

    }



}