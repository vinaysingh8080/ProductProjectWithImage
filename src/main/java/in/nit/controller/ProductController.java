package in.nit.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import in.nit.model.Product;
import in.nit.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService service;
	
	@RequestMapping("/show")
	public String showProduct(Model model) {
		model.addAttribute("product", new Product());
		return "Product";
	}
	@RequestMapping("/save")
	public String saveProduct(@RequestParam String prdName,
			@RequestParam String prdPrice,
			@RequestParam String prdQty,@RequestParam MultipartFile file,
			Model model) {
		Product product =new Product();
		try {
			product.setPrdName(prdName);
			product.setPrdPrice(prdPrice);
			product.setPrdQty(prdQty);
			product.setFileName(org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename()));
			product.setFile(file.getBytes());
			System.out.println(product.getPrdName()+" "+ product.getPrdPrice()+" "+product.getPrdQty()+" "+product.getFileName() );
			Integer id=service.saveProduct(product);
			String msg="Product saved "+id+"successfully";
			model.addAttribute("message",msg);
			//form backing object
			model.addAttribute("product", new Product());
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
		return "Product";
	}
	
	@RequestMapping("/fetch")
	public String fetchData(Model model, HttpServletResponse resp,Product product) {
		List<Product> list=service.productDetails();
		model.addAttribute("list",list);
		return "ProductData";
	}
	

}
