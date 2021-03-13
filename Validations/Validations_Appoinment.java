
package Validations;

import com.sun.glass.events.KeyEvent;
import interfaces.HMS_AppoinmentGUI11_1;
import interfaces.HMS_PatientGUI_new;


public class Validations_Appoinment {
  
      public void phone1(char c,char c2,String text,HMS_AppoinmentGUI11_1 gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 10) {
               gui.txtphone.setEditable(true);
            } else {
                gui.txtphone.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtphone.setEditable(true);
            } else {
                gui.txtphone.setEditable(false);
            }
        }
    }
    
     public void phone2(char c,char c2,String text,HMS_AppoinmentGUI11_1 gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 10) {
               gui.txtphone2.setEditable(true);
            } else {
                gui.txtphone2.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtphone2.setEditable(true);
            } else {
                gui.txtphone2.setEditable(false);
            }
        }
    }
     public void age1(char c,char c2,String text,HMS_AppoinmentGUI11_1 gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 3) {
               gui.txtage.setEditable(true);
            } else {
                gui.txtage.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtage.setEditable(true);
            } else {
                gui.txtage.setEditable(false);
            }
        }
    }
    
     public void age2(char c,char c2,String text,HMS_AppoinmentGUI11_1 gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 10) {
               gui.txtage2.setEditable(true);
            } else {
                gui.txtage2.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtage2.setEditable(true);
            } else {
                gui.txtage2.setEditable(false);
            }
        }
    }
    
    
}
