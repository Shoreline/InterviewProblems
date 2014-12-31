package tree2;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test extends JPanel {
    BinaryTree<Integer> root = new BinaryTree<Integer>();
    TreeView treeView = new TreeView();
    private JTextField jtField = new JTextField(5);
    private JButton jbtInsert = new JButton("Insert");
    private JButton jbtDelete = new JButton("Delete");

    public Test(BinaryTree<Integer> root) {
	this.root = root;
	setUI();

    }

    private void setUI() {
	// TODO Auto-generated method stub
	this.setLayout(new BorderLayout());
	add(treeView, BorderLayout.CENTER);
	JPanel panel = new JPanel();
	// this.setVisible(true);
	panel.add(new JLabel("Enter a key :"));
	panel.add(jtField);
	panel.add(jbtInsert);
	panel.add(jbtDelete);
	add(panel, BorderLayout.SOUTH);
	jbtInsert.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int key = Integer.parseInt(jtField.getText());
		if (root.search(key)) {
		    JOptionPane.showMessageDialog(null, key
			    + "is already in the tree");
		} else {
		    root.insert(key);
		    treeView.repaint();
		}
	    }
	});
	jbtDelete.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int key = Integer.parseInt(jtField.getText());
		if (root.search(key)) {
		    root.delete(key);
		    treeView.repaint();
		} else {
		    JOptionPane.showMessageDialog(null, key
			    + "is not in the tree");
		}
	    }
	});

    }

    class TreeView extends JPanel {
	private int radius = 20;
	private int vGap = 50;

	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    if (root.getRoot() != null) {
		diaplay(g, root.getRoot(), getWidth() / 2, 30, getWidth() / 4);
	    }
	}

	private void diaplay(Graphics g, TreeNode root, int x, int y, int hGap) {
	    // TODO Auto-generated method stub
	    g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
	    g.drawString(root.element + "", x - 6, y + 4);
	    if (root.left != null) {
		connectLeftChild(g, x - hGap, y + vGap, x, y);
		diaplay(g, root.left, x - hGap, y + vGap, hGap / 2);
	    }
	    if (root.right != null) {
		connectRightChild(g, x + hGap, y + vGap, x, y);
		diaplay(g, root.right, x + hGap, y + vGap, hGap / 2);
	    }
	}

	private void connectRightChild(Graphics g, int x1, int y1, int x2,
		int y2) {
	    // TODO Auto-generated method stub
	    double d = Math.sqrt(vGap * vGap + (x2 - x1) * (x2 - x1));
	    int x11 = (int) (x1 - radius * (x1 - x2) / d);
	    int y11 = (int) (y1 - radius * vGap / d);
	    int x21 = (int) (x2 + radius * (x1 - x2) / d);
	    int y21 = (int) (y2 + radius * vGap / d);
	    g.drawLine(x11, y11, x21, y21);
	}

	private void connectLeftChild(Graphics g, int x1, int y1, int x2, int y2) {
	    // TODO Auto-generated method stub
	    double d = Math.sqrt(vGap * vGap + (x2 - x1) * (x2 - x1));
	    int x11 = (int) (x1 + radius * (x2 - x1) / d);
	    int y11 = (int) (y1 - radius * vGap / d);
	    int x21 = (int) (x2 - radius * (x2 - x1) / d);
	    int y21 = (int) (y2 + radius * vGap / d);
	    g.drawLine(x11, y11, x21, y21);
	}
    }

}