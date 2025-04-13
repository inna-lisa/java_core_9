import java.util.StringJoiner;

public class MyQueue<T> {

	private int size = 0;
	private MyNode<T> first;
	private MyNode<T> last;

	private static class MyNode<T>{
		T value;
		MyNode<T> next;

		private MyNode(T value, MyNode<T> next) {
			this.value = value;
			this.next = next;
		}

		@Override
		public  String toString() {
			return value.toString();
		}
	}

	public void add(T value){
		final MyNode<T> newNode;
		if(size == 0){
			first = new MyNode<T>(value, null);
			last = first;
			size++;
		}
		else {
			newNode = new MyNode<T>(value,null);
			last.next = newNode;
			last = newNode;
			size++;
		}
	}

	public void clear(){
		if(size == 0){
			return;
		}
		MyNode<T> tempNode;

		while (first.next != null){
			tempNode = first;
			first = null;
			first = tempNode.next;
			size--;
		}
		if(size == 1){
			first = null;
			last = null;
			size--;
		}
	}

	public int getSize(){
		return size;
	}

	public MyNode<T> peek(){
		return first;
	}

	public MyNode<T> poll(){
		MyNode<T> tempNode = first;
		first = tempNode.next;
		size--;
		return tempNode;
	}

	@Override
	public String toString() {
		if(size == 0){
			return null;
		}

		StringJoiner result = new StringJoiner(", ");
		MyNode<T> temp = first;

		while (temp.next != null) {
			result.add(temp.value.toString());
			temp = temp.next;
		}
		result.add(temp.value.toString());

		return result + "\nsize = " + size;
	}
}
