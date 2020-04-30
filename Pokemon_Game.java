import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
public class Pokemon_Game{
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonParnel, mainTextPanel, choiceButtonPanel,pokemonparnel;
    JLabel titleNameLabel, pokemonlebel,pokemonname,hplebel,currenthp;
    Font titleFont = new Font ("times New Roman",Font.PLAIN, 90);
    Font normalFont = new Font ("times New Roman",Font.PLAIN, 25);
    JButton startButton,choice1, choice2, choice3, choice4;
    JTextArea maintextarea; 
    Pokemon yourPokemon,wildpokemon;
    String  whatUdo;
    Random r;
    int berrybag=0;
    

    TitleScreenhandler tshandler = new TitleScreenhandler(); 
    Choicehandler CHandler = new  Choicehandler();
    public static void  main(String[] args) {
        new Pokemon_Game();
    }
    public Pokemon_Game()  {
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("POKEMON");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        

        startButtonParnel = new JPanel();
        startButtonParnel.setBounds (300,400,200,100);
        startButtonParnel.setBackground(Color.black);
        

        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tshandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonParnel.add(startButton);

        con.add(titleNamePanel); 
        con.add(startButtonParnel);
        titleNameLabel.revalidate();
        titleNameLabel.repaint();
    }
    public void createGameScreen(){

        titleNamePanel.setVisible(false);
        startButtonParnel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel); 

        maintextarea = new JTextArea();
        maintextarea.setBounds(100,100, 600, 250);
        maintextarea.setBackground(Color.black);
        maintextarea.setForeground(Color.white);
        maintextarea.setFont(normalFont);
        maintextarea.setLineWrap(true);
        mainTextPanel.add(maintextarea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 400, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);


