package utiles.tad.msproductos.services;

import utiles.tad.msproductos.entities.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> getAll ();
    Product getById(int id);
    void remove (int id);
    void save (Product product);
    String comprobarExistencia (int id);
    Map<String, Object> stock (int id);
}
