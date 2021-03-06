import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MainMethod {

	public static void main(String[] args) {
		PredicateExample ex = new PredicateExample();
		boolean result = ex.test(6);
		System.out.println(result);

		Predicate<Integer> ex1 = (data) -> {
			if (data % 2 == 0) {
				return true;
			}
			return false;
		};
		boolean result1 = ex1.test(8);
		System.out.println(result1);

		Predicate<Integer> ex2 = data -> data % 2 == 0;
		boolean result2 = ex2.test(9);
		System.out.println(result2);

		Consumer<String> str = (data) -> {
			System.out.println(data);
		};
		str.accept("Hello welcome");

		Supplier<Integer> supplier = () -> {
			Integer num = new Random().nextInt();
			return num;
		};
		Integer result5 = supplier.get();
		System.out.println(result5);
	}
}
