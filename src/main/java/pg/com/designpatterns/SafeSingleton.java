package pg.com.designpatterns;

public class SafeSingleton {
    // Private static instance to hold the single instance of the class
    private static volatile SafeSingleton instance;

    // Private constructor to prevent instantiation
    private SafeSingleton() {
        // To prevent instantiation through reflection
        if (instance != null) {
            throw new IllegalStateException("Cannot instantiate singleton class using reflection");
        }
    }

    // Public method to get the single instance of the class
    public static SafeSingleton getInstance() {
        // Double-check locking for thread safety
        if (instance == null) {
            synchronized (SafeSingleton.class) {
                if (instance == null) {
                    instance = new SafeSingleton();
                }
            }
        }
        return instance;
    }

    // To prevent instantiation through cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cannot clone singleton class");
    }

    // To prevent instantiation through deserialization
    protected Object readResolve() {
        return getInstance();
    }

    // Other methods and attributes of the singleton class

    public void someMethod() {
        // Implementation of methods
    }
}

