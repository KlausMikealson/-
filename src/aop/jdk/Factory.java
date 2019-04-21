package aop.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Factory {
  public static UserService createUserService(){
    final UserService userService = new UserServiceImpl();
    final MyAspect myAspect = new MyAspect();
    return (UserService)Proxy.newProxyInstance(
            Factory.class.getClassLoader(),
            userService.getClass().getInterfaces(),
            new InvocationHandler() {
              @Override
              public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                myAspect.before();
                Object object = method.invoke(userService, args);
                myAspect.after();
                return object;
              }
            }
    );
  }
}
