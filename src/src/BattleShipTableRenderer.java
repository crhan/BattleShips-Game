/**
 * 
 */
package src;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


/**
 * @author crhan
 * 
 */
@SuppressWarnings("serial")
public class BattleShipTableRenderer extends JPanel 
		implements	TableCellRenderer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.swing.table.TableCellRenderer#getTableCellRendererComponent(javax
	 * .swing.JTable, java.lang.Object, boolean, boolean, int, int)
	 */
	@Override
	public Component getTableCellRendererComponent(JTable arg0, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		this.setBackground((Color)value);
		return this;
	}

}
