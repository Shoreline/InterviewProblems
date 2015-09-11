package tree;

/**
 * Given a binary tree, find the lowest common ancestor of two given nodes in
 * the tree. Each node contains a parent pointer which links to its parent.
 *
 */

/*
 * Same as finding the joint of two linked list
 */
public class LowestCommonAncestorWithParentPointer {
    /*
     * An easy solution: As we trace the two paths from both nodes up to the
     * root, eventually it will merge into one single path. The LCA is the exact
     * first intersection node where both paths merged into a single path. An
     * easy solution is to use a hash table which records visited nodes as we
     * trace both paths up to the root. Once we reached the first node which is
     * already marked as visited, we immediately return that node as the LCA.
     * 
     * The run time complexity of this approach is O(h), where h is the tree’s
     * height. The space complexity is also O(h), since it can mark at most 2h
     * nodes
     */

    /*
     * The best solution: A little creativity is needed here. Since we have the
     * parent pointer, we could easily get the distance (height) of both nodes
     * from the root. Once we knew both heights, we could subtract from one
     * another and get the height’s difference (dh). If you observe carefully
     * from the previous solution, the node which is closer to the root is
     * always dh steps ahead of the deeper node
     */
}
