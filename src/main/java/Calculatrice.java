import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;

public class Calculatrice extends JFrame{
        protected JButton [] buttons = new JButton[17];
        protected String operator;
        protected JLabel text = new JLabel("0");
        protected Boolean newNumber =false;
        protected Boolean clickEnter =false;
        protected Boolean testOperation =false;
        protected double Number ;
        protected double SecondNumber=0 ;
        
        
       public Calculatrice(){
           text.setOpaque(true);
           text.setBackground(Color.WHITE);
           JPanel p1 =new JPanel(new BorderLayout());
           JPanel p2 =new JPanel(new BorderLayout());
           JPanel p3 =new JPanel(new BorderLayout());
           
           String[] array2 ={"+","-","*","/"};
           String[] array1 ={"7","8","9","4","5","6","1","2","3","0","+/-","ClearAll"};
           
           p1.setLayout(new GridLayout(4,3)) ;
           for(int i=0 ; i<array1.length ;i++){
               buttons[i]=new JButton("" +array1[i]);
               if(i==11){
                    buttons[i].setForeground(new Color(255, 0, 127));
                    buttons[i].addActionListener(new ClearAllClass());
               }
               else {
                    buttons[i].setForeground(new Color(15, 10, 222));
                    if(i==10){
                        buttons[i].addActionListener(new SignClass());
                    }
                    else {
                         buttons[i].addActionListener(new NumberClass());
                    }
               
               }
            p1.add(buttons[i]); 
           
            
        }
           
            p2.setLayout(new GridLayout(4,1)) ; 
            for (int i=0 ; i<array2.length;i++){
                
            buttons[i+12]=new JButton("" +array2[i]);
            buttons[i+12].setForeground(new Color(255, 76, 48));
            if(i==0){
                 buttons[i+12].addActionListener(new PlusClass());
            }
            else if (i==1){
                buttons[i+12].addActionListener(new MinusClass());
            }
            else if (i==2){
                buttons[i+12].addActionListener(new MultiplicateClass());
            }
            else {
                buttons[i+12].addActionListener(new DivideClass());
             }
            p2.add(buttons[i+12]);
        }
            
            p3.setLayout(new GridLayout(1,1)) ;
            buttons[16]=new JButton("Enter");
            buttons[16].addActionListener(new EnterClass());
            buttons[16].setForeground(Color.GREEN);
            p3.add(buttons[16]);
            
            
           
            add(text,BorderLayout.NORTH); 
            add(p1,BorderLayout.CENTER); 
            add(p2,BorderLayout.EAST);  
            add(p3,BorderLayout.SOUTH);
            
       }
       
       public void calcul(){
         
           if(operator=="+"){
               if(!clickEnter){
               Number= Number+Double.parseDouble(text.getText());
               clickEnter=true;
               SecondNumber=Double.parseDouble(text.getText());
               }
               else {
                    Number= Number+SecondNumber;
               }
               
               text.setText(String.valueOf(Number));
           }
           else if(operator=="*"){
                if(!clickEnter){
               Number= Number*Double.parseDouble(text.getText());
               clickEnter=true;
               SecondNumber=Double.parseDouble(text.getText());
               }
               else {
                    Number= Number*SecondNumber;
               }
               
               text.setText(String.valueOf(Number));
               
           }
           else if (operator=="-"){
               if(!clickEnter){
               Number= Number-Double.parseDouble(text.getText());
               clickEnter=true;
               SecondNumber=Double.parseDouble(text.getText());
               }
               else {
                    Number= Number-SecondNumber;
               }
               
               text.setText(String.valueOf(Number));
           }
           else {
               try{
               if(!clickEnter){
               Number= Number/Double.parseDouble(text.getText());
               clickEnter=true;
               SecondNumber=Double.parseDouble(text.getText());
               }
               else {
                    Number= Number/SecondNumber;
               }
               
               text.setText(String.valueOf(Number));
               }
               catch(ArithmeticException e) {
                text.setText("0");
                  }
               
           }
       }
       
class PlusClass implements ActionListener{
     @Override
     public void actionPerformed (ActionEvent e){
    

          if(!testOperation){
        
         Number= Double.parseDouble(text.getText());
         clickEnter=false;
         testOperation=true;
         }
         else {
             calcul();
         }
 
         
         
         clickEnter=false;
         newNumber=true;
         operator="+";
         
     }
 }
class MinusClass implements ActionListener{
    @Override
    public void actionPerformed (ActionEvent e){
      
       
       if(!testOperation){
           
        
        Number= Double.parseDouble(text.getText());
        newNumber=true;
        clickEnter=false;
        testOperation=true;
       }
       else {
            calcul();
       }
       
       
       clickEnter=false;
       newNumber=true;
       operator="-";
    }
}

class DivideClass implements ActionListener{
     @Override
     public void actionPerformed (ActionEvent e){
        
        
         if(!testOperation){
         
         Number= Double.parseDouble(text.getText());
         newNumber=true;
        
         testOperation=true;}
         else{
              calcul();
         }
         clickEnter=false;
         newNumber=true;
         operator="/";
     }
 }
class MultiplicateClass implements ActionListener{
    @Override
    public void actionPerformed (ActionEvent e){
       
     if(!testOperation){
       
       Number= Double.parseDouble(text.getText());
       newNumber=true;
      
       testOperation=true;
     }
     else{
          calcul();
     }
     clickEnter=false;
     newNumber=true;
     operator="*";
    }
}

class ClearAllClass implements ActionListener{
    @Override
    public void actionPerformed (ActionEvent e){
        operator="";
        newNumber=false;
        text.setText("0");
        clickEnter=false;
        testOperation=false;
        
    }
}
class SignClass implements ActionListener{
    @Override
    public void actionPerformed (ActionEvent e){
        if(text.getText()!="0")
        { double x= Double.parseDouble(text.getText());
        x=x*-1 ; 
        clickEnter=false;
        text.setText(String.valueOf(x));}
    }
}

class NumberClass implements ActionListener{
    @Override
    public void actionPerformed (ActionEvent e){
        String number = ((JButton)e.getSource()).getText();
        if(newNumber){
            newNumber=false;
        }
        else {
             if(text.getText()!="0")
        {
            number = text.getText()+number;
        }
        
        }
       
        text.setText(number);
        
    }
}

class EnterClass implements ActionListener{
    @Override
    public void actionPerformed (ActionEvent e){
        calcul();
    }
}  

}


