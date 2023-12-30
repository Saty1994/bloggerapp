import com.example.blogger.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MainUtil2 {
    public static void main(String[] args) {
//        Function<Integer,String> myfunction = i -> "Result: " +i;
//        String val = myfunction.apply(100);
//        System.out.println(val);

//        Function<Integer,Double> myfunction = i -> i*1.3;
//        Double val = myfunction.apply(100);
//        System.out.println(val);

//        List<Integer> data = Arrays.asList(18,5,2,20);
//        List<Integer> newData = data.stream().map(n ->n*n).collect(Collectors.toList());
//        System.out.println(newData);

//        List<Integer> data = Arrays.asList(18,5,2,20);
//        List<Integer> newData = data.stream().map(n ->n+n).collect(Collectors.toList());
//        System.out.println(newData);
//
//        List<Integer> data = Arrays.asList(18,5,2,20);
//        List<Integer> newData = data.stream().map(n ->n/2).collect(Collectors.toList());
//        System.out.println(newData);

//        List<Integer> data = Arrays.asList(18,5,2,20);
//        List<Integer> newData = data.stream().sorted().collect(Collectors.toList());
//        System.out.println(newData);

//        List<String> data = Arrays.asList("mike","stallin","adam","steven","david","micheal");
//        List<String> newData = data.stream().sorted().collect(Collectors.toList());
//        System.out.println(newData);
//
//        List<Integer> data = Arrays.asList(18,5,2,20,2,20,5);
//        List<Integer> newData = data.stream().distinct().collect(Collectors.toList());
//        System.out.println(newData);

//        Supplier<String> supplier = () -> "Hello, World!";
//        String s = supplier.get();
//        System.out.println(s);

        Consumer<String> comsumer =  s -> System.out.println("consumed:" +s);
        comsumer.accept("HELLO");

    }
}

