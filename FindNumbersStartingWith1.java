import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindNumbersStartingWith1 {

    public static void main(String[] args) {
        
         List<Integer> numbers = Arrays.asList(123, 456, 101, 789, 120, 132, 204);

       List<Integer> startWith1 = numbers.stream()
                .filter(num -> String.valueOf(num).startsWith("1"))
                .collect(Collectors.toList());

        System.out.println(startWith1);
    }
}
