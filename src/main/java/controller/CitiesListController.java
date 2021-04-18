package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import org.json.simple.parser.ParseException;
import service.JsonParser;
import javafx.scene.control.Button;



import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class CitiesListController implements Initializable {
    @FXML
    public VBox cities;
    private JsonParser jsonParser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            jsonParser = new JsonParser();
            JSONObject obj = jsonParser.parse("/datastorage/cities.json");
            JSONArray cities_list = (JSONArray) obj.get("Cities_List");

            Iterator it = cities_list.iterator();

            while (it.hasNext()) {
                String element = (String) it.next();

                Button b = new Button();
                //b.setEditable(false); //makes textfield not editable
                b.setMaxWidth(Double.MAX_VALUE);
                b.setText(element);
                b.setAlignment(Pos.CENTER);
                b.setStyle("-fx-background-color: white; -fx-background-radius: 15px; -fx-text-fill: #ff2323");
                cities.getChildren().add(b);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        for(Node i: cities.getChildren()) {
            Button b = (Button) i;
            b.setOnAction(new ChooseCityEventHandler());
        }

    }


}
