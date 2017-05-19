/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package win_yas;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

/**
 *
 * @author Haider
 */
public class Win_yas{
    String lastactivity = "";
    int minutes=0;
    boolean isKeyPressed = false;
    public Win_yas(){
        
    }
    Logging log = new Logging();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        // TODO code application logic here
        Win_yas wn = new Win_yas();
        
//        
//        JDialog j = new JDialog();
//        j.setTitle("Jar File Executed");
//            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//            j.setLocation(400, 400);
//      
//        j.setVisible(true);
//        
        
//        log.MarkAttendance
    while(true){
           wn.IdleTime();
    }
    }
    
    
    
    public void GetTime(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        lastactivity = sdf.format(cal.getTime());
        System.out.println( sdf.format(cal.getTime()) );

    }

    
    private void IdleTime() throws UnknownHostException{
        
        long idleTime = 0 ;
    long start = System.currentTimeMillis();
    Point currLocation = MouseInfo.getPointerInfo().getLocation();
    while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Win_yas.class.getName()).log(Level.SEVERE, null, ex);
            }
        Point newLocation = MouseInfo.getPointerInfo().getLocation();
        if(newLocation.equals(currLocation) && !isKeyPressed){
            //not moved
            idleTime = System.currentTimeMillis() - start;
        }
        else{
            minutes+=idleTime;
//            minutes += TimeUnit.MILLISECONDS.toHours(idleTime);
            System.out.printf("Idle time was: %s ms", idleTime);
            System.out.println("");
            long maxidle = 1*60000;
            if(minutes > maxidle){
                if(!newLocation.equals(currLocation)){
            
//                idleTime = System.currentTimeMillis() - start;
                    Long min = TimeUnit.MILLISECONDS.toMinutes(minutes);
                    System.out.printf("Total Idle Time in Hours: %s m",min);
                    log.MarkAttendance(min);
                    minutes=0;
                }
            }
        
            idleTime=0;
            start =  System.currentTimeMillis();
            break;
        }
        currLocation = newLocation;
        
        
    }
    
    }
    public void keyPressed(KeyEvent e) {
         isKeyPressed = true;
         System.out.println("Key Pressed");
    }

    
}
