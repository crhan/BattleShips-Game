package src;

import javax.swing.JOptionPane;

public class GameOverState extends PlayState {

	@Override
	public boolean click(BattleShipTableModel model, GridLocation location) {
		return false;
	}

	@Override
	public void comfirm(BattleShipTableModel model) {

	}

	@Override
	public void showResult() {
		BattleShipTableModel model = super.getContext();
		BattleShipTableModel model2 = model.getAnotherPlayer();

		model.setShipPlaceState(true);
		model2.setShipPlaceState(true);
		model.fireTableDataChanged();
		model2.fireTableDataChanged();
		model.setCurrentState(BattleShipTableModel.GAMEOVER_STATE);
		model2.setCurrentState(BattleShipTableModel.GAMEOVER_STATE);
		JOptionPane.showMessageDialog(BattleShipsFram.thisFrame, toString());

	}

	public void cleanBoard(BattleShipTableModel model) {
		for (int i = 0; i < model.getSize(); i++) {
			for (int j = 0; j < model.getSize(); j++) {
				model.getGridLocate(i, j).setType(BattleShipTableModel.SEA);
			}
		}
	}

	public void setResultGrid(BattleShipTableModel model, boolean isWin) {
		int _x, _y;
		int length;

		if (isWin)
			length = win.length;
		else
			length = lose.length;

		for (int i = 0; i < length; i++) {
			if (isWin) {
				_x = win[i][0];
				_y = win[i][1];
			} else {
				_x = lose[i][0];
				_y = lose[i][1];
			}
			if (isWin)
				model.getGridLocate(_x + 3, _y).setType(
						BattleShipTableModel.WIN);
			else
				model.getGridLocate(_x + 2, _y + 2).setType(
						BattleShipTableModel.LOSE);
		}
	}

	private int[][] win = { { 0, 0 }, { 1, 0 }, { 2, 1 }, { 3, 1 }, { 4, 2 },
			{ 3, 3 }, { 2, 3 }, { 1, 4 }, { 0, 4 }, { 1, 5 }, { 2, 6 },
			{ 3, 6 }, { 4, 7 }, { 3, 8 }, { 2, 8 }, { 1, 9 }, { 0, 9 } };

	private int[][] lose = { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 }, { 4, 0 },
			{ 5, 0 }, { 6, 0 }, { 6, 1 }, { 6, 2 }, { 6, 3 }, { 6, 4 } };

	@Override
	public void button(BattleShipTableModel model) {

	}

	public String toString() {
		BattleShipTableModel _model;
		if (super.getContext().getShipLeft() == 0) {
			_model = super.getContext();
		} else if (super.getContext().getShipLeft() > 0
				&& super.getContext().getAnotherPlayer().getShipLeft() == 0)
			_model = super.getContext().getAnotherPlayer();
		else
			_model = null;

		return _model + " Won!";
	}

}
