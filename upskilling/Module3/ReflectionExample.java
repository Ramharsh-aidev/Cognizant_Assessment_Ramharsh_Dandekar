import java.lang.reflect.Method;

class DummyClass {
    public void printMessage(String msg) {
        System.out.println("DummyClass executed and says: " + msg);
    }
}

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Load class
            Class<?> clazz = Class.forName("DummyClass");
            
            // Instantiate dynamically
            Object instance = clazz.getDeclaredConstructor().newInstance();
            
            // Get all methods
            Method[] methods = clazz.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println("Found method via Reflection: " + m.getName());
                
                // Invoke specific method
                if (m.getName().equals("printMessage")) {
                    m.invoke(instance, "Invoked dynamically via Reflection API!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
