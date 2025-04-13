public class MyLinkedListTest {

//	add(Object value) додає елемент в кінець
//	remove(int index) видаляє елемент з вказаним індексом
//	clear() очищає колекцію
//	size() повертає розмір колекції
//	get(int index) повертає елемент по індексу

	public static void main(String[] args) {

		MyLinkedList<String> myLinkedList = new MyLinkedList<>();
		System.out.println("myLinkedList = " + myLinkedList);

		myLinkedList.add("Hello");
		myLinkedList.add("World");
		myLinkedList.add("I");
		myLinkedList.add("Like");

		System.out.println("myLinkedList = " + myLinkedList);

		System.out.println("myLinkedList.get(index) = " + myLinkedList.get(2));

		myLinkedList.remove(0);
		System.out.println("myLinkedList = " + myLinkedList);

		MyLinkedList<Integer> myLinkedList1 = new MyLinkedList<>();

		for (int i = 0; i < 7; i++) {
			myLinkedList1.add(i);
		}
		System.out.println("myLinkedList1 = " + myLinkedList1);

		myLinkedList1.remove(2);
		System.out.println("myLinkedList1 = " + myLinkedList1);

		myLinkedList1.clear();
		System.out.println("myLinkedList1 = " + myLinkedList1);
		System.out.println("myLinkedList1.size = " + myLinkedList1.getSize());

	}
}
