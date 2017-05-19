/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package win_yas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static sun.java2d.cmm.ColorTransform.Out;

/**
 *
 * @author Haider
 */
public class Logging{
    
    
    public void MarkAttendance(long idletime) throws UnknownHostException{
        String hostname="";
        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd____HH:mm:ss.SSS");
//        String current_time_str = time_formatter.format(System.currentTimeMillis());
//        System.out.print(current_time_str);
        String username = System.getProperty("user.name");
        try{
        FileDirectory(username,idletime);
        }
        catch(Exception ex){
            System.out.print(ex.getMessage().toString());
        }
    }
    
    Writer writer=null;
    public void FileDirectory(String name,long time) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        
        String path = "C:\\Users\\Haider\\Documents\\Attendance.txt";
        String line = "---------------\n";
//        String userloginfo = name+" ---> "+time;
        String line2 = "\n-----------------";
        File f = new File(path); 
//                 writer = new BufferedWriter(new OutputStreamWriter(
//                 new FileOutputStream(path), "utf-8"));
//                 writer.append(line);
//                 writer.
//                 writer.append(userloginfo);
//                 writer.append(line2);
//                 writer.close();

        FileWriter writer;
        PrintWriter print_writer;
        try{
        f.getParentFile().mkdir();
        f.createNewFile();
        String userloginfo = "\n"+name+" ---> Idle Time : "+String.valueOf(time)+" min(s)";        
        writer = new FileWriter(path,true);
        print_writer = new PrintWriter(writer);
        print_writer.printf("\r\n"+userloginfo);
        print_writer.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    
}
