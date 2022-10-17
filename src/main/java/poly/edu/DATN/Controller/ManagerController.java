package poly.edu.DATN.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import poly.edu.DATN.Service.ProductService;
import poly.edu.DATN.Service.UserService;


@Controller
public class ManagerController  {

	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	void getname(HttpServletRequest request, ModelMap model) {
		Cookie[] cookie = request.getCookies();//sử dụng rqck trả về danh sách các cookie
		
	}
}
