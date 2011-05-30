package src;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class BattleShipsFram extends JFrame {
	private BattleShipsFram(){
		this.setTitle("Battle Ship");
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		dimensionTableSize = 300;
		table1 =new JTable();
		table2 = new JTable();
		comfirm = new JButton("Comfirm");

		// add comfirm actionListener
		comfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String _text = new String();
				if (model1.isMyTurn()){
					model1.button(model1);
					_text += model2.getCurrentState();
				} else {
					model2.button(model2);
					_text += model1.getCurrentState();
				}
				status.setText(_text);
			}
		});
		
		Border etched = BorderFactory.createEtchedBorder();

		//initializing two tables
		model1 = new BattleShipTableModel(size);
		model2 = new BattleShipTableModel(size);
		table1.setModel(model1);
		table2.setModel(model2);
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
		model1.initGrid(BattleShipTableModel.GUESS);
		model2.initGrid(BattleShipTableModel.GUESS);
		table1.addMouseListener(new BattleShipTableMouseAdapter());
		table2.addMouseListener(new BattleShipTableMouseAdapter());

		//initializing all panels;
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
		this.changeStatus("Wating for Start");
		panelMessage.setBorder(BorderFactory.createTitledBorder(etched,"State"));
		panelMessage.add(status);
		status.setBackground(Color.darkGray);
		panelInfo.add(panelMessage, BorderLayout.CENTER);
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
		
		JMenu prepare = new JMenu("Prepare");
		isVertical = new JCheckBoxMenuItem("Vertical");
		prepare.add(isVertical);
		menuBar.add(prepare);
		
		// menuItem isVertical
		isVertical.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isVertical.isSelected()){
					model1.setShipVertical(true);
					model2.setShipVertical(true);
				} else {
					model1.setShipVertical(false);
					model2.setShipVertical(false);
				}
			}
		});
		
		// menuItem Start actionPerform
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO 增加开始dialog,选择salvo rules和选择size
				JDialog dialog = new StartGameDialog(thisFrame);
				dialog.setLocationRelativeTo(thisFrame);
				dialog.setVisible(true);
			}
		});
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// Adding to main Frame
		this.add(panelMain, BorderLayout.CENTER);
		this.setJMenuBar(menuBar);
		this.getRootPane().setDefaultButton(comfirm);


		pack();
		
		
		//initializing the game
		model1.setCurrentState(BattleShipTableModel.PREPARE_STATE);
		model2.setCurrentState(BattleShipTableModel.PREPARE_STATE);
		model1.setPlayerName("Player one");
		model2.setPlayerName("Player two");
		comfirm.setEnabled(false);
	}
	
	public void startGame(){
		//initializing two tables
		model1 = new BattleShipTableModel(size);
		model2 = new BattleShipTableModel(size);
		table1.setModel(model1);
		table2.setModel(model2);
		//setting the table size
		table1.setPreferredSize(new Dimension(dimensionTableSize, dimensionTableSize));
		table2.setPreferredSize(new Dimension(dimensionTableSize, dimensionTableSize));
		table1.setRowHeight(dimensionTableSize / size);
		table2.setRowHeight(dimensionTableSize / size);
		model1.initGrid(BattleShipTableModel.SEA);
		model2.initGrid(BattleShipTableModel.SEA);
		//initializing the game
		model1.setCurrentState(BattleShipTableModel.PREPARE_STATE);
		model2.setCurrentState(BattleShipTableModel.PREPARE_STATE);
		model1.setPlayerName("Player one");
		model2.setPlayerName("Player two");
		model1.setTurn(true);
		model2.setTurn(false);
		model1.setAnotherPlayer(model2);
		model2.setAnotherPlayer(model1);
		comfirm.setEnabled(true);
		status.setText(""+model1.getCurrentState());
		model1.fireTableDataChanged();
		model2.fireTableDataChanged();
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
	private JPanel panelMain, panelTable1,
		panelTable2, panelInfo, panelLegend, panelMessage;
	private JTextPane status;
	private JMenuBar menuBar;
	private BattleShipTableModel model1,model2;
	private JTable table1, table2;
	private static JButton comfirm;
	private JCheckBox checkSalvoRules;
	private JComboBox comboBoxSize;
	JCheckBoxMenuItem isVertical;
	public final static JFrame thisFrame = new BattleShipsFram();

	private final static int DEFAULT_WIDTH = 800;
	private final static int DEFAULT_HEIGHT = 600;
	
	class BattleShipTableMouseAdapter extends MouseAdapter{
		public void mouseClicked(MouseEvent event) {
			JTable table =  (JTable)event.getSource();
			// check for mouse click, just an example
			int col = table.columnAtPoint(event.getPoint());
			int row = table.rowAtPoint(event.getPoint());
			BattleShipTableModel model = (BattleShipTableModel) table.getModel();
			model.click(model, model.getGridLocate(row, col));
		}
	}
	
	/**
	 * Internal class of {@link BattleShipsFram}
	 */
	class StartGameDialog extends JDialog{
		/**
		 * @param owner: parent Frame
		 */
		public StartGameDialog(JFrame owner){
			super(owner,"Start Game", true);
			
			ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(
					new String[] { "10", "11", "12" });
			comboBoxSize = new JComboBox();
			getContentPane().add(comboBoxSize,BorderLayout.NORTH);
			comboBoxSize.setModel(jComboBox1Model);
			
			checkSalvoRules = new JCheckBox("Salvo Rules");
			add(checkSalvoRules,BorderLayout.CENTER);
			
			JPanel panel= new JPanel();
			JButton ok = new JButton("OK");
			
			getRootPane().setDefaultButton(ok);
			
			ok.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// check if use the salvo rules
					String selected = (String) comboBoxSize.getSelectedItem();
					if(selected == "11")
						size = 11;
					else if(selected == "12")
						size = 12;
					else if (selected == "10")
						size = 10;
					
					startGame();
					if(checkSalvoRules.isSelected()){
						model1.setSalvo(true);
						model2.setSalvo(true);
					} else {
						model1.setSalvo(false);
						model2.setSalvo(false);
					}
					setVisible(false);
					System.out.println(table1.getMouseListeners().length);
				}
			});
			
			panel.add(ok);
			add(panel,BorderLayout.SOUTH);
			
			setSize(250,250);
		}
	}
}