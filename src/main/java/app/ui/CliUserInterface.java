package app.ui;

import app.repository.UserRepositoryImplCollection;
import app.service.UserServiceImpl;
import app.service.inputports.UserService;
import app.service.outputports.UserRepository;
import app.service.validators.DataTypeValidator;
import app.view.SeatView;
import app.view.UserView;

public class CliUserInterface {



    private final UserView userView;
    private final SeatView seatView;

    public CliUserInterface(UserView userView , SeatView seatView){
        this.userView = userView;
        this.seatView = seatView;

    }

    public void applicationInit(){

        System.out.println("Bienvenido TicketMax V1");

        int init = DataTypeValidator.validateInt("Presione 1 para iniciar la aplicación");


        while(init != 0){

            int option = DataTypeValidator.validateInt("1. Registro " +
                    "2. Login " +
                    "3. Salir");

            switch (option){
                case 1:
                    userView.createUser();
                    break;
                case 2:
                    System.out.println("Login");
                    userMenu();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación");
                    init = 0;
                    break;
                default:
                    System.out.println("Seleccione una opción valida");
                    break;
            }

        }



    }

    public void userMenu() {

        int option = DataTypeValidator.validateInt(
                "Seleccione una opción:\n" +
                        "1. Registrar usuario\n" +
                        "2. Consultar usuario por ID\n" +
                        "3. Consultar todos los usuarios\n" +
                        "4. Actualizar usuario\n" +
                        "5. Contar usuarios registrados\n" +
                        "6. Eliminar usuario\n"

        );


        switch (option) {
            case 1:
                userView.createUser();
                break;

            case 2:
                int id = DataTypeValidator.validateInt("Ingrese el ID del usuario a consultar: ");
                userView.selectById(id);
                break;

            case 3:
                userView.selectUsers();
                break;

            case 4:
                userView.update();
                break;

            case 5:
                userView.countUsers();
                break;

            case 6:
                int idDelete = DataTypeValidator.validateInt("Ingrese el ID del usuario que desea eliminar: ");
                userView.deleteUser(idDelete);
                break;


            default:
                System.out.println("Ingrese una opción válida.");
        }
    }
}
