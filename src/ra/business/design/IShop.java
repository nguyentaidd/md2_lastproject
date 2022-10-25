package ra.business.design;

import java.util.List;
import java.util.Scanner;

public interface IShop<T, E> {
    boolean create(T t);
    boolean update (T t);
    List<T>  findAll ();
    T inputData (Scanner sc);
    void displayData (T t);
    boolean delete(E e);


}
