package service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ConfirmAppointment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AppointmentService {
    public static void addAppointment(ConfirmAppointment appointment) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file=new File("D:Project_SEF/CardiologistApplication/src/main/resources/datastorage/appointments.json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, appointment);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
