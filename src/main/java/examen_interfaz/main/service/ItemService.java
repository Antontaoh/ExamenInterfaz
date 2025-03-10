package examen_interfaz.main.service;

import examen_interfaz.main.model.Item;
import examen_interfaz.main.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar los ítems en la base de datos.
 * Proporciona métodos para obtener, agregar y eliminar ítems.
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Obtiene la lista de todos los ítems almacenados en la base de datos.
     * @return Lista de objetos {@link Item}.
     */
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    /**
     * Busca un ítem en la base de datos por su ID.
     * @param id Identificador del ítem en MongoDB.
     * @return Un {@link Optional} que contiene el ítem si existe, o vacío si no se encuentra.
     */
    public Optional<Item> getItemById(String id) {
        return itemRepository.findById(id);
    }

    /**
     * Guarda un nuevo ítem en la base de datos.
     * @param item Objeto {@link Item} a almacenar.
     * @return El ítem guardado con su ID generado por MongoDB.
     */
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    /**
     * Elimina un ítem de la base de datos por su ID.
     * @param id Identificador del ítem a eliminar.
     */
    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }
}

