
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicates  {
    public static void main(String[] args) {
              
       List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 3, 7, 8, 4);

       Map<Integer, Long> freqNum = numbers.stream()
               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        /*
           freqNum.forEach((key,value) -> {
            System.out.println(key+" "+value);
        });
        */

     /*
        Non-duplicate

               List<Integer> list = freqNum.entrySet().stream()
                          .filter(entry -> entry.getValue()==1)
                          .map(Map.Entry::getKey)
                          .collect(Collectors.toList());

               System.out.println(list);
     */

      /* Duplicate number */

       List<Integer> list = freqNum.entrySet().stream()
                          .filter(entry -> entry.getValue()>1)
                          .map(Map.Entry::getKey)
                          .collect(Collectors.toList());

      System.out.println(list);
    }
}
