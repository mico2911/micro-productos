package utiles.tad.msproductos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utiles.tad.msproductos.entities.Product;
import utiles.tad.msproductos.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repositorio;

    @Override
    public List<Product> getAll () {
        return (List<Product>) repositorio.findAll();
    }

    @Override
    public Product getById(int id) {
        return (Product) repositorio.findById(id).get();
    }

    @Override
    public void remove(int id) {
        repositorio.deleteById(id);
    }

    @Override
    public void save(Product product) {
        repositorio.save(product);
    }

    @Override
    public String comprobarExistencia(int id) {
        int existencias = 0;
        String mensaje = "false";
        List <Product> productos = (List<Product>) repositorio.findAll();
        for(int i=0; i<productos.size(); i++){
            if(i == id){
                existencias ++;
            }
        }
        if (existencias > 0) {
            mensaje = "true";
        }
        return mensaje;
    }

    @Override
    public Map<String, Object> stock(int id) {
        int existencias = 0;
        String mensaje = "false";
        Map<String, Object> pedido = new HashMap<>();
        try {
            List <Product> productos = (List<Product>) repositorio.findAll();
            for(int i=0; i<productos.size(); i++){
                if(i == id-1){
                    existencias ++;
                    mensaje = "true";
                    pedido.put("mensaje", mensaje);
                    pedido.put("nombre", productos.get(i).getNombre());
                    pedido.put("stock", productos.get(i).getStock());
                }
            }
            if(existencias == 0){
                pedido.put("mensaje", mensaje);
            }
        }catch (Exception ignored) {

        }
        return pedido;
    }
}
