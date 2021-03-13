
package Validations;

import com.sun.glass.events.KeyEvent;
import interfaces.HMS_PatientGUI_new;
import interfaces.HMS_ReceptionistGUI;


public class Validations_Recep {
    
    public void key1(char c,char c2,String text,HMS_ReceptionistGUI gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 12) {
               gui.txtNic1.setEditable(true);
            } else {
                gui.txtNic1.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtNic1.setEditable(true);
            } else {
                gui.txtNic1.setEditable(false);
            }
        }
    }

    
    public void key2(char c,char c2,String text,HMS_ReceptionistGUI gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 12) {
               gui.txtNic2.setEditable(true);
            } else {
                gui.txtNic2.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtNic2.setEditable(true);
            } else {
                gui.txtNic2.setEditable(false);
            }
        }
       }
    public void phone1(char c,char c2,String text,HMS_ReceptionistGUI gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 10) {
               gui.txtPhone1.setEditable(true);
            } else {
                gui.txtPhone1.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtPhone1.setEditable(true);
            } else {
                gui.txtPhone1.setEditable(false);
            }
        }
    }
    
     public void phone2(char c,char c2,String text,HMS_ReceptionistGUI gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 10) {
               gui.txtPhone2.setEditable(true);
            } else {
                gui.txtPhone2.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtPhone2.setEditable(true);
            } else {
                gui.txtPhone2.setEditable(false);
            }
        }
    }
      public void age1(char c,HMS_ReceptionistGUI gui){
          if (Character.isLetter(c)) {
            gui.txtAge1.setEditable(false);
        } else {
           gui.txtAge1.setEditable(true);
        }
      }
      
       public void age2(char c,HMS_ReceptionistGUI gui){
          if (Character.isLetter(c)) {
            gui.txtAge2.setEditable(false);
        } else {
           gui.txtAge2.setEditable(true);
        }
      }
    
}
