package interfaceLine;

import domain.Program;
import manager.ProgramDAO;

import java.util.Scanner;

public class CommandLineInterface {
    private ProgramDAO programDAO;
    private Scanner scanner;

    public CommandLineInterface() {
        programDAO = new ProgramDAO();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Добро пожаловать в магазин!");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();

            if (command.equals("ВсеДанные")) {
                System.out.println(programDAO.getAllPrograms());
            } else if (command.equals("ДобавитьДанные")) {
                System.out.print("Введите название отдела: ");
                String department_name = scanner.nextLine();
                System.out.print("Введите часы работы: ");
                String hours_of_operation = scanner.nextLine();
                System.out.print("Введите название товара: ");
                String product_name = scanner.nextLine();
                System.out.print("Введите цену товара: ");
                int price = Integer.parseInt(scanner.nextLine());

                Program program = new Program(department_name, hours_of_operation, product_name, price);
                programDAO.addProgram(program);
                System.out.println("Данные добавлены успешно!");
            } else if (command.equals("ОбновитьДанные")) {
                System.out.print("Введите id: ");
                int id = Integer.parseInt(scanner.nextLine());


                System.out.print("Введите название отдела: ");
                String department_name = scanner.nextLine();
                System.out.print("Введите часы работы: ");
                String hours_of_operation = scanner.nextLine();
                System.out.print("Введите название товара: ");
                String product_name = scanner.nextLine();
                System.out.print("Введите цену товара: ");
                int price = Integer.parseInt(scanner.nextLine());

                Program updatedProgram = new Program(department_name, hours_of_operation, product_name, price);
                updatedProgram.setId(id);
                programDAO.updateProgram(updatedProgram);
                System.out.println("Данные успешно обновлены!");
            } else if (command.equals("УдалитьДанные")) {
                System.out.print("Введите id: ");
                int id = Integer.parseInt(scanner.nextLine());


                programDAO.deleteProgram(id);
                System.out.println("Данные успешно удалены!");
            } else if (command.equals("Выход")) {
                break;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
