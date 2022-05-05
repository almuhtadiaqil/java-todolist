package test.service;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testShowTodoList();
//        testAddTodoList();
//        testRemoveTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajra Java Spring");

        todoListService.showTodoList();
    }

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajra Java Spring");

        todoListService.removeTodoList(1);

        todoListService.showTodoList();
    }

}
