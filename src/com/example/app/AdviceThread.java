package com.example.app;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.app.GUI.*;

public class AdviceThread extends SwingWorker<String, String> {
    @Override
    protected String doInBackground() throws Exception {

        List<String> advices = new ArrayList<>();

        for (int i = 0; i < 500; i++){
            advices.add("my advice for you number " + String.valueOf(i+1));
        }

        for (int i = 0; i < advices.size(); i++){

            labelAdvice1.setText(advices.get(i));
            labelAdvice2.setText(advices.get(i+1));
            labelAdvice3.setText(advices.get(i+2));
            labelAdvice4.setText(advices.get(i+3));
            labelAdvice5.setText(advices.get(i+4));

            Thread.sleep(1000);
        }

        return null;
    }
}
