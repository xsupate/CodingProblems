package pg.com.roughTest;

public class Mutable {

	private int realValue;

	public Mutable(int value) {
		realValue = value;
	}

	public int getValue() {
		return realValue;
	}

	public void setValue(int newValue) {
		realValue = newValue;
	}

	public static void main(String[] arg) {
		Immutable obj = new Immutable(4);
		System.out.println(obj.getValue());
	}
}

final class Immutable {
    final int val;

	public Immutable(int value) {
		this.val = value;
	}

	public int getValue() {
		return val;
	}
}