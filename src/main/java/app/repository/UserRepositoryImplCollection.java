package app.repository;

import app.domain.User;
import app.service.outputports.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImplCollection implements UserRepository {

    List<User> users = new ArrayList<>();


    @Override
    public User save(User user) {

        if (selectById(user.getId()) != null) {
            System.out.println("Error: ya existe un usuario con ID: " + user.getId());
            return null;
        }

        /*
        users.add(String.valueOf(user.getId()));
        users.add(user.getName());
        users.add(user.getLastName());
        users.add(user.getEmail());
        users.add(user.getPhone());
        users.add(user.getPassword());
        users.add(String.valueOf(user.isState()));
        users.add(user.getCity());
        users.add(user.getPreferences());*/

        users.add(user);
        return user;
    }

    @Override
    public User selectById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> selectAll() {

        for(User user : users){
            System.out.println(user.getId() + ", " +
                    user.getName() + ", " +
                    user.getLastName() + ", " +
                    user.getEmail() + ", " +
                    user.getPhone() + ", " +
                    user.getPassword() + ", " +
                    user.isState() + ", " +
                    user.getCity() + ", " +
                    user.getPreferences());
        }

        return users;
    }

    @Override
    public User updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public int countUsers() {
        return users.size();
    }

}
