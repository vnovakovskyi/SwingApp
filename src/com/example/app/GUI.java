package com.example.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUI extends JFrame {

    JScrollPane scroll;
    JLabel labelTime;
    public static JLabel labelAdvice1, labelAdvice2, labelAdvice3, labelAdvice4, labelAdvice5;
    public static JEditorPane webPane;

    GUI() {
        super("the tittle");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel timePanel = new JPanel(new BorderLayout());
        JPanel secondPanel = new JPanel(new BorderLayout());
        JPanel innerWebPanel = new JPanel();
        JPanel innerAdvicePanel = new JPanel();

        innerAdvicePanel.setLayout(new BoxLayout(innerAdvicePanel, BoxLayout.PAGE_AXIS));

        labelTime = new JLabel();
        labelAdvice1 = new JLabel();
        labelAdvice2 = new JLabel();
        labelAdvice3 = new JLabel();
        labelAdvice4 = new JLabel();
        labelAdvice5 = new JLabel();

        webPane = new JEditorPane();
        webPane.setContentType("text/html");
        webPane.setEditable(false);

        timePanel.setBackground(Color.LIGHT_GRAY);
        secondPanel.setBackground(Color.LIGHT_GRAY);
        innerWebPanel.setBackground(Color.GRAY);
        innerAdvicePanel.setBackground(Color.WHITE);

        scroll = new JScrollPane(webPane,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(500, 300));

        innerWebPanel.add(scroll);
        innerAdvicePanel.add(labelAdvice1);
        innerAdvicePanel.add(labelAdvice2);
        innerAdvicePanel.add(labelAdvice3);
        innerAdvicePanel.add(labelAdvice4);
        innerAdvicePanel.add(labelAdvice5);
        innerAdvicePanel.setPreferredSize(new Dimension(500, 80));

        timePanel.add(labelTime, BorderLayout.CENTER);
        secondPanel.add(innerWebPanel, BorderLayout.CENTER);
        secondPanel.add(innerAdvicePanel, BorderLayout.SOUTH);


        add(timePanel, BorderLayout.NORTH);
        add(secondPanel, BorderLayout.CENTER);

        final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        ActionListener timerListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                String time = timeFormat.format(date);
                labelTime.setText(time);
            }
        };
        Timer timer = new Timer(1000, timerListener);
        timer.setInitialDelay(0);
        timer.start();

        WebThread webThread = new WebThread();
        webThread.execute();
        AdviceThread adviceThread = new AdviceThread();
        adviceThread.execute();
    }
}