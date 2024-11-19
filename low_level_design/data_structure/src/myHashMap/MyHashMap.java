package myHashMap;

public class MyHashMap<K, V> {

	private static final int INITIAL_SIZE = 1 << 4; // 16
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    
    Entry[] hashTable;
    
    MyHashMap() {
    	hashTable = new Entry[INITIAL_SIZE];
    }
    
    MyHashMap(int capacity) {
    	int tableSize = getTableSize(capacity);
    	hashTable = new Entry[tableSize];
    }
    
    final int getTableSize(int capacity) {
    
    	int n = capacity - 1;
    	
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
    	
    	return (n < 0) ? 1 : (n > MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    
    class Entry <K, V> {

		K key;
    	V value;
    	
    	Entry<K, V> next;
    	
    	Entry(K k, V v) {
    		key = k;
    		value = v;
    	}
    	
    	public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
    }
    
    public void put(K key, V value) {
    	
    	int hasCode = key.hashCode() % hashTable.length;
    	Entry node = hashTable[hasCode];
    	
    	if (node == null) {
    		Entry newNode = new Entry(key, value);
    		hashTable[hasCode] = newNode;
    	}
    	// Collision handling
    	else {
    		// First node
    		Entry previousNode = node;
    		
    		// Reach to last node if same key not found
    		while (node != null) {
    			
    			if (node.key == key) {
    				node.value = value; // overwrite if same key
    				return;
    			}
    			
    			previousNode = node;
    			node = node.next;
    		}
    		
    		Entry newNode = new Entry(key, value);
    		previousNode.next = newNode;
    	}
    }
    
    public V get(K key) {
    	
    	int hasCode = key.hashCode() % hashTable.length;
    	Entry node = hashTable[hasCode];
    			
    	while (node != null) {
    		
    		if (node.key.equals(key))
    			return (V) node.value;
    		
    		node = node.next;
    	}
    	
    	return null;
    }
}


