package poly.edu.DATN.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import poly.edu.DATN.Service.ProductService;


@Controller
public class ManagerController  {

	@Autowired
	ProductService productService;
}
