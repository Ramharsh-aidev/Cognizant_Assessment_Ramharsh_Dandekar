interface Playable {
    void play();
}

class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Strumming the guitar...");
    }
}

class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Playing the piano keys...");
    }
}

public class InterfaceImplementation {
    public static void main(String[] args) {
        Playable myGuitar = new Guitar();
        Playable myPiano = new Piano();
        
        myGuitar.play();
        myPiano.play();
    }
}
