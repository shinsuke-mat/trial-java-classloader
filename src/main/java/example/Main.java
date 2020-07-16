package example;

import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    System.out.println("[Main] Hi, this is an example class");
    System.out.println(
        "[Main] Main classloader is: " + traverseCLDelegation(Main.class));

    String s = new String("a");
    System.out.println("[Main] String classloader is: " + traverseCLDelegation(s));

    Pattern p = Pattern.compile(".");
    System.out.println("[Main] Pattern classloader is: " + traverseCLDelegation(p));

    Sub sub = new Sub();
    System.out.println("[Main] Sub classloader is: " + traverseCLDelegation(sub));
  }

  private static String traverseCLDelegation(Object o) {
    return traverseCLDelegation(o.getClass());
  }

  private static String traverseCLDelegation(Class<?> c) {
    return traverseCLDelegation(c.getClassLoader());
  }

  private static String traverseCLDelegation(ClassLoader cl) {
    if (null == cl) {
      return "null";
    }
    return cl.toString() + " -> " + traverseCLDelegation(cl.getParent());
  }
}

class Sub {
  // only used for class loading.
}