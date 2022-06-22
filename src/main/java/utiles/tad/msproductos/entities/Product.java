package utiles.tad.msproductos.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table (name = "products")
@Getter @Setter
@ToString
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    private String nombre;
    private double precio_unit;
    private int stock;
}
