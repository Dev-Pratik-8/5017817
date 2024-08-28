package bookstore.bookstoreapi_10.mapper;

import bookstore.bookstoreapi_10.dto.BookDTO;
import bookstore.bookstoreapi_10.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toDTO(Book book);
    Book toEntity(BookDTO bookDTO);
}
