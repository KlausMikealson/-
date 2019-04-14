package concurrent;

public class singleton {
  private static class Inner{
    private static singleton s = new singleton();
  }
  public static singleton getInstance(){
    return Inner.s;
  }

  public static void main(String[] args) {
    singleton s = singleton.getInstance();
  }
}
