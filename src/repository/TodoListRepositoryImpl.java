package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository {

    private TodoList[] data = new TodoList[10];

    @Override
    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull() {
        var isFull = true;
        //        cek apakah model penuh
        var full = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
//                model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIfFull(){
        //        jika penuh, resize ukuran array 2 kali lipat
        if (isFull()) {
            var temp = data;
            data = new TodoList[data.length * 2];

            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }
    @Override
    public void add(TodoList todoList) {
        resizeIfFull();

//        tambahkan ke posisi yang data array nya null
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todoList;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer id) {
        if ((id - 1) >= data.length) {
            return false;
        } else if (data[id - 1] == null) {
            return false;
        } else {
            data[id - 1] = null;

            for (int i = (id - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
