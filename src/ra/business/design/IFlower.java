package ra.business.design;

public interface IFlower<T, E> extends IShop<T, E>{
    boolean searchByNameOrPrice(String str,Float price);


}
