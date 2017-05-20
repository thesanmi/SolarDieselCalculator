/**
 * 
 */

/**
 * @author TheSanmi
 *
 */
public class PricePoint {

	/**
	 * @param args
	 */

	public static double GDP_PC_NGR; //GDP per capita Nigeria, dollars
	public static double GDP_PC_USA;  //GDP per capita USA, dollars
	public static double HOUSESIZE_NGR; //average household size of Nigerian family
	public static double HOUSESIZE_US; //average household size of US family
	public static double HOUSESIZE_WORLD; //average household size worldwide 
	public static double CONS_NGR_YR_PC; //Energy consumed per year per capita Nigeria //TO DO check if legit
	public static double CONS_NGR_DAY_PC; //Energy consumed per day per capita Nigeria
	public static double CONS_US_YR_PC; //Energy consumed per year per capita US
	public static double CONS_US_DAY_PC; //Energy consumed per day per capita US
	public static double CONS_WORLD_YR_PC; //Energy consumed per year per capita worldwide
	public static double CONS_WORLD_DAY_PC; //Energy consumed per day per capita worldwide
	public static double CONS_NGR_YR; //Energy consumed per year in a household Nigeria
	public static double CONS_NGR_DAY; 
	public static double CONS_US_YR; //Energy consumed per year in a household US
	public static double CONS_US_DAY; 
	public static double CONS_WORLD_YR; //Energy consumed per year in a household worldwide
	public static double CONS_WORLD_DAY; 
	public static double HOUSE_CONS_NG; //Energy consumed per day in a household Nigeria
	public static double HOUSE_CONS_US; //Energy consumed per day in a household US
	public static double HOUSE_CONS_NG_F; //Energy consumed per day in a household Nigeria, Forecast
	public static double HOUSE_CONS_WORLD; //Energy consumed per day in a household worldwide
	public static double POWER_NGR_FORECAST;
	public static double CONS_NGR_YR_FORECAST;
	public static double CONS_NGR_DAY_F;
	public static double CONS_NGR_YR_F;
	public static double POP_NGR; //population of Nigeria, people
	public static double SC_EFF; //solar sell efficiency
	public static double B_EFF; //solar cell battery efficiency
	public static double G_EFF; //generator efficiency
	public static double SC_COST_AREA; //cost of solar cell per area (per m^2)
	public static double SC_COST_WATT; //cost solar cell per watt
	public static double G_COST_WATT; //cost of generator per wayy
	public static double B_COST; //per watt hour
	public static double DIESEL_COST; //cost of diesel per gallon
	public static double S_IRR; //solar cell irradiation watt per m^2 
	public static double NUM_SUNHOURS; //number of sun light hours

	public static double GEN_CAPACITY; //generator capacity for system (watts)

	/*
	 * Sets default values for variables
	 * */
	public static void setDefaults(){
		POP_NGR = 182202; //Source: Worldometer
		GDP_PC_NGR = 2640; //Source: World Bank
		GDP_PC_USA = 55836.8; //Source: World Bank
		HOUSESIZE_NGR = 5; //Edited guess, Source: 5 [DHS], 4.5 [Arcgis], 5.9 [Kwara State Gov]
		HOUSESIZE_US = 2.54; //Statista.com https://www.statista.com/statistics/183648/average-size-of-households-in-the-us/
		//HOUSESIZE_WORLD = HOUSESIZE_NGR; //assumption
		HOUSESIZE_WORLD = 3.36; //average from Wikipedia 
		CONS_NGR_YR_PC = 142 * 1000; //watt hours Source: World Bank  
		CONS_NGR_DAY_PC = CONS_NGR_YR_PC/365.25;
		CONS_US_YR_PC = 13000 * 1000; //watt hours Source: World Bank
		CONS_US_DAY_PC =  CONS_US_YR_PC/365.25;
		CONS_WORLD_YR_PC = 3104 * 1000; //watt hours Source: World Bank
		CONS_WORLD_DAY_PC = CONS_WORLD_YR_PC/365.25;
		CONS_NGR_YR = CONS_NGR_YR_PC * HOUSESIZE_NGR; //watt hours
		CONS_NGR_DAY = CONS_NGR_YR/365.25 ;
		CONS_US_YR = CONS_US_YR_PC * HOUSESIZE_US; //watt hours
		CONS_US_DAY = CONS_US_YR/365.25;
		CONS_WORLD_YR = CONS_WORLD_YR_PC * HOUSESIZE_WORLD; //watt hours
		CONS_WORLD_DAY = CONS_WORLD_YR/365.25;

		POWER_NGR_FORECAST = 14630 * 1000000; //Peak forecast in Watts Source: TCN
		CONS_NGR_YR_FORECAST = POWER_NGR_FORECAST * 24 * 365.25 ;  //Watt hours
		CONS_NGR_YR_F = CONS_NGR_YR_FORECAST/POP_NGR;
		CONS_NGR_DAY_F = CONS_NGR_YR_F/365.25 ;		

		HOUSE_CONS_NG = CONS_NGR_DAY_PC * HOUSESIZE_NGR;
		HOUSE_CONS_NG_F = CONS_NGR_DAY_F * HOUSESIZE_NGR;
		HOUSE_CONS_US = CONS_US_DAY_PC * HOUSESIZE_US;
		HOUSE_CONS_WORLD = CONS_US_DAY_PC * HOUSESIZE_WORLD;

		NUM_SUNHOURS = 6;

		SC_EFF = 0.15; //Source: MIT http://news.mit.edu/2016/new-solar-cell-more-efficient-costs-less-its-counterparts-0829
		B_EFF = 0.9; //Source: https://web.archive.org/web/20090326150713/http://www.pluginhighway.ca/PHEV2007/proceedings/PluginHwy_PHEV2007_PaperReviewed_Valoen.pdf
		G_EFF = 0.4; //Source: Electropaedia http://www.mpoweruk.com/energy_efficiency.htm
		S_IRR = 4.68 * 1000; //watt hours per m^2 per day Source: Solar Electricity Handbook. http://solarelectricityhandbook.com/solar-irradiance.html
		SC_COST_WATT = 3.7; //http://news.energysage.com/how-much-does-the-average-solar-panel-installation-cost-in-the-u-s/
		G_COST_WATT = 0.15; // Source: http://www.dieselserviceandsupply.com/Diesel_Fuel_Consumption.aspx
		B_COST = 0.5; //watt hour. Source: https://cleantechnica.com/2014/10/13/battery-costs-may-drop-100kwh/

		DIESEL_COST = 3.78541 * 0.61; //per gallon. Source: Global Petrol Prices http://www.globalpetrolprices.com/Nigeria/diesel_prices/


	}

