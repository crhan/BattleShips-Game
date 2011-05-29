package src;

import info.clearthought.layout.TableLayout;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class BattleShipsFrame extends javax.swing.JFrame {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception e) {
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
	private JButton jButton5;
	private JTable table2;

	public BattleShipsFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			TableLayout thisLayout = new TableLayout(new double[][] {
					{ 43.0, 38.0, 126.0, 97.0, 34.0, 52.0, 31.0, 117.0, 119.0,
							63.0, 50.0, 93.0 },
					{ 32.0, 24.0, 19.0, 22.0, 278.0, 38.0, TableLayout.FILL } });
			thisLayout.setHGap(5);
			thisLayout.setVGap(5);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				model1 = new BattleShipTableModel(size);
				model1.setAnotherPlayer(model2);
				table1 = new JTable();
				table1.setRowSelectionAllowed(false);
				table1.setDefaultRenderer(Color.class,
						new BattleShipTableRenderer());
				getContentPane().add(table1, "1, 4, 4, 4, f, c");
				table1.setModel(model1);
				table1.setRowHeight(25);
//				table1.getModel().addTableModelListener(new TableModelListener() {
//					
//					@Override
//					public void tableChanged(TableModelEvent e) {
//						// TODO Auto-generated method stub
//						int row = e.getFirstRow();
//				        int column = e.getColumn();
//				        TableModel model = (TableModel)e.getSource();
//				        String columnName = model.getColumnName(column);
//				        GridLocation data = (GridLocation) model.getValueAt(row, column);
//				        
//					}
//				});
			}
			
			class BattleShipTableMouseAdapter extends MouseAdapter{
				public void mouseClicked(MouseEvent event) {
					JTable table =  (JTable)event.getSource();
					// check for mouse click, just an example
					int col = table.columnAtPoint(event.getPoint());
					 //TODO should be modified for your own code
					int row = table.rowAtPoint(event.getPoint());
					System.out.println("col:" + col + ", row:" + row);
					BattleShipTableModel model = (BattleShipTableModel) table.getModel();
					model.click(model, model.getGridLocate(row, col));
				}
			}
			
			{
				model2 = new BattleShipTableModel(size);
				model2.setAnotherPlayer(model1);
				table2 = new JTable();
				table2.setRowSelectionAllowed(false);
				table2.setDefaultRenderer(Color.class,
						new BattleShipTableRenderer());
				getContentPane().add(table2, "6, 4, 9, 4, c, c");
				table2.setModel(model2);
				table2.setRowHeight(25);
				table1.addMouseListener(new BattleShipTableMouseAdapter());
				table2.addMouseListener(new BattleShipTableMouseAdapter());
			}

			model1.setCurrentState(BattleShipTableModel.PREPARE_STATE);
			model2.setCurrentState(BattleShipTableModel.PREPARE_STATE);
			model1.setTurn(true);
			
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
				ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(
						new String[] { "10", "12", "14" });
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
				jButton1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						model1.comfirm(model1);
					}
				});
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
			//vertical check
			{
				JPanel checkBoxTestPanel = new JPanel();
				vertial = new JCheckBox("Vertical");
				vertial.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (vertial.isSelected())
						{
							model1.setShipVertical(true);
							model2.setShipVertical(true);
						} else {
							model1.setShipVertical(false);
							model2.setShipVertical(false);
						}
					}
				});
				checkBoxTestPanel.add(vertial);
				getContentPane().add(vertial, "8, 6");
				}
			pack();
			this.setSize(817, 587);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
		
		
	}
	
	

	private int size=10;
	private BattleShipTableModel model1;
	private BattleShipTableModel model2;
	private JCheckBox vertial;
	
	private final static int DEFAULT_WIDTH = 600;
	private final static int DEFAULT_HEIGHT = 300;
}
