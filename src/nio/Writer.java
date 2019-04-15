package nio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class Writer {
  public static void main(String[] args) {
    /*File file = new File("haha.txt");
    String content = "新的内容";
    FileWriter fw = null;
    BufferedWriter bw = null;
    try{
      if(!file.exists()){
        file.createNewFile();
      }
      fw = new FileWriter(file.getAbsoluteFile(), true);
      bw = new BufferedWriter(fw);
      bw.write(content);
      bw.close();
    }catch (Exception e){
      e.printStackTrace();
    }*/

    File file = new File("haha.txt");
    String content = "新的内容";
    FileOutputStream fileOutputStream = null;
    try{
      if(!file.exists()){
        file.createNewFile();
      }
      fileOutputStream = new FileOutputStream(file);
      fileOutputStream.write(content.getBytes());
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      if(fileOutputStream!=null){
        try {
          fileOutputStream.close();
        }catch (Exception e){
          e.printStackTrace();
        }
      }
    }
  }
}
