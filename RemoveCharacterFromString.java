import java.util.stream.Collectors;

public class RemoveCharacterFromString  {

    public static void main(String[] args) {
        
          String str = "java interview";

          char ch = 'a';


        String s =  str.chars()
             .filter(c -> c!=ch)
             .mapToObj(c -> String.valueOf((char) c))
             .collect(Collectors.joining(""));

        System.out.println(s);


    }
}
