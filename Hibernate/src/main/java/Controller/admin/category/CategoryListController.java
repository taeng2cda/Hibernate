package Controller.admin.category;

import Controller.Controller;
import Service.CategoryService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryListController implements Controller {
	private static final String METHOD = "GET";
	
	@Override
	public String getMethod() {
		return CategoryListController.METHOD;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CategoryService categoryService = new CategoryService(request);
		categoryService.getCategoryList();
		
		return "/admin/category/list.jsp";
	}

}
