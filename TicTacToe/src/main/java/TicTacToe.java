import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {                         //interfata
     Random random = new Random();                                         //choose random player to start (x or 0);
     JFrame frame = new JFrame();                                          //frame(container, windows with buttons, text, pannel..etc.);
     JPanel title_panel = new JPanel();                                    //title;
     JPanel button_panel = new JPanel();                                   // panel for buttons;
     JLabel textfield = new JLabel();                                      //for messages;
     JButton [] buttons = new JButton[9];                                  //array for buttons;
     boolean player1_turn;                                                 // if true player 1 start, if not, player2;
    TicTacToe (){                                                          //constructor
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);              //close button;
        frame.setSize(800,800);                                            //size of yor frame;
        frame.getContentPane().setBackground(new Color(50,50,50));         //color of the background;
        frame.setLayout(new BorderLayout()); //appearance
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i=0; i<9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0; i <9; i++){
            if (e.getSource()==buttons[i]){
            if(player1_turn){
                    if (buttons[i].getText()==""){
                    buttons[i].setForeground(new Color(255,0,0));
                    buttons[i].setText("X");
                    player1_turn=false;
                    textfield.setText("0 turn");
                    check();
                    }
                }
                else{
                     if (buttons[i].getText()==""){
                     buttons[i].setForeground(new Color(0,0,255));
                     buttons[i].setText("0");
                     player1_turn=true;
                     textfield.setText("X turn");
                     check();
                    }

                    }
                }
        }
    }
    public void firstTurn(){//metoda

        try {
        Thread.sleep(2000);                      //add delay so the game starts with the message->
        }catch (InterruptedException e) {        // ->tictactoe and than shows x or 0 turn
        // TODO Auto-generated catch block
        e.printStackTrace();}

        if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X turn");

        } else{
            player1_turn=false;
            textfield.setText("0 turn");
        }
    }
    public void check()
    {//check x win conditions
        if ((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) {xWins(0,1,2);}
        if ((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) {xWins(3,4,5);}
        if ((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) {xWins(6,7,8);}
        if ((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) {xWins(0,3,6);}
        if ((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) {xWins(1,4,7);}
        if ((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) {xWins(2,5,8);}
        if ((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) {xWins(0,4,8);}
        if ((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) {xWins(2,4,6);}

        //check 0 win conditions
        if ((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) {oWins(0,1,2);}
        if ((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")) {oWins(3,4,5);}
        if ((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) {oWins(6,7,8);}
        if ((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) {oWins(0,3,6);}
        if ((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) {oWins(1,4,7);}
        if ((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) {oWins(2,5,8);}
        if ((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) {oWins(0,4,8);}
        if ((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) {oWins(2,4,6);}
    }
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
        buttons[i].setEnabled(false);                   //stop game after wining comb
        }
        textfield.setText("X wins");
    }
    public void oWins (int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
        buttons[i].setEnabled(false);                  //stop game after wining comb
        }
        textfield.setText("O wins");
    }
}
