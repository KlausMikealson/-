package nio;

import java.io.File;

public class Test {
  public static void main(String[] args) {
    File file = new File("haha.txt");
    System.out.println(file.exists());
    System.out.println(file.length());
  }
}
