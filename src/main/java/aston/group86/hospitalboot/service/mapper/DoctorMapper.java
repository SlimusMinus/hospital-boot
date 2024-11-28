package aston.group86.hospitalboot.service.mapper;


import aston.group86.hospitalboot.entity.Doctor;
import aston.group86.hospitalboot.service.dto.DoctorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Интерфейс DoctorMapper для преобразования сущности Doctor в DTO (Data Transfer Object) и наоборот.
 * Использует библиотеку MapStruct для автоматического маппинга.
 */
@Mapper
public interface DoctorMapper {
    /**
     * Экземпляр DoctorMapper, создаваемый MapStruct.
     */
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    /**
     * Преобразует объект Doctor в объект DoctorDTO.
     *
     * @param doctor объект Doctor для преобразования
     * @return объект DoctorDTO, соответствующий переданному Doctor
     */
    DoctorDTO toDoctorDTO(Doctor doctor);

    /**
     * Преобразует объект DoctorDTO в объект Doctor.
     *
     * @param doctorDTO объект DoctorDTO для преобразования
     * @return объект Doctor, соответствующий переданному DoctorDTO
     */
    Doctor toDoctor(DoctorDTO doctorDTO);
}
