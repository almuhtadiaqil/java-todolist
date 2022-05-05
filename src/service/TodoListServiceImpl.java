package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();

        System.out.println("TODOLIST");
        for (int i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo.getTodo());
            } else {
                System.out.println("Data kosong");
                break;
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("Sukses menambahkan todo : " + todoList.getTodo());
    }

    @Override
    public void removeTodoList(int id) {
        boolean success = todoListRepository.remove(id);
        if (success){
            System.out.println("Sukses Menghapus Todo : " + id);
        } else {
            System.out.println("Gagal Menghapus Todo : " + id);
        }
    }
}
