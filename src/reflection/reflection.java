package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射：在运行状态中，对于任意一个类，都能够获取到这个类的所有属性和方法，
 *       对于任意一个对象，都能够调用它的任意一个方法和属性（包括私有方法和属性），
 *       这种动态获取信息以及动态调用对象的方法的功能就称为java的反射机制。
 */
public class reflection {
  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
    Person person = new Person();
    // 获得字节码对象的三种方式
    Class class1 = Class.forName("reflection.Person");
    Class class2 = Person.class;
    Class class3 = person.getClass();

    // 无参构造函数创建实例对象
    Person person1 = (Person) class1.newInstance();
    // 指定有参构造函数创建对象
    Constructor constructor = class1.getConstructor(String.class, int.class);
    Person person2 = (Person) constructor.newInstance("张慧",18);

    // 获取全部构造方法
    Constructor[] constructors = class1.getConstructors();
    for(Constructor c : constructors){
      Class[] parameterTypes = c.getParameterTypes();
      for(Class cc : parameterTypes){
        System.out.print(cc.getName()+" ");
      }
      System.out.println();
    }

    // 获取指定成员变量并设值
    Person person3 = (Person) class1.newInstance();
    Field field = class1.getDeclaredField("age");
    field.setAccessible(true);
    field.setInt(person3, 20);
    System.out.println(field.getInt(person3));

    // 获取方法并使用
    Method method = class1.getMethod("haha");
    method.invoke(person3);

    // 利用反射机制将 String 类型对象存入 ArrayList<Integer>
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    Class class4 = list.getClass();
    Method method1 = class4.getMethod("add", Object.class);
    method1.invoke(list, "haha");
    System.out.println(list);
  }
}
