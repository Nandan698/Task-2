package pl.edu.vistula.task_2.Product.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.vistula.task_2.Product.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}