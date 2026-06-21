public class Calculator {
    private int memory;

    public Calculator() {
        this.memory = 0;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public void saveToMemory(int value) {
        this.memory = value;
    }

    public int getMemory() {
        return this.memory;
    }

    public void clearMemory() {
        this.memory = 0;
    }
}
