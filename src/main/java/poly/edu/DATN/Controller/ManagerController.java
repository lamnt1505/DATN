package poly.edu.DATN.Controller;

import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poly.edu.DATN.Entity.Product;
import poly.edu.DATN.Entity.User;
import poly.edu.DATN.Service.ProductService;
import poly.edu.DATN.Service.UserService;


@Controller
public class ManagerController  {

	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	void getname(HttpServletRequest request, ModelMap model) {
		//đọc cookie từ trình duyệt
		Cookie[] cookie = request.getCookies();//sử dụng rqck trả về danh sách các cookie
		for(int i = 0; i < cookie.length; i++) {//sd vl for để duyệt qua cookie
			if(cookie[i].getName().equals("accountuser")){
				 //so sánh phần tử i trong cookie với accountuser
				User user = this.userService.findByPhone(cookie[i].getValue()).get();
				//sử dụng pt findbyphone để so sánh user
				//đưa các giá trị vào model
				model.addAttribute("fullname",user.getFullname());
				model.addAttribute("image",user.getImageBase64());
				
				break;
			}
		}
	}
	//action add
	@GetMapping(value = "/manager/addProdcut")
	public String addProduct(ModelMap model, 
			@CookieValue(value = "accountuser", required = false) String username, HttpServletRequest request){
			Cookie[] cookies = request.getCookies();//sử dụng rqck trả về 1 mảng người dùng yêu cầu
			if(cookies != null) {//kiểm tra cookie
				//kiểm tra cookie
				for (int i = 0; i < cookies.length; i++) {//sd vl for để duyệt qua cookie
					//sd length lấy tt phần tử cookies
					if(cookies[i].getName().equals("accountuser")) {//kiểm tra nếu i khác entity
						this.userService.findByPhone(cookies[i].getValue()).get();//sử dụng userService lấy tt người đăng nhập
						getname(request, model);
						//đưa các giá trị vào model
						model.addAttribute("product",new Product());
						//model.addAttribute("listCategory",ca)
						return "/manager/product/addProduct";
					}
				}
			}
			return "redirect:/login";
	}
	
	//action add
	@PostMapping(value = "/manager/addProdcut")
	public String addProduct(@RequestParam(value = "image") MultipartFile image,
			@ModelAttribute(name = "product") @Valid Product product, BindingResult result,
			RedirectAttributes redirect) {
			if(result.hasErrors()) {
				return "/manager/addProduct";
			}else {
				this.productService.save(product);
				redirect.addFlashAttribute("success","Thêm mới thông tin sản phẩm thành công!");
			}
			return "redirect:/manager/listProduct";
	}
	
	
	@GetMapping(value = "/manager/updateProdcut")
	public String updateProduct(ModelMap model, @PathVariable(name = "idProduct") int id,
			@CookieValue(value = "accountuser", required = false) String username, HttpServletRequest request) {
		
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {//kiểm tra cookie
				for(int i = 0; i < cookies.length; ++i) {
					if(cookies[i].getName().equals("accountuser")) {
						this.userService.findByPhone(cookies[i].getValue()).get();
					}
				}
			}
			return "/manager/updateProduct";
	}
	
	//action update
	@PostMapping(value = "/manager/updateProduct")
	public String updateProduct(@RequestParam("image") MultipartFile image, 
			@ModelAttribute ("product") @Valid Product product,BindingResult result, 
			ModelMap model) {
		
		if(result.hasErrors()) {
			return "/manager/updateProduct";
		}else {
			this.productService.save(product);
			model.addAttribute("success","Cập nhật sản phẩm thành công!");
		}
		
		return "manager/updateProduct";
	}
}
