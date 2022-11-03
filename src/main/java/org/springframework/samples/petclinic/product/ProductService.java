package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private ProductRepository repo;
	
	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}
	
    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return repo.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return repo.getProductType(typeName);
    }

    public Product save(Product p){
        return repo.save(p);       
    }
    
    public List<ProductType> findAllProductTypes() {
    	return repo.findAllProductTypes();
    }

    
}
