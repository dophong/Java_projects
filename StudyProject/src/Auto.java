
public class Auto {

	public int currentSpeed = 0;
	public int maxSpeed = 214;
	public int speedStep = 2;
	public boolean isRoofUp = false; 
	public boolean isCabrio;
	public int tankCapasity;
	public int fuelAtNow = 0;
	public int fuelCons = 0;
	public Driver driver;
	
			
			
	public Auto(){
		System.out.println("Конструктор");
		
		//driver = new Driver();
		//System.out.println("Текущий уровень водителя " + driver.getDriverExperience());
	}	
	
	public void increaseSpeed (){
		currentSpeed += speedStep; 
		fuelAtNow -= fuelCons;
		if (fuelAtNow <= 0) {
			System.out.println("Невозможно увеличить скорость. В баке нет бензина");
		currentSpeed = 0;
		fuelAtNow = 0;
		}else{
			System.out.println("Скорость увеличена на" + speedStep + "км/ч. Текущая скорость: " + currentSpeed + "км/ч.");
			System.out.println("Бензин уменьшился на " + fuelCons + "л. В баке осталось " + fuelAtNow + "л.");
			//currentSpeed = currentSpeed + speedStep;	
		}
		
	}
	
	public void printSpeed () {
		System.out.println(currentSpeed);
	}
	
	public void decreaseSpeed (){
		System.out.println("Текущая скорость " + currentSpeed + "км/ч.");
		if (currentSpeed <= 0 ){
			System.out.println("Невозможно уменьшить скорость.");
			System.out.println("Двигатель выключен. В баке " + fuelAtNow + "л.");
		}else{
			currentSpeed -= speedStep;
			if (currentSpeed < 0){
				currentSpeed  = 0;
			}
			
			fuelAtNow -= fuelCons;
			if (fuelAtNow <= 0) {
				System.out.println("Двигатель выключен. В баке " + fuelAtNow + "л.");
				System.out.println("Топливо закончилось.");
			currentSpeed = 0;
			fuelAtNow = 0;
			}else{
				System.out.println("Скорость уменьшена на" + speedStep + "км/ч. Текущая скорость: " + currentSpeed + "км/ч.");
				System.out.println("Бензин уменьшился на " + fuelCons + "л. В баке осталось " + fuelAtNow + "л.");
			}
		
		}
	}
	
	public void setSpeedStep(int newValue){
		speedStep = newValue;
	
	}	
	public void roofOperating(){
		if (isCabrio == true) {
			// поднимаем или опускаем
			if (isRoofUp == true){
				isRoofUp = false;
				System.out.println("Крыша опущена");
			}else {
				isRoofUp = true;
				System.out.println("Крыша поднята");
			}
		}else {
			System.out.println("Машина не кабрио");
		}
	}
	
	public void setBodyType (String cab){
		if ( cab.equals("cab") ){
			isCabrio = true;
		}else if(cab.equals("no cab")){
			isCabrio = false;
		}
	}
	
	public void setTankCapasity (int ltrs){
		tankCapasity = ltrs;
	}
	
	public void fillup (int ltrs){
		if (ltrs < 0 ){
			System.out.println("Некорректное значение.  Количество топлива не может быть отрицательным");
			ltrs= 0;
		} if (ltrs > tankCapasity - fuelAtNow){
			System.out.println("Невозможно залить такое кол-во безнина. В баке свободно " + (tankCapasity - fuelAtNow) + "л. А вы пытаетесь залить " + ltrs + " л.");
		}else {
			fuelAtNow += ltrs;
			System.out.println("Бак заправлен на " + ltrs + " л.");
			System.out.println("В баке " + fuelAtNow + " л. бензина");

		}
	
	}
	
	public void setFuelConsumption (int newFuelCons){
		fuelCons = newFuelCons;
	}
	
	public void putDriver(Driver _driver){
		driver = _driver;
		//getCurrentDriverExperience();
	}
	
	public void getCurrentDriverExperience(){
		System.out.println("::::Текущий уровень водителя " + driver.getDriverExperience());
	}
	
	//public void setCurrentSpeed (int newSpeed ){
		//currentSpeed = newSpeed;
	//}
}
	


