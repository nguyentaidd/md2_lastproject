package ra.business.design;

import java.util.List;

public interface IProduct<T, E> extends IShop<T, E>{
    List<T> sort(List<T> list);
    boolean changeStatus(T t);
}
