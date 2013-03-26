package finalproject;
public enum States {
	AUTO_STEPPING {
		public void enter() {
			states[CLEAR] = false;
			states[LOAD] = false;
			states[RELOAD] = false;
			states[RUN] = true;
			states[STEP] = false;
			states[TRANSLATE] = false;
		}		
	},
	NOTHING_LOADED {
		public void enter() {
			states[CLEAR] = false;
			states[LOAD] = true;
			states[RELOAD] = false;
			states[RUN] = false;
			states[STEP] = false;
			states[TRANSLATE] = true;
		}
	}, 
	PROGRAM_HALTED {
		public void enter() {
			states[CLEAR] = true;
			states[LOAD] = true;
			states[RELOAD] = true;
			states[RUN] = false;
			states[STEP] = false;
			states[TRANSLATE] = true;
		}		
	}, 
	PROGRAM_LOADED_NOT_AUTOSTEPPING {
		public void enter() {
			states[CLEAR] = true;
			states[LOAD] = true;
			states[RELOAD] = true;
			states[RUN] = true;
			states[STEP] = true;
			states[TRANSLATE] = true;
		}		
	};
	private static final int CLEAR = 0;
	private static final int LOAD = 1; 
	private static final int RELOAD = 2;
	private static final int RUN = 3;
	private static final int STEP = 4; 
	private static final int TRANSLATE = 5;
	
	boolean[] states = new boolean[6];
	
	public abstract void enter();
	
	public boolean getClearActive() {
		return states[CLEAR];
	}
	public boolean getLoadFileActive() {
		return states[LOAD];
	}
	public boolean getReloadActive() {
		return states[RELOAD];
	}
	public boolean getRunSuspendActive() {
		return states[RUN];
	}
	public boolean getStepActive() {
		return states[STEP];
	}
	public boolean getTranslateFileActive() {
		return states[TRANSLATE];
	}
}
