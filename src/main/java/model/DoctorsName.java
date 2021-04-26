package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DoctorsName {
    private StringProperty doctorsName = new SimpleStringProperty("");;

    public String getDoctorsName() { return doctorsName.get(); }

    public StringProperty doctorNameProperty() { return doctorsName; }

    public void setDoctorName(String doctorsName) { this.doctorsName.set(doctorsName); }
}
