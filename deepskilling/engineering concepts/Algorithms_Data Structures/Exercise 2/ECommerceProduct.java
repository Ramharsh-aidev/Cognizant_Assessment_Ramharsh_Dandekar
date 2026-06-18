public class ECommerceProduct implements Comparable<ECommerceProduct> {
    private String productId;
    private String productName;
    private String category;

    public ECommerceProduct(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int compareTo(ECommerceProduct other) {
        return this.productId.compareTo(other.productId);
    }

    @Override
    public String toString() {
        return "ECommerceProduct{" +
                "id='" + productId + '\'' +
                ", name='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
