//import java.util.ArrayList;
//
//public class CarDealer {
//	private String dealerName; 	  	  // Car Company name
//	private ArrayList<String> models; // Car models that are for sell
//	private int carAmount; 			  // Amount of cars available in the storage
//	private int workers;  			  // Employees that work at the car company
//	private int capital;			  // Money of the company
//
//
//	public CarDealer(String dealerName, ArrayList<String> models, int carAmount, int workers, int capital) {
//		this.dealerName = dealerName;
//		this.models = models;
//		this.carAmount = carAmount;
//		this.workers = workers;
//		this.capital = capital;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof CarDealer) {
//			CarDealer c = (CarDealer) obj;
//			return this.dealerName.equals(c.dealerName) && this.models.equals(c.models) &&
//					this.carAmount == c.carAmount && this.workers == c.workers && this.capital == c.capital;
//		}
//		return false;
//	}
//
//
//	/**
//	 * Exercise 1: Is the end of the week and the workers charge there weekly payment. It looks like you have to pay your
//	 * workers as a whole.  Every workers has to get paid.  The boss wants to know how much you payed the workers.
//	 * Their hourly salary is 10 per hour if workers worked more than 40 hours per week, the extra hour bonus(1.5) is added
//	 * to the payment.
//	 * Hint: Remember the money comes from somewhere.
//	 * Hint: Formula => hours + bonus (The fun part is how you get the bonus ;) )
//	 * @param hoursWorked
//	 * @return the amount that you paid the workers for the week.
//	 */
//	public int workersPayment(int hoursWorked) {
//		//	YOUR CODE HERE
//		int extraHours = (hoursWorked/this.getWorkers() - 40);
//		int normalPay = this.getWorkers() * 40 * 10;
//		double bonus = extraHours * this.getWorkers() * 10 * 1.5;
//		this.setCapital(this.getCapital() - (normalPay + (int)bonus));
//		return normalPay + (int)bonus; //Dummy return
//	}
//
//	/**
//	 * Exercise 2: A Car Dealer across the street wants to know if he can trade with you some cars that he has.
//	 * The problem is that you can only receive cars of the same model or you can get in big trouble.
//	 * However, the fee of trading a car has a cost of:
//	 *  	$8,500 for 1 up to 3 cars(per car)
//	 *  	$7,000 for 4 up to 7 cars(per car)
//	 *  	$5,200 for 8 and up amount of cars
//	 * Finally we want to know which cars we got trading.
//	 * Hint: For loops
//	 * @param cars
//	 * @return return an array containing the cars traded.
//	 */
//	public String[] tradeInCar(ArrayList<String> cars) {
//		//	YOUR CODE HERE
//		ArrayList<String> tCars = new ArrayList<String>();
//
//		int u =0;
//		for(int i=0; i<this.getModels().size();i++) {
//			for(int j=0; j<cars.size();j++) {
//				if(cars.get(j).equals(this.getModels().get(i))){
//					tCars.add(cars.get(j));
//				}
//			}
//		}
//		//Passing values from ArrayList to Array
//		String[] tradedCars = new String[tCars.size()];
//		for(int i=0;i<tCars.size();i++) {
//			tradedCars[i] = tCars.get(i);
//		}
//
//		// The Trade fee
//		int carAmount = tradedCars.length;
//		if(carAmount >= 1 && carAmount <= 3) {
//			this.setCapital(this.getCapital() - (8500 * carAmount));
//		} else if(carAmount >= 4 && carAmount <= 7) {
//			this.setCapital(this.getCapital() - (7000 * carAmount));
//		} else {
//			this.setCapital(this.getCapital() - (5200 * carAmount));
//		}
//
//		return tradedCars; //Dummy return;
//	}
//
//	/**
//	 * Exercise 3: It's Wednesday and that means that new cars are arriving from the shipment container.
//	 * When arriving to the car dealer the truck driver notices that the Inventory Paper was left at the dock.
//	 * You have to make a new file in which it has the amount of car per model in order to put them in inventory.
//	 * Hint: Every Car Dealer have different amounts of model. Check amount before making array.
//	 * @param newCars
//	 * @return a list following this format [firstCarModelAmount, secCarModel2Amount, thirdCarModelAmount,...]
//	 */
//	public int[] checkInventory(ArrayList<String> newCars) {
//		//	YOUR CODE HERE
//		int count = 0;
//		int[] inventory = new int[this.getModels().size()];
//		for(int i=0; i<this.getModels().size();i++) {
//			for(int j=0; j<newCars.size();j++) {
//				if(this.getModels().get(i).equals(newCars.get(j))) {
//					count++;
//				}
//			}
//			inventory[i]=count;
//			count=0;
//		}
//		return inventory; //Dummy return;
//	}
//
//	/**
//	 * Exercise 4: It's a weekday and a Person comes and wants to buy a car.  However, the car dealer adds fees depending
//	 * the day of the week.  Remember that this person has to pay state tax (12%) fees plus the car buying fee (5%)
//	 * implemented to reduce the desire of buying cars instead of using public transportation.  You must use loops to find
//	 * Car Model Price.
//	 * Hint: the prices are in order [CarModel1Price, CarModel2Price,...]
//	 * Hint#2: the array should be in the same order as the models ArrayList
//	 * @param carModel, carModelPrices array
//	 * @return the price of the car after all taxes and fees are added.
//	 */
//	public int carSellTotal(String carModel, int[] carModelPrices) {
//		//  YOUR CODE HERE
//		int pos =0;
//		for(int i=0; i<this.getModels().size();i++) {
//			if(carModel.equals(this.getModels().get(i))) {
//				pos = i;
//			}
//		}
//		int carPrice = carModelPrices[pos];
//		int total = (int) (carPrice * 1.17);
//		this.setCapital(this.getCapital() + total);
//		this.setCarAmount(this.getCarAmount()-1);
//		return total;
//	}
//
//	/**
//	 * Exercise 5: The owner of the Car Dealer wants to buy the car dealer down the street since it sells various cars.
//	 * Condition: if the owner's car dealer car capacity is larger than the other car dealer, then he will buy it.
//	 * Otherwise, he will not buy the other car dealer.
//	 * However if the car amount is equal to the other car dealer or the car amount multiplied by 1.2 is smaller or equal than
//	 * car amount, if the owners capital is larger than the others capital then he will buy the other car dealer.
//	 * @param carDealer
//	 * @return
//	 */
//	public boolean buyRivalDealer(CarDealer carDealer) {
//		boolean des = false;
//		if(this.getCarAmount() > carDealer.getCarAmount()) {
//			des = true;
//		} else if(this.getCarAmount() == carDealer.getCarAmount() || this.getCarAmount() * 1.2 <= carDealer.getCarAmount()) {
//			if(this.getCapital() > carDealer.getCapital()) {
//				des = true;
//			}
//		} else if(this.getCarAmount() < carDealer.getCarAmount()) {
//			des = false;
//		}
//		return des;
//	}
//
//
//	// Getters
//	public String getdealerName() {return dealerName;}
//	public ArrayList<String> getModels() {return models;}
//	public int getCarAmount() {return carAmount;}
//	public int getWorkers() {return workers;}
//	public int getCapital() {return capital;}
//
//	// Setters
//	public void setdealerName(String dealerName) {this.dealerName = dealerName;}
//	public void setModels(ArrayList<String> models) {this.models = models;}
//	public void setCarAmount(int carAmount) {this.carAmount = carAmount;}
//	public void setWorkers(int workers) {this.workers = workers;}
//	public void setCapital(int capital) {this.capital = capital;}
//}
//Solution for Car Dealer
import java.util.ArrayList;

