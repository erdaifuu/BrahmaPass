package com.example.brahmapassv3;

import android.media.metrics.Event;
import android.util.Log;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.android.gms.tasks.Task;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EventScraper {
    ArrayList<String> eventN = new ArrayList<>();
    public void HTMLScraper() {
        WebClient client = new WebClient(BrowserVersion.CHROME);
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        client.getOptions().setThrowExceptionOnFailingStatusCode(false);
        client.getOptions().setThrowExceptionOnScriptError(false);
        client.getOptions().setPrintContentOnFailingStatusCode(false);
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    URL url=new URL("https://dbhs.wvusd.k12.ca.us/apps/events/");
                    //Log.d("EventScraper","OUTPUT: First!");
                    HtmlPage page = client.getPage(url);
                    //Log.d("EventScraper","OUTPUT: Second!");
                    client.getCurrentWindow().getJobManager().removeAllJobs();
                    client.close();
                    List<HtmlAnchor> anchors = page.getByXPath("//a[@class='event-link']");
                    //Log.d("EventScraper","OUTPUT: Third!");
                    for (int i = 0; i < anchors.size(); i++) {
                        HtmlAnchor link = (HtmlAnchor) anchors.get(i);
                        eventN.add(link.getAttribute("aria-label").replace(',', ';'));
                        //Log.d("EventScraper","OUTPUT: " + eventN.get(i) + "\n");
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }


}
