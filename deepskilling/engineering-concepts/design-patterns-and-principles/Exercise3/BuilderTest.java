public class BuilderTest {
    public static void main(String[] args) {
        System.out.println("Testing Builder Pattern");

        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB DDR5")
                .setStorage("2TB NVMe SSD")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("8GB DDR4")
                .setStorage("512GB SSD")
                .setGraphicsCardEnabled(false)
                .setBluetoothEnabled(false)
                .build();

        System.out.println("Gaming PC Configuration:\n" + gamingPC);
        System.out.println("\nOffice PC Configuration:\n" + officePC);
    }
}
