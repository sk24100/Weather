package api;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class TestCurrentWeather extends TestBase {
	
	
	@Test(dataProvider = "latandlon")
	public void testCurrentWeatherWithLatAndLon(Integer lat, Integer lon) {
		
		given()
			.queryParam("lat", lat)
			.queryParam("lon", lon)
			.queryParam("key", TestConstants.API_KEY)
		.when().log().all()
			.get(TestConstants.APOI_BASE_URL + "current")
		.then()
			.statusCode(200);		
	}
	
	
	@Test (dataProvider = "postalcode")
	public void testCurrentWeatherWithPostCode(String postalCode) {
		given().queryParam("postal_code", postalCode).queryParam("key", TestConstants.API_KEY)
		.when().log().all().get(TestConstants.APOI_BASE_URL + "current").then().statusCode(200);
	}
	
	@DataProvider(name = "latandlon")
	public Object[][] getLatAndLonData(){
		Object data[][]=  new Object[1][2];
        // Country1
        data[0][0]= 28; 
        data[0][1]= 78;
         
//        // Canada
//        data[1][0]= "Amod";
//        data[1][1]= "Mahajan";
//         
//        // India
//        data[2][0]= "Animesh";
//        data[2][1]= "Prashant";
//         
//        // Australia
//        data[3][0]= "Ankur";
//        data[3][1]= "Singh";
//         
//        // Africa
//        data[4][0]= "Amritansh";
//        data[4][1]= "Kumar";
        
        return data;
	}
	
	
	
	@DataProvider(name = "postalcode")
	public Object[][] getPostalCode(){
		Object data[][]=  new Object[2][1];
        // London
        data[0][0]= "SE167BL"; 
        data[1][0]= "110085"; 

         
//        // Canada
//        data[1][0]= "Amod";
//        data[1][1]= "Mahajan";
//         
//        // India
//        data[2][0]= "Animesh";
//        data[2][1]= "Prashant";
//         
//        // Australia
//        data[3][0]= "Ankur";
//        data[3][1]= "Singh";
//         
//        // Africa
//        data[4][0]= "Amritansh";
//        data[4][1]= "Kumar";
        
        return data;
	}
}
