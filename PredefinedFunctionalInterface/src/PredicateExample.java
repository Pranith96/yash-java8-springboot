import java.util.function.Predicate;

public class PredicateExample implements Predicate<Integer> {

	public boolean test(Integer data) {
		if (data % 2 == 0) {
			return true;
		}
		return false;
	}
}
