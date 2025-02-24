package aston.group86.hospitalboot.repository;

import aston.group86.hospitalboot.entity.Doctor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

  List<Doctor> findByStatus(String status);

}