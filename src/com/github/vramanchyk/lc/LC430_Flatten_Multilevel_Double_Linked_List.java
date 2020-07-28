package com.github.vramanchyk.lc;

/**
 * Created by Vitali Ramanchyk on 7/28/20.
 */
public class LC430_Flatten_Multilevel_Double_Linked_List {

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}
    }

    Node flattenTail(Node cur) {

        Node tail = null;

        while (cur != null) {

            Node next = cur.next;
            cur.prev = tail;

            if (tail != null) {
                tail.next = cur;
            }

            tail = cur;

            if (cur.child != null) {

                Node prevTail = tail;
                tail.next = cur.child;
                tail = flattenTail(cur.child);
                cur.child.prev = prevTail;
            }

            cur.child = null;

            cur = next;
        }

        return tail;
    }

    public Node flatten(Node head) {
        flattenTail(head);
        return head;
    }
}
