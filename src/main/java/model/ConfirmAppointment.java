package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class ConfirmAppointment {
    private String doctorName;
    private List<Appointment> appointmentList=new ArrayList<Appointment>();

    public ConfirmAppointment() {}

    public ConfirmAppointment(Text doctorName, List<Appointment> appointmentList) {
        this.doctorName=doctorName.getText();
        this.appointmentList.addAll(appointmentList);
    }

    public String getDoctorName() {
        return this.doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public List<Appointment> getAppointmentList() {
        return this.appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    /*public boolean equals(Object object) {
        if(object==this)
            return true;

        if(!(object instanceof Order))
            return false;

        Order order=(Order) object;
        return this.shopName.equals(order.shopName) && this.productList.equals(order.productList);
    }*/


}
