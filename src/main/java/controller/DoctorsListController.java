package controller;


import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.Doctor;
import model.DoctorTable;
import org.json.JSONArray;
import org.json.JSONObject;
import service.JsonParser;

import javax.swing.table.TableColumn;
import java.io.IOException;
import java.text.ParseException;
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


    private JsonParser jsonParser;

    public void init(Doctor doctor)
    {
        try {
            jsonParser = new JsonParser();
            org.json.simple.JSONObject obj = jsonParser.parse("/datastorage/doctors.json");
            JSONArray doctors = (JSONArray) obj.get("");

            Iterator<Object> it = doctors.iterator();


            List<DoctorTable> prList = new ArrayList<DoctorTable>();
            while(it.hasNext()){
                JSONObject getDoctor = (JSONObject) it.next();
                prList.add(new DoctorTable(getDoctor.get("name").toString(), (String) getDoctor.get("city"), getDoctor.get("price").toString(), getDoctor.get("workingHours").toString()) );
            }
        }catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }

}
