public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            // Lazy initialization
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
