package Classes;

import Interfaces.iReturnOrderBehaviour;

public class OrdinaryClient extends Actor {
    /**
     * Конструктор стандартного клиента (typeId=0)
     *
     * @param name Имя клиента
     */
    public OrdinaryClient(String name) {
        super(name, 0, iReturnOrderBehaviour.isReturnOrder);
    }

    /**
     *
     * @param name Имя клиента
     * @param isReturnOrder Флаг возврата товара
     */
    public OrdinaryClient(String name, boolean isReturnOrder) {
        super(name, 0, isReturnOrder);
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

    @Override
    public int getPromoId() {
        return 0;
    }

    @Override
    public int getQuantityBuyPromoItems() {
        return 0;
    }
}
