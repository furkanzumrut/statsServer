/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statsserver;

import com.sun.corba.se.spi.activation.Server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author furkanzumrut
 */
public class StatsServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try{
//Server soket oluşturduk.
        ServerSocket sSocket=new ServerSocket(21500);
        
        System.out.printf("Server basladi."+" " + new Date()+"\n");
        

        //bağlantı isteklerini dinlemeye aldık.
        while(true){       
        Socket sckt=sSocket.accept();
        DataInputStream inputClient=new DataInputStream(sckt.getInputStream());
        DataOutputStream outputClient=new DataOutputStream(sckt.getOutputStream());

        //Burada artık işlem yapmaya başladık
        // Clienttan girilen yarıçapı alıp alanı bulup
        //tekrar Clienta yolluyoruz. 
        

        String a = inputClient.readUTF();

        if(a.equals("istek 1")){

        System.out.println("Karakter sayisi gonderildi.\n");
        int sayi = new File("folder").listFiles().length;
        outputClient.writeUTF(String.valueOf(sayi));
        
        }
        
            if(a.equals("istek 2")){
                 System.out.println("Skor siralamasi gonderildi.\n");
            //System.out.println("Ev sayisi hesaplaniyor.");
            //System.out.println("Ev sayisi gonderildi.");
            //int sayi = new File("/home/samp/HKDeathMatch/scriptfiles/PPC_Housing").listFiles().length;
            //outputClient.writeUTF(String.valueOf(sayi));
            getScore g = new getScore();
            g.doit();   
            Map<Integer, String> getTree = new TreeMap<Integer,String>(Collections.reverseOrder());
            getTree.putAll(g.getTreeMap(g.treeMap));
            //outputClient.writeUTF(String.valueOf(getTree.size()));
                for (Map.Entry entry : getTree.entrySet()) {
                                //System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
                                outputClient.writeUTF(entry.getKey()+" "+entry.getValue());

                }
                
            

            }
            if(a.equals("istek 3")){
                System.out.println("Para siralamasi gonderildi.\n");
            //System.out.println("Ev sayisi hesaplaniyor.");
            //System.out.println("Ev sayisi gonderildi.");
            //int sayi = new File("/home/samp/HKDeathMatch/scriptfiles/PPC_Housing").listFiles().length;
            //outputClient.writeUTF(String.valueOf(sayi));
            getMoney gm = new getMoney();
            gm.doit();   
            Map<Integer, String> getTreeMoney = new TreeMap<Integer,String>(Collections.reverseOrder());
            getTreeMoney.putAll(gm.getTreeMap(gm.treeMap));
            //outputClient.writeUTF(String.valueOf(getTree.size()));
                for (Map.Entry entry : getTreeMoney.entrySet()) {
                                //System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
                                outputClient.writeUTF(entry.getKey()+" "+entry.getValue());

                }

            }
            if(a.equals("istek 4")){
            System.out.println("Online sure siralamasi gonderildi.\n");
            //System.out.println("Ev sayisi hesaplaniyor.");
            //System.out.println("Ev sayisi gonderildi.");
            //int sayi = new File("/home/samp/HKDeathMatch/scriptfiles/PPC_Housing").listFiles().length;
            //outputClient.writeUTF(String.valueOf(sayi));
            getOnlineTime go = new getOnlineTime();
            go.doit();   
            Map<Integer, String> getTreeOnline = new TreeMap<Integer,String>(Collections.reverseOrder());
            getTreeOnline.putAll(go.getTreeMap(go.treeMap));
            //outputClient.writeUTF(String.valueOf(getTree.size()));
                for (Map.Entry entry : getTreeOnline.entrySet()) {
                                //System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
                                outputClient.writeUTF(entry.getKey()+" "+entry.getValue());
                                

                }

            }               

        }
        }
        catch(IOException e){
        System.err.println(e);

        }
    
    }
}
