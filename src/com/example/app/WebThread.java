package com.example.app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.io.IOException;

import static com.example.app.GUI.webPane;

public class WebThread extends SwingWorker<String, String>{
    @Override
    protected String doInBackground() throws Exception {

        String s;
        String tmp;

        while (true){
            Document doc = null;
            try {
                doc = Jsoup.connect("https://www.youtube.com/").get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            s = doc.wholeText();

            tmp = "";
            int counter = 0;

            for (int i = 0; i < s.length(); i++) {
                if (counter < 100) {
                    char ch = s.charAt(i);
                    if ((ch == '\n') | (ch == '\r')) {
                        counter++;
                    }
                    tmp += ch;
                }
            }

            tmp += "*************************************";

            String s1 = "<html>" + tmp.replaceAll("[\n\r]", "<br>") + "</html>";
            webPane.setText(s1);

            try {
                Thread.currentThread().sleep(300000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
