
public class VariableInit {
	VariableInit() {
	}

	VariableInit(String r) {
		relevant = r;
	}

	String relevant;

	private void TruePath() {
		relevant = "True path";
	}

	private void FalsePath() {
		relevant = "False path";
	}

	public void DoStuff(boolean toggle) {
		if (toggle) {
			TruePath();
		} else if (!toggle) {
			FalsePath();
		}
		// Is relevant always initialised?
		// How should the compiler know?
		System.out.println(relevant);
	}

	public static void main(String args[]) {
		VariableInit obj = new VariableInit();
		obj.DoStuff(false);
	}
}
