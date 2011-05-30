package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

public class BattleShipsFram extends JFrame {
	public BattleShipsFram(){
		this.setTitle("Battle Ship");
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		dimensionTableSize = 300;
		Border etched = BorderFactory.createEtchedBorder();

		//initializing two tables
		BattleShipTableModel model1 = new BattleShipTableModel(size);
		BattleShipTableModel model2 = new BattleShipTableModel(size);
		JTable table1 = new JTable(model1);
		JTable table2 = new JTable(model2);
		//setting the table size
		table1.setPreferredSize(new Dimension(dimensionTableSize, dimensionTableSize));
		table2.setPreferredSize(new Dimension(dimensionTableSize, dimensionTableSize));
		table1.setRowSelectionAllowed(false);
		table2.setRowSelectionAllowed(false);
		table1.setRowHeight(dimensionTableSize / size);
		table2.setRowHeight(dimensionTableSize / size);
		//couple two table models
		model1.setAnotherPlayer(model2);
		model2.setAnotherPlayer(model1);
		table1.setDefaultRenderer(Color.class, new BattleShipTableRenderer());
		table2.setDefaultRenderer(Color.class, new BattleShipTableRenderer());


		//initializing all panels;
		panelBanner = new JPanel();
		panelMain = new JPanel();
		panelTable1 = new JPanel();
		panelTable2 = new JPanel();
		panelInfo = new JPanel();
		panelLegend = new JPanel();
		panelMessage = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelInfo.setLayout(new BorderLayout());

		//adding table to panel
		panelTable1.add(table1);
		panelTable2.add(table2);
		panelTable1.setPreferredSize(new Dimension(dimensionTableSize+40, dimensionTableSize+40));
		panelTable2.setPreferredSize(new Dimension(dimensionTableSize+40, dimensionTableSize+40));
		panelTable1.setBorder(BorderFactory.createTitledBorder(etched, "Player One Area"));
		panelTable2.setBorder(BorderFactory.createTitledBorder(etched, "Player Two Area"));
		
		//design the info panel
		panelInfo.setBorder(BorderFactory.createTitledBorder(etched, "INFO"));
		panelLegend.setBorder(BorderFactory.createTitledBorder(etched, "Legend"));
		panelLegend.setLayout(new GridLayout(6, 2));
		legend(panelLegend, "Sea", Color.blue);
		legend(panelLegend, "Guess", Color.gray);
		legend(panelLegend, "Miss", Color.yellow);
		legend(panelLegend, "Hit", Color.red);
		legend(panelLegend, "Sank", Color.black);
		legend(panelLegend, "Ship", Color.green);
		panelInfo.add(panelLegend, BorderLayout.NORTH);

		status = new JTextPane();
		status.setEnabled(false);
		this.changeStatus("Player1:\nPrepare state");
		panelMessage.setBorder(BorderFactory.createTitledBorder(etched,"State"));
		panelMessage.add(status);
		status.setBackground(Color.darkGray);
		panelInfo.add(panelMessage, BorderLayout.CENTER);
		
		JButton comfirm = new JButton("Comfirm");
		panelInfo.add(comfirm,BorderLayout.SOUTH);

		// Design main panel
		panelMain.add(panelTable1, BorderLayout.WEST);
		panelMain.add(panelInfo, BorderLayout.CENTER);
		panelMain.add(panelTable2,BorderLayout.EAST);
		
		// Design Menu
		menuBar = new JMenuBar();
		JMenu common = new JMenu("Common");
		JMenuItem start = new JMenuItem("Start Game");
		JMenuItem quit = new JMenuItem("Quit");
		common.add(start);
		common.add(quit);
		menuBar.add(common);
		final JFrame thisFrame = this;
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog dialog = new StartGameDialog(thisFrame);
				dialog.setLocationRelativeTo(thisFrame);
				dialog.setVisible(true);
				
			}
		});
		quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		});

		// Adding to main Frame
		this.add(panelBanner,BorderLayout.NORTH);
		this.add(panelMain, BorderLayout.CENTER);
		this.setJMenuBar(menuBar);


		pack();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				BattleShipsFram frame = new BattleShipsFram();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}
	
	public void changeStatus(String _string){
		status.setText(_string);
	}
	
	private void legend(JPanel panel,String _text ,Color _color){
		JButton button = new JButton();
		JLabel label = new JLabel(_text);
		button.setBackground(_color);
		button.setPreferredSize(new Dimension(25, 25));
		button.setEnabled(false);
		panel.add(label);
		panel.add(button);
	}

	
	private int size=10;
	private int dimensionTableSize;
	private JPanel panelBanner, panelMain, panelTable1,
		panelTable2, panelInfo, panelLegend, panelMessage;
	private JTextPane status;
	private JMenuBar menuBar;
	

	private final static int DEFAULT_WIDTH = 800;
	private final static int DEFAULT_HEIGHT = 600;
	
	// Internal class
	class StartGameDialog extends JDialog{
		public StartGameDialog(JFrame owner){
			super(owner,"Start Game", true);
			
			ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(
					new String[] { "10", "11", "12" });
			JComboBox comboBoxSize = new JComboBox();
			getContentPane().add(comboBoxSize,BorderLayout.NORTH);
			comboBoxSize.setModel(jComboBox1Model);
			
			JPanel panel= new JPanel();
			JButton ok = new JButton("OK");
			
			getRootPane().setDefaultButton(ok);
			
			ok.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
				}
			});
			
			panel.add(ok);
			add(panel,BorderLayout.SOUTH);
			
			setSize(250,250);
		}
	}
}
