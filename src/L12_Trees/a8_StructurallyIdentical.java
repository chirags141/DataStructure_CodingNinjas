package L12_Trees;
/*
Structurally identical
Send Feedback
Given two Generic trees, return true if they are structurally identical i.e. they are made of nodes with the same values arranged in the same way.
Input format :

Line 1 : Tree 1 elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Line 2 : Tree 2 elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : true or false

Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0
10 3 20 30 40 2 40 50 0 0 0 0
Sample Output 1 :
true
Sample Input 2 :
10 3 20 30 40 2 40 50 0 0 0 0
10 3 2 30 40 2 40 50 0 0 0 0
Sample Output 2:
false
 */
public class a8_StructurallyIdentical {
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if( root1.data != root2.data){
            return false;
        }
        if(root1.children.size() != root2.children.size() ){
            return false;
        }
        for(int i = 0;i<root1.children.size();i++ ) {
            boolean ans = checkIdentical(root1.children.get(i), root2.children.get(i));
            if (!ans) return false;
        }
        return true;
    }
}
