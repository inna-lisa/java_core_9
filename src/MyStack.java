import java.util.StringJoiner;

public class MyStack<T> {

	private static final int INIT_SIZE = 10;
	private Object[] array;
	private int index;

	public MyStack() {
		array = new Object[INIT_SIZE];
		index = 0;
	}

	public void push(T value){
		if(index < array.length){
			array[index] = value;
			index++;
		}
		else {
			Object[] newArray = new Object[array.length * 2];

			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
			array[index] = value;
			index++;
		}
	}

	public void remove(int index){
		if(index < 0 || index > array.length - 1){
			System.out.println("this element is not exist");
			return;
		}
		Object[] newArray = new Object[array.length-1];

		int j = 0;
		for (int i = 0;  i < array.length; i++) {
			if(index != i) {
				newArray[j] = array[i];
				j++;
			}
			else {
				newArray[j] = array[i + 1];
				i++;
				j++;
			}
		}
		this.index--;
		array = newArray;
		newArray = null;
	}

	public void clear(){
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
		array = new Object[INIT_SIZE];
		index = 0;
	}

	public int size(){
		return index;
	}

	public T peek(){
		return (T)array[index-1];
	}

	public T pop(){
		Object temp = array[index-1];
		array[index-1] = null;
		index--;
		return (T)temp;
	}

	@Override
	public String toString() {
		StringJoiner result = new StringJoiner(", ");

		for (int i = 0; i < index; i++) {
			result.add(array[i].toString());
		}
		return result.toString();
	}
}
