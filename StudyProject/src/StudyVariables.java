public class StudyVariables {
	
	public int a = -1;
	public int b;
	public String s;
	public float f;
	

	public static void main(String[] args) {
		//@SuppressWarnings("unused")
		StudyVariables m = new StudyVariables();
	}
	
	public StudyVariables(){
		int x;
		x = sum(2, 8);
		int y = div(1, 8);
		
		//System.out.println(a);
		/*workWithVariables();
		System.out.println(a);
		workWithVariables();
		System.out.println(a);*/
		
		if(a > 0){
			a = sum(a, a);
		}else {
			a = div(a, a);
		}
		System.out.println(a);
	}
	
	
	
	
	
	public void workWithVariables (){
		a = sum(a, a);
	}
	
	public int sum(int var1, int var2){
		int result = var1 + var2;
		return result;
	}
	
	public int div(int var1, int var2){
		//int result = var1 - var2;
		//return result;
		return var1 - var2;
	}
}

