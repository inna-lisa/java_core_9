public class MyHashMapTest {

//	put(Object key, Object value) додає пару ключ + значення
//	remove(Object key) видаляє пару по ключу
//	clear() очищає колекцію
//	size() повертає розмір колекції
//	get(Object key) повертає значення (Object value) по ключу

	public static void main(String[] args) {
		MyHashMap<String, Integer> names = new MyHashMap<>();

		names.put("Artem", 15);
		names.put("Igor", 16);
		names.put("Dmitrii", 17);
		names.put("Oleg", 18);
		names.put("Sasha", 19);
		names.put("Roma", 19);

		System.out.println(names);
		System.out.println("names.size = " + names.size());

		names.remove("Igor");
		System.out.println(names);
		System.out.println("names.size = " + names.size());


		System.out.println("names.get = " + names.get("Dmitrii"));

		names.put("Nastya", 25);
		names.put("Ira", 26);
		names.put("Natasha", 27);
		names.put("Inna", 28);
		names.put("Masha", 29);
		names.put("Kristina",30);

		System.out.println(names);
		System.out.println("names.size = " + names.size());

		names.clear();
		System.out.println("names = " + names);



	}
}
