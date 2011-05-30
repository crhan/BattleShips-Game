package src;

public class FireState extends PlayState {

	@Override
	public boolean click(BattleShipTableModel model, GridLocation location) {
		if (model.isMyTurn()) {
			model.addGuess(location);
			System.out.println(model.getGuess().size());
			model.fireTableDataChanged();
			return true;
		} else
			return false;
	}

	@Override
	public void comfirm(BattleShipTableModel model) {
		super.getContext().setCurrentState(BattleShipTableModel.COMFIRM_STATE);
		super.getContext().comfirm(model);

	}

	@Override
	public void showResult() {
		// TODO Auto-generated method stub

	}

}
