package GetRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RCBTeam {
	
	@Test
	public void getForeignPlayersName() {
		RestAssured.baseURI = "https://gist.github.com/kumarpani/1e759f27ae302be92ad51ec09955e765";
		int count = 0;
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET);
		String[] countries = response.jsonPath().get("player.country");
		for(String country : countries) {
			if(!country.equals("India")) {
				count++;
			}
		}
		Assert.assertEquals(count,"4");
		System.out.println("The team has only 4 foreign players");	
	}
	
	@Test
	public void getCountOfWicketKeeper() {
		RestAssured.baseURI = "https://gist.github.com/kumarpani/1e759f27ae302be92ad51ec09955e765";
		int count = 0;
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET);
		String[] playersrole = response.jsonPath().get("player.role");
		for(String role : playersrole) {
			if(role.equals("Wicket-keeper")) {
				count++;
			}
		}
		Assert.assertEquals(count,"1");
		System.out.println("The team has only 1 Wicket-keeper");
	}
	

}
