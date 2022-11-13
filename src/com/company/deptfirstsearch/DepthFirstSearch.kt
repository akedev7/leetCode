package com.company.deptfirstsearch

class TreeNode<T>(val value: T, val children: MutableList<TreeNode<T>>? = null)

// How to tree look like
//                  A
//       B          C          D
//   E       F            G        H
//        I    J            K
//Expected result = ABEFIJCDGKH
fun main() {
    val tree = TreeNode("A ", mutableListOf(TreeNode("B", mutableListOf(TreeNode("E"), TreeNode("F", mutableListOf(TreeNode("I"), TreeNode("J"))))), TreeNode("C"), TreeNode("D", mutableListOf(TreeNode("G", mutableListOf(TreeNode("K"))), TreeNode("H")))))
    depthFirstSearch(tree)
}

fun <T> depthFirstSearch(treeNode: TreeNode<T>) {
    println(treeNode.value)
    treeNode.children?.forEach {
        depthFirstSearch(it)
    }
}