import java.lang.Math;
import java.util.ArrayList;

/**
 * This class acts as the back end calculator of the dice
 * @author Lauren
 *
 */
public class RollingFunction {
	private ArrayList<Object> num = new ArrayList<>();
	private int total;
	private int roll = 0;
	
	
	public void roll (int numDice, int typeDice) {
		for (int i = 0; i < numDice; i++) {
			roll = (int)((Math.random() * (typeDice)) + 1);	
			total = total + roll;
			num.add(roll);
			System.out.println(roll); // test
		}
	}
	
	public ArrayList<Object> rollArray() {
		// test loop
		System.out.print("[ ");
		for (Object i : num) {
			
			System.out.print(i + " ");
		}
		System.out.print("]");
		return num;
	}
	
	public int rollTotal() {
		System.out.println("\n" + total); // test
		return total;
	}
	
	// main test
	public static void main(String[] args) {
		RollingFunction r = new RollingFunction();

	}

}
