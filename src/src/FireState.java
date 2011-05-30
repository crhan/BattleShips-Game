package src;

import javax.swing.JOptionPane;

public class FireState extends PlayState {

	@Override
	public boolean click(BattleShipTableModel model, GridLocation location) {
		assert (model.isMyTurn());
		// check if is salvo rule and fire number less then 5
		// or is not salvo rule and fire number less then 1
		// then add the guess, or return false and open a dialog
		if ((model.isSalvo() && model.getGuess().size() < model.getShipLeft())
				|| !model.isSalvo() && model.getGuess().size() < 1) {
			model.addGuess(location);
			System.out.println(model.getGuess().size());
			model.fireTableDataChanged();
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"You have reach the max fire number");
			return false;
		}
	}

	@Override
	public void comfirm(BattleShipTableModel model) {
		super.getContext().setCurrentState(BattleShipTableModel.COMFIRM_STATE);
		super.getContext().comfirm(model);

	}

	@Override
	public void showResult() {
	}

	@Override
	public void button(BattleShipTableModel model) {
		if ((model.isSalvo() && model.getGuess().size() < model.getShipLeft())
				|| !model.isSalvo() && model.getGuess().size() < 1) {
			this.comfirm(model);
		}
	}
}
