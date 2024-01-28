package generic_example;

public class Generics<T> {
	private T test;

	public Generics(T test) {
		this.test = test;
	}

	public T getTest() {
		return this.test;
	}
}