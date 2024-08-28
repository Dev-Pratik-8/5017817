package bookstore.bookstoreapi_9.mapper;

import bookstore.bookstoreapi_9.dto.CustomerDTO;
import bookstore.bookstoreapi_9.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO toDTO(Customer customer);

    Customer toEntity(CustomerDTO customerDTO);
}
