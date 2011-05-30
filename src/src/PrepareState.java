package src;

public class PrepareState extends PlayState {

	@Override
	public boolean click(BattleShipTableModel _model, GridLocation location) {
		assert(_model.isMyTurn());
		if (_model.isMyTurn()) {
			int _type = _model.getCurrentShipType();
			BattleShip _a = _model.getShip(_type);
			_a.setVertical(_model.isShipVertical());
			// if has ship, then try to set the location
			try {
				_a.setLocation(_model.getSize(), location, _model);
				_model.updateGrid();
				_model.setCurrentShipType(_type + 1);
				return true;
			} catch (GridOutOfBoundsException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (BattleShipCrossOverException e) {
				e.printStackTrace();
			}
			if (_model.getCurrentShipType() > 5) {
				_model.setCurrentState(BattleShipTableModel.FIRE_STATE);
				_model.changePlayer();
				return true;
			}
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
