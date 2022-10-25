package poly.edu.DATN.Controller;

import java.sql.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.DATN.Entity.Customer;
import poly.edu.DATN.Entity.User;
import poly.edu.DATN.Service.CustomerService;
import poly.edu.DATN.Service.UserService;

@Controller
@RequestMapping("")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserService userService;
	
	void getName(HttpServletRequest request, ModelMap model) {
		Cookie [] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; ++i) {//sd vl for để duyệt qua cookie
			if (cookies[i].getName().equals("accountcustomer")) {//kiểm tra cookie
			    //so sánh phần tử i trong cookie với accountuser
				Customer cus = this.customerService.findByPhoneCus(cookies[i].getValue()).get();
				//đưa giá trị vào model
				model.addAttribute("fullname", cus.getFullname());
				model.addAttribute("customerId", cus.getCustomerId());
				break;
			}
		}
	}
	
	@GetMapping(value = "/manager/listCustomer")
	public String listCustomer(ModelMap model, @CookieValue(value = "accountuser", required = false)String phone,
			HttpServletRequest request, HttpServletResponse respone){
		Cookie [] cookies = request.getCookies();
		if(cookies != null) {
			for (int i = 0; i < cookies.length; ++i) {
				if(cookies[i].getName().equals("accountcustomer")) {
					User user = this.userService.findByPhone(cookies[i].getValue()).get();
					model.addAttribute("listcustomer", customerService.findAll());
					model.addAttribute("username",phone);
					model.addAttribute("fullname", user.getFullname());
					return "/manager/users/listCustomer";
				}
			}
		}
		return "redirect:/login";
	}
	
	@GetMapping(value = "/registration")
	public String registration(ModelMap model) {
		model.addAttribute("registration",new Customer());
		return "/login/registred";
	}
	
	@PostMapping(value = "/registration")//action đăng ký customer
	public String addProduct(ModelMap model,@ModelAttribute(name = "registration") Customer registration, 
			@RequestParam boolean gender, @RequestParam Date birthday, @RequestParam("phone") String phone) {
	    //truyền vào model 1 entity mới
		model.addAttribute("registration",new Customer());
		if(customerService.findByPhoneCus(phone).isPresent()|| userService.findByPhone(phone).isPresent()) {
		    //sử dụng pt findbyphone lấy tt người đăng nhập 
		    model.addAttribute("error", "Số điện thoại đã tồn tại");//cùng số điện thoại đưa ra tb 
		    return "/login/registred";
		    //trả về trang login đăng ký
		}else {//ngược lại 
		    customerService.save(registration);
		    //sử dụng pt save 
		    return "redirect:login";
		    //trả về trang login
		}
	}
	
	@GetMapping(value = "/updateProfile/{customerId}")
	public String updateCus(ModelMap model, @PathVariable(name = "customerId") int customerId, 
	        HttpServletRequest request) {
	    model.addAttribute("listuser", this.customerService.findAll());
	    model.addAttribute("customer", this.customerService.findById(customerId).isPresent() ? this.customerService.findById(customerId).get() 
	            : null);
	    return "/manager/users/udateProfile";
	}
	
	@PostMapping
	public String updateCus(@ModelAttribute(name = "customerId") @Valid Customer customerId,
	        @CookieValue(value = "accountcustomer", required = false) String phone,HttpServletRequest request,
            ModelMap model) {
	    customerService.save(customerId);
	    getName(request,model);
	    return "redirect:/index";
	}
}
