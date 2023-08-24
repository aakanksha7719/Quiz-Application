package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1300, 700);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1300, 300);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 370, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 370, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "What does HTML stand for?";
        questions[0][1] = "Hyper Text Markup Language";
        questions[0][2] = "Home tool markup language";
        questions[0][3] = "Hyperlinks Text Markup language";
        questions[0][4] = "High Text Markup language";

        questions[1][0] = "Who is making the Web standards??";
        questions[1][1] = "Mozila";
        questions[1][2] = "Chrome";
        questions[1][3] = "Microsoft";
        questions[1][4] = "world wide web consortium";

        questions[2][0] = "Choose the correct HTML element for the largest heading:";
        questions[2][1] = "<h1>";
        questions[2][2] = "<h2>";
        questions[2][3] = "<h5>";
        questions[2][4] = "<h6>";

        questions[3][0] = "What is the correct HTML element for inserting a line break??";
        questions[3][1] = "<break>";
        questions[3][2] = "br";
        questions[3][3] = "<br>";
        questions[3][4] = "break";

        questions[4][0] = "What is the correct HTML for adding a background color??";
        questions[4][1] = "<background>yellow</background>";
        questions[4][2] = "<body bg='yellow'>Hii</body>";
        questions[4][3] = "<body style='background-color:yellow'>Hii</body>";
        questions[4][4] = "<body background='yellow'>Hii</body>";

        questions[5][0] = "Choose the correct HTML element to define important text?";
        questions[5][1] = "<b>";
        questions[5][2] = "<strong>";
        questions[5][3] = "<h1>";
        questions[5][4] = "<important>";

        questions[6][0] = "Which character is used to indicate an end tag?";
        questions[6][1] = "<";
        questions[6][2] = ">";
        questions[6][3] = "/";
        questions[6][4] = "//";

        questions[7][0] = "Inline elements are normally displayed without starting a new line.";
        questions[7][1] = "True";
        questions[7][2] = "False";
        questions[7][3] = "None";
        questions[7][4] = "Both";

        questions[8][0] = "How can you make a numbered list??";
        questions[8][1] = "<ul>";
        questions[8][2] = "<ol>";
        questions[8][3] = "<dl>";
        questions[8][4] = "<list>";

        questions[9][0] = "How can you make a bulleted list?";
        questions[9][1] = "<ul>";
        questions[9][2] = "<dl>";
        questions[9][3] = "<list>";
        questions[9][4] = "<ol>";

        answers[0][1] = "Hyper Text Markup Language";
        answers[1][1] = "world wide web consortium";
        answers[2][1] = "<h6>";
        answers[3][1] = "<br>";
        answers[4][1] = "<body style='background-color:yellow'>Hii</body>";
        answers[5][1] = "<strong>";
        answers[6][1] = "/";
        answers[7][1] = "True";
        answers[8][1] = "<ol>";
        answers[9][1] = "<ul>";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 420, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 460, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 500, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 540, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1000, 460, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1000, 560, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        // String time = "Time left - " + timer + " seconds"; // 15
        // g.setColor(Color.RED);
        // g.setFont(new Font("Tahoma", Font.BOLD, 25));

        // if (timer > 0) {
        // g.drawString(time, 1000, 400);
        // } else {
        // g.drawString("Time over!!", 1000, 400);
        // }

        // timer--; // 14
        // try {
        // Thread.sleep(1000);
        // repaint();
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1000, 400);
        } else {
            g.drawString("Times up!!", 1000, 400);
        }

        timer--; // 14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
