import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Thesaurus {
  // 读取同义词6w行应该够用
  // 并且自己可以在同义词文件中添加同义词组
  public  List<Map<String,String>> thesaurus(String fileName) throws IOException {
    List<Map<String,String>> thesaurus=new ArrayList<Map<String,String>>();
    Map<String,String> thesaurusLeftMap=new HashMap<String,String>();
    Map<String,String> thesaurusRightMap=new HashMap<String,String>();
    File file = new File(fileName);
    //读取文件
    InputStreamReader read = new InputStreamReader(new FileInputStream(file),"GBK");
    // 文件流是否存在
    if(file.isFile() && file.exists()){
      String line = null;
      @SuppressWarnings("resource")
      BufferedReader bufferedReader = new BufferedReader(read);
      while((line = bufferedReader.readLine()) != null){
        // new String(line.getBytes("UTF-8"),"utf-8").split("=");
        String [] arr=line.split("=");
        if(arr.length==2) {
          // 将词组存入一张Hash表
          thesaurusLeftMap.put(arr[0], arr[1]);
          thesaurusRightMap.put(arr[1], arr[0]);
        }
      }
    }
    else{
      //抛出异常
      System.out.println("文件路径有误！");
    }
    read.close();
    thesaurus.add(thesaurusLeftMap);
    thesaurus.add(thesaurusRightMap);
    return  thesaurus;
  }



}
