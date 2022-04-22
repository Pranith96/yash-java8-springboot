import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiExample1 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> result = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(result);
		list.stream().map(y -> y * 5).forEach(z -> System.out.println(z));

		List<Integer> result1 = list.stream().filter(x -> x % 2 == 0).map(y -> y * 5).collect(Collectors.toList());
		System.out.println(result1);

		List<Integer> list1 = Arrays.asList(1, 12, 18, 15, 11, 17, 2, 3, 4, 5, 6, 7, 21, 20, 8, 9, 10);
		List<Integer> result2 = list1.stream().sorted().collect(Collectors.toList());
		System.out.println(result2);

		List<Integer> result3 = list1.stream().sorted((x, y) -> y.compareTo(x)).collect(Collectors.toList());
		System.out.println(result3);

		long count = list1.stream().count();
		System.out.println(count);
	}
}
