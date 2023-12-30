import com.example.blogger.Employee;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainUtil {
    public static void main(String[] args) {
//        Predicate<Integer>condition = x -> x >0;
//        boolean val = condition.test(100);
//        System.out.println(val);

//        Predicate<String>condition = x->x.equals("puja");
//        boolean val = condition.test("puja");
//        System.out.println(val);
//    List<Integer> data = Arrays.asList(10,20,30,40,50);
//        List<Integer> newData = data.stream().filter(x -> x > 20).collect(Collectors.toList());
//        System.out.print(newData);
//
//        List<String> data = Arrays.asList("mike","stallin","adam","steven","david","micheal");
//        List<String> newData = data.stream().filter(x -> x.startsWith("m")).collect(Collectors.toList());
//        System.out.println(newData);

//        List<String> data = Arrays.asList("mike","stallin","adam","steven","david","micheal");
//        List<String> newData = data.stream().filter(x -> x.endsWith("n")).collect(Collectors.toList());
//        System.out.println(newData);

//        List<String> data = Arrays.asList("mike","stallin","adam","steven","david","micheal");
//        List<String> newData = data.stream().filter(x -> x.equals("mike")).collect(Collectors.toList());
//        System.out.println(newData);

        Employee empl = new Employee();
        empl.setName("mike");
        empl.setCity("mysore");
        empl.setSalary(20000);

        Employee empl2 = new Employee();
        empl2.setName("smith");
        empl2.setCity("mysore");
        empl2.setSalary(30000);

        Employee empl3 = new Employee();
        empl3.setName("adam");
        empl3.setCity("banglore");
        empl3.setSalary(40000);

        Employee empl4 = new Employee();
        empl4.setName("pathan");
        empl4.setCity("chennai");
        empl4.setSalary(20000);

        List<Employee> data = Arrays.asList(empl,empl2,empl3,empl4);
        List<Employee> newData = data.stream().filter(e -> e.getCity().equalsIgnoreCase("mysore")).collect(Collectors.toList());

        for(Employee employee: newData) {
            System.out.println(employee.getName());
            System.out.println(employee.getCity());
            System.out.println(employee.getSalary());

        }
    }

}
