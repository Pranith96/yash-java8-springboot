
public class MainMethod {

	public static void main(String[] args) {
		AdditionImpl addImpl = new AdditionImpl(); // compile time
		addImpl.add(5, 5);

		Addition addImpl1 = new AdditionImpl(); // runtime polymorphism // runtime
		addImpl1.add(10, 10);

		Addition ad = (x, y) -> {
			int c = x + y;
			System.out.println(c);
		};
		ad.add(5, 5);

		Summation sm = (x, y, z) -> {
			int q = x + y + z;
			return q;
		};
		int result = sm.sum(5, 5, 5);
		System.out.println(result);
		
		PrintData pd = () -> {
			System.out.println("inside print method");
		};
		pd.print();
	}
}
