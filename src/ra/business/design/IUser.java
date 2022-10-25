package ra.business.design;

import ra.business.entity.User;

import java.util.List;

public interface IUser<T, E> extends IShop<T, E>{
    List<User> searchByName(String str);
}
