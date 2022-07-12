package stepdefinition;

import action.APIAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cocktail {

    APIAction apiAction = new APIAction();

    @Given("that user is initializing the cocktail base uri")
    public void thatUserIsInitializingTheBaseUri() {
        apiAction.initializingTheCocktailsDetails();
    }

    @When("the user search the ingredients as {string}")
    public void theUserSearchTheIngredientsAs(String ingredient) {
        apiAction.addingTheIngredients(ingredient);
        apiAction.searchTheIngredients();
    }


    @Then("user is able to validate and return the required fields")
    public void userIsAbleToValidateAndReturnTheRequiredFields() {
        apiAction.validatingTheStatusCodeToBe200();
        apiAction.validatingAlcoholWithABV();
        apiAction.loggingTheIngredients();
    }

    @Then("the user is able to validate the response and any required schema properties")
    public void userIsAbleToValidateTheResponseAndRequiredSchemaProperties() {
        apiAction.validatingTheStatusCodeToBe200();
        apiAction.validatingIfCockTailsExists();
        apiAction.validatingTheCockTailSchema();
    }

    @When("the user search the name of {string}")
    public void theUserSearchTheNameOf(String nameOfCocktail) {
        apiAction.searchByCocktailName(nameOfCocktail);
    }

    @When("a user searches for cocktails based on their {string}")
    public void aUserSearchesForCocktailsBasedOnTheir(String content) {
        apiAction.filterByAlcoholicContent(content);
    }

    @Then("the user is able to validate the response by filtering cocktails api")
    public void theUserIsAbleToValidateTheResponseByFilteringCocktailsApi() {
        apiAction.validatingTheStatusCodeToBe200();
        apiAction.validatingTheFilterResponse();
    }

    @When("a user lookup for a random cocktail")
    public void aUserLookupForARandomCocktail() {
        apiAction.lookingUpRandomCocktail();
    }

    @Then("the user is able to validate the standard schema of the cocktail")
    public void theUserIsAbleToValidateTheStandardSchemaOfTheCocktail() {
        apiAction.validatingTheStatusCodeToBe200();
        apiAction.validatingTheRandomResponse();
    }
}
