package DataLayer;

import bin.User;

/**
 * Created by Vahan.Bakaryan on 8/30/2016.
 */
public interface DataLayerMode {
    public void addUser(User user);
    public void getUser(String userName);
    public void deleteUser(Integer userId);
    public void editUser(User user);
}
