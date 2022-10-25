package ra.business.design;

public interface IFlowerType<T,E> extends IShop<T,E> {
    boolean searchByNameOrId(String name,String id);
}
