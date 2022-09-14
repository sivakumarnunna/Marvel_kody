package com.kody_marvel.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;



public class RestUtils extends WebDriverUtils{
	
	public static Logger logger = LogManager.getLogger(RestUtils.class);

	
	public RequestSpecification getCommonSpec() {
		
		RequestSpecification rspec = RestAssured.given();
		rspec.contentType(ContentType.JSON).baseUri(ApplicationConstants.BASE_URL).queryParams(createapiKey(ApplicationConstants.PRIVATE_KEY, ApplicationConstants.PUBLIC_KEY));
		return rspec;
	}
	public RequestSpecification getCommonSpec(String path) {

		RequestSpecification rSpec = RestAssured.given();
		rSpec.contentType(ContentType.JSON).baseUri(ApplicationConstants.BASE_URL)
				.queryParams(createapiKey(ApplicationConstants.PRIVATE_KEY, ApplicationConstants.PUBLIC_KEY)).basePath(path);
		return rSpec;
	}
	public Map<String, Object> createapiKey(String privatekey, String publickey) {
		Map<String, Object> queryparams = new HashMap<String, Object>();
		String time = String.valueOf(System.currentTimeMillis());
		String hashvalue = DigestUtils
				.md5Hex(time +privatekey + publickey);
		queryparams.put("ts", time);
		queryparams.put("apikey", publickey);
		queryparams.put("hash", hashvalue);
		return queryparams;
	}
	public RequestSpecification getCommonSpec(Map<String, Object> apikey) {
		RequestSpecification rSpec = RestAssured.given();
		rSpec.contentType(ContentType.JSON).baseUri(ApplicationConstants.BASE_URL).queryParams(apikey);
		return rSpec;
	}
	public RequestSpecification getCommonSpec(Map<String, Object> apikey,String path) {
		RequestSpecification rSpec = RestAssured.given();
		rSpec.contentType(ContentType.JSON).baseUri(ApplicationConstants.BASE_URL).queryParams(apikey).basePath(path);
		return rSpec;
	}
	/**
	 * 
	 * This method will deserialize the file into POJO.
	 * 
	 * @param <T>
	 * @param filename
	 * @param T
	 * @return
	 * @throws FileNotFoundException
	 */
	public static <T> T deserialize(String filename, Type T) throws FileNotFoundException {
		FileReader reader = new FileReader("");
		Gson gson = new Gson();
		T data = gson.fromJson(reader, T);
		return data;

	}

	/**
	 * This method will serialize a POJO to string.
	 * 
	 * @param object
	 * @return
	 */
	public static String serialize(Object object) {
		Gson gson = new Gson();
		String st = gson.toJson(object);
		return st;

	}
	
	public Response sendRequest(RequestSpecification request, int requestType, Object pojo) {
		Response response;

		if (pojo != null) {
			String payload = serialize(pojo).toString();
			request.body(payload);

		}

		QueryableRequestSpecification queryRequest = SpecificationQuerier.query(request);
		logger.info("Request");
		logger.info("===============================");
		logger.info("URI " + queryRequest.getURI());
		logger.info("Total Headers count " + queryRequest.getHeaders().size());
		logger.info("Headers " + queryRequest.getHeaders().toString());

		switch (requestType) {
		case ApplicationConstants.POST_REQUEST:
			if (request == null) {
				response = RestAssured.when().post();
			} else {

				logger.info("body is..." + request.get().getBody().asString());
				response = request.post();
			}
			break;
		case ApplicationConstants.DELETE_REQUEST:
			if (request == null) {
				response = RestAssured.when().delete();
			} else {
				response = request.delete();
			}
			break;
		case ApplicationConstants.PUT_REQUEST:
			if (request == null) {
				response = RestAssured.when().put();
			} else {
				response = request.put();
			}
			break;
		case ApplicationConstants.GET_REQUEST:
		default:
			if (request == null) {
				response = RestAssured.when().get();
			} else {
				response = request.get();
				logger.info("Response");
				logger.info("===============================");
				logger.info("Response code : " + response.getStatusCode());
				logger.info("===============================");
				logger.debug("Response Body" + response.getBody().prettyPrint());

			}
			break;
		}
		return response;
	}


}
