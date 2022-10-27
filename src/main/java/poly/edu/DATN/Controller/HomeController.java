package poly.edu.DATN.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

import javax.servlet.http.Cookie;

import poly.edu.DATN.Entity.Customer;
import poly.edu.DATN.Service.CategoryService;
import poly.edu.DATN.Service.CustomerService;
import poly.edu.DATN.Service.FeedBackService;
import poly.edu.DATN.Service.ProductService;
import poly.edu.DATN.Service.UserService;

@Controller
@RequestMapping("/index")
public class HomeController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    ProductService productService;
    
    @Autowired
    CustomerService customerService;
    
    @Autowired
    CategoryService categorySerivce;
    
    @Autowired
    FeedBackService feedBackService;
    
    void getName(HttpServletRequest request, ModelMap model) {
        Cookie[] cookies = request.getCookies();
        for(int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals("accountcustomer")) {
                Customer customer = this.customerService.findByPhoneCus(cookies[i].getValue()).get();
                model.addAttribute("fullname", customer.getFullname());
                model.addAttribute("customerId", customer.getCustomerId());
                break;
            }
        }
    }
    
    void initHomeResponse(ModelMap model) {
        model.addAttribute("prods", this.productService.findAll());
        model.addAttribute("category", this.categorySerivce.findAll());
        model.addAttribute("showProduct", this.productService.showListProductForIndex());
        model.addAttribute("feedback",this.feedBackService.listFeedBack());
    }
    
    //action home
    @GetMapping()
    public String Home(ModelMap model, HttpServletRequest request, @CookieValue(value = "accountcustomer", required = false) String phone
            , HttpServletResponse response, HttpSession session) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(int i = 0; i < cookies.length; i++) {
                if(cookies[i].getName().equals("accountcustomer")) {
                    Customer customer = this.customerService.findByPhoneCus(cookies[i].getValue()).get();
                    if(session.getAttribute("cart") == null) {
                        session.setAttribute("cart", new ArrayList<>());
                    }
                    model.addAttribute("fullname", customer.getFullname());
                    model.addAttribute("customerId", customer.getCustomerId());
                }
            }
        }else {
            if(session.getAttribute("cart") == null) {
                session.setAttribute("cart", new ArrayList<>());
            }
        }
        this.initHomeResponse(model);
        return "home/index";
    }
    
    //@GetMapping("/product")
    
}
