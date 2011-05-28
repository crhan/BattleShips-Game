package src;

public class FireState extends PlayState {

	@Override
	public boolean click(BattleShipTableModel model, GridLocation location) {
		if (context.getTurn())
		{
		model.addGuess(location);
		return true;
		}
		else
			return false;
	}

	@Override
	public void comfirm(BattleShipTableModel model) {
		super.context.setCurrentState(BattleShipTableModel.COMFIRMSTATE);
		super.context.comfirm(model);
		
	}

	@Override
	public void showResult() {
		// TODO Auto-generated method stub

	}

}
