package tree2;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class DisplayBinary extends JApplet {

    public DisplayBinary() {
	// Test means the Test class.
	add(new Test(new BinaryTree<Integer>()));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	JFrame jFrame = new JFrame("Tree GUI");
	jFrame.add(new DisplayBinary());
	jFrame.setSize(400, 400);
	jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
	jFrame.setLocationRelativeTo(null);
	jFrame.setVisible(true);
    }

}
