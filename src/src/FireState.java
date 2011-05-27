package src;

public class FireState extends PlayState {

	@Override
	public boolean click(BattleShipTableModel model, GridLocation location) {
		model.addGuess(location);
		return true;
	}

	@Override
	public void comfirm(BattleShipTableModel model) {
		super.context.setCurrentState(context.COMFIRMSTATE);
		super.context.comfirm(model);
		
	}

	@Override
	public void showResult() {
		// TODO Auto-generated method stub

	}

}
