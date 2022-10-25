package ra.business.design;
import java.util.List;

public interface Icatalog<T, E> extends IShop<T, E>{
   void searchByName (String name);
}
