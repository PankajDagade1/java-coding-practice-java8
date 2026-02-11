import java.util.List;
import java.util.stream.Collectors;

public class FindSpecialCharacter {
    public static void main(String[] args) {
        
        String input = "Hello, World! 123 #Java$Stream";

      String specialCharacters  =  input.chars()
               .filter(c -> !Character.isLetterOrDigit(c))
                .mapToObj(c -> String.valueOf((char)c))
             .collect(Collectors.joining(" "));

      System.out.println(specialCharacters);
    }
}
