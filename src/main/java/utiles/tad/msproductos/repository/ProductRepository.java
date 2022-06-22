package utiles.tad.msproductos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import utiles.tad.msproductos.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
