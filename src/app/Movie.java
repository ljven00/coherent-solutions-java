package app;

import java.time.Year;

/**
 * This class illustrates a real world movie. Each movie contains
 * a title, a director, and a year of production.
 * Those attributes are privates, and setters and getters are used
 * to interact with them.
 * @ Jean Venaldo Louissaint
 */
public class Movie {

    private String title;
    private String director;
    private int yearOfProduction;


    /* The constructor calls the setters in order
     * to check the preconditions before creating the object
     */
    public Movie(String title, String director, int yearOfProduction){
        this.setTitle(title);
        this.setDirector(director);
        this.setYearOfProduction(yearOfProduction);
    }

    private String checkTitle(String title){
        return (title == null || title.isEmpty() || title.isBlank())
                ? "Untitled" : title;
    }

    private String checkDirector(String director){
        return (director == null || director.isEmpty() || director.isBlank() )
                ? "Anonymous" : director;
    }

    private int checkYear(int year){
        int currentYear = Year.now().getValue();
        return (year < 0 || year > currentYear)
                ? currentYear : year;
    }


    // setters ang getters
    public void setTitle(String title){
        this.title = this.checkTitle(title);
    }


    // set director to Anonymous in case no legal value is provided
    public void setDirector(String director){
        this.director = checkDirector(director);
    }

    // year of production should be greater than zero but not greater than the current year
    public void setYearOfProduction(int year){
        this.yearOfProduction = checkYear(year);
    }

    public String getTitle(){ return this.title; }

    public String getDirector(){ return this.director; }

    public int getYearOfProduction(){ return this.yearOfProduction; }

    // return the info about a movie with "-" as separator
    public String movieInfo(){
        return String.format("%s-%s-%04d", this.title, this.director,
                this.yearOfProduction);
    }

    public static void main(String[] args){
        Movie movie = new Movie("The Fast and The Furious",
                "Justin Lin", 2045);

        System.out.println(movie.movieInfo());
    }

}

