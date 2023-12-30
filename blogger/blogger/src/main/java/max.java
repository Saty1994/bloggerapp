import java.util.Arrays;
import java.util.List;

public class max {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,100,200,500,5,1000,5000,10000);
        Integer val = numbers.stream().max(Integer::compareTo).get();
        System.out.println(val);

        Integer val1 = numbers.stream().min(Integer::compareTo).get();
        System.out.println(val1);

    }
}
