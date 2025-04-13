public class MyStackTest {

//	push(Object value) додає елемент в кінець
//	remove(int index) видаляє елемент по індексу
//	clear() очищає колекцію
//	size() повертає розмір колекції
//	peek() повертає перший елемент стеку
//	pop() повертає перший елемент стеку та видаляє його з колекції

	public static void main(String[] args) {

		MyStack<String> myStack = new MyStack<>();

		myStack.push("A");
		myStack.push("B");
		myStack.push("C");
		myStack.push("D");
		System.out.println("myStack = " + myStack + "\nsize " + myStack.size());

		myStack.remove(1);
		System.out.println("myStack = " + myStack + "\nsize " + myStack.size());

		myStack.clear();
		System.out.println("myStack = " + myStack + "\nsize " + myStack.size());

		myStack.push("A");
		myStack.push("B");
		myStack.push("C");
		myStack.push("D");
		System.out.println("myStack = " + myStack + "\nsize " + myStack.size());

		System.out.println("myStack.peek() = " + myStack.peek());
		System.out.println("myStack.pop() = " + myStack.pop());
		System.out.println("myStack = " + myStack + "\nsize " + myStack.size());

	}
}