        choice1 = new JButton();
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(CHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        
        choice2 = new JButton();
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(CHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        
        choice3 = new JButton();
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(CHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        
        choice4 = new JButton();
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(CHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);
        
        pokemonparnel = new JPanel();
        pokemonparnel.setBounds(100,15,600,50);
        pokemonparnel.setBackground(Color.blue);
        pokemonparnel.setLayout(new GridLayout(1,4));
        con.add(pokemonparnel);
        pokemonlebel = new JLabel("pokemon :");
        pokemonlebel.setFont(normalFont);
        pokemonlebel.setForeground(Color.white);
        pokemonparnel.add(pokemonlebel);
        pokemonname = new JLabel();
        pokemonname.setFont(normalFont);
        pokemonname.setForeground(Color.white);
        pokemonparnel.add(pokemonname);
        hplebel = new JLabel("HP :");
        hplebel.setFont(normalFont);
        hplebel.setForeground(Color.white);
        pokemonparnel.add(hplebel);
        currenthp = new JLabel();
        currenthp.setFont(normalFont);
        currenthp.setForeground(Color.white);
        pokemonparnel.add(currenthp);

        pokemonSetup();
        mainmenu();
    }
    public void pokemonSetup(){
        pokemonname.setText(yourPokemon.getname());
        currenthp.setText(yourPokemon.gethp());
    }
    public void mainmenu(){
        whatUdo = "mainmenu";
        maintextarea.setText("what do you want to do?");
        choice1.setText("Go fight");
        choice2.setText("Your Pokemon");
        choice3.setText("Find some berry");
        choice4.setText("Pokemon Center");
    }
    public void findBerry(){
        whatUdo = "findberry";
        r = new Random();
        int i = r.nextInt(3);
    if (i==0){
        berrybag++;
        maintextarea.setText("You find a berry.");
    }
    else{
        maintextarea.setText("You don't find anything.");
    } 
        choice1.setText("<");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void pokemoncenter(){
        whatUdo="pokemoncenter";
        yourPokemon.heal();
        maintextarea.setText("Your pokemon has been cured.");
        choice1.setText("<");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        currenthp.setText(yourPokemon.gethp());
    }
    public void pokemonbag(){
        whatUdo = "pokemonbag";
        maintextarea.setText("Do something with him.");
        choice1.setText("Check status");
        choice2.setText("Give berry");
        choice3.setText("Rename");
        choice4.setText("<");
    }
    public void getstat(){
        whatUdo = "stat";
        maintextarea.setText(yourPokemon.showstatus());
        choice1.setText("<");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void eatberry(){
        whatUdo = "eatberry";
        if(berrybag<=0){
            maintextarea.setText("You don't have any berry.");
        }
        else{
            int i = yourPokemon.eat();
            berrybag--;
            if(i==0){
                maintextarea.setText("Your maxHp has increase.");
                currenthp.setText(yourPokemon.gethp()); 
            }
            if(i==1){
                maintextarea.setText("Your Attack has increase.");
            }
            if(i==2){
                maintextarea.setText("Your Defend has increase.");
            }
        }   
            choice1.setText("<");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
    }
    public void ReName(){
        yourPokemon.rename(JOptionPane.showInputDialog("what is your pokemon's name."));

        pokemonname.setText(yourPokemon.getname());
    }
    public void foundpokemon(){
        wildpokemon = new Pokemon("Pidgey");
        r = new Random();
        wildpokemon.lvup(r.nextInt(5));
        wildpokemon.heal();
        whatUdo = "foundpokemon";
        maintextarea.setText("You find a wild pokemon.\n It's a"+wildpokemon.getname()+" Lv: "+wildpokemon.getlv()+"\nHp: "+wildpokemon.gethp());
        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }
    public void pokemonfight(){
        Pokemon.attack(wildpokemon, yourPokemon);
        if(wildpokemon.checkhp()>0){
            maintextarea.setText("You find a wild pokemon.\n It's a"+wildpokemon.getname()+" Lv: "+wildpokemon.getlv()+"\nHp: "+wildpokemon.gethp());
            Pokemon.attack(yourPokemon, wildpokemon);
            if(yourPokemon.checkhp()>0){
                whatUdo = "foundpokemon";
                currenthp.setText(yourPokemon.gethp());
                choice1.setText("Attack");
                choice2.setText("Run");
                choice3.setText("");
                choice4.setText("");
            }
            else{
                whatUdo = "lost";
                currenthp.setText("XxX");
                maintextarea.setText("You are noob.\nYour pokemon lose.\nGo to PokemonCenter.");
                choice1.setText(">");
                choice2.setText("");
                choice3.setText("");
                choice4.setText("");
            }
        }
        else{
            whatUdo="win"; 
            int Nlvup = yourPokemon.recivexp(2*wildpokemon.getmaxhp());
            if (Nlvup<1){
                maintextarea.setText("You win a wild Pidgey");
            }
            else{
                maintextarea.setText("You win a wild Pidgey\nYour pokemon is Level up to Level "+yourPokemon.getlv()+".");
                currenthp.setText(yourPokemon.gethp());
            }
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }
        
    public String wyName(){
        String name="";
        do{
            name = JOptionPane.showInputDialog("what is your pokemon's name.");
        }while( name == "");
        
        return name;
    }
    public class TitleScreenhandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            yourPokemon = new Pokemon(wyName());
            yourPokemon.lvup(4);
            yourPokemon.heal();
            createGameScreen();
        } 
    }
    public class Choicehandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            String yourchoice = event.getActionCommand();
            switch(whatUdo){
            case "mainmenu":
                switch(yourchoice){
                case "c1": foundpokemon();break;
                case "c2": pokemonbag(); break; 
                case "c3": findBerry(); break;
                case "c4": pokemoncenter(); break;
                }break;
            case "findberry":
                switch(yourchoice){
                case "c1": mainmenu();break;
                }break;
            case "pokemoncenter":
                switch(yourchoice){
                case "c1": mainmenu();break;
                } break;
            case "pokemonbag":
                switch(yourchoice){
                case "c1":getstat();break;
                case "c2":eatberry();break;
                case "c4":mainmenu();break;
                case "c3":ReName();break;
                }break;
            case "stat":
            switch(yourchoice){
                case "c1": pokemonbag();break;
                }break;
            case "eatberry":
            switch(yourchoice){
                case "c1": pokemonbag();break;
                }break;
            case "foundpokemon":
            switch(yourchoice){
                case "c1":pokemonfight();break;
                case "c2":mainmenu();break;
            }break;
            case "win":
            switch(yourchoice){
                case "c1":mainmenu();break;
            }break;
            case "lost":
            switch(yourchoice){
                case "c1":pokemoncenter();break;
            }break;
        }
    }
}
}