package Domen;

public class Bottle extends Product {
    private int volume;

    public Bottle(int productId, String productName, String productCategory, double price, int volume) throws Exception {
        super(productId, productName, productCategory, price);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "name='" + super.getProductName() + '\'' +
                "category='" + super.getProductCategory() + '\'' +
                ", cost=" + super.getPrice() +
                ", volume=" + volume +
                '}';
    }
}