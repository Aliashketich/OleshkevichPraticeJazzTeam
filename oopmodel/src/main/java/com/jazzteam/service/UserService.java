package com.jazzteam.service;

import com.jazzteam.constants.Constant;
import com.jazzteam.constants.ExceptionMessage;
import com.jazzteam.exception.MyException;
import com.jazzteam.model.Company;
import com.jazzteam.model.user.User;
import com.jazzteam.model.user.ext.Employee;
import com.jazzteam.model.user.ext.Sysadmin;

public class UserService {
    private static Employee emptyEmployee = new Employee();
    private static Sysadmin emptySysadmin = new Sysadmin();

    private UserService() {

    }

    /**
     * Method for editing User personal data
     *
     * @param user        User object for editing
     * @param newAge      new User age
     * @param newEmail    new User email
     * @param newLogin    new User login
     * @param newPassword new User password
     * @param newName     new User name
     * @param newSurname  new User surname
     * @throws NullPointerException if received User is null
     */
    public static void changeUserPersonalData(User user, int newAge, String newEmail, String newLogin, String newPassword,
                                              String newName, String newSurname) {
        if (user != null) {
            user.setAge(newAge);
            user.setEmail(newEmail);
            user.setLogin(newLogin);
            user.setPassword(newPassword);
            user.setName(newName);
            user.setSurname(newSurname);
        } else throw new NullPointerException(ExceptionMessage.USER_IS_NULL);
    }

    /**
     * Method for editing Employee personal data
     *
     * @param employee      Employee object for editing
     * @param newAge        new Employee age
     * @param newEmail      new Employee email
     * @param newLogin      new Employee login
     * @param newPassword   new Employee password
     * @param newName       new Employee name
     * @param newSurname    new Employee surname
     * @param newDepartment new Employee department
     * @throws MyException if received Employee is empty
     */
    public static void changeEmployeePersonalData(Employee employee, int newAge, String newEmail, String newLogin, String newPassword,
                                                  String newName, String newSurname, String newDepartment) throws MyException {
        if (employee.equals(emptyEmployee))
            throw new MyException(ExceptionMessage.EMPLOYEE_IS_EMPTY);

        changeUserPersonalData(employee, newAge, newEmail, newLogin, newPassword, newName, newSurname);
        employee.setDepartment(newDepartment);
    }

    /**
     * Method for editing Sysadmin personal data
     *
     * @param sysadmin      Sysadmin object for editing
     * @param newAge        new Sysadmin age
     * @param newEmail      new Sysadmin email
     * @param newLogin      new Sysadmin login
     * @param newPassword   new Sysadmin password
     * @param newName       new Sysadmin name
     * @param newSurname    new Sysadmin surname
     * @param newExperience new Sysadmin experience value
     * @throws MyException when try delete empty sysadmin
     */
    public static void changeSysadminPersonalData(Sysadmin sysadmin, int newAge, String newEmail, String newLogin, String newPassword,
                                                  String newName, String newSurname, int newExperience) throws MyException {
        if (sysadmin.equals(emptySysadmin))
            throw new MyException(ExceptionMessage.SYSADMIN_IS_EMPTY);

        changeUserPersonalData(sysadmin, newAge, newEmail, newLogin, newPassword, newName, newSurname);
        sysadmin.setExperience(newExperience);
    }

    /**
     * Method which delete User from company
     *
     * @param user    User object which should be deleted
     * @param company Company global Context
     * @throws MyException if you try delete auditor
     */
    public static void deleteUser(User user, Company company) throws MyException {
        for (int i = 0; i < company.getAllUsers().size(); i++) {
            if (Constant.AUDITOR_ROLE.equals(user.getRole())) {
                throw new MyException(ExceptionMessage.AUDITOR_CAN_NOT_BE_DELETED);
            } else {
                try {
                    if (company.getAllUsers().get(i).equals(user)) {
                        company.getAllUsers().remove(i);
                        break;
                    }
                } catch (IndexOutOfBoundsException e) {
                    throw new MyException(ExceptionMessage.DELETING_NONEXISTENT_USER_IS_IMPOSSIBLE);
                }
            }
        }
    }
}
