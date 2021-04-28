package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Callback;
import model.Appointment;
import model.ConfirmAppointment;
import model.DoctorsName;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import service.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ViewDoctorAppointmentsController {

    @FXML
    public Text currentDoctor;
    public TableView<Appointment> table;
    public javafx.scene.control.TableColumn<Appointment, String> prDate;
    public javafx.scene.control.TableColumn<Appointment, String> prHour;


    private JsonParser jsonParser;

    public void init(Appointment appointment)
    {
        //currentDoctor.setText(doctorsName.getDoctorsName());
        try {
            DoctorsName doctorsName=new DoctorsName();
            jsonParser = new JsonParser();
            org.json.simple.JSONObject obj = jsonParser.parse("/datastorage/appointments.json");
            JSONArray doctors = (JSONArray) obj.get("appointmentList");

            Iterator<Object> it = doctors.iterator();

            List<Appointment> prList = new ArrayList<Appointment>();

            while (it.hasNext()) {
                JSONObject getDoctorSchedule = (JSONObject) it.next();
                prList.add(new Appointment(getDoctorSchedule.get("date").toString(), (String) getDoctorSchedule.get("hour")));

            }

            ObservableList<Appointment> data = FXCollections.observableArrayList(prList);
            table.setEditable(true);
            prDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            prHour.setCellValueFactory(new PropertyValueFactory<>("hour"));



           // table.setEditable(true);
            table.setItems(data);
            table.setEditable(true);

        }catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
