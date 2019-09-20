package com.mycompany;

import com.mycompany.model.Movie;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Main {

    private static final String CSV_FILE_PATH = "movies1.csv";

    public static void main(String[] args) throws IOException {

        try (
            Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(CSV_FILE_PATH).toURI()))
        ) {
            CsvToBean<Movie> csvBean = new CsvToBeanBuilder(reader)
                    .withType(Movie.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Movie> movies = csvBean.parse();


            for (Movie moviesList: movies
                 ) {
                System.out.println("Id filmu: " + moviesList.getMovieID());
                System.out.println("Tytuł: " + moviesList.getTitle());
                System.out.println("Rok produkcji: " + moviesList.getYear());
                System.out.println("Typ filmu: " + moviesList.getGenre());
                System.out.println("========================================");

            }

            Long moviesVolume = movies.stream()
                    .map(moviesID -> moviesID.getMovieID())
                    .count();
            System.out.println("Liczba filmów: " + moviesVolume);

            IntSummaryStatistics statistics = movies.stream()
                    .mapToInt(moviesYear -> moviesYear.getYear())
                    .summaryStatistics();
            System.out.println("Przedział czasowy filmów to: " + statistics.getMin() + "-" + statistics.getMax());



        }catch (URISyntaxException ex){
            ex.printStackTrace();
        }

    }
}
