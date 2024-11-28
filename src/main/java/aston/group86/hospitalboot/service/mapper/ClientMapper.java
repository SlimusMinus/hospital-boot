package aston.group86.hospitalboot.service.mapper;


import aston.group86.hospitalboot.entity.Client;
import aston.group86.hospitalboot.service.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Интерфейс ClientMapper для преобразования сущности Client в DTO (Data Transfer Object) и наоборот.
 * Использует библиотеку MapStruct для автоматического маппинга.
 */
@Mapper
public interface ClientMapper {
    /**
     * Экземпляр ClientMapper, создаваемый MapStruct.
     */
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    /**
     * Преобразует объект Client в объект ClientDTO.
     *
     * @param client объект Client для преобразования
     * @return объект ClientDTO, соответствующий переданному Client
     */
    ClientDTO clientToClientDTO(Client client);

    /**
     * Преобразует объект ClientDTO в объект Client.
     *
     * @param clientDTO объект ClientDTO для преобразования
     * @return объект Client, соответствующий переданному ClientDTO
     */
    Client clientDTOToClient(ClientDTO clientDTO);
}
