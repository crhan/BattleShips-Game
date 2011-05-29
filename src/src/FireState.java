package src;

public class FireState extends PlayState {

	@Override
	public boolean click(BattleShipTableModel model, GridLocation location) {
		if (context.isMyTurn())
		{
		model.addGuess(location);
		System.out.println(model.getGuess().size());
		model.fireTableDataChanged();
		return true;
		}
		else
			return false;
	}

	@Override
	public void comfirm(BattleShipTableModel model) {
		super.context.setCurrentState(BattleShipTableModel.COMFIRM_STATE);
		super.context.comfirm(model);
		
	}

	@Override
	public void showResult() {
		// TODO Auto-generated method stub

	}

}
