package api.steps;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.Map;

public class ApiSteps {

  private Response response;
  private Map<String,String> country;

  @Before
  public void setUp(){
    RestAssured.baseURI = "http://services.groupkt.com/country/";
    response = null;
  }

  @Given("^I have an API with a country list$")
  public void setUpCountryListAPI() throws Throwable {
    RestAssured.basePath = "/get/all";
  }


  @When("^I retrieve the list of countries$")
  public void retrieveAllCountries() throws Throwable {
    response = RestAssured.get();
  }

  @Then("^I check the following countries are successfully retrieved$")
  public void verifyRequiredCountriesAreReturnedSuccessfully(List<String> countries) throws Throwable {
    assertThat(response.statusCode(), equalTo(200));
    assertThat(response.getBody().print(), matchesJsonSchemaInClasspath("country-list-schema.json"));
    assertThat(response.getBody().path("RestResponse.result.alpha2_code"), hasItems(countries.toArray() ));
    }

  @Given("^I have an API with country information to consume$")
  public void setUpCountryDetailsApi() throws Throwable {
    RestAssured.basePath = "/get/iso2code";
  }

  @When("^I consume the country (.*)$")
  public void iConsumeTheCountryCountry(String country) throws Throwable {
    response = RestAssured.get(String.format("/%s", country));
  }

  @Then("^I verify the data retrieved respects the expected structure$")
  public void iVerifyTheDataRetrievedRespectsTheExpectedStructure() throws Throwable {
    assertThat(response.statusCode(), equalTo(200));
    assertThat(response.getBody().print(), matchesJsonSchemaInClasspath(
        "country-detail-schema.json"));
  }

  @Given("^I have an API to create a new country$")
  public void setUpCreationApi() throws Throwable {
    RestAssured.baseURI =  "http://demo6295711.mockable.io";
  }

  @When("^I create a new country with the following data$")
  public void postCountryToEndpoint(DataTable countryData) throws Throwable {
    String json = new Gson().toJson(countryData.asMap(String.class, String.class));
    RestAssured.given().contentType(ContentType.JSON).body(json).post("/post");
  }
}
