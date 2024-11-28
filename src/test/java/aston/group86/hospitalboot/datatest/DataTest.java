package aston.group86.hospitalboot.datatest;


import aston.group86.hospitalboot.entity.Client;
import aston.group86.hospitalboot.entity.Doctor;
import aston.group86.hospitalboot.entity.Sick;
import aston.group86.hospitalboot.service.dto.ClientDTO;
import aston.group86.hospitalboot.service.dto.DoctorDTO;

public class DataTest {
    public static final Doctor DOCTOR_1 = new Doctor("John", "Doe", 54, "Cardiologist");
    public static final Client CLIENT_1 = new Client("John", "Doe", 25);
    public static final ClientDTO CLIENT_DTO = new ClientDTO("John", "Doe", 25);
    public static final DoctorDTO DOCTOR_DTO = new DoctorDTO("John", "Doe", 54, "Cardiologist");
    public static final Sick SICK_1 = new Sick("Flu", "First");
}
