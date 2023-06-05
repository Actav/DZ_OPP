package Classes;

public class Promo {
    private int id;
    private String name;
    private int quantity;

    /**
     * Конструктор промо акции
     *
     * @param promoId ID промо-акции
     * @param promoName Название промо-акции
     * @param quantity Количество предоставляемых промо-акций/промо-товаров
     */
    public Promo(int promoId, String promoName, int quantity) {
        this.id = promoId;
        this.quantity = quantity;
        this.name = promoName;
    }

    /**
     * Получение ID промо-акции
     * 
     * @return ID промо-акции
     */
    public int getId() {
        return id;
    }

    /**
     * Получение количества промо-акции/промо-товара
     * 
     * @return Количество промо-акции/промо-товара
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Получение названия промо-акции/промо-товара
     * 
     * @return название промо-акции/промо-товара
     */
    public String getName() {
        return name;
    }

    /**
     * Получение всех данных и методов промо-акции/промо-товара
     * 
     * @return Объект всех данных и методов промо-акции/промо-товара
     */
    public Promo getPromo() {
        return this;
    }

    /**
     * Установка количества промо-акции/промо-товара
     * 
     * @param quantity количество промо-акции/промо-товара
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Уменьшение количества промо-акции/промо-товара
     *
     * @param quantity количество промо-акции/промо-товара
     */
    public void downQuantity(int quantity) {
        this.quantity -= quantity;
    }

    /**
     * Увеличение количества промо-акции/промо-товара
     *
     * @param quantity количество промо-акции/промо-товара
     */
   public void upQuantity(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        return "Promo{" +
                "id=" + id +
                ", promoName='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
