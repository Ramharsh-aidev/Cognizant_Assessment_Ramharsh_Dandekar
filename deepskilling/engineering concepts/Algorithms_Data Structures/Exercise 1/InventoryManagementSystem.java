import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private Map<String, InventoryProduct> inventory;

    public InventoryManagementSystem() {
        this.inventory = new HashMap<>();
    }

    // Add Product
    public void addProduct(InventoryProduct product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Error: Product with ID " + product.getProductId() + " already exists.");
        } else {
            inventory.put(product.getProductId(), product);
            System.out.println("Successfully added: " + product.getProductName());
        }
    }

    // Update Product
    public void updateProduct(String productId, String newName, Integer newQuantity, Double newPrice) {
        if (inventory.containsKey(productId)) {
            InventoryProduct product = inventory.get(productId);
            if (newName != null) {
                product.setProductName(newName);
            }
            if (newQuantity != null) {
                product.setQuantity(newQuantity);
            }
            if (newPrice != null) {
                product.setPrice(newPrice);
            }
            System.out.println("Successfully updated Product ID: " + productId);
        } else {
            System.out.println("Error: Product ID " + productId + " not found.");
        }
    }

    // Delete Product
    public void deleteProduct(String productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Successfully deleted Product ID: " + productId);
        } else {
            System.out.println("Error: Product ID " + productId + " not found.");
        }
    }

    // Display Inventory
    public void displayInventory() {
        System.out.println("\n--- Current Inventory ---");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (InventoryProduct product : inventory.values()) {
                System.out.println(product);
            }
        }
        System.out.println("-------------------------\n");
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Testing the implementation
        InventoryProduct p1 = new InventoryProduct("P001", "Gaming Laptop", 15, 1499.99);
        InventoryProduct p2 = new InventoryProduct("P002", "Wireless Mouse", 50, 29.99);

        // Add
        ims.addProduct(p1);
        ims.addProduct(p2);
        ims.displayInventory();

        // Update
        ims.updateProduct("P001", null, 12, null);
        ims.displayInventory();

        // Delete
        ims.deleteProduct("P002");
        ims.displayInventory();
    }
}
