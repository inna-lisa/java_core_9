import java.util.StringJoiner;

public class MyHashMap<K,V> {
	private MyNode<K,V> [] table;
	private int size;
	private int threshold;
	private float loadFactor;

	static final int INITIAL_CAPACITI = 16;
	static final float LOAD_FACTOR = 0.75f;
	static final int MAXIMUM_THRESHOLD = 8;

	public MyHashMap() {
		this.table = new MyNode[INITIAL_CAPACITI];
	}

	public static class MyNode<K,V>{
		final int hash;
		K key;
		V value;
		MyNode<K,V> next;

		public MyNode(K key, V value, MyNode<K, V> next) {
			this.hash = key.hashCode();
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public MyNode<K, V>[] getTable() {
		return table;
	}

	public int getSize() {
		return size;
	}

	public float getLoadFactor() {
		return loadFactor;
	}

	public int getThreshold() {
		return threshold;
	}

	public void resize(MyNode<K,V> [] table){
		loadFactor = 0;
		size = 0;
		this.table = new MyNode[table.length * 2];

		for (int i = 0; i < table.length; i++) {
			if(table[i] != null){
				int sizeBacket = countNodesInOneBacket(table[i]);

				if(sizeBacket == 1){
					put(table[i].key, table[i].value);
				}
				else {
					for (int j = 1; j <= sizeBacket; j++) {
						put(table[i].key, table[i].value);
						table[i] = table[i].next;
					}
				}
			}
		}
	}

	public int countNodesInOneBacket(MyNode<K,V> first){
		MyNode<K,V> temp = first;
		int count = 0;

		while (temp.next != null) {
			count++;
			temp = temp.next;
		}
		return ++count;
	}

	public void put(K key, V value){

		MyNode<K,V> newNode = new MyNode<>(key, value, null);;

		//index bucket
		int index;
		index = (table.length -1) & newNode.hash;
		//System.out.println(newNode.key + "  index = " + index);

		if(table[index] == null) {
			table[index] = newNode;
			loadFactor++;
			size++;
		}
		else {
			threshold = countNodesInOneBacket(table[index]);
			MyNode<K, V> temp = table[index];

			for (int i = 1; i < threshold; i++) {
				if (temp.hash != newNode.hash && temp.key != newNode.key) {
					temp = temp.next;
				} else {
					temp.value = newNode.value;
				}
			}
			temp.next = newNode;
			size++;
		}
			//check size bucket
		if(threshold >= MAXIMUM_THRESHOLD){
			threshold = 0;
			resize(table);
			return;
		}
		threshold = 0;
			//check loadFactor
		if( loadFactor / table.length >= LOAD_FACTOR){
			resize(table);
		}
	}

	public void remove(K key) {
		for (int i = 0; i < table.length; i++) {
			if(table[i] != null){
				int sizeBacket = countNodesInOneBacket(table[i]);

				if(sizeBacket == 1){
					if(table[i].hash == key.hashCode()  && table[i].key == key) {
						table[i] = null;
						size--;
						loadFactor--;
					}
				}
				else {
					MyNode<K,V> temp = table[i];
					MyNode<K, V> previous = table[i];

					for (int j = 1; j <= sizeBacket; j++) {
						if (temp.hash == key.hashCode() && temp.key == key) {
							if (j == 1) {
								table[i] = table[i].next;
								temp = null;
								size--;
								return;
							}
							if(j == sizeBacket){
								previous.next = null;
								temp = null;
								size--;
								return;
							}
							else {
								previous.next = temp.next;
								temp = null;
								size--;
								return;
							}
						}
						previous = temp;
						temp = temp.next;
					}
				}
			}
		}
	}

	public void clear(){
		for (int i = 0; i < table.length; i++) {
			if(table[i] != null){
				int sizeBacket = countNodesInOneBacket(table[i]);

				if(sizeBacket == 1){
					table[i] = null;
					size--;
					loadFactor--;
				}
				else {
					for (int j = 1; j <= sizeBacket; j++) {
						table[i] = table[i].next;
						size--;
					}
					loadFactor--;
				}
			}
		}
	}

	public int size(){
		return size;
	}

	public V get(K key){
		for (int i = 0; i < table.length; i++) {
			if(table[i] != null){
				int sizeBacket = countNodesInOneBacket(table[i]);

				if(sizeBacket == 1){
					if(table[i].hash == key.hashCode()  && table[i].key == key) {
						return table[i].value;
					}
				}
				else {
					MyNode<K,V> temp = table[i];

					for (int j = 1; j <= sizeBacket; j++) {
						if (temp.hash == key.hashCode() && temp.key == key) {
							return table[i].value;
						}
						temp = temp.next;
					}
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringJoiner map = new StringJoiner("\n");
		String result;

		for (int i = 0; i < table.length; i++) {
			if(table[i] != null){
				MyNode<K,V> temp = table[i];

				while (temp.next != null) {
					result = "{ " + temp.key + " - " + temp.value + "}";
					map.add(result);
					temp = temp.next;
				}
				result = "{ " + temp.key + " - " + temp.value + "}";
				map.add(result);
			}
		}
		return map.toString();
	}
}
