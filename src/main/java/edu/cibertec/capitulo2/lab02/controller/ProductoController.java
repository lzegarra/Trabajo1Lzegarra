package edu.cibertec.capitulo2.lab02.controller;

import edu.cibertec.capitulo2.lab02.dto.ProductoDTO;
import edu.cibertec.capitulo2.lab02.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @GetMapping("/listarProductos")
    public ModelAndView listarUsuarios(){
        return new ModelAndView("productos/listar", "lista", productoService.getListaProductos());
    }


    @GetMapping("/registrar")
    public ModelAndView crear(){
        return new ModelAndView("productos/registrar","productoBean",new ProductoDTO());
    }

    @PostMapping("/grabar")
    public ModelAndView grabar(@Valid @ModelAttribute("productoBean") ProductoDTO productoDTO, BindingResult result){
        ModelAndView mv = null;
        if (result.hasErrors()) {
            mv = new ModelAndView("productos/registrar", "productoBean", productoDTO);
        } else {
            List<ProductoDTO> product = productoService.getListaProductos();
            ProductoDTO maxId=  product.stream().max(Comparator.comparing(ProductoDTO::getId)).orElseThrow(NoSuchElementException::new);
            int id = Integer.parseInt(maxId.getId())+1;
            productoDTO.setId(Integer.toString(id));

            productoService.insertarProducto(productoDTO);
            mv = new ModelAndView("redirect:/listarProductos");
        }
        return mv;
    }


    @GetMapping("/editar/{producto}")
    public ModelAndView editar(@ModelAttribute("producto") String producto){
        return new ModelAndView("productos/editar", "productoBean", productoService.buscarProducto(producto));
    }
    @PostMapping("/actualizar")
    public ModelAndView actualizar(@Valid @ModelAttribute("productoBean") ProductoDTO productoDTO, BindingResult result){
        ModelAndView mv = null;
        if (result.hasErrors()) {
            mv = new ModelAndView("productos/editar", "productoBean", productoDTO);
        } else {
            productoService.actualizarProdcuto(productoDTO);
            mv = new ModelAndView("redirect:/listarProductos");
        }
        return mv;
    }

    @PostMapping("/eliminar")
    public String eliminar(@ModelAttribute("producto") String producto){
        productoService.eliminarProducto(producto);
        return "redirect:/listarProductos";
    }




}
