public class AplikasiTodoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        testViewTodoList();
    }

    //    Menampilkan todolist
    public static void showTodoList() {
        for (int i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Java Dasar";
        model[1] = "Java Spring";

        showTodoList();
    }

    //    Menambah todo ke list
    public static void addTodoList(String todo) {
//        cek apakah model penuh
        var full = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
//                model masih ada yang kosong
                full = false;
                break;
            }
        }
//        jika penuh, resize ukuran array 2 kali lipat
        if (full) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }
//        tambahkan ke posisi yang data array nya null
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        addTodoList("Java Dasar");
        addTodoList("Java Spring Boot");
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh todo ke -" + i);
        }
    }

    //    Menghapus todo dari list
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            model[number - 1] = null;

            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }

    }

    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        var result = removeTodoList(2);
        if (result) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }

        result = removeTodoList(2);
        if (result) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);
    }

    //    View todo list
    public static void viewShowTodoList() {
        System.out.println("TODOLIST");
        while(true){
            showTodoList();

            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("X. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("X")){
                break;
            }else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        viewShowTodoList();
    }

    //    View menambahkan todo list
    public static void viewAddTodoList() {
        System.out.println("Menambah TodoList");
        var input = input("Todo (x jika batal) : ");

        if (input.toLowerCase().equals("x")) {
//            batal
            viewShowTodoList();
        } else {
            addTodoList(input);
        }
    }

    public static void testViewAddTodoList(){
        viewAddTodoList();
    }

    //    View menghapus todo list
    public static void viewRemoveTodoList() {
        System.out.println("Menghapus TodoList");
        var input = input("Todo (x jika batal) ");

        if (input.toLowerCase().equals("x")) {
//            batal
            viewShowTodoList();
        } else {
            boolean success = removeTodoList(Integer.parseInt(input));
            if (!success) {
                System.out.println("Gagal menghapus");
            }
            viewShowTodoList();
        }
    }
}
