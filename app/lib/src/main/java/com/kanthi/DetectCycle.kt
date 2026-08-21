package com.kanthi

fun main() {
    // Manually build: 1 -> 2 -> 3 -> 4 -> (back to 2, creating a cycle)
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2   // <-- this creates the cycle, pointing back to node2

    println(hasCycle(node1))   // should print: true

    //Floyd's (slow/fast pointers) - Approach
    //Time	O(n)Fast pointer traverses the tail + at most one full cycle length before either hitting null (no cycle) or meeting slow (cycle exists) — both bounded by total node count
    //Space	O(1)Only two pointer variables used, regardless of list size — no extra structure that scales with input
}

fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head

    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) {
            return true
        }
    }

    return false
}

class ListNode(var value: Int) {
    var next: ListNode? = null
}

