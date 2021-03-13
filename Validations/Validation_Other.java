
package Validations;

import interfaces.NursePanel;
import interfaces.ReceptionistPanel;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;


public class Validation_Other {
    
    
    public void clock1(ReceptionistPanel gui){
        Thread th = new Thread(){
            public void run(){
                try{
                    for(;;)
                    {
                        Calendar cal = new GregorianCalendar();
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MONTH)+1;
                        int year = cal.get(Calendar.YEAR);
                        
                        int sec = cal.get(Calendar.SECOND);
                        int min = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR);
                        int am_pm = cal.get(Calendar.AM_PM);
                        
                        String d_n = "";
                        if(am_pm == 1){
                            d_n = "PM";
                        }
                        else
                            d_n = "AM";
                        gui.lblTime.setText("" + hour+":"+min+":"+sec+" "+d_n + "");
                        gui.lblDate.setText("" + day +"/" + month+"/"+year + "");
                        sleep(1000);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex + "----------Error in printing time!!!","Warning!", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        th.start();
    }
    
    
    
      public void clock2(NursePanel gui){
        Thread th = new Thread(){
            public void run(){
                try{
                    for(;;)
                    {
                        Calendar cal = new GregorianCalendar();
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MONTH)+1;
                        int year = cal.get(Calendar.YEAR);
                        
                        int sec = cal.get(Calendar.SECOND);
                        int min = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR);
                        int am_pm = cal.get(Calendar.AM_PM);
                        
                        String d_n = "";
                        if(am_pm == 1){
                            d_n = "PM";
                        }
                        else
                            d_n = "AM";
                        gui.lblTime.setText("" + hour+":"+min+":"+sec+" "+d_n + "");
                        gui.lblDate.setText("" + day +"/" + month+"/"+year + "");
                        sleep(1000);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex + "----------Error in printing time!!!","Warning!", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        th.start();
    }
    
    
    
}
