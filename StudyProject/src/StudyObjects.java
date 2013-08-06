
public class StudyObjects {
	
	public Auto camaro;
	public Auto sierra;
	public Driver driver;
	
	//public Driver test;
	
	public static void main(String[] args) {
		StudyObjects m = new StudyObjects();
	}
	
	public StudyObjects(){
		
		camaro = new Auto();
		camaro.setTankCapasity(110);
		camaro.fillup(70);
				
		driver = new Driver();
		//driver.increaseExp();
		//driver.increaseExp();
		//driver.increaseExp();
		
		camaro.putDriver(driver);
		camaro.getCurrentDriverExperience();
		
		
		
		//driver.increaseExp();
		//camaro.getCurrentDriverExperience();
		
		//test = new Driver();
		
		/*test.increaseExp();
		test.increaseExp();
		test.increaseExp();
		test.increaseExp();*/
	}
		/*camaro = new Auto();
		sierra = new Auto();
		
		camaro.setSpeedStep(10);
		//camaro.setCurrentSpeed(0);
		//camaro.setBodyType("cab");
		camaro.setTankCapasity(110);
		camaro.setFuelConsumption(10);
		
		//sierra.setSpeedStep(10);
		//sierra.setTankCapasity(60);
		//sierra.setFuelConsumption(10);
		//sierra.setBodyType("no cab");
		
		//sierra.fillup(60);
		//sierra.setSpeedStep(15);
		//sierra.decreaseSpeed();
		//sierra.increaseSpeed();
		//sierra.increaseSpeed();
		
		//sierra.printSpeed();
		
		camaro.fillup(10);
		camaro.fillup(70);
		camaro.increaseSpeed();
		camaro.increaseSpeed();
		camaro.increaseSpeed();
	    camaro.increaseSpeed();
		camaro.decreaseSpeed();
		camaro.decreaseSpeed();
		camaro.decreaseSpeed();
		camaro.decreaseSpeed();
		camaro.decreaseSpeed();
		camaro.decreaseSpeed();
		camaro.decreaseSpeed();
		camaro.decreaseSpeed();
		camaro.fillup(30);
		camaro.decreaseSpeed();
		camaro.decreaseSpeed();
		camaro.increaseSpeed();
		camaro.increaseSpeed();
		camaro.increaseSpeed();
		camaro.increaseSpeed();
		camaro.fillup(0);
		camaro.fillup(-20);
		camaro.fillup(50);
		camaro.increaseSpeed();
		camaro.decreaseSpeed();
		camaro.decreaseSpeed();
		//camaro.increaseSpeed();
		//camaro.increaseSpeed();
		//
		//camaro.printSpeed();
		
		
		
		
		
		//camaro.roofOperating();
		//camaro.roofOperating();
		//sierra.roofOperating();
	}
	*/
	
}
