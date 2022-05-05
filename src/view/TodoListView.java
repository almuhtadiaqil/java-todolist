package view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListView {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    private TodoListRepository todoListRepository = new TodoListRepositoryImpl();
    private TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
    public void showTodoList(){

        while(true){
            todoListService.showTodoList();

            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("X. Keluar");

            var request = input("Pilih");
            if (request.equals("1")) {
                addTodoList();
            } else if (request.equals("2")) {
                removeTodoList();
            } else if (request.toLowerCase().equals("x")){
                break;
            }else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void addTodoList(){
        System.out.println("Menambah TodoList");
        var input = input("Todo (x jika batal)");

        if (input.toLowerCase().equals("x")) {
//            batal
            showTodoList();
        } else {
            todoListService.addTodoList(input);
        }
    }

    public void removeTodoList(){
        System.out.println("Menghapus TodoList");
        var request = input("Todo (x jika batal)");

        if (request.toLowerCase().equals("x")) {
//            batal
            showTodoList();
        } else {
            todoListService.removeTodoList(Integer.parseInt(request));
            showTodoList();
        }
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }
}
