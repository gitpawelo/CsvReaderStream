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
import java.util.List;

public class Main {

    private static final String CSV_FILE_PATH = "movies1.csv";

    public static void main(String[] args) throws IOException {

        try (
            Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(CSV_FILE_PATH).toURI()));
        ) {
            CsvToBean<Movie> csvBean = new CsvToBeanBuilder(reader)
                    .withType(Movie.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Movie> movies = csvBean.parse();

        }catch (URISyntaxException ex){
            ex.printStackTrace();
        }

    }
}
