package inheritance;

import java.util.HashMap;
import java.util.Map;

public class CityMgr {

	Map<String, Long> cityPopulationMap = new HashMap<String, Long>();
	Map<Country, String> countryCityMap = new HashMap<Country, String>();

	public CityMgr() {
		countryCityMap.put(Country.CANADA, "Ottawa");
		countryCityMap.put(Country.JAPAN, "Tokyo");
		countryCityMap.put(Country.LEBANON, "Beirut");
		countryCityMap.put(Country.SWEDEN, "Stockholm");
		countryCityMap.put(Country.PERU, "Lima");
		countryCityMap.put(Country.NIGERIA, "Abuja");
		
		cityPopulationMap.put("Ottawa", 100000L);
		cityPopulationMap.put("Tokyo", 100000L);
		cityPopulationMap.put("Beirut", 100000L);
		cityPopulationMap.put("Stockholm", 100000L);
		cityPopulationMap.put("Lima", 100000L);
		cityPopulationMap.put("Abuja", 100000L);
	}

	public String getCityByCountry(Country country) {
		return countryCityMap.get(country);
	}

	public City getCity(Country inCountry) {
		City city = new City();
		city.setName(getCityByCountry(inCountry));
		city.setPopulation(cityPopulationMap.get(city.getName()));

		return city;
	}

}
