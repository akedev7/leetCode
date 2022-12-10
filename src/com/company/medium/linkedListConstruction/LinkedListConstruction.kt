package com.company.medium.linkedListConstruction

class LinkedListNode(val value: Int, var next: LinkedListNode? = null, var prev: LinkedListNode? = null)

fun main() {
    //Data preparation
    var head = LinkedListNode(1)
    val node2 = LinkedListNode(2)
    val node3 = LinkedListNode(3)
    val node4 = LinkedListNode(4)
    var tail = LinkedListNode(5)
    head.next = node2
    node2.next = node3
    node2.prev = head
    node3.next = node4
    node3.prev = node2
    node4.next = tail
    node4.prev = node3
    tail.prev = node4

    println(head.containNode(3))
    head = head.remove(3)
    head.printNodes()
    println(head.containNode(3))


    head = head.swapNodeBefore(4, 2)
    head.printNodes()
    head = head.swapNodeBefore(4, 1)
    head.printNodes()

    head.insertNewNodeAfter(9, 1)
    head.printNodes()
}

private fun LinkedListNode.insertNewNodeAfter(valueToInsert: Int, targetValue: Int) {
    val targetNode = this.findNode(targetValue) ?: error("Cannot find the node in the linked list")
    val newNode = LinkedListNode(valueToInsert)

    newNode.prev = targetNode
    newNode.next = targetNode.next
    targetNode.next!!.prev = newNode
    targetNode.next = newNode
}

//This method is to move an existing linked list node to before a node in the linked link
private fun LinkedListNode.swapNodeBefore(valueToSwap: Int, valueOfNodeToSwap: Int): LinkedListNode {
    val node = this.findNode(valueToSwap) ?: error("Cannot find the node to swap")
    val targetNode = this.findNode(valueOfNodeToSwap) ?: error("Cannot find the targetNode to insert before")
    this.remove(valueToSwap)
    return if (targetNode.prev == null) { // It's a head
        node.next = targetNode
        node.prev = null
        targetNode.prev = node
        node
    } else {
        node.next = targetNode
        node.prev = targetNode.prev
        targetNode.prev!!.next = node
        targetNode.prev = node
        this
    }
}

private fun LinkedListNode.printNodes() {
    var currentNode: LinkedListNode? = this
    while (currentNode != null) {
        print("${currentNode.value},")
        currentNode = currentNode.next
    }
    println()
}

private fun LinkedListNode.remove(value: Int): LinkedListNode {
    val nodeToRemove = this.findNode(value)
    var prevNode = nodeToRemove?.prev
    var nextNode = nodeToRemove?.next
    return if (prevNode == null) { // It's a head
        nextNode!!
    } else {
        prevNode.next = nextNode
        nextNode?.prev = prevNode
        this
    }
}

private fun LinkedListNode.containNode(searchNumber: Int): Boolean {
    var currentNode: LinkedListNode? = this
    while (currentNode != null) {
        if (currentNode.value == searchNumber) {
            return true
        }
        currentNode = currentNode.next
    }
    return false
}

private fun LinkedListNode.findNode(searchNumber: Int): LinkedListNode? {
    var currentNode: LinkedListNode? = this
    while (currentNode != null) {
        if (currentNode.value == searchNumber) {
            return currentNode
        }
        currentNode = currentNode.next
    }
    return null
}


