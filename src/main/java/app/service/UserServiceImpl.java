package app.service;

import app.domain.enums.SelectStateEnum;
import app.domain.User;
import app.repository.UserRepositoryImplCollection;
import app.service.inputports.UserService;
import app.service.outputports.UserRepository;
import app.service.helpers.SetUserState;
import app.service.validators.DataTypeValidator;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User create(Integer id, String name, String lastName, String email, String phone, String password, String state, String city, String preferences) {

        User user = new User(id, name, lastName, email, phone, password, state, city, preferences);

        return userRepository.save(user);
    }

    @Override
    public boolean existsById(int id) {
        return userRepository.selectById(id) != null;
    }

    @Override
    public void selectById(int id) {
        User user = userRepository.selectById(id);

        if (user != null) {
            System.out.println("Usuario encontrado:");
            System.out.println("ID: " + user.getId());
            System.out.println("Nombre: " + user.getName());
            System.out.println("Apellido: " + user.getLastName());
            System.out.println("Correo: " + user.getEmail());
            System.out.println("Teléfono: " + user.getPhone());
            System.out.println("Ciudad: " + user.getCity());
            System.out.println("Preferencias: " + user.getPreferences());
        } else {
            System.out.println("No se encontró un usuario con ID: " + id);
        }
    }

    @Override
    public void update() {
        int id = app.service.validators.DataTypeValidator.validateInt("Ingrese el ID del usuario que desea actualizar: ");

        User existingUser = userRepository.selectById(id);

        if (existingUser == null) {
            System.out.println("No se encontró un usuario con ID: " + id);
            return;
        }

        String name = DataTypeValidator.validateString("Ingrese el nuevo nombre: ");
        String lastName = DataTypeValidator.validateString("Ingrese el nuevo apellido: ");
        String email = DataTypeValidator.validateString("Ingrese el nuevo correo: ");
        String phone = DataTypeValidator.validateString("Ingrese el nuevo teléfono: ");
        String password = DataTypeValidator.validateString("Ingrese la nueva contraseña: ");
        String state = SetUserState.getUserState();
        String city = DataTypeValidator.validateString("Ingrese la nueva ciudad: ");
        String preferences = existingUser.getPreferences();

        User updatedUser = new User(
                id, name, lastName, email, phone, password, state, city, preferences
        );

        User result = userRepository.updateUser(updatedUser);

        if (result != null) {
            System.out.println("Usuario actualizado correctamente.");
        } else {
            System.out.println("No fue posible actualizar el usuario.");
        }
    }

    @Override
    public List<User> selectUsers() {

        return userRepository.selectAll();
    }


    @Override
    public void deleteUser(int id) {
        User user = userRepository.selectById(id);

        if (user == null) {
            System.out.println("No se encontró un usuario con ID: " + id);
            return;
        }

        userRepository.deleteById(id);

        System.out.println("Usuario eliminado correctamente.");
    }


    @Override
    public int countUsers() {
        return userRepository.countUsers();
    }

}
