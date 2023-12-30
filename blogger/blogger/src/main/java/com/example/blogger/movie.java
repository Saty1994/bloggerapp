package com.example.blogger;

public class movie implements Comparable<movie> {


    private String name;
    private int rating;
    private  int year;

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public movie(String name, int rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }
//for String use CompareTo Method
    @Override
    public int compareTo(movie o) {
//        return this.year-o.year;
//    }
//    public int compareTo(movie o) {
//        return this.rating-o.rating;
        return this.name.compareTo(o.name);
    }
}
