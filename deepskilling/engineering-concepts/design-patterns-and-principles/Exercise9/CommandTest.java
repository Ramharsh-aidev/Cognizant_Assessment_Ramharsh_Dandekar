public class CommandTest {
    public static void main(String[] args) {
        System.out.println("Testing Command Pattern");

        // The Receiver
        Light livingRoomLight = new Light();
        
        // The Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // The Invoker
        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
