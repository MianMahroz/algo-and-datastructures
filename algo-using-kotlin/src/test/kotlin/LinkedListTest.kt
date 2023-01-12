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

    /**
     * we have defined k such that passing in k = 1 would return the last element, k
     * = 2 would return to the second to last element, and so on. It is equally acceptable to define k such that k
     * = 0 would return the lastelement
     */
    @Test
    fun test_find_kth_toTheLastElement(){

        val node  = Node(Node(Node(null,6),4),2)
        val dataStore = mutableListOf<Int>()
        val k = 3

        var current:Node? = node
        var i = 0

        while (current?.next != null){
                dataStore.add(current.data)
                current = current.next!!
                i++

            // for last node
            if(current.next==null){
                dataStore.add(current.data)
                i++
            }
        }


        assertEquals(2,dataStore[i-k])
    }


    @Test
    fun test_delete_middle_node(){
        val node  = Node(Node(Node(null,6),4),2)

        var slowPtr: Node? = node
        var fastPtr: Node? = node
        var prev:Node? = null

        while(fastPtr?.next != null){
            prev = slowPtr
            slowPtr = slowPtr?.next
            fastPtr = fastPtr.next?.next
        }

        prev?.next = slowPtr?.next

        assertEquals(6,prev?.next?.data)

    }



}