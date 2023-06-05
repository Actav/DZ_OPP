package Classes;

import Interfaces.iActorBehaviour;

public class TaxService implements iActorBehaviour {
    private String name;
    private int typeId;
    private boolean isTakeOrder, isMakeOrder;

    /**
     * Конструктор стандартного инспектора налоговой службы (typeId=996699)
     */
    public TaxService() {
        this.name = "Tax audit";
        this.typeId = 996699;
    }

    /**
     * Конструктор особого инспектора налоговой службы
     *
     * @param typeId ID типа учетной записи
     */
    public TaxService(int typeId) {
        this.name = "Tax audit";
        this.typeId = typeId;
    }

    /**
     * Получение имени клиента
     *
     * @return Имя клиента
     */
    public String getName() {
        return name;
    }

    /**
     * Получение статуса выдачи товара
     *
     * @return Флаг выдачи товара
     */
    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    /**
     * Получение статуса обработки клиента
     *
     * @return Флаг обработки клиента
     */
    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    /**
     * Изменение статуса обработки клиента
     *
     * @param makeOder Флаг обработки клиента
     */
    @Override
    public void setTakeOrder(boolean makeOder) {
        isMakeOrder = makeOder;
    }

    /**
     * Изменение статуса выдачи товара
     *
     * @param pikUpOrder Флаг выдачи товара
     */
    @Override
    public void setMakeOrder(boolean pikUpOrder) {
        isTakeOrder = pikUpOrder;
    }

    /**
     * Получения всех данных и методов клиента
     *
     * @return Объект всех данных и методов клиента
     */
    @Override
    public Actor getActor() {
        return new OrdinaryClient(name);
    }
}
