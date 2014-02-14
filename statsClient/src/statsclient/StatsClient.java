/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statsclient;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author furkanzumrut
 */
public class StatsClient {

    /**
     * @param args the command line arguments
     */
    int sayac = 0;
    Timer Zamanlayici1 = new Timer();
    Timer Zamanlayici2 = new Timer();
    Timer Zamanlayici3 = new Timer();
    Timer Zamanlayici4 = new Timer();
    public static void main(String[] args) {
        // TODO code application logic here

        StatsClient s = new StatsClient();
        s.calis1();
        s.calis2();
        s.calis3();
        //s.calis4();
        

    }
    
    public void calis1(){
 
        TimerTask gorev1=new TimerTask() {
                                      
        @Override
        public void run() {
                try{
                 //Socket sckt=new Socket("localhost",21500);
                 Socket sckt = new Socket("37.187.85.209",21500);

                 //Socket sckt = new Socket(“siteadı.com.tr”,portNo);
                 DataInputStream frServer=new DataInputStream(sckt.getInputStream());
                 DataOutputStream toServer=new DataOutputStream(sckt.getOutputStream());

                 
                         try{


                         //yarıçapı Server a gönderiyoruz…
                         toServer.writeUTF("istek 1");
                         toServer.flush();
                         String content = frServer.readUTF();
                         //alanı serverdan geri cilent e almak için…
                         //double area = frServer.readDouble();
                         //System.out.println(content);
                         try {
 
                                

                                File file = new File("filepath");

                                // if file doesnt exists, then create it
                                if (!file.exists()) {
                                        file.createNewFile();
                                }

                                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                                BufferedWriter bw = new BufferedWriter(fw);
                                bw.write(content);
                                bw.close();


                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                         //System.out.println(istek);
                         //System.out.println(area);
                         }
                         catch(IOException ex){
                         System.err.println(ex);
                         }
                 }
                 catch(IOException e){
                 System.out.println(e.toString());
                 }
          }
        }; 

             Zamanlayici1.schedule(gorev1, 10000, 980000);  
        }
    public void calis2(){
 
        TimerTask gorev2=new TimerTask() { 
                                        
        @Override
        public void run() {
                try{
                 //Socket sckt=new Socket("localhost",21500);
                 Socket sckt = new Socket("37.187.85.209",21500);
                 //Socket sckt = new Socket(“siteadı.com.tr”,portNo);
                 DataInputStream frServer=new DataInputStream(sckt.getInputStream());
                 DataOutputStream toServer=new DataOutputStream(sckt.getOutputStream());
                         try{
                             

                         //yarıçapı Server a gönderiyoruz…
                         toServer.writeUTF("istek 2");//ÖNCEKİ VERİLERİ SİL APPEND ET
                         toServer.flush();
                         File file = new File("/home/admin/sampforum/st/scores.dat"); 
                         FileWriter fw = new FileWriter(file.getAbsoluteFile());
                         BufferedWriter bw = new BufferedWriter(fw);
                         bw.write("");
                         bw.close();
                         
                         for (int i = 0; i <= 100; i++) {
                             
                                 //System.out.println(fr);
                                    try {
 
                                
                                    
  

                                    // if file doesnt exists, then create it
                                    if (!file.exists()) {
                                            file.createNewFile();
                                    }

                                    FileWriter fw_ = new FileWriter(file.getAbsoluteFile(),true);
                                    BufferedWriter bw_ = new BufferedWriter(fw_);
                                    if(i==0) bw_.write("\n"+frServer.readUTF()+"\n");
                                    else bw_.write(frServer.readUTF()+"\n");
                                    bw_.close();


                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                         }
 
                         //alanı serverdan geri cilent e almak için…
                         //double area = frServer.readDouble();
                         


                         //System.out.println(istek);
                         //System.out.println(area);
                         }
                         catch(IOException ex){
                         System.err.println(ex);
                         }
                 }
                 catch(IOException e){
                 System.out.println(e.toString());
                 }
          }
        }; 

             Zamanlayici2.schedule(gorev2, 115000, 248000);  
             
        }   
    public void calis3(){
 
        TimerTask gorev3=new TimerTask() { // TimerTask ile "gorev" adlı fonksiyonu oluşturduk bundan dolayı
                                        // public void run methodu oluştu(netbeans tarafından implement edin yada siz oluşturun)
        @Override
        public void run() {
                try{
                 //Socket sckt=new Socket("localhost",21500);
                 Socket sckt = new Socket("37.187.85.209",21500);
                 //Socket sckt = new Socket(“siteadı.com.tr”,portNo);
                 DataInputStream frServer=new DataInputStream(sckt.getInputStream());
                 DataOutputStream toServer=new DataOutputStream(sckt.getOutputStream());
                         try{


                         //yarıçapı Server a gönderiyoruz…
                         toServer.writeUTF("istek 3");//ÖNCEKİ VERİLERİ SİL APPEND ET
                         toServer.flush();
                         File file = new File("/home/admin/sampforum/st/money.dat"); 
                         FileWriter fw = new FileWriter(file.getAbsoluteFile());
                         BufferedWriter bw = new BufferedWriter(fw);
                         bw.write("");
                         bw.close();
                         
                         for (int i = 0; i <= 100; i++) {
                             
                                 //System.out.println(fr);
                                    try {
 
                                

  

                                    // if file doesnt exists, then create it
                                    if (!file.exists()) {
                                            file.createNewFile();
                                    }

                                    FileWriter fw_ = new FileWriter(file.getAbsoluteFile(),true);
                                    BufferedWriter bw_ = new BufferedWriter(fw_);
                                    if(i==0) bw_.write("\n"+frServer.readUTF()+"\n");
                                    else bw_.write(frServer.readUTF()+"\n");
                                    bw_.close();


                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                         }
 
                         //alanı serverdan geri cilent e almak için…
                         //double area = frServer.readDouble();
                         


                         //System.out.println(istek);
                         //System.out.println(area);
                         }
                         catch(IOException ex){
                         System.err.println(ex);
                         }
                 }
                 catch(IOException e){
                 System.out.println(e.toString());
                 }
          }
        }; 

             Zamanlayici3.schedule(gorev3, 120000, 312000);  
        }   
    
    public void calis4(){
 
        TimerTask gorev4=new TimerTask() { // TimerTask ile "gorev" adlı fonksiyonu oluşturduk bundan dolayı
                                        // public void run methodu oluştu(netbeans tarafından implement edin yada siz oluşturun)
        @Override
        public void run() {
                try{
                 //Socket sckt=new Socket("localhost",21500);
                 Socket sckt = new Socket("37.187.85.209",21500);
                 //Socket sckt = new Socket(“siteadı.com.tr”,portNo);
                 DataInputStream frServer=new DataInputStream(sckt.getInputStream());
                 DataOutputStream toServer=new DataOutputStream(sckt.getOutputStream());
                         try{


                         //yarıçapı Server a gönderiyoruz…
                         toServer.writeUTF("istek 4");//ÖNCEKİ VERİLERİ SİL APPEND ET
                         toServer.flush();
                         File file = new File("/home/admin/sampforum/st/online.dat"); 
                         FileWriter fw = new FileWriter(file.getAbsoluteFile());
                         BufferedWriter bw = new BufferedWriter(fw);
                         bw.write("");
                         bw.close();
                         
                         for (int i = 0; i <= 100; i++) {
                             
                                 //System.out.println(fr);
                                    try {
 
                                

  

                                    // if file doesnt exists, then create it
                                    if (!file.exists()) {
                                            file.createNewFile();
                                    }

                                    FileWriter fw_ = new FileWriter(file.getAbsoluteFile(),true);
                                    BufferedWriter bw_ = new BufferedWriter(fw_);
                                    if(i==0) bw_.write("\n"+frServer.readUTF()+"\n");
                                    else bw_.write(frServer.readUTF()+"\n");
                                    bw_.close();


                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                         }
 
                         //alanı serverdan geri cilent e almak için…
                         //double area = frServer.readDouble();
                         


                         //System.out.println(istek);
                         //System.out.println(area);
                         }
                         catch(IOException ex){
                         System.err.println(ex);
                         }
                 }
                 catch(IOException e){
                 System.out.println(e.toString());
                 }
          }
        }; 

             Zamanlayici4.schedule(gorev4, 85000, 420000);  
        }     
}
