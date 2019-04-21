package aop.cglib;

public class Factory {
  public static UserServiceImpl createUserService(){
    final UserServiceImpl userService = new UserServiceImpl();
    final MyAspect myAspect = new MyAspect();

  }
}