public class CarDealer {
	private String dealerName; // Car Company name
	private ArrayList<String> models; // Car models that are for sell
	private int carAmount; // Amount of cars available in the storage
	private int workers; // Employees that work at the car company
	private int capital; // Money of the company

	public CarDealer(String dealerName, ArrayList<String> models, int carAmount, int workers, int capital) {
		this.dealerName = dealerName;
		this.models = models;
		this.carAmount = carAmount;
		this.workers = workers;
		this.capital = capital;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CarDealer) {
			CarDealer c = (CarDealer) obj;
			return this.dealerName.equals(c.dealerName) && this.models.equals(c.models) && this.carAmount == c.carAmount
					&& this.workers == c.workers && this.capital == c.capital;
		}
		return false;
	}

	/**
	 * Exercise 1: Is the end of the week and the workers charge there weekly
	 * payment. It looks like you have to pay your workers as a whole. Every workers
	 * has to get paid. The boss wants to know how much you payed the workers. Their
	 * hourly salary is 10 per hour if workers worked more than 40 hours per week,
	 * the extra hour bonus(1.5) is added to the payment. Hint: Remember the money
	 * comes from somewhere. Hint: Formula => hours + bonus (The fun part is how you
	 * get the bonus ;) )
	 * 
	 * @param hoursWorked
	 * @return the amount that you paid the workers for the week.
	 */
	public int workersPayment(int hoursWorked) {
		// YOUR CODE HERE
		int extraHours = (hoursWorked / this.getWorkers() - 40);
		int normalPay = this.getWorkers() * 40 * 10;
		double bonus = extraHours * this.getWorkers() * 10 * 1.5;
		this.setCapital(this.getCapital() - (normalPay + (int) bonus));
		return normalPay + (int) bonus; // Dummy return
	}

	/**
	 * Exercise 2: A Car Dealer across the street wants to know if he can trade with
	 * you some cars that he has. The problem is that you can only receive cars of
	 * the same model or you can get in big trouble. However, the fee of trading a
	 * car has a cost of: $8,500 for 1 up to 3 cars(per car) $7,000 for 4 up to 7
	 * cars(per car) $5,200 for 8 and up amount of cars Finally we want to know
	 * which cars we got trading. Hint: For loops
	 * 
	 * @param cars
	 * @return return an array containing the cars traded.
	 */
	public String[] tradeInCar(ArrayList<String> cars) {
		// YOUR CODE HERE
		ArrayList<String> tCars = new ArrayList<String>();

		int u = 0;
		for (int i = 0; i < this.getModels().size(); i++) {
			for (int j = 0; j < cars.size(); j++) {
				if (cars.get(j).equals(this.getModels().get(i))) {
					tCars.add(cars.get(j));
				}
			}
		}
		// Passing values from ArrayList to Array
		String[] tradedCars = new String[tCars.size()];
		for (int i = 0; i < tCars.size(); i++) {
			tradedCars[i] = tCars.get(i);
		}

		// The Trade fee
		int carAmount = tradedCars.length;
		if (carAmount >= 1 && carAmount <= 3) {
			this.setCapital(this.getCapital() - (8500 * carAmount));
		} else if (carAmount >= 4 && carAmount <= 7) {
			this.setCapital(this.getCapital() - (7000 * carAmount));
		} else {
			this.setCapital(this.getCapital() - (5200 * carAmount));
		}

		return tradedCars; // Dummy return;
	}

	/**
	 * Exercise 3: It's Wednesday and that means that new cars are arriving from the
	 * shipment container. When arriving to the car dealer the truck driver notices
	 * that the Inventory Paper was left at the dock. You have to make a new file in
	 * which it has the amount of car per model in order to put them in inventory.
	 * Hint: Every Car Dealer have different amounts of model. Check amount before
	 * making array.
	 * 
	 * @param newCars
	 * @return a list following this format [firstCarModelAmount,
	 *         secCarModel2Amount, thirdCarModelAmount,...]
	 */
	public int[] checkInventory(ArrayList<String> newCars) {
		// YOUR CODE HERE
		int count = 0;
		int[] inventory = new int[this.getModels().size()];
		for (int i = 0; i < this.getModels().size(); i++) {
			for (int j = 0; j < newCars.size(); j++) {
				if (this.getModels().get(i).equals(newCars.get(j))) {
					count++;
				}
			}
			inventory[i] = count;
			count = 0;
		}
		for (int i : inventory) {
			System.out.println(i);
		}
		return inventory; // Dummy return;
	}

	/**
	 * Exercise 4: It's a weekday and a Person comes and wants to buy a car.
	 * However, the car dealer adds fees depending the day of the week. Remember
	 * that this person has to pay state tax (12%) fees plus the car buying fee (5%)
	 * implemented to reduce the desire of buying cars instead of using public
	 * transportation. You must use loops to find Car Model Price. Hint: the prices
	 * are in order [CarModel1Price, CarModel2Price,...] Hint#2: the array should be
	 * in the same order as the models ArrayList
	 * 
	 * @param carModel, carModelPrices array
	 * @return the price of the car after all taxes and fees are added.
	 */
	public int carSellTotal(String carModel, int[] carModelPrices) {
		// YOUR CODE HERE
		int pos = 0;
		for (int i = 0; i < this.getModels().size(); i++) {
			if (carModel.equals(this.getModels().get(i))) {
				pos = i;
			}
		}
		int carPrice = carModelPrices[pos];
		int total = (int) (carPrice * 1.17);
		this.setCapital(this.getCapital() + total);
		this.setCarAmount(this.getCarAmount() - 1);
		return total;
	}

	/**
	 * Exercise 5: The owner of the Car Dealer wants to buy the car dealer down the
	 * street since it sells various cars. Condition: if the owner's car dealer car
	 * capacity is larger than the other car dealer, then he will buy it. Otherwise,
	 * he will not buy the other car dealer. However if the car amount is equal to
	 * the other car dealer or the car amount multiplied by 1.2 is smaller or equal
	 * than car amount, if the owners capital is larger than the others capital then
	 * he will buy the other car dealer.
	 * 
	 * @param carDealer
	 * @return
	 */
	public boolean buyRivalDealer(CarDealer carDealer) {
		boolean des = false;
		if (this.getCarAmount() > carDealer.getCarAmount()) {
			des = true;
		} else if (this.getCarAmount() == carDealer.getCarAmount()
				|| this.getCarAmount() * 1.2 <= carDealer.getCarAmount()) {
			if (this.getCapital() > carDealer.getCapital()) {
				des = true;
			}
		} else if (this.getCarAmount() < carDealer.getCarAmount()) {
			des = false;
		}
		return des;
	}

	// Getters
	public String getdealerName() {
		return dealerName;
	}

	public ArrayList<String> getModels() {
		return models;
	}

	public int getCarAmount() {
		return carAmount;
	}

	public int getWorkers() {
		return workers;
	}

	public int getCapital() {
		return capital;
	}

	// Setters
	public void setdealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public void setModels(ArrayList<String> models) {
		this.models = models;
	}

	public void setCarAmount(int carAmount) {
		this.carAmount = carAmount;
	}

	public void setWorkers(int workers) {
		this.workers = workers;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}
}
