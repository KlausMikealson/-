package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class FileChannel {
  public static void main(String[] args) throws IOException {
    RandomAccessFile randomAccessFile = new RandomAccessFile("haha.txt","rw");
    System.out.println(randomAccessFile.length());
    java.nio.channels.FileChannel fileChannel = randomAccessFile.getChannel();
    ByteBuffer byteBuffer = ByteBuffer.allocate(48);
    int byteRead = fileChannel.read(byteBuffer);
    while(byteRead != -1){
      System.out.println("Read "+byteRead);
      byteBuffer.flip();
      while(byteBuffer.hasRemaining()){
        System.out.println((char)byteBuffer.get());
      }
      byteBuffer.clear();
      byteRead = fileChannel.read(byteBuffer);
    }
    randomAccessFile.close();
  }
}
