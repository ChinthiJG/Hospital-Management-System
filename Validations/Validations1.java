
package Validations;

import com.sun.glass.events.KeyEvent;
import interfaces.HMS_DoctorGUI_1;
import java.beans.PropertyEditorManager;


public class Validations1 {
  
    public void key1(char c,char c2,String text,HMS_DoctorGUI_1 gui){
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

    
    public void key2(char c,char c2,String text,HMS_DoctorGUI_1 gui){
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
    public void phone1(char c,char c2,String text,HMS_DoctorGUI_1 gui){
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
    
     public void phone2(char c,char c2,String text,HMS_DoctorGUI_1 gui){
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
    
     public void ward1(char c,char c2,String text,HMS_DoctorGUI_1 gui){
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
      public void ward2(char c,char c2,String text,HMS_DoctorGUI_1 gui){
           if (c >= '0' && c <= '9') {
            if (text.length()< 4) {
               gui.txtWard2.setEditable(true);
            } else {
                gui.txtWard2.setEditable(false);
            }
        } else {
            if (c2 == KeyEvent.VK_BACKSPACE || c2== KeyEvent.VK_DELETE) {
                gui.txtWard2.setEditable(true);
            } else {
                gui.txtWard2.setEditable(false);
            }
        }
    
      }
      
      public void room1(char c,HMS_DoctorGUI_1 gui){
          if (Character.isLetter(c)) {
            gui.txtroom1.setEditable(false);
        } else {
           gui.txtroom1.setEditable(true);
        }
      }
      
      public void room2(char c,HMS_DoctorGUI_1 gui){
          if (Character.isLetter(c)) {
            gui.txtroom2.setEditable(false);
        } else {
           gui.txtroom2.setEditable(true);
        }
      }
      
      public void age1(char c,HMS_DoctorGUI_1 gui){
          if (Character.isLetter(c)) {
            gui.txtAge1.setEditable(false);
        } else {
           gui.txtAge1.setEditable(true);
        }
      }
      
       public void age2(char c,HMS_DoctorGUI_1 gui){
          if (Character.isLetter(c)) {
            gui.txtAge2.setEditable(false);
        } else {
           gui.txtAge2.setEditable(true);
        }
      }
    
    
}
