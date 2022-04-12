package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserListController implements Controller{
    private static String METHOD = "GET";

    @Override
    public String getMethod() {
        return UserListController.METHOD;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "/mes/user/list.jsp";
    }

}
