package src;

public class PrepareState extends PlayState {

	@Override
	public boolean click(BattleShipTableModel model, GridLocation location) {
		try {
			super.context.getCurrentShip().setLocation(super.context.getSize(), location);
		} catch (GridOutOfBoundsException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void comfirm(BattleShipTableModel model) {

	}

	@Override
	public void showResult() {

	}

}
