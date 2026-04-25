package pl.edu.vistula.task_2.Product.service;

import org.springframework.stereotype.Service;
import pl.edu.vistula.task_2.Product.api.request.ProductRequest;
import pl.edu.vistula.task_2.Product.api.response.ProductResponse;
import pl.edu.vistula.task_2.Product.domain.Product;
import pl.edu.vistula.task_2.Product.repository.ProductRepository;
import pl.edu.vistula.task_2.Product.support.ProductMapper;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }
    public ProductResponse create(ProductRequest productRequest){
        Product product = productRepository.save(productMapper.toProduct(productRequest));
        return productMapper.toProductResponse(product);
    }
    public ProductResponse find(Long id){
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
        return productMapper.toProductResponse(product);
    }
}
