package Classes;

import Interfaces.iActorBehaviour;
import Interfaces.iCherryPickerBehaviour;
import Interfaces.iReturnOrderBehaviour;

public abstract class Actor implements iActorBehaviour, iReturnOrderBehaviour, iCherryPickerBehaviour {
    protected String name;
    protected int typeId;
    protected boolean isMakeOrder, isTakeOrder, isReturnOrder;

    /**
     * @return ID типа учетной записи
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * Конструктор Клиента
     *
     * @param name   Имя клиента
     * @param typeId ID типа учетной записи
     */
    public Actor(String name, int typeId) {
        this.name = name;
        this.typeId = typeId;
        this.isReturnOrder = iReturnOrderBehaviour.isReturnOrder;
    }

    /**
     * @param name          Имя клиента
     * @param typeId        ID типа учетной записи
     * @param isReturnOrder Флаг возврата товара
     */
    public Actor(String name, int typeId, boolean isReturnOrder) {
        this.name = name;
        this.typeId = typeId;
        this.isReturnOrder = isReturnOrder;
    }

    /**
     * @return Имя клиента
     */
    abstract public String getName();
}
