package com.kody_marvel.step;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kody_marvel.model.Result;
import com.kody_marvel.model.Root;
import com.kody_marvel.utils.RestUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import io.restassured.response.ResponseBody;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class MarvelCharacterStep extends RestUtils {
	int totalpages;
	Root root = null;
	Set<String> myset = null;
	RequestSpecification request;
	ArrayList<Result> TotalResults = null;
	int availablecomics = 0;
	String uimessage;
	@When("I get the properties and values for all the characters with base path {string}")
	public void i_get_the_properties_and_values_for_all_the_characters_with_base_path(String basepath) {
		this.request = getCommonSpec(basepath);
		int offset = 0;
		int limit = 100;
		this.request.queryParam("limit", limit);
        this.TotalResults = new ArrayList<Result>();
		for (int i = 0; i < 100; i++) {
			this.request.queryParam("offset", offset);
			Response response = sendRequest(this.request, 0, null);
			root = response.getBody().as(Root.class);
			ArrayList<Result> results = root.getData().getResults();
			logger.info("Total size " + results.size());
			if (results.size() == 0) {
				logger.info("got the data for all the Characters");
				break;
			}
			this.TotalResults.addAll(results);
			offset = offset + limit;
			FilterableRequestSpecification filterableRequestSpecification = (FilterableRequestSpecification) this.request;
			filterableRequestSpecification.removeQueryParam("offset");
		}
	}
	@Then("each character should have all the properties listed below")
	public void each_character_should_have_all_the_properties_listed_below(DataTable dataTable) {
		
		
		List<List<String>> properties = dataTable.asLists(String.class);
		this.myset = properties.get(0).stream().collect(Collectors.toSet());
		
			Gson gson = new GsonBuilder().create();
			for (Result result : TotalResults) {
				String json = gson.toJson(result);
				Map<String, Object> resultkeys = new Gson().fromJson(json, Map.class);
				Assert.assertEquals(resultkeys.keySet(), this.myset);
				logger.info("verified that all the properties are present for character.."+resultkeys.get("name")+" in the repsonse");
			}
			
	}
	@When("I give invalid path {string}")
	public void i_give_invalid_path(String basepath) {
		this.request = getCommonSpec(basepath);
	}
	@Then("verify the response code and errormessage")
	public void verify_the_response_code_and_errormessage(DataTable dataTable) {
		List<List<String>> expectedresult = dataTable.asLists();
		Response response = sendRequest(this.request, 0, null);
		Assert.assertEquals( response.getStatusCode(),Integer.parseInt(expectedresult.get(1).get(0)));
		Assert.assertEquals(expectedresult.get(1).get(1), response.getBody().jsonPath().getString("code"));
		Assert.assertEquals(response.getBody().jsonPath().getString("message").contains(expectedresult.get(1).get(2)),true);
	}
	@When("I give wrong credentials {string}")
	public void i_give_worng_credentials(String basepath) {
		Map<String,Object>	apikey = createapiKey("123456", "qwwwwere");
		this.request = getCommonSpec(apikey,basepath);
	}
	@When("I get the properties and values for the character with base path {string}")
	public void i_get_the_properties_and_values_for_the_character_with_base_path(String basepath) {
		this.request = getCommonSpec(basepath);
		Response response = sendRequest(this.request, 0, null);
		this.root = response.getBody().as(Root.class);
		ArrayList<Result> results = root.getData().getResults();
		results.get(0).getComics().getAvailable();

	}

	@Then("get the number of comics")
	public int get_the_number_of_comics() {
		
		ArrayList<Result> results = root.getData().getResults();
		this.availablecomics = results.get(0).getComics().getAvailable();
		System.out.println("Total available comics.."+this.availablecomics);
		return this.availablecomics;
		
	}
	
	@When("I login to page UI {string}")
	public void i_login_to_page_ui(String url) {
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@data-filtercounter='browse']")));
		this.uimessage = driver.findElement(By.xpath("//span[@data-filtercounter='browse']")).getText();
		
	}

	@Then("verify the number of comics in UI")
	public void verify_the_number_of_comics_in_ui() {
		
		Assert.assertEquals(this.uimessage.contains(this.availablecomics+" RESULTS"),true);
	}



}
