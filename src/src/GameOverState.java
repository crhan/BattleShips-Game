package src;

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
		BattleShipTableModel model = super.context;
		BattleShipTableModel model2 = super.context.getAnotherPlayer();
		
		
		this.cleanBoard(super.context);
		
		// check the shipLeft and mark the winner
		if (model.getShipLeft() <=0 )
			this.setResultGrid(model, true);
		else 
			this.setResultGrid(model, false);
		
		if(model2.getShipLeft() <=0)
			this.setResultGrid(model2, true);
		else
			this.setResultGrid(model2, false);
		
	}
	
	public void cleanBoard(BattleShipTableModel model){
		for(int i=0;i<model.getSize(); i++){
			for (int j=0; j<model.getSize(); j++){
				model.getGridLocate(i, j).setType(BattleShipTableModel.SEA);
			}
		}
	}
	
	public void setResultGrid(BattleShipTableModel model, boolean isWin){
		int _x,_y;
		int length;
		
		if(isWin)
			length = win.length;
		else
			length = lose.length;
		
		for (int i=0;i<length;i++){
			if(isWin){
				_x = win[i][0];
				_y = win[i][1];
			} else {
				_x = lose[i][0];
				_y = lose[i][1];
			}
				if(isWin)
					model.getGridLocate(_x+3, _y).setType(BattleShipTableModel.WIN);
				else
					model.getGridLocate(_x+2, _y+2).setType(BattleShipTableModel.LOSE);
		}
	}
	
	private int[][] win = {
			{0,0},{1,0},{2,1},{3,1},{4,2},{3,3},{2,3},{1,4},{0,4},
			{1,5},{2,6},{3,6},{4,7},{3,8},{2,8},{1,9},{0,9}
	};
	
	private int[][] lose = {
			{0,0},{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{6,1},{6,2},
			{6,3},{6,4}
	};

}
