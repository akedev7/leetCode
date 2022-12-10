package com.company.medium.removeNNodeFromEnd

private class LinkedListNode(val value: Int, var next: LinkedListNode? = null)

fun main() {
    val head = LinkedListNode(0, LinkedListNode(1,  LinkedListNode(2, LinkedListNode(3, LinkedListNode(4, LinkedListNode(5, LinkedListNode(6, LinkedListNode(7, LinkedListNode(8, LinkedListNode(9))))))))))
    head.printNode()
    head.removeNNodeFromEnd(4)
    head.printNode()

}

private fun LinkedListNode.printNode() {
    var currentNode: LinkedListNode? = this
    while (currentNode != null) {
        print("${currentNode.value},")
        currentNode = currentNode.next
    }
    println()
}

private fun LinkedListNode.removeNNodeFromEnd(numNodeToRemove: Int) {
    var firstPointer: LinkedListNode = this
    var secondPointer: LinkedListNode? = this
    repeat(numNodeToRemove + 1) {
        secondPointer = secondPointer?.next
    }

    while (secondPointer != null) {
        firstPointer = firstPointer.next!!
        secondPointer = secondPointer?.next
    }
    firstPointer.next = firstPointer.next?.next
}
