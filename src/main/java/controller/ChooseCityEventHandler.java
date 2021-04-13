package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

public class ChooseCityEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

       /* try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/ShopView.fxml"));
            Parent view = loader.load();
            Scene view2 = new Scene(view);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(view2);
            ShopPageController controller = loader.getController();
            Shop shop = new Shop();
            shop.setShopName(((Button)event.getTarget()).getText());
            controller.init(shop);

            window.show();
        } catch (IOException ex){
            ex.printStackTrace();
        }*/
    }
}
