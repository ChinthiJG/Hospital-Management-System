
package Validations;

import com.sun.glass.events.KeyEvent;
import interfaces.WardGUI;


public class Validations_Ward {
    
      public void ward1(char c,char c2,String text,WardGUI gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 4) {
               gui.txtWardno.setEditable(true);
            } else {
                gui.txtWardno.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtWardno.setEditable(true);
            } else {
                gui.txtWardno.setEditable(false);
            }
        }
           
     }
    
    
    
    
}
