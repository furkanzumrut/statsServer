/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statsserver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 *
 * @author furkanzumrut
 */
public class getMoney {
          Map<Integer, String> treeMap = new TreeMap<Integer,String>(Collections.reverseOrder());
//  public static void main(String args[]) {
//    NewClass ini = new NewClass();
//    ini.doit();
//    }

  public int passwordhash(String s){
      int length = s.length();
      int s1 = 1;
      int s2 = 0;
      int n;
      for(n=0;n<length;n++){
          s1 = (s1+s.charAt(n)) % 65521;
          s2 = (s2+s1) % 65521;
      }
      
      return (s2 << 16) + s1;
  }
  public String decode(String nickname){
      nickname = nickname.replace("_00", "_");
      nickname = nickname.replace("_01", ";");
      nickname = nickname.replace("_02", "!");
      nickname = nickname.replace("_03", "/");
      nickname = nickname.replace("_04", "\\");
      nickname = nickname.replace("_05", "[");
      nickname = nickname.replace("_06", "]");
      nickname = nickname.replace("_07", "?");
      nickname = nickname.replace("_08", ".");
      nickname = nickname.replace("_09", "*");
      nickname = nickname.replace("_10", "<");
      nickname = nickname.replace("_11", ">");
      nickname = nickname.replace("_12", "{");
      nickname = nickname.replace("_13", "}");
      nickname = nickname.replace("_14", " ");
      nickname = nickname.replace("_15", "\"");
      nickname = nickname.replace("_16", ":");
      nickname = nickname.replace("_17", "|");
      nickname = nickname.replace("_18", "=");
      
      return nickname;
  
  }
  public String encode(String nickname){
      nickname = nickname.replace("_", "_00");
      nickname = nickname.replace(";", "_01");
      nickname = nickname.replace("!", "_02");
      nickname = nickname.replace("/", "_03");
      nickname = nickname.replace("\\", "_04");
      nickname = nickname.replace("[", "_05");
      nickname = nickname.replace("]", "_06");
      nickname = nickname.replace("?", "_07");
      nickname = nickname.replace(".", "_08");
      nickname = nickname.replace("*", "_09");
      nickname = nickname.replace("<", "_10");
      nickname = nickname.replace(">", "_11");
      nickname = nickname.replace("{", "_12");
      nickname = nickname.replace("}", "_13");
      nickname = nickname.replace(" ", "_14");
      nickname = nickname.replace("\"", "_15");
      nickname = nickname.replace(":", "_16");
      nickname = nickname.replace("|", "_17");
      nickname = nickname.replace("=", "_18");
      
      return nickname;
  
  }
  public void printMap(Map<Integer, String> map) {
		for (Map.Entry entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : "
				+ entry.getValue());
		}
 }
  	private Map sortByComparator(Map unsortMap) {
 
		List list = new LinkedList(unsortMap.entrySet());
 
		// sort list based on comparator
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue())
                                       .compareTo(((Map.Entry) (o1)).getValue());
			}
		});
 
		// put sorted list into map again
                //LinkedHashMap make sure order in which keys were inserted
		Map sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
  public Map<Integer, String> getTreeMap(Map<Integer, String> treeMap){
      this.treeMap = treeMap;
      return treeMap;
  }
  public void doit() {
    try{
        String path = "/home/samp/HKDeathMatch/scriptfiles/SFCRRPG/"; 
 
        String files;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles(); 


      Map<Integer,String> userMap = new HashMap();
      Properties p = new Properties();
           for (int i = 0; i < listOfFiles.length; i++) 
          {

           if (listOfFiles[i].isFile()) 
           {
            files = listOfFiles[i].getName();
             if (files.endsWith(".dudb.sav"))
             {
                String nickname = files.replace(".dudb.sav", "");
                p.load(new FileInputStream(String.format("/home/samp/HKDeathMatch/scriptfiles/SFCRRPG/%s.dudb.sav", nickname)));
                userMap.put(Integer.parseInt(p.getProperty("Money"))+Integer.parseInt(p.getProperty("Bankcash")), decode(nickname));
                //System.out.println(nickname+" "+p.getProperty("Score"));
                
              }
              }
          }     


      
 

      treeMap.putAll(userMap);
      
 
      
      //System.out.println(p.getProperty("Money"));
      //System.out.println(p.getProperty("toplamsoygun"));
      //System.out.println(p.getProperty("toplamtutuklama"));
      //p.list(System.out);
      }
    catch (Exception e) {
      System.out.println(e);
      }

        
    }


}
