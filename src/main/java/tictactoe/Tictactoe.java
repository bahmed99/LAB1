
package tictactoe;
import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics.*;
import static java.lang.Thread.sleep;
import javax.swing.border.Border;
import java.util.HashMap;

public class Tictactoe extends JFrame  {
    protected JLabel [] labels = new JLabel[9];
    
    protected JLabel text = new JLabel("0");
    
    protected ImageIcon o = new ImageIcon("o.png");
    protected ImageIcon x = new ImageIcon("x.png");
    
    protected Boolean turnPlayer=false ; 
    
    protected Boolean end=false ; 
    
    protected String []list=new String[9] ; 
    
    protected int turn=0;
    
    protected int scoreX=0;
    protected int scoreO=0;
    
    protected JLabel XScore = new JLabel("ScoreX: "+scoreX);
    protected JLabel OScore = new JLabel("ScoreO: "+scoreO);

    
    
    
    public Tictactoe(){
        Border blackline = BorderFactory.createLineBorder(Color.black);
        JButton btnReset = new JButton("Reset");
        
        text.setOpaque(true);
        text.setBackground(Color.white);
        
        XScore.setOpaque(true);
        XScore.setBackground(Color.white);
        
        OScore.setOpaque(true);
        OScore.setBackground(Color.white);
        
        JPanel p1 =new JPanel(new BorderLayout());
        JPanel p2 =new JPanel(new BorderLayout());
        JPanel p3 =new JPanel();
        
        p1.setLayout(new GridLayout(3,3)) ;
        
        p3.setLayout(new GridLayout(1,3)) ;
        
        
        
        for(int i=0;i<labels.length;i++){
            labels[i]=new JLabel("");
            labels[i].setHorizontalAlignment(JLabel.CENTER);
            labels[i].setBorder(blackline);
            labels[i].setBackground(new Color(46,163,221));
            labels[i].setName(""+i);
            labels[i].addMouseListener(new MouseAdapter(){
            public void  mousePressed(MouseEvent e){
            if(!end && !find(list,((JLabel)e.getSource()).getName()) ){
                 if(turnPlayer){
                ((JLabel)e.getSource()).setIcon(x);
                CheckEnd();
                turnPlayer=false;
                text.setText("O turn");
                list[turn]=((JLabel)e.getSource()).getName();
                turn++;
 
            }
            else {
                ((JLabel)e.getSource()).setIcon(o);
                CheckEnd();
                turnPlayer=true;
                list[turn]=((JLabel)e.getSource()).getName();
                turn++;
                text.setText("X turn");
           
            }
            }     
           
        }
             public void mouseEntered(MouseEvent e) {
            ((JLabel)e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        });
            
            labels[i].setOpaque(true);
            p1.add(labels[i]);
            
        }
        p3.setBackground(Color.white);
        
        btnReset.addActionListener(new ActionListener(){
                
         public void actionPerformed (ActionEvent e){
         newTurn();
             
         }
        }
        );
            
        
        XScore.setHorizontalAlignment(JLabel.CENTER);
        OScore.setHorizontalAlignment(JLabel.CENTER);
        p3.add(btnReset);
        p3.add(XScore);
        p3.add(OScore);
        
        
        
        text.setHorizontalAlignment(JLabel.CENTER);
        p2.add(text);
        p2.add(p3,BorderLayout.EAST);
        add(p2,BorderLayout.NORTH);
        add(p1,BorderLayout.CENTER);
        
        int x = (int) Math.round( Math.random() )  ;
        if(x==1){
            turnPlayer=true;
             text.setText("X play first");
        }
        else {
            text.setText("O play first");
        }
        
    }
    
    public void CheckEnd(){
        if(turnPlayer){
            if(labels[0].getIcon()==x && labels[1].getIcon()==x && labels[2].getIcon()==x){
                Winner(0,1,2);
                end=true;
            }
            else if(labels[0].getIcon()==x && labels[3].getIcon()==x && labels[6].getIcon()==x){
                Winner(0,3,6);
                 end=true;
            }
            else if(labels[0].getIcon()==x && labels[4].getIcon()==x && labels[8].getIcon()==x){
                Winner(0,4,8);
                 end=true;
            }
            else if(labels[1].getIcon()==x && labels[4].getIcon()==x && labels[7].getIcon()==x){
                Winner(1,4,7); end=true;
            }
            else if(labels[2].getIcon()==x && labels[5].getIcon()==x && labels[8].getIcon()==x){
                Winner(2,5,8); end=true;
            }
            else if(labels[3].getIcon()==x && labels[4].getIcon()==x && labels[5].getIcon()==x){
                Winner(3,4,5); end=true;
            }
            else if(labels[6].getIcon()==x && labels[7].getIcon()==x && labels[8].getIcon()==x){
                Winner(6,7,8); end=true;
            }
            else if(labels[6].getIcon()==x && labels[4].getIcon()==x && labels[2].getIcon()==x){
                Winner(6,4,2); end=true;
            }
            else if(turn==9){
                    newTurn();
                
            }
            
        }
        else{
              if(labels[0].getIcon()==o && labels[1].getIcon()==o && labels[2].getIcon()==o){
                Winner(0,1,2); end=true;
            }
            else if(labels[0].getIcon()==o && labels[3].getIcon()==o && labels[6].getIcon()==o){
                Winner(0,3,6); end=true;
            }
            else if(labels[0].getIcon()==o && labels[4].getIcon()==o && labels[8].getIcon()==o){
                Winner(0,4,8); end=true;
            }
            else if(labels[1].getIcon()==o && labels[4].getIcon()==o && labels[7].getIcon()==o){
                Winner(1,4,7); end=true;
            }
            else if(labels[2].getIcon()==o && labels[5].getIcon()==o && labels[8].getIcon()==o){
                Winner(2,5,8); end=true;
            }
            else if(labels[3].getIcon()==o && labels[4].getIcon()==o && labels[5].getIcon()==o){
                Winner(3,4,5); end=true;
            }
            else if(labels[6].getIcon()==o && labels[7].getIcon()==o && labels[8].getIcon()==o){
                Winner(6,7,8); end=true;
            }
            else if(labels[6].getIcon()==o && labels[4].getIcon()==o && labels[2].getIcon()==o){
                Winner(6,4,2); end=true;
            }
        }
        
    }
    
    public void Winner(int x,int y ,int z) {
       
       labels[x].setBackground(Color.GREEN);
       labels[y].setBackground(Color.GREEN);
       labels[z].setBackground(Color.GREEN);
        if(turnPlayer){
            
            text.setText("X win");
            
            scoreX++;
            
            XScore.setText("ScoreX: "+scoreX);
        }
        else{
            text.setText("O win");
            scoreO++;
            OScore.setText("ScoreO: "+scoreO);
        }
        
       
        new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                newTurn(x,y,z);
            }
        }, 
       1000 
);
     
   }
    
    public void newTurn(int x,int y,int z){
        for(int i=0;i<labels.length;i++){
            labels[x].setBackground(new Color(46,163,221));
            labels[y].setBackground(new Color(46,163,221));
            labels[z].setBackground(new Color(46,163,221));
            labels[i].setIcon(new ImageIcon("1.png"));}
            end=false;
            turn=0;
            clear();
            list=new String[9] ;  
        
         
    }
    public void newTurn(){
        for(int i=0;i<labels.length;i++){
            labels[i].setIcon(new ImageIcon("1.png"));}
            end=false;
            turn=0;
            clear();
            list=new String[9] ;  
        
         
    }
    
    public void clear() {
        for (int i = 0; i < turn; i++)
            list[i] = null;

    }
    
    public Boolean find(String[] T, String val){
        for(int i = 0 ; i<T.length;i++){
        if(val==T[i])
          //retourner la position courante
          return true;
       }
   
        return false;
 }
      
    
    
}