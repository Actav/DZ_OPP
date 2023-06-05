import Classes.*;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // Список акций
        List<Promo> promoList = new ArrayList<>();
        {
            promoList.add(new Promo(1, "Скидка 10%", 150));
            promoList.add(new Promo(2, "Скидка 90%", 2));
        }

        // Список клиентов
        List<Actor> clientList = new ArrayList<>();
        {
            clientList.add(new OrdinaryClient("OrdinaryClient1"));
            clientList.add(new OrdinaryClient("OrdinaryClient2", true));

            clientList.add(new SpecialClient("SpecialClient_VIP1", 2));
            clientList.add(new SpecialClient("SpecialClient_VIP2", 2, true));

            clientList.add(new CherryPickerClient("CherryPicker1", 10, 1, 1));
            clientList.add(new CherryPickerClient("CherryPicker2", 10, 2, 2));
            clientList.add(new CherryPickerClient("CherryPicker3", 10, 2, 1));
            clientList.add(new CherryPickerClient("CherryPicker4", 10, 2, 1, true));
            clientList.add(new CherryPickerClient("CherryPicker5", 10, 2, 1));
        }

        // Запустим магазин
        Market market = new Market();
        market.initPromos(promoList);
        market.addPromo(new Promo(3, "Скидка 50%", 1));
        market.removePromo(999);

        for (Actor client : clientList) {
            market.acceptToMarket(client);
        }
        market.acceptToMarket(new TaxService());

        market.update();
    }
}
