package org.springframework.samples.petclinic.product;

import java.security.Provider.Service;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

	@Autowired
	private ProductService pservice;
	
    @Override
    public String print(ProductType object, Locale locale) {
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
    	ProductType pt = pservice.getProductType(text);
    	if (pt != null) {
    		return pt;
    	} else {
    		throw new ParseException("producto " + text + "no encontrado", 0);
    	}
    }
    
}
