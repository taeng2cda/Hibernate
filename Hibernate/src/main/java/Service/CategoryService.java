package Service;

import Dao.CategoryDao;
import Entity.Category;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
public class CategoryService {
    private final HttpServletRequest request;
    private final static CategoryDao categoryDao = new CategoryDao();

    public void getCategoryList() {
        List<Category> categoryList = categoryDao.findAll();

        request.setAttribute("categoryList", categoryList);
    }
}
