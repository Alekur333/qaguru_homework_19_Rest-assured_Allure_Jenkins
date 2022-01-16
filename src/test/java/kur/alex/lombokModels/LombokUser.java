package kur.alex.lombokModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LombokUser {
    private Integer id;
    private String email;
    @JsonProperty("first_name") // нужно,когда ключ не в формате camelCase, чтобы переназначить ему имя в camelCase
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;

}
