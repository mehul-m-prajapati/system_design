package myHashMap;

public class Main {
	
	public static void main (String args[]) {
		
		int HASH_SIZE = 7;
	    MyHashMap<Integer, String> map = new MyHashMap<>(HASH_SIZE);
	    map.put(1, "hi");
	    map.put(2, "my");
	    map.put(3, "name");
	    map.put(4, "is");
	    map.put(5, "Mehul");
	    map.put(6, "how");
	    map.put(7, "are");
	    map.put(8, "you");
	    map.put(9, "friends");
	    map.put(10, "?");
	
	    for (int idx = 0; idx < HASH_SIZE; idx++) {
	    	String value = map.get(idx);
	    	System.out.println(value);
	    }
	}
}
