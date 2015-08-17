package linkedin;

/**
 * http://articles.leetcode.com/2010/09/serializationdeserialization-of-binary.
 * html
 *
 */

/*
 * 1) pre-order traversal
 * 
 * 2)we would need to output the NULL nodes using some kind of sentinel (Here,
 * we use ‘#‘ as the sentinel);
 * 
 * Other method: level order traversal
 */
public class EncodeDecodeBinaryTrees {
/*
 * void writeBinaryTree(BinaryTree *p, ostream &out) {
  if (!p) {
    out << "# ";
  } else {
    out << p->data << " ";
    writeBinaryTree(p->left, out);
    writeBinaryTree(p->right, out);
  }
}


	
void readBinaryTree(BinaryTree *&p, ifstream &fin) {
  int token;
  bool isNumber;
  if (!readNextToken(token, fin, isNumber)) 
    return;
  if (isNumber) {
    p = new BinaryTree(token);
    readBinaryTree(p->left, fin);
    readBinaryTree(p->right, fin);
  }
}
 */
}
