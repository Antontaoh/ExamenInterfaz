package examen_interfaz.main.controller;

import examen_interfaz.main.model.Item;
import examen_interfaz.main.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar los ítems a través de la API.
 */
@RestController
@RequestMapping("/api/items")
@CrossOrigin("*")
public class ApiItemController {

    @Autowired
    private ItemService itemService;

    /**
     * Obtiene la lista de todos los ítems.
     * @return Lista de objetos Item.
     */
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    /**
     * Obtiene un ítem por su ID.
     * @param id Identificador del ítem.
     * @return ResponseEntity con el ítem encontrado o un código 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable String id) {
        return itemService.getItemById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Agrega un nuevo ítem a la base de datos.
     * @param item Objeto Item a agregar.
     * @return El ítem guardado.
     */
    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    /**
     * Elimina un ítem por su ID.
     * @param id Identificador del ítem a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
    }
}
