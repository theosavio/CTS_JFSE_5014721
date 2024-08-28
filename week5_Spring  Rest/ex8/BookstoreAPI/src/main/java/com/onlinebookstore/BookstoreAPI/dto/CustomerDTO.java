import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)  
public class CustomerDTO {
    
    @JsonProperty("customer_id")  
    private Long id;
    
    @JsonProperty("customer_name")
    private String name;
    
    @JsonProperty("customer_email")
    private String email;
    
    @JsonProperty("customer_phone")
    private String phoneNumber;
}
