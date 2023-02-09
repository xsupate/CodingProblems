package pg.com.roughTest;

import java.util.ArrayList;
import java.util.Set;

public class SetListExample extends ArrayList<Integer> implements Set<Integer>{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		SetListExample obj = new SetListExample();
		obj.add(123);
		obj.add(123);
		obj.add(123);
		obj.forEach(s->System.out.println(s));
	}

}
