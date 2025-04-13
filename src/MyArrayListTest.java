public class MyArrayListTest {

//	add(Object value) додає елемент в кінець
//	remove(int index) видаляє елемент з вказаним індексом
//	clear() очищає колекцію
//	size() повертає розмір колекції
//	get(int index) повертає елемент по індексу

	public static void main(String[] args) {

		MyArrayList<String> myArrayList = new MyArrayList<>();

		myArrayList.add("Hello");
		myArrayList.add("World");
		myArrayList.add("!");

		System.out.println("myArrayList = " + myArrayList);

		MyArrayList<Integer> myArrayList1 = new MyArrayList<>();

		for (int i = 0; i < 7; i++) {
			myArrayList1.add(i);
		}
		System.out.println("myArrayList1 = " + myArrayList1);

		myArrayList1.remove(0);

		System.out.println("myArrayList1 = " + myArrayList1);
		System.out.println("myArrayList1.size() = " + myArrayList1.size());

		System.out.println("myArrayList1.get(index) = " + myArrayList1.get(3));

		myArrayList1.clear();
		System.out.println("myArrayList1 = " + myArrayList1);
		System.out.println("myArrayList1.size() = " + myArrayList1.size());


	}
}