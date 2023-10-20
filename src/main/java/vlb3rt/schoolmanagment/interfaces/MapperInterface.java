package vlb3rt.schoolmanagment.interfaces;

import java.util.List;

public interface MapperInterface<E extends EntityInterface, C extends CDMInterface> {

    E toEntityMapper(C c);

    C toCDMMapper(E e);

    List<E> toEntityListMapper(List<C> c);

    List<C> toCDMListMapper(List<E> e);
}
