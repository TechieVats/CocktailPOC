
package pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idIngredient",
    "strIngredient",
    "strDescription",
    "strType",
    "strAlcohol",
    "strABV"
})
public class Ingredient {

    Ingredient(){

    }

    @JsonProperty("idIngredient")
    private String idIngredient;
    @JsonProperty("strIngredient")
    private String strIngredient;
    @JsonProperty("strDescription")
    private String strDescription;
    @JsonProperty("strType")
    private String strType;
    @JsonProperty("strAlcohol")
    private String strAlcohol;
    @JsonProperty("strABV")
    private Object strABV;

    @JsonProperty("idIngredient")
    public String getIdIngredient() {
        return idIngredient;
    }

    @JsonProperty("idIngredient")
    public void setIdIngredient(String idIngredient) {
        this.idIngredient = idIngredient;
    }

    @JsonProperty("strIngredient")
    public String getStrIngredient() {
        return strIngredient;
    }

    @JsonProperty("strIngredient")
    public void setStrIngredient(String strIngredient) {
        this.strIngredient = strIngredient;
    }

    @JsonProperty("strDescription")
    public String getStrDescription() {
        return strDescription;
    }

    @JsonProperty("strDescription")
    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    @JsonProperty("strType")
    public String getStrType() {
        return strType;
    }

    @JsonProperty("strType")
    public void setStrType(String strType) {
        this.strType = strType;
    }

    @JsonProperty("strAlcohol")
    public String getStrAlcohol() {
        return strAlcohol;
    }

    @JsonProperty("strAlcohol")
    public void setStrAlcohol(String strAlcohol) {
        this.strAlcohol = strAlcohol;
    }

    @JsonProperty("strABV")
    public Object getStrABV() {
        return strABV;
    }

    @JsonProperty("strABV")
    public void setStrABV(Object strABV) {
        this.strABV = strABV;
    }


}
