package src;

import java.util.*;

public class IteratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<BattleShip> a = new ArrayList<BattleShip>();
		a.add(new BattleShip(1));
		a.add(new BattleShip(2));
		a.add(new BattleShip(3));
		a.add(new BattleShip(4));
		a.add(new BattleShip(5));
		
		Iterator<BattleShip> i = a.iterator();
		
		while (i.hasNext()){
			BattleShip x = i.next();
			System.out.println(x);
		}
	}
}
