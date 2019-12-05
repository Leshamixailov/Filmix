package com.imdb.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.FileWriter;
import java.io.IOException;

public class IMDB250 {
    public static void main(String[] args) throws IOException {
        final Document document = Jsoup.connect("http://www.imdb.com/chart/top").get();
        FileWriter writer;
        writer = new FileWriter("E:\\250.txt");

        String title;
        String rating;

        int count = 0;

        for (Element row : document.select("table.chart.full-width tr")){

            title = row.select("> .titleColumn a").text();
            rating = row.select(".imdbRating").text();
            

            if(count != 0){
                System.out.println(count + ". "+ title + " -> Rating: " + rating);
                writer.write(count + ". "+ title + " -> Rating: " + rating);
                writer.write("\n");
            }

            count++;

        }
        writer.close();
        final Document document1 = Jsoup.connect("https://www.imdb.com/chart/moviemeter").get();
        FileWriter writer1;
        writer1 = new FileWriter("E:\\250.txt");

        String title1;
        String rating1;
        
        int count1 = 0;

        for (Element row : document.select("table.chart.full-width tr")){

            title1 = row.select("> .titleColumn a").text();
            rating1 = row.select(".imdbRating").text();
            

            if(count != 0){
                System.out.println(count1 + ". "+ title1 + " -> Rating: " + rating1);
                writer.write(count + ". "+ title1 + " -> Rating: " + rating1);
                writer.write("\n");
            }

            count1++;

        }
        writer1.close();
        
        
    }
}

