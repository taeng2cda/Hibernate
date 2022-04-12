package Controller;

import Controller.admin.category.CategoryListController;
import Util.HibernateUtil;
import lombok.extern.java.Log;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Log
@WebServlet("*.do")
public class FrontController extends HttpServlet {

    //직렬화 인터페이스를 구현하면 serialVersionUID에 값을 할당하라고 함.
    private static final Long serialVersionUID = 1L;

    HashMap<String , Controller> router = new HashMap<>();

    public FrontController(){super();}
    public void init(ServletConfig config) throws ServletException {
        router.put("/admin/categoryList.do", new CategoryListController());
    }

    @Override
    public void destroy() {
        System.out.println("destroy!!");
        HibernateUtil.closeEntityManager();
    }
//test
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  URI = 웹 전체경로를 가져옴 /user/test.jsp
        String url = req.getRequestURI();
        //  프로젝트 명을 가져옴   /user
        String contextPath = req.getContextPath();

        String path = url.substring(contextPath.length());

        if(router.containsKey(path)){
            Controller frontController = router.get(path);

            String method = req.getMethod();
            if(frontController.getMethod().equals(method)){
                String page = frontController.execute(req,resp);
            }else{
                System.out.println("403 Error");
            }
        }else{
            System.out.println("404 Error");
        }

    }

}
