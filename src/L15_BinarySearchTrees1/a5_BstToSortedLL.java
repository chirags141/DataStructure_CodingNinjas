package L15_BinarySearchTrees1;
/*
Code: BST to Sorted LL
Send Feedback
Given a BST, convert it into a sorted linked list. You have to return the head of LL.
Input format:
The first and only line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output Format:
The first and only line of output prints the elements of sorted linked list.
Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1:
2 5 6 7 8 10
 */
class Pair<T,V>{
    T head;
    V tail;
}
class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    public LinkedListNode(T data)
    { this.data = data; }
}
public class a5_BstToSortedLL {
    public static Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> constructLinkedListHelper(BinaryTreeNode<Integer> root)
    {
        if(root == null){
            Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> output = new Pair<>();
            output.head = null;
            output.tail = null;
            return output;
        }

        if(root.left == null && root.right == null){
            Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> output = new Pair<>();
            LinkedListNode<Integer> newNode = new LinkedListNode<>(root.data);
            newNode.next = null;
            output.head = newNode;
            output.tail = newNode;
            return output;
        }

        Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> leftAns,rightAns;
        leftAns = constructLinkedListHelper(root.left);
        rightAns = constructLinkedListHelper(root.right);

        LinkedListNode<Integer> head,tail;
        LinkedListNode<Integer> newNode = new LinkedListNode<>(root.data);

        if(leftAns.head != null && leftAns.tail != null){
            leftAns.tail.next = newNode;
            head = leftAns.head;
        }else{
            head = newNode;
        }

        if(rightAns.head != null && rightAns.tail != null){
            newNode.next = rightAns.head;
            tail = rightAns.tail;
        }else{
            tail = newNode;
        }

        Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> ans = new Pair<>();
        ans.head = head;
        ans.tail = tail;

        return ans;

    }
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        return constructLinkedListHelper(root).head;
    }
}
