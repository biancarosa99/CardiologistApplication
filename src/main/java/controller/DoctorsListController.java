package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.City;
import model.DoctorTable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import service.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DoctorsListController {

    @FXML
    public TableView<DoctorTable> table;
    public javafx.scene.control.TableColumn<DoctorTable, String> prName;
    public javafx.scene.control.TableColumn<DoctorTable, String> prCity;
    public javafx.scene.control.TableColumn<DoctorTable, String> prPrice;
    public javafx.scene.control.TableColumn<DoctorTable, String> prWorkingHours;
    public TableColumn prConfirm;

    List<DoctorTable> doctorList = new ArrayList<>();

    private JsonParser jsonParser;

    public void goBack(ActionEvent event) throws IOException {

       Parent view = FXMLLoader.load(getClass().getClassLoader().getResource("view/CitiesList.fxml"));
       Scene view2 = new Scene(view);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(view2);
        window.show();

    }

    public void init()
    {
        try {
            jsonParser = new JsonParser();
            org.json.simple.JSONObject obj = jsonParser.parse("/datastorage/doctor.json");
            JSONArray doctors = (JSONArray) obj.get("");

            Iterator<Object> it = doctors.iterator();

            List<DoctorTable> prList = new ArrayList<DoctorTable>();
            while (it.hasNext()) {
                JSONObject getDoctor = (JSONObject) it.next();
                prList.add(new DoctorTable(getDoctor.get("name").toString(), (String) getDoctor.get("city"), getDoctor.get("price").toString(), getDoctor.get("workingHours").toString()));
            }

            ObservableList<DoctorTable> data = FXCollections.observableArrayList(prList);
            table.setEditable(true);
            prName.setCellValueFactory(new PropertyValueFactory<>("name"));
            prCity.setCellValueFactory(new PropertyValueFactory<>("city"));
            prPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            prWorkingHours.setCellValueFactory(new PropertyValueFactory<>("workingHours"));
            prConfirm.setCellValueFactory(new PropertyValueFactory<>(""));

            Callback<TableColumn<DoctorTable, String>, TableCell<DoctorTable, String>> cellFactory =  new Callback <TableColumn<DoctorTable, String>,TableCell<DoctorTable, String>>() {
                @Override
                public TableCell<DoctorTable, String> call(TableColumn<DoctorTable, String> productStringTableColumn) {
                    final TableCell<DoctorTable, String> cell = new TableCell<DoctorTable, String>() {

                        final Button btn = new Button("Confirm");

                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                                setText(null);
                            } else{

                                btn.setOnAction(event -> {
                                    DoctorTable selectedDoctor= getTableView().getItems().get(getIndex());
                                    DoctorTable doctor = new DoctorTable("","","","");
                                    doctor.setName(selectedDoctor.getName());
                                    doctor.setCity(selectedDoctor.getCity());
                                    doctor.setPrice(selectedDoctor.getPrice());
                                    doctor.setWorkingHours(selectedDoctor.getWorkingHours());
                                    doctorList.add(doctor);

                                });
                                setGraphic(btn);
                                btn.setStyle("-fx-background-color: papayawhip; -fx-background-radius: 15;");
                                btn.setAlignment(Pos.CENTER);
                                setText(null);
                            }
                        }
                    };
                    return cell;
                }
            };


            prConfirm.setCellFactory(cellFactory);
            table.setItems(data);

        }catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}
