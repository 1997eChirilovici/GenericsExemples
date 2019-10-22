package part2.generics.miniProject.dao;

import part2.generics.miniProject.db.MyDataBase;
import part2.generics.miniProject.entity.BaseUser;
import part2.generics.miniProject.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDAOImpl<T extends BaseUser> implements EmployeeDAO<T> {

    MyDataBase<T> myDataBase = new MyDataBase<>();

    @Override
    public void saveEmployee(T t) {
        myDataBase.addUser(t);
    }

    @Override
    public List<T> getEmployee() {
        return myDataBase.getUsers().stream()
                .filter(t -> t.getClass() == Employee.class)
                .collect(Collectors.toList());
    }

    @Override
    public T getById(Long id) {
        for (BaseUser baseUser : myDataBase.getUsers()) {
            if (baseUser.getId().equals(id)) {
                return (T) baseUser;
            }
        }
        return null;
    }

    //get all Employees
    @Override
    public List<T> getAll() {
        return myDataBase.getUsers().stream()
                .filter(t -> t.getClass() == Employee.class)
                .collect(Collectors.toList());
    }

    //display all Employees
    @Override
    public void displayAll() {
        List<T> allInterns = getAll();
        for (T intern : allInterns) {
            intern.toString();
        }
    }

    @Override
    public void save(T t) {
        myDataBase.addUser(t);
    }
}
