package model;

import javafx.beans.property.SimpleStringProperty;


public class DoctorTable {

    private SimpleStringProperty name;
    private SimpleStringProperty city;
    private SimpleStringProperty price;
    private SimpleStringProperty workingHours;

    public DoctorTable(String name, String city, String price, String workingHours){
        this.name = new SimpleStringProperty(name);
        this.city = new SimpleStringProperty(city);
        this.price = new SimpleStringProperty(price);
        this.workingHours = new SimpleStringProperty(workingHours);
    }



    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCity() { return city.get(); }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) { this.city.set(city); }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getWorkingHours() { return workingHours.get(); }

    public SimpleStringProperty workingHoursProperty() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) { this.workingHours.set(workingHours); }

}
