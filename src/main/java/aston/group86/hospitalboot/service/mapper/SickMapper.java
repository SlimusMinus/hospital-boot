package aston.group86.hospitalboot.service.mapper;


import aston.group86.hospitalboot.entity.Sick;
import aston.group86.hospitalboot.service.dto.SickDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SickMapper {

    SickMapper INSTANCE = Mappers.getMapper(SickMapper.class);

    SickDTO sickToSickDTO(Sick sick);

    SickDTO sickDTOtoSick(SickDTO sickDTO);
}
