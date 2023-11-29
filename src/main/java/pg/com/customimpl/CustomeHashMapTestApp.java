package pg.com.customimpl;

public class CustomeHashMapTestApp {

	public static void main(String[] args) {
		CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();
        customHashMap.put("one", 1);
        customHashMap.put("two", 2);
        customHashMap.put("three", 3);

        System.out.println("Size: " + customHashMap.size());
        System.out.println("Value for key 'two': " + customHashMap.get("two"));

        customHashMap.remove("two");
        System.out.println("Size after removing 'two': " + customHashMap.size());
        System.out.println("Value for key 'two' after removal: " + customHashMap.get("two"));
	}

}
