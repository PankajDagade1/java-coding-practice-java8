import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SumEvenAndOdd {

    public static void main(String[] args) {
        
        List<Integer> numbers = Arrays.asList(
            1,2,3,4,5,6,7,8,9,10
        );
        
        Map<Boolean,Integer> m =  numbers.stream()
               .collect(Collectors.partitioningBy(num -> num%2 == 0, Collectors.summingInt(Integer::intValue)));
        System.out.println("Sum of even num : "+m.get(true));
        System.out.println("Sum of odd num  : "+m.get(false));

    }
}
