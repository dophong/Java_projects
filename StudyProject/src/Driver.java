
public class Driver {
	
	private String[] experience = {"noob", "regular", "pro"};
	private int currentExp = 0;
	
	public void  increaseExp() {
		currentExp++;
		if (currentExp > experience.length - 1 ){
			currentExp = experience.length - 1;
			System.out.println("�������� ��� ������ ������������� ������ ��������.");
			
		}else{
			System.out.println("�������� ������� �� " + experience[currentExp]);
		}
		
	}

	public String getDriverExperience (){
		return experience[currentExp];
	}
}	
	/*String driverName;
	String driverExperience = "noob";
	int expStep = 0;
			
	
	
	public void  increaseExp() {
		expStep += 1;
		if (expStep == 1){
			driverExperience = "noob";
			System.out.println("�������� ������� ��" + driverExperience);
		}else if (expStep == 2){
			driverExperience = "regular";
			System.out.println("�������� ������� ��" + driverExperience);
		}else if (expStep == 3){
			driverExperience = "pro";
			System.out.println("�������� ������� ��" + driverExperience);
			
		}else if (expStep > 3){
			System.out.println("�������� ��� ������ ������������� ������ ��������.");

		}
		
	}
	
}
	
*/