package com.example.ankush.hackathon;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ankush on 3/13/2018.
 */

public class AlphabetOrderDataExtraction {


    public static ArrayList<data_with_link> fetchData(final String url,String Activity) {

        final ArrayList<data_with_link> temp= new ArrayList<>();
        Elements links= new Elements();


        try {

        if(Activity.equals("AlphabetDisplayList")) {
            Document doc = Jsoup.connect(url).get();
            // String title = doc.title();
           links = doc.select("div.col.span_4_of_3 td");
        }else
            if(Activity.equals("ScholarshipListActivity")){

                Document doc = Jsoup.connect(url).get();
                // String title = doc.title();
                links = doc.select("div.span_3_of_3");
            }


        Elements linkss = links.select("a[href]");
        for (Element link : linkss) {

            String initialUrl = "https://career.webindia123.com";
            temp.add(new data_with_link(link.text().charAt(0),link.text(), initialUrl + link.attr("href")));
            Log.i("text; ",temp.get(0).getTitle());
        }
    } catch (IOException e) {
       Log.i("a","aa");
    }


return temp;
}



}
