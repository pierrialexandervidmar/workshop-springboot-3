package com.educandoweb.course.resources;


import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Classe que representa um controlador REST para manipulação de recursos relacionados a usuários.
 *
 * Esta classe gerencia as requisições HTTP relacionadas à entidade Category.
 * Os recursos são acessíveis através do caminho "/Categorys".
 *
 * @RestController Indica que esta classe é um controlador REST.
 * @RequestMapping Define o caminho base para os endpoints nesta classe.
 *
 * @see RestController
 * @see RequestMapping
 *
 * @author Pierri Alexander Vidmar
 * @version 1.0
 * @since 2023-01-01
 */
@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
