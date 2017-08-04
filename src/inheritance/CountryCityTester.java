package inheritance;

public class CountryCityTester {

	public static void main(String[] args) {
		CityMgr mgr = new CityMgr();
		Country[] countries = Country.values();
		int index = (int)((Math.random()*6));
		City city = mgr.getCity(countries[index]);
		System.out.println("Country: " + countries[index].name() + "\t" + city);

	}

}
