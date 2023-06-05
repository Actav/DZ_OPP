package Classes;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import Interfaces.iActorBehaviour;
import Interfaces.iMarketBehaviour;
import Interfaces.iQueueBehaviour;

public class Market implements iMarketBehaviour, iQueueBehaviour {
    private final List<iActorBehaviour> queue;
    private final HashMap<Integer, Promo> promoList;

    /**
     * Конструктор магазина
     */
    public Market() {
        this.promoList = new HashMap<>();
        this.queue = new ArrayList<>();
    }

    /**
     * Метод прихода клиента в магазин
     *
     * @param actor объект данных клиента
     */
    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        Logger.writeToLog(actor.getActor().getName() + " клиент ПРИШЕЛ в магазин ");
        takeInQueue(actor);
    }

    /**
     * Метод постановки клиента в очередь
     *
     * @param actor объект данных клиента
     */
    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        Logger.writeToLog(actor.getActor().getName() + " клиент ДОБАВЛЕН в очередь ");
    }

    /**
     * Метод прихода клиента в магазин
     *
     * @param actors список клиентов
     */
    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            queue.remove(actor);
            Logger.writeToLog(actor.getName() + " клиент УШЁЛ из магазина ");
        }
    }

    /**
     * Обновление состояние магазина
     */
    @Override
    public void update() {
        takeOrder();
        giveOrder();
        releaseFromQueue();
        Logger.flushBuffer();
    }

    /**
     * Метод получения клиентом товара
     */
    @Override
    public void giveOrder() {
        for (iActorBehaviour actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                Logger.writeToLog(actor.getActor().getName() + " клиент ПОЛУЧИЛ свой заказ ");
            }
        }

    }

    /**
     * Метод изъятия клиента из очереди после обработки
     */
    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (iActorBehaviour actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor.getActor());
                Logger.writeToLog(actor.getActor().getName() + " клиент ИЗЪЯТ из очереди ");
            }
        }
        releaseFromMarket(releaseActors);
    }

    /**
     * Метод обработки заказа/возврата товара клиента
     */
    @Override
    public void takeOrder() {
        for (iActorBehaviour actor : queue) {
            if (!actor.isMakeOrder()) {
                Actor client = actor.getActor();
                int typeId = client.getTypeId();
                String clientName = client.getName();

                if (!client.isReturnOrder()) {
                    if (typeId == 0) {
                        Logger.writeToLog(clientName + " клиент СДЕЛАЛ заказ ");
                    } else if (typeId == 2) {
                        Logger.writeToLog(clientName + " VIP клиент СДЕЛАЛ заказ со скидкой 15%");
                    } else if (typeId == 10) {
                        int promoId = client.getPromoId();
                        int quantityClient = client.getQuantityBuyPromoItems();
                        int quantityPromo = this.promoList.get(promoId).getQuantity();

                        if (quantityClient < quantityPromo) {
                            String promoName = this.promoList.get(promoId).getName();
                            Logger.writeToLog(clientName + " клиент СДЕЛАЛ заказ по акции \"" + promoName + "\"");
                            this.promoList.get(promoId).downQuantity(quantityClient);
                        } else {
                            Logger.writeToLog(clientName + " клиент НЕ СДЕЛАЛ заказ, акционного товара нет");
                        }
                    }
                } else {
                    if (typeId == 10) {
                        int promoId = client.getPromoId();
                        int quantityClient = client.getQuantityBuyPromoItems();
                        this.promoList.get(promoId).upQuantity(quantityClient);
                        String promoName = this.promoList.get(promoId).getName();

                        Logger.writeToLog(client.getName() + " клиент ВЕРНУЛ заказ по акции \"" + promoName + "\"");
                    } else {
                        Logger.writeToLog(client.getName() + " клиент ВЕРНУЛ заказ ");
                    }
                }

                actor.setMakeOrder(true);
            }
        }
    }

    /**
     * Инициализации списка промо-акций/промо-товаров
     *
     * @param promoList Список промо-акций/промо-товаров
     */
    public void initPromos(List<Promo> promoList) {
        for (Promo promo : promoList) {
            this.promoList.put(promo.getId(), promo);
        }
    }

    /**
     * Добавленик промо-акции/промо-товара
     *
     * @param promo Объект промо-акции/промо-товара
     */
    public boolean addPromo(Promo promo) {
        int id = promo.getId();
        this.promoList.put(id, promo);

        return this.promoList.containsKey(id);
    }

    /**
     * Удаление промо-акции/промо-товара
     *
     * @param promoId ID промо-акции/промо-товара
     */
    public boolean removePromo(int promoId) {
        this.promoList.remove(promoId);

        return !this.promoList.containsKey(promoId);
    }
}