	/*public static double priceSolarArea(boolean useDefaults, char target, int hoursToRun){

		if (useDefaults ) setDefaults();
		double total_energy;
		switch(target){
			case 'W': 	total_energy = HOUSE_CONS_WORLD;
						break;
			case 'U': 	total_energy = HOUSE_CONS_US;
				break;
			case 'N':	total_energy = HOUSE_CONS_NG_F;
				break;
			default:	total_energy = HOUSE_CONS_NG_F;
				break;
		}

		double panel_size = total_energy/(S_IRR * SC_EFF);
		double max_energy = NUM_SUNHOURS * S_IRR;

		return panel_size* SC_COST_AREA;


	}*/

	/*
	 * input:
	 * 	 useDefaults, uses default values in the class
	 * 	 target: character representing what energy consumption target to use target to use U - US average, C- custom target, default - global average consumption
	 *   target_num: amount of electricity consumed in the household per day
	 *   genHours: number of hours to run generator system
	 *   genPercent: percent (from 0 to 1) that generator system produces
	 *   numYears: number of years electricity analysis is performed for
	 * 
	 * */
	public static void systemPrice(boolean useDefaults, char target, double target_num, double genHours, double genPercent, double numYears){
		if (useDefaults ) setDefaults();
		double total_energy;
		
			switch(target){
			//	case 'W': 	total_energy = HOUSE_CONS_WORLD;
			//				break;
			case 'U': 	total_energy = HOUSE_CONS_US; 
			break;
			case 'C': 	total_energy = target_num; 
			break;
			//	case 'N':	total_energy = HOUSE_CONS_NG_F; //Using projected peak forecast 
			//		break;
			default:	total_energy = HOUSE_CONS_WORLD; 
			break;
			}
		

		System.out.println("System has " + ((1-genPercent)*100) + "% Solar and " + (genPercent*100) + "% Diesel");

		double gen_total_energy = total_energy * genPercent;
		double solar_total_energy = total_energy - gen_total_energy;

		double solar_system_price = priceSolar(solar_total_energy, 24 - genHours);
		double gen_system_price = priceDiesel(gen_total_energy, genHours);
		double diesel_price = priceDieselFuel(numYears, GEN_CAPACITY, genHours);
		double total_cost = solar_system_price + gen_system_price + diesel_price;

		System.out.println("Total Cost of Solar System : $ " + solar_system_price);
		System.out.println("Cost of Diesel System: $ " + gen_system_price);
		System.out.println("Cost of Fuel for Diesel System for " + (int) numYears + " years: $ " + diesel_price);
		System.out.println("Total Cost of Fuel and Diesel System for " + (int) numYears + " years: $ " + (diesel_price + gen_system_price) );
		System.out.println("Total Cost for " + (int) numYears + " years: $ " + total_cost);

	}




	public static double priceDiesel(double total_energy, double hoursToRun){

		double system_cost = 0;

		GEN_CAPACITY = (total_energy / hoursToRun) * (1/G_EFF);
		system_cost = GEN_CAPACITY * G_COST_WATT;

		return system_cost;

	}

	public static double priceDieselFuel(double numberYears, double gen_capacity, double numHours){
		double gal_per_hr = (7e-5* gen_capacity) +0.4234; //y = 7E-05x + 0.4234, R² = 0.99998
		double gal_per_day = gal_per_hr * numHours;
		double cost_per_day = gal_per_day * DIESEL_COST;
		double num_days = 365.25 * numberYears;
		double fuel_cost = cost_per_day * num_days;		
		return fuel_cost;

	}



	public static double priceSolar(double total_energy, double solar_hours){

		System.out.println("Solar Energy Target: (Watt-hours) " + total_energy);
		double total_energy_hr = total_energy/solar_hours;
		double system_rating = (total_energy/NUM_SUNHOURS);// * (1/SC_EFF); //TODO
		double system_cost = system_rating * SC_COST_WATT;
		System.out.println("System Rating: " + system_rating);
		double energy_storage = total_energy - (total_energy_hr * NUM_SUNHOURS); //amount of energy battery needs to store
		double battery_cap = energy_storage * (1/B_EFF);
		//System.out.println("Solar Hours: " + solar_hours);
		//System.out.println("Total Energy: " + total_energy);
		//System.out.println("Battery capacity: " + battery_cap);
		System.out.println("Cost of Solar Cells: $" + system_cost );
		double battery_cost = battery_cap * B_COST;
		System.out.println("Cost of Batteries: $" + battery_cost );
		system_cost += battery_cost;


		return system_cost;


	}

	public static void main(String[] args) {

		systemPrice(true, 'G', 0, (24-NUM_SUNHOURS)/2, 1, 2);
		//systemPrice(true, 'U', 0, 0, 2);
	}

}
