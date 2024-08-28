import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)  
public class BookDTO {
    
    @JsonProperty("book_id") 
    private Long id;
    
    @JsonProperty("book_title")
    private String title;
    
    @JsonProperty("book_author")
    private String author;
    
    @JsonProperty("book_price")
    private double price;
    
    @JsonProperty("book_isbn")
    private String isbn;
}
