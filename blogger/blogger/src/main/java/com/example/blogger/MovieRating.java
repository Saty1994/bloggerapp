package com.example.blogger;

import java.util.Comparator;

public class MovieRating implements Comparator<movie> {
    @Override
    public int compare(movie o1, movie o2) {
        return o1.getRating()- o2.getRating();
    }
}

