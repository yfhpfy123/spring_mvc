package web;

import org.springframework.ui.ModelMap;
import web.controller.UsersController;

public class Main {

    public static void main(String[] args) {
        UsersController usersController = new UsersController();
        ModelMap model = new ModelMap();
        String index = usersController.index(model);

        System.out.println(index);
        System.out.println(model);

    }
}
