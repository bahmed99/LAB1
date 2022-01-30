
import javax.swing.JFrame;

public class NewMain {

    
       public static void main(String[] args) {
        Calculatrice frame = new Calculatrice(); 
        frame.setTitle("Calculatrice");
        frame.setSize(300,200); 
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);
    }
    
}
