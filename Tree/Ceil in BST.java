class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        int temp=-1;
        while(root!=null){
            if(root.data==key){
                temp=root.data;
                return temp;
            }
            if(key>root.data){
                root=root.right;
            }
            else{
                temp=root.data;
                root=root.left;
            }
        }
        return temp;
    }
}
/*
Given a BST and a number X, find Ceil of X.
Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.

Example 1:

Input:
      5
    /   \
   1     7
    \
     2 
      \
       3
X = 3
Output: 3
Explanation: We find 3 in BST, so ceil
of 3 is 3.
Example 2:

Input:
     10
    /  \
   5    11
  / \ 
 4   7
      \
       8
X = 6
Output: 7
Explanation: We find 7 in BST, so ceil
of 6 is 7.
*/
