package test.service;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

public class TodoListViewTest {
    public static void main(String[] args) {
        testShowTodoList();
    }

    public static void testShowTodoList() {
        TodoListView todoListView = new TodoListView();

        todoListView.showTodoList();
    }
}
