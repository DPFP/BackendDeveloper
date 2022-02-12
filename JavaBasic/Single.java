package JavaBasic;

public class Single {
    private Single() {
    }

    private static Single instance;

    private static Single getInstance() {
        if (instance == null) {
            synchronized (Single.class) {
                if (instance == null) {
                    instance = new Single();
                }
            }
        }

        return instance;
    }
}
