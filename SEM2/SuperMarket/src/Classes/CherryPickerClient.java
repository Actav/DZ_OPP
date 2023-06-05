package Classes;

public class CherryPickerClient extends Actor {
    private int promoId;
    private int quantityBuyPromoItems;

    /**
     * Конструктор клиента "охотника" за скидками
     *
     * @param name Имя клиента
     * @param typeId ID типа учетной записи
     * @param promoId ID промо-акции
     * @param quantityBuyPromoItems Количество применения промо клиентом
     */
    public CherryPickerClient(String name, int typeId, int promoId, int quantityBuyPromoItems) {
        super(name, typeId);
        this.promoId = promoId;
        this.quantityBuyPromoItems = quantityBuyPromoItems;
    }

    /**
     * Конструктор клиента охотника за скидками
     *
     * @param name Имя клиента
     * @param typeId ID типа учетной записи
     * @param promoId ID промо-акции
     * @param quantityBuyPromoItems Количество возращения промо клиентом
     * @param isReturnOrder Флаг возврата товара
     */
    public CherryPickerClient(String name, int typeId,int promoId, int quantityBuyPromoItems,  boolean isReturnOrder) {
        super(name, typeId, isReturnOrder);
        this.promoId = promoId;
        this.quantityBuyPromoItems = quantityBuyPromoItems;
    }

    /**
     * Получение имени клиента
     *
     * @return Имя клиента
     */
    @Override
    public String getName() {
        return super.name;
    }

    /**
     * Получение ID промо-акции/промо-товара
     *
     * @return ID промо-акции/промо-товара
     */
    public int getPromoId() {
        return this.promoId;
    }

    /**
     * Получение количества используемых промо-акций/промо-товаров
     *
     * @return количества используемых промо-акций/промо-товаров
     */
    public int getQuantityBuyPromoItems() {
        return this.quantityBuyPromoItems;
    }

    /**
     * Получение статуса выдачи товара
     *
     * @return Флаг выдачи товара
     */
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    /**
     * Получение статуса обработки клиента
     *
     * @return Флаг обработки клиента
     */
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    /**
     * Получение статуса намеренья возврата товара клиентом
     *
     * @return Флаг намеренья возврата товара
     */
    public boolean isReturnOrder() {
        return super.isReturnOrder;
    }

    /**
     * Изменение статуса обработки клиента
     *
     * @param makeOder Флаг обработки клиента
     */
    public void setTakeOrder(boolean makeOder) {
        super.isMakeOrder = makeOder;
    }

    /**
     *  Изменение статуса выдачи товара
     *
     * @param pikUpOrder Флаг выдачи товара
     */
    public void setMakeOrder(boolean pikUpOrder) {
        super.isTakeOrder = pikUpOrder;
    }

    /**
     * Изменение статуса возврата товара
     *
     * @param returnOrder Флаг возврата товара
     */
    public void setReturnOrder(boolean returnOrder) {
        super.isReturnOrder = returnOrder;
    }

    /**
     * Получения всех данных и методов клиента
     *
     * @return Объект всех данных и методов клиента
     */
    public Actor getActor() {
        return this;
    }
}
