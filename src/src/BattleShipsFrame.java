package src;
import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class BattleShipsFrame extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JTable table1;
	private JButton jButton1;
	private JButton jButton4;
	private JButton jButton3;
	private JButton jButton2;
	private JLabel jLabel1;
	private JComboBox jComboBox1;
	private JLabel player1;
	private JLabel Player2;
	private ButtonGroup buttonGroup2;
	private ButtonGroup buttonGroup1;
	private JButton jButton5;
	private JTable table2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BattleShipsFrame inst = new BattleShipsFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BattleShipsFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			TableLayout thisLayout = new TableLayout(new double[][] {{43.0, 38.0, 126.0, 97.0, 34.0, 52.0, 31.0, 117.0, 117.0, 59.0, 50.0, 93.0}, {32.0, 24.0, 19.0, 22.0, 278.0, 38.0, TableLayout.FILL}});
			thisLayout.setHGap(5);
			thisLayout.setVGap(5);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				BattleShipTableModel model1 = new BattleShipTableModel(size);
				table1 = new JTable();
				table1.setRowSelectionAllowed(false);
				table1.setDefaultRenderer(Color.class, new BattleShipTableRenderer());
				getContentPane().add(table1, "1, 4, 4, 4, f, c");
				table1.setModel(model1);
				table1.setRowHeight(25);
			}
			{
				BattleShipTableModel model2 = new BattleShipTableModel(size);
				table2 = new JTable();
				table2.setRowSelectionAllowed(false);
				table2.setDefaultRenderer(Color.class, new BattleShipTableRenderer());
				getContentPane().add(table2, "6, 4, 9, 4, c, c");
				table2.setModel(model2);
				table2.setRowHeight(25);
			}
			{
				Player2 = new JLabel();
				getContentPane().add(Player2, "7, 3, 9, 3, c, c");
				Player2.setText("Player2");
			}
			{
				player1 = new JLabel();
				getContentPane().add(player1, "1, 3, 3, 3, c, c");
				player1.setText("Player1");
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "10", "12","14" });
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1, "9, 2, f, c");
				jComboBox1.setModel(jComboBox1Model);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1, "8, 2, r, c");
				jLabel1.setText("Size: ");
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1, "2, 5");
				jButton1.setText("aircraft carrier");
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2, "3, 5");
				jButton2.setText("battleship");
			}
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3, "4, 5, 6, 5");
				jButton3.setText("destroyer");
			}
			{
				jButton4 = new JButton();
				getContentPane().add(jButton4, "7, 5");
				jButton4.setText("submarine");
			}
			{
				jButton5 = new JButton();
				getContentPane().add(jButton5, "8, 5");
				jButton5.setText("patrol boat");
			}
			pack();
			this.setSize(817, 587);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	

	private int size=10;
	
	private final static int DEFAULT_WIDTH = 600;
	private final static int DEFAULT_HEIGHT = 300;
}
