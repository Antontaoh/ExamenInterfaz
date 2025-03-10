package examen_interfaz.main.controller;

import examen_interfaz.main.model.Item;
import examen_interfaz.main.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controlador para gestionar las vistas web con Thymeleaf.
 */
@Controller
@RequestMapping("/items")
public class WebItemController {

    @Autowired
    private ItemService itemService;

    /**
     * Muestra la lista de todos los ítems en la página web.
     * @param model Modelo de datos para la vista.
     * @return La vista "list.html".
     */
    @GetMapping
    public String listItems(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "items/list";
    }

    /**
     * Muestra los detalles de un ítem específico.
     * @param id Identificador del ítem.
     * @param model Modelo de datos para la vista.
     * @return La vista "detail.html" si el ítem existe, de lo contrario redirige a la lista.
     */
    @GetMapping("/{id}")
    public String viewItem(@PathVariable String id, Model model) {
        Optional<Item> item = itemService.getItemById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
            return "items/detail";
        } else {
            return "redirect:/items";
        }
    }

    /**
     * Agrega un ítem desde el formulario web.
     * @param item Objeto Item a agregar.
     * @return Redirección a la lista de ítems.
     */
    @PostMapping("/add")
    public String addItem(@ModelAttribute Item item) {
        itemService.addItem(item);
        return "redirect:/items";
    }

    /**
     * Elimina un ítem y redirige a la lista.
     * @param id Identificador del ítem a eliminar.
     * @return Redirección a la lista de ítems.
     */
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
        return "redirect:/items";
    }
}


