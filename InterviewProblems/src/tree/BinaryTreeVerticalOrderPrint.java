package tree;
/**
 * Given a binary tree, print it vertically. The following example illustrates vertical order traversal.

           1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9 
               
			  
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9 

 *
 */

/*
 * http://www.geeksforgeeks.org/print-binary-tree-vertical-order/
 * 
 * http://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/ an
 * efficient solution based on hash map is discussed. We need to check the
 * Horizontal Distances from root for all nodes. If two nodes have the same
 * Horizontal Distance (HD), then they are on same vertical line. The idea of HD
 * is simple. HD for root is 0, a right edge (edge connecting to right subtree)
 * is considered as +1 horizontal distance and a left edge is considered as -1
 * horizontal distance. For example, in the above tree, HD for Node 4 is at -2,
 * HD for Node 2 is -1, HD for 5 and 6 is 0 and HD for node 7 is +2.
 * 
 * We can do inorder traversal of the given Binary Tree. While traversing the
 * tree, we can recursively calculate HDs. We initially pass the horizontal
 * distance as 0 for root.
 * 
 */
public class BinaryTreeVerticalOrderPrint {

}
/*
//Utility function to store vertical order in map 'm'
//'hd' is horigontal distance of current node from root.
//'hd' is initally passed as 0
void getVerticalOrder(Node* root, int hd, map<int, vector<int>> &m)
{
 // Base case
 if (root == NULL)
     return;

 // Store current node in map 'm'
 m[hd].push_back(root->key);

 // Store nodes in left subtree
 getVerticalOrder(root->left, hd-1, m);

 // Store nodes in right subtree
 getVerticalOrder(root->right, hd+1, m);
}

//The main function to print vertical oder of a binary tree
//with given root
void printVerticalOrder(Node* root)
{
 // Create a map and store vertical oder in map using
 // function getVerticalOrder()
 map < int,vector<int> > m;
 int hd = 0;
 getVerticalOrder(root, hd,m);

 // Traverse the map and print nodes at every horigontal
 // distance (hd)
 map< int,vector<int> > :: iterator it;
 for (it=m.begin(); it!=m.end(); it++)
 {
     for (int i=0; i<it->second.size(); ++i)
         cout << it->second[i] << " ";
     cout << endl;
 }
}
*/