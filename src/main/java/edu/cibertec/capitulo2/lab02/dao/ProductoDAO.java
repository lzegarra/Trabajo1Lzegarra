package edu.cibertec.capitulo2.lab02.dao;

import edu.cibertec.capitulo2.lab02.dto.ProductoDTO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoDAO {

    private List<ProductoDTO> listaProductos;

    public ProductoDAO(){
        listaProductos = new ArrayList<>();
        listaProductos.add(new ProductoDTO("1","Carlos","22","6") );
        listaProductos.add(new ProductoDTO("2","Felipe","22","6") );
        listaProductos.add(new ProductoDTO("3","Alberto","22","6") );
        listaProductos.add(new ProductoDTO("4","Maria","22","6") );
        listaProductos.add(new ProductoDTO("5","Cristel","22","6") );
    }

    public List<ProductoDTO> getListaProductos() {
        return listaProductos;
    }

    public void insertarProducto(ProductoDTO produtoDTO){
        listaProductos.add(produtoDTO);
    }

    public ProductoDTO buscarProducto (String id){
        return listaProductos
                .stream()
                .filter(u -> u.getId().equalsIgnoreCase(id))
                .findFirst().orElse(null);
    }

    public void actualizarProducto(ProductoDTO productoDTO){
        for (int i = 0; i < listaProductos.size(); i++) {
            if(listaProductos.get(i).getId().equalsIgnoreCase(productoDTO.getId())){
                listaProductos.set(i, productoDTO);
                break;
            }
        }
    }

    public void eliminarProducto(String id){
        for (int i = 0; i < listaProductos.size(); i++) {
            if(listaProductos.get(i).getId().equalsIgnoreCase(id)){
                listaProductos.remove(i);
                break;
            }
        }
    }

}
