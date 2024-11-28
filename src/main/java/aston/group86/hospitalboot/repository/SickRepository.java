package aston.group86.hospitalboot.repository;

import aston.group86.hospitalboot.entity.Sick;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SickRepository extends JpaRepository<Sick, Long> {

}