import com.example.blogger.MovieName;
import com.example.blogger.MovieRating;
import com.example.blogger.movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainUtil4 {

    public static void main(String[] args) {
        movie m1 = new movie("bbb", 9, 1999);
        movie m2 = new movie("aaa", 8, 1989);
        movie m3 = new movie("ccc", 10, 1979);

        ArrayList<movie> List = new ArrayList<movie>();
        List.add(m1);
        List.add(m2);
        List.add(m3);

//        movieYear MovieYear = new movieYear();
//        Collections.sort(List,MovieYear);

//        MovieRating movieRating = new MovieRating();
//        Collections.sort(List,movieRating);

        MovieName movieName = new MovieName();
        Collections.sort(List,movieName);

        for (movie m:List) {
            System.out.println(m.getName());
            System.out.println(m.getYear());
            System.out.println(m.getRating());



        }
    }
}