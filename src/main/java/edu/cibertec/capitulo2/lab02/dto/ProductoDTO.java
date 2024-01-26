package edu.cibertec.capitulo2.lab02.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class ProductoDTO {

    private String id;

    @NotBlank(message = "No vacio")
    //@NotEmpty(message = "No vacio")
    private String nombre;

    @NotBlank(message = "No vacio")
    @Digits(integer = 6,fraction = 2, message = "No es numerico.")
    private String precio;

    @Size(min = 1, max = 20, message = "Debe ser mayor a 0.")
    @Digits(integer = 6,fraction = 0, message = "No es numerico.")
    private String stock;

    public ProductoDTO() {
    }
    public ProductoDTO(String id, String nombre, String precio, String stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

}
