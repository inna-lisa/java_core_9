import java.util.StringJoiner;

public class MyLinkedList<T> {
	private int size = 0;
	private MyNode<T> first;
	private MyNode<T> last;

	public MyLinkedList() {
	}

	private static class MyNode<T>{
		T value;
		MyNode<T> previous;
		MyNode<T> next;

		private MyNode(T value, MyNode<T> previous, MyNode<T> next) {
			this.value = value;
			this.previous = previous;
			this.next = next;
		}

		@Override
		public  String toString() {
			return value.toString();
		}
	}

	public void add(T value){
		final MyNode<T> newNode;
		if(size == 0) {
			first = new MyNode(value, null, null);
			last = first;
			size++;
		}
		else {
			newNode = new MyNode<>(value, last, null);
			last.next = newNode;
			last = newNode;
			size++;
		}
	}

	public void remove(int index){
		if(index >= 0 && index < size ) {
			if(index == 0) {
				//first.previous = null;
				first = first.next;
			}
			if(index == size - 1) {
				last = last.previous;
				last.next = null;
			}
			else {
				MyNode<T> temp = get(index);
				temp.previous.next = temp.next;
				temp.next.previous = temp.previous;
			}
			size--;
		}
		else {
			System.out.println("index is not exist!!!");
		}
	}

	public MyNode<T> get(int index) {
		if(index >= 0 && index < size) {
			int count = 0;
			MyNode<T> temp = first;

			while (temp.next != null) {
				if(count == index) {
					return temp;
				}
				count++;
				temp = temp.next;
			}
			return temp;
		}
		else {
			System.out.println("index is not exist!!!");
		}
		return null;
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
		}
		if(size == 1){
			first = null;
			last = null;
		}
		size = 0;
	}

	public int getSize() {
		return size;
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
