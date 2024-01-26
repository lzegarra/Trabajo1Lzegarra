package edu.cibertec.capitulo2.lab02.service;

import edu.cibertec.capitulo2.lab02.dao.ProductoDAO;
import edu.cibertec.capitulo2.lab02.dto.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoDAO productoDao;

    public List<ProductoDTO> getListaProductos() {
        return productoDao.getListaProductos();
    }

    public void insertarProducto(ProductoDTO produtoDTO) {
        productoDao.insertarProducto(produtoDTO);
    }

    public ProductoDTO buscarProducto(String id) {
        return productoDao.buscarProducto(id);
    }

    public void actualizarProdcuto(ProductoDTO productoDTO) {
        productoDao.actualizarProducto(productoDTO);
    }

    public void eliminarProducto(String id) {
        productoDao.eliminarProducto(id);
    }
}
