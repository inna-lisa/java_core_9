public class MyQueueTest {

//	add(Object value) додає елемент в кінець
//	clear() очищає колекцію
//	size() повертає розмір колекції
//	peek() повертає перший елемент з черги
//	poll() повертає перший елемент з черги і видаляє його з колекції

	public static void main(String[] args) {

		MyQueue<String> myQueue = new MyQueue<>();

		myQueue.add("A");
		myQueue.add("B");
		myQueue.add("C");
		myQueue.add("D");
		myQueue.add("E");
		System.out.println("myQueue = " + myQueue);

		System.out.println("myQueue.peek() = " + myQueue.peek());

		System.out.println("myQueue.poll() = " + myQueue.poll());
		System.out.println("myQueue = " + myQueue);

		myQueue.clear();
		System.out.println("myQueue = " + myQueue);

		myQueue.add("D");
		System.out.println("myQueue = " + myQueue);
	}
}
