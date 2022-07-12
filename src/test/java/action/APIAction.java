package action;

import config.Configuration;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.JSONParser;
import pojo.Drink;
import pojo.Ingredient;
import pojo.SearchCocktail;
import pojo.SearchIngredient;
import util.APIUtility;

import java.io.FileReader;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class APIAction {

    APIUtility apiUtility = new APIUtility();
    Response response;
    List<Ingredient> ingredients;
    Configuration config = new Configuration();
    boolean cockTailFlag = true;
    private static Logger Log = LogManager.getLogger(APIAction.class.getName());

    public void initializingTheCocktailsDetails() {
        apiUtility.setBaseURI();
    }

    public void addingTheIngredients(String ingredient) {
        apiUtility.setQueryParam("i", ingredient);
    }

    public void searchTheIngredients() {
        response = apiUtility.apiGETCall(config.getCustomProperty("COCKTAIL_SEARCH"));
    }

    public void searchByCocktailName(String cocktail) {
        apiUtility.setQueryParam("s", cocktail);
        response = apiUtility.apiGETCall(config.getCustomProperty("COCKTAIL_SEARCH"));
    }

    public void filterByAlcoholicContent(String content) {
        apiUtility.setQueryParam("a", content);
        response = apiUtility.apiGETCall(config.getCustomProperty("COCKTAIL_FILTER"));
    }

    public void validatingAlcoholWithABV() {
        var searchIngredient = response.getBody().as(SearchIngredient.class);
        ingredients = searchIngredient.getIngredients();
        String alcohol = ingredients.get(0).getStrAlcohol();
        var abv = ingredients.get(0).getStrABV();
        if (alcohol.contains("Yes")) {
            assertThat(abv).isNotNull();
        } else
            assertThat(abv).isNull();
    }

    public void loggingTheIngredients() {
        Log.info("Id : " + ingredients.get(0).getIdIngredient());
        Log.info("Ingredient : " + ingredients.get(0).getStrIngredient());
        Log.info("Description : " + ingredients.get(0).getStrDescription());
        Log.info("Type : " + ingredients.get(0).getStrIngredient());
        Log.info("Alcohol : " + ingredients.get(0).getStrAlcohol());
        Log.info("ABV : " + ingredients.get(0).getStrABV());
    }

    public void validatingTheStatusCodeToBe200() {
        apiUtility.validatingStatusCode(response, 200);
    }

    public void validatingIfCockTailsExists() {
        var cockTails = response.getBody().as(SearchCocktail.class);
        if (cockTails.getDrinks() == null) {
            cockTailFlag = false;
        }
    }

    public void validatingTheCockTailSchema() {
        if (cockTailFlag)
            apiUtility.schemaValidator(response, "schema/SearchCocktail.json");
        else
            Log.info("Cocktail does not exists");
    }

    public void validatingTheFilterResponse() {
        apiUtility.schemaValidator(response, "schema/FilterCocktail.json");
    }

    public void lookingUpRandomCocktail() {
        response = apiUtility.apiGETCall(config.getCustomProperty("COCKTAIL_RANDOM"));
    }

    public void validatingTheRandomResponse() {
        apiUtility.schemaValidator(response, "schema/SearchCocktail.json");
    }
}
