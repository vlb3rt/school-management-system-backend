package vlb3rt.schoolmanagment.interfaces;

import vlb3rt.schoolmanagment.responses.exceptions.EntityException;

import java.util.List;

public interface MapperInterface <T extends EntityInterface, U extends ResponseInterface, W extends ResponsesInterface> {

    T toEntityMapper(U u) throws EntityException;

    U toResponseMapper(T t);

    W toResponseListMapper(List<T> t);
}
