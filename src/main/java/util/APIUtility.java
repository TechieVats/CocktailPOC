package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.Configuration;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

import java.util.HashMap;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class APIUtility {

    public RequestSpecification request = RestAssured.given();
    private static Logger Log = LogManager.getLogger(APIUtility.class.getName());
    private static final String CONTENT_TYPE = "application/json";
    Configuration config = new Configuration();


    public Response response = null;

    public RequestSpecification setBaseURI() {

        try {
            Log.info("Passed: New API call started");
            request = request.baseUri(config.getCustomProperty("BaseURI"));
            Log.info("Passed: user set the baseURI for the API call"+config.getCustomProperty("BaseURI"));
            return request;

        } catch (Exception e) {
            Log.error("Fail: user not able to set the baseURI for the API call");
            return null;
        }

    }

    public void setHeaderAsContentType() {
        try {
            request = request.header("Content-Type", CONTENT_TYPE);
            Log.info("Passed: user set the Content-Type " + CONTENT_TYPE);
        } catch (Exception e) {
            Log.error("Fail: user not able to set the Content-Type");
        }
    }

    public void setJsonBodyInRequest(String payload) {
        try {
            request = request.body(payload);
            Log.info("Passed: user sent the payload with the request");
        } catch (Exception e) {
            Log.error("Fail: user is not able to send the payload with the request");
        }
    }

    public Response apiGETCall(String endpoint) {
        return request.get(endpoint);
    }

    public void validatingStatusCode(Response res, Integer statusCodeToBeExpected) {
        try {
            Assertions.assertThat(res.getStatusCode()).isEqualTo(statusCodeToBeExpected);
            Log.info("Passed: status code is " + statusCodeToBeExpected);
        } catch (Exception e) {
            Log.error("Fail: status code is not " + statusCodeToBeExpected);
        }
    }


    public void validatingContentType(Response res, String expectedContentType) {
        try {
            Assertions.assertThat(res.getContentType()).isEqualTo(expectedContentType);
            Log.info("Passed: Content type is validated as " + expectedContentType);
        } catch (Exception e) {
            Log.error("Fail: Content type is not as expected :" + expectedContentType);
        }
    }

    public RequestSpecification setQueryParam(String key, String value) {
        HashMap<String, String> queryParams = new HashMap<String, String>();
        queryParams.put(key, value);
        return request.queryParams(queryParams);
    }

    public void schemaValidator(Response res, String path) {
        try {
            assertThat(res.getBody().asString(),matchesJsonSchemaInClasspath(path));
            Log.info("Passed: Schema has been validated");
        } catch (Exception e) {
            Log.error("Fail: not able to validate the schema:"+ res.getBody().asString());
        }

    }

}
