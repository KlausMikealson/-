package aop.jdk;

public class Test {
  public static void main(String[] args) {
    UserService userService = Factory.createUserService();
    userService.addUser();
    userService.updateUser();
    userService.deleteUser();
  }
}
