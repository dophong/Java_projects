
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
		System.out.println("�����������");
		
		//driver = new Driver();
		//System.out.println("������� ������� �������� " + driver.getDriverExperience());
	}	
	
	public void increaseSpeed (){
		currentSpeed += speedStep; 
		fuelAtNow -= fuelCons;
		if (fuelAtNow <= 0) {
			System.out.println("���������� ��������� ��������. � ���� ��� �������");
		currentSpeed = 0;
		fuelAtNow = 0;
		}else{
			System.out.println("�������� ��������� ��" + speedStep + "��/�. ������� ��������: " + currentSpeed + "��/�.");
			System.out.println("������ ���������� �� " + fuelCons + "�. � ���� �������� " + fuelAtNow + "�.");
			//currentSpeed = currentSpeed + speedStep;	
		}
		
	}
	
	public void printSpeed () {
		System.out.println(currentSpeed);
	}
	
	public void decreaseSpeed (){
		System.out.println("������� �������� " + currentSpeed + "��/�.");
		if (currentSpeed <= 0 ){
			System.out.println("���������� ��������� ��������.");
			System.out.println("��������� ��������. � ���� " + fuelAtNow + "�.");
		}else{
			currentSpeed -= speedStep;
			if (currentSpeed < 0){
				currentSpeed  = 0;
			}
			
			fuelAtNow -= fuelCons;
			if (fuelAtNow <= 0) {
				System.out.println("��������� ��������. � ���� " + fuelAtNow + "�.");
				System.out.println("������� �����������.");
			currentSpeed = 0;
			fuelAtNow = 0;
			}else{
				System.out.println("�������� ��������� ��" + speedStep + "��/�. ������� ��������: " + currentSpeed + "��/�.");
				System.out.println("������ ���������� �� " + fuelCons + "�. � ���� �������� " + fuelAtNow + "�.");
			}
		
		}
	}
	
	public void setSpeedStep(int newValue){
		speedStep = newValue;
	
	}	
	public void roofOperating(){
		if (isCabrio == true) {
			// ��������� ��� ��������
			if (isRoofUp == true){
				isRoofUp = false;
				System.out.println("����� �������");
			}else {
				isRoofUp = true;
				System.out.println("����� �������");
			}
		}else {
			System.out.println("������ �� ������");
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
			System.out.println("������������ ��������.  ���������� ������� �� ����� ���� �������������");
			ltrs= 0;
		} if (ltrs > tankCapasity - fuelAtNow){
			System.out.println("���������� ������ ����� ���-�� �������. � ���� �������� " + (tankCapasity - fuelAtNow) + "�. � �� ��������� ������ " + ltrs + " �.");
		}else {
			fuelAtNow += ltrs;
			System.out.println("��� ��������� �� " + ltrs + " �.");
			System.out.println("� ���� " + fuelAtNow + " �. �������");

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
		System.out.println("::::������� ������� �������� " + driver.getDriverExperience());
	}
	
	//public void setCurrentSpeed (int newSpeed ){
		//currentSpeed = newSpeed;
	//}
}
	


