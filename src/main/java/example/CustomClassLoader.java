package example;

public class CustomClassLoader extends ClassLoader {

  public CustomClassLoader(final ClassLoader parent) {
    super(parent);
    System.out.println("[custom-cl] my parent: " + parent);
  }

  @Override
  protected Class<?> findClass(final String name) throws ClassNotFoundException {
    System.out.println("[custom-cl] findclass " + name);
    return super.findClass(name);
  }

  @Override
  protected Class<?> loadClass(final String name, final boolean resolve)
      throws ClassNotFoundException {
    System.out.println("[custom-cl] loadclass " + name + " (" + resolve + ")");
    return super.loadClass(name, resolve);
  }

}
