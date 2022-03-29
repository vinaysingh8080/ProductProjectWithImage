package in.nit.service;


import java.util.List;

import in.nit.model.Product;

public interface IProductService {
	public Integer saveProduct(Product product);
	public List<Product> productDetails();
	
}
