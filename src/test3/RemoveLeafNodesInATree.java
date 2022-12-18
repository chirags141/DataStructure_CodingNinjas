package test3;

import java.util.ArrayList;

/*
Remove leaf nodes in Tree
Send Feedback
Remove all leaf nodes from a given generic Tree. Leaf nodes are those nodes, which don't have any children.
Note : Root will also be a leaf node if it doesn't have any child. You don't need to print the tree, just remove all leaf nodes and return the updated root.
Input format :
Line 1 : Elements in level order form separated by space (as per done in class). Order is - `

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element `
Output Format :
Elements are printed level wise, each level in new line (separated by space)
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0
Sample Output 1 : (Level wise, each level in new line)
10
20
 */
class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children;

    TreeNode(T data){
        this.data = data;
        children = new ArrayList<TreeNode<T>>();
    }
}
public class RemoveLeafNodesInATree {

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
        if(root.children.size() == 0){
            return null;
        }

        for(int i = 0;i<root.children.size();i++){
            TreeNode<Integer> smallAns = removeLeafNodes(root.children.get(i));
            if(smallAns == null){
                root.children.remove(root.children.get(i));
                i--;  //Removal of a element move next element to previous index
            }
        }
        return root;
    }


}
/*
// PepCoding
public static Node removeLeafNodes1(Node root) {
    if(root.children.size() == 0){
        return null;
    }

    for(int i = 0;i<root.children.size();i++){
        Node smallAns = removeLeafNodes1(root.children.get(i));
        if(smallAns == null){
            root.children.remove(root.children.get(i));
            i--;
        }
    }
    return root;
}

    public static void removeLeaves(Node root){
        removeLeafNodes1(root);
    }
 */