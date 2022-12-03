package L12_Trees;
/*
Check if generic tree contain element x
Send Feedback
Given a generic tree and an integer x, check if x is present in the given tree or not. Return true if x is present, return false otherwise.
Input format :

Line 1 : Integer x

Line 2 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : true or false

Sample Input 1 :
40
10 3 20 30 40 2 40 50 0 0 0 0
Sample Output 1 :
true
Sample Input 2 :
4
10 3 20 30 40 2 40 50 0 0 0 0
Sample Output 2:
false
 */
public class a6_CheckIfTreeContainsElementX {
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
        if(root == null) return false;
        boolean ans = false;
        if(root.data == x){
            return true;
        }
        for(int i = 0 ;i<root.children.size();i++){
            ans = checkIfContainsX(root.children.get(i),x );
            if(ans) return true;
        }
        return ans;
    }
}
