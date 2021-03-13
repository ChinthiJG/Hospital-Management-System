
package Validations;

import com.sun.glass.events.KeyEvent;
import interfaces.HMS_DoctorGUI_1;
import interfaces.HMS_PatientGUI_new;

public class Validations_Patient {
   
    
     public void key1(char c,char c2,String text,HMS_PatientGUI_new gui){
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

    
    public void key2(char c,char c2,String text,HMS_PatientGUI_new gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 12) {
               gui.txtnic2.setEditable(true);
            } else {
                gui.txtnic2.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtnic2.setEditable(true);
            } else {
                gui.txtnic2.setEditable(false);
            }
        }
       }
    public void phone1(char c,char c2,String text,HMS_PatientGUI_new gui){
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
    
     public void phone2(char c,char c2,String text,HMS_PatientGUI_new gui){
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
    
     public void ward1(char c,char c2,String text,HMS_PatientGUI_new gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 4) {
               gui.txtWard1.setEditable(true);
            } else {
                gui.txtWard1.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtWard1.setEditable(true);
            } else {
                gui.txtWard1.setEditable(false);
            }
        }
           
     }
      public void ward2(char c,char c2,String text,HMS_PatientGUI_new gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 4) {
               gui.txtward2.setEditable(true);
            } else {
                gui.txtward2.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtward2.setEditable(true);
            } else {
                gui.txtward2.setEditable(false);
            }
        }
    
      }
      
      
      
      public void age1(char c,HMS_PatientGUI_new gui){
          if (Character.isLetter(c)) {
            gui.txtAge1.setEditable(false);
        } else {
           gui.txtAge1.setEditable(true);
        }
      }
      
       public void age2(char c,HMS_PatientGUI_new gui){
          if (Character.isLetter(c)) {
            gui.txtage2.setEditable(false);
        } else {
           gui.txtage2.setEditable(true);
        }
      }
      public void bed1(char c,char c2,String text,HMS_PatientGUI_new gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 4) {
               gui.txtBed1.setEditable(true);
            } else {
                gui.txtBed1.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtBed1.setEditable(true);
            } else {
                gui.txtBed1.setEditable(false);
            }
        }
    
      }
      
       public void bed2(char c,char c2,String text,HMS_PatientGUI_new gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 4) {
               gui.txtbed2.setEditable(true);
            } else {
                gui.txtbed2.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtbed2.setEditable(true);
            } else {
                gui.txtbed2.setEditable(false);
            }
        }
    
      }
    
        
    
}
