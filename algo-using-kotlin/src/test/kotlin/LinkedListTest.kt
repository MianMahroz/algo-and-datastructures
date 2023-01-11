import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
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



    @Test
    fun test_deleteNode(){

        val myLinkedList  =  Node(Node(Node(null,6),4),2)

        var current = myLinkedList
        while (current.next != null){

            if(current.next!!.data==4){
                current.next = current.next!!.next
            }
                current = current.next!!
        }

        assertTrue(myLinkedList.next?.data==6)

    }


    @Test
    fun reverseLinkedList(){

        var node = Node(Node(Node(null,6),4),2)

        var current:Node? = node
        var prev:Node? = null
        var next:Node? = null

        while (current != null){

            next = current.next
            current.next = prev // points to null on first iteration
            prev = current

            current = next // move pointer for next iteration
        }

        node = prev!!

        assertTrue(node.data == 6)
    }

    @Test
    fun test_removeDuplicates(){

        val node = Node(Node(Node(Node(null,6),2),4),2)

        val dataStore = mutableListOf<Int?>()

        var current:Node? = node

        // insert first element
        dataStore.add(node.data)

        // print node data
        while (current?.next!=null){

            if(!dataStore.contains(current.next?.data)){
                dataStore.add(current.next?.data)
            }else{
                current.next = current.next?.next
            }
            current = current.next
        }

        assertEquals(node.next?.next?.data,6)


    }

}