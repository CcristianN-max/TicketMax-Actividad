package app.service.validators;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataTypeValidator {

    static Scanner sc = new Scanner(System.in);

    public static int validateInt(String prompt){

    while(true) {
            try {
                System.out.println(prompt);
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Solo se aceptan numeros enteros, error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }


    public static Double validateDouble(String prompt){
        while(true) {
            try {
                System.out.println(prompt);
                Double value = sc.nextDouble();
                sc.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Solo se aceptan numeros decimales, error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }


    public static Float validateFloat(String prompt){
        while(true) {
            try {
                System.out.println(prompt);
                Float value = sc.nextFloat();
                sc.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Solo se aceptan numeros decimal flotante, error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    public static String validateString(String prompt){
        while(true) {
            System.out.println(prompt);
            String value = sc.nextLine().trim();
            if(!value.isEmpty()){
                return value;


            }
        }
    }

    public static String validatePhone(String prompt) {
        while (true) {
            System.out.println(prompt);
            String phone = sc.nextLine().trim();

            if (phone.matches("[0-9]{7,15}")) {
                return phone;
            }

            System.out.println("Error: ingrese un teléfono de 7 a 15 dígitos, sin letras ni espacios."
            );
        }
    }

}
