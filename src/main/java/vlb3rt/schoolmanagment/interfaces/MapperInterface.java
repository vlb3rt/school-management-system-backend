package vlb3rt.schoolmanagment.interfaces;

import java.util.List;

public interface MapperInterface <T extends EntityInterface, U extends ResponseInterface, W extends ResponsesInterface> {

    T toEntityMapper(U u);

    U toResponseMapper(T t);

    W toResponseListMapper(List<T> t);
}
