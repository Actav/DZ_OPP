package Classes;

public class SpecialClient extends Actor {
    /**
     * @param name   Имя клиента
     * @param typeId ID типа учетной записи
     */
    public SpecialClient(String name, int typeId) {
        super(name, typeId);
    }

    /**
     * @param name          Имя клиента
     * @param typeId        ID типа учетной записи
     * @param isReturnOrder Флаг возврата товара
     */
    public SpecialClient(String name, int typeId, boolean isReturnOrder) {
        super(name, typeId, isReturnOrder);
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
     * Изменение статуса выдачи товара
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

    @Override
    public int getPromoId() {
        return 0;
    }

    @Override
    public int getQuantityBuyPromoItems() {
        return 0;
    }
}
