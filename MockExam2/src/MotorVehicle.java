public class MotorVehicle {
	
	private String make;
	private String model;
	private String licensePlate;
	private int year;
	private double mileage;
	
	private int warrantyYears;
	private double warrantyMileage;
	
	/*
	 * Constructs a new MotorVehicle with the given parameters
	 */
	public MotorVehicle(String make, String model, String licensePlate, int year, double mileage, int wy, double wm) {
		this.make = make;
		this.model = model;
		this.licensePlate = licensePlate;
		this.year = year;
		this.mileage = mileage;
		this.warrantyYears = wy;
		this.warrantyMileage = wm;
	}

	/*
	 * Contructs a new MotorVehicle object with the same properties as parameter mv
	 */
	public MotorVehicle(MotorVehicle mv) {
		this.make = mv.make;
		this.model = mv.model;
		this.licensePlate = mv.licensePlate;
		this.year = mv.year;
		this.mileage = mv.mileage;
		this.warrantyYears = mv.warrantyYears;
		this.warrantyMileage = mv.warrantyMileage;

	}
	
	// Getters
	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}


	public String getLicensePlate() {
		return licensePlate;
	}


	public int getYear() {
		return year;
	}


	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public int getWarrantyYears() {
		return warrantyYears;
	}


	public double getWarrantyMileage() {
		return warrantyMileage;
	}


	//Setters
	public void setMake(String make) {
		this.make = make;
		
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setWarrantyYears(int warrantyYears) {
		this.warrantyYears = warrantyYears;
	}
	public void setWarrantyMileage(double warrantyMileage) {
		this.warrantyMileage = warrantyMileage;
	}
	

	// Instance methods
	
	/*
	 * Add given additionalMileage to the target MotorVehicle. Modifies the target object.
	 * 
	 */
	public void addMileage(double additionalMileage) {
		this.mileage= mileage+additionalMileage;
		// YOUR CODE HERE
		
	}
	
	/*
	 * Returns the average miles per year achieved by the target MotorVehicle
	 * Average Mileage = mileage / (currentYear - VehicleYear)
	 */
	public double milesPerYear(int currentYear) {
	double averageMileage= this.mileage/(currentYear-this.year);
	return averageMileage; 
	}
	/*
	 * Returns true if the target MotorVehicle is still under warranty
	 * A MotorVehicle is still under warranty if it has NOT surpassed the warranty years NOR the warranty mileage
	 */
	public boolean underWarranty(int currentYear) {
		if(mileage<warrantyMileage && (currentYear-year)<warrantyYears){
		return true;
		}
		else{
			return false;
		}
		
	}

}