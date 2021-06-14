package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Category;
import alkemy.challenge.Challenge.Alkemy.service.CategoryService;
import alkemy.challenge.Challenge.Alkemy.util.Message;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    //Faltan las otras funciones del crud.
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> addCategories(@RequestBody @Valid Category category) {

        if (StringUtils.isBlank(category.getName())) {
            return new ResponseEntity(new Message("campo nombre no puede estar vacio."),
                    HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.isAlpha(category.getName())) {
            return new ResponseEntity(new Message("Debe contener solo letras."),
                    HttpStatus.BAD_REQUEST);
        } else {
            categoryService.createCategory(category);
            return new ResponseEntity(new Message("categoria creada."),
                    HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<?> getCategories(){
        return new ResponseEntity(categoryService.getAll(), HttpStatus.OK);
    }
}
