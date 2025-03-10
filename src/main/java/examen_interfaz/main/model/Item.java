package examen_interfaz.main.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "items")
public class Item {
    @Id
    private String _id;
    private int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private double rate;
    private int count;
    private String image;
}
