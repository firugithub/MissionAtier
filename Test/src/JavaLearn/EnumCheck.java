package JavaLearn;

public class EnumCheck {

	public static void main(String[] args) {
		System.out.println(ThreadStatesEnum.START.getPriority());
		ThreadStatesEnum th = Enum.valueOf(ThreadStatesEnum.class, "START");
		System.out.println("th priority=" + th.getPriority());
		ThreadStatesEnum.START.setPriority(2);
		System.out.println(ThreadStatesEnum.START.getPriority());
		
		ThreadStatesEnum th2 = Enum.valueOf(ThreadStatesEnum.class, "START");
		System.out.println("th priority=" + th2.getPriority());
	}

}
