package finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Machine extends Observable {
	private final int TICK = 500; // timer tick = 1/2 second
	private Processor proc = new Processor();
	private CodeMemory code = new CodeMemory();
	private DataMemory data = new DataMemory();
	private boolean running = false;
	private boolean autoStepOn = false;
	private File currentlyExecutingFile = null;
	private States state;
	private Map<Byte,Instruction> instructionSet = 
			new HashMap<Byte,Instruction>();
	private CodeViewPanel codeViewPanel;
	private DataViewPanel dataViewPanel;
	private ControlPanel controlPanel;
	private ProcessorViewPanel processorPanel;
	private MenuBarBuilder menuBuilder;
	private JFrame frame;

	public Machine() {
		Instruction instr = new ADD(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new ADDI(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new ADDN(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new AND(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new ANDI(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new CPL(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new CPZ(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new DIV(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new DIVI(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new DIVN(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new HLT(proc, data, this);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new JMP(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new JMPN(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new JMZ(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new LOD(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new LODI(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new LODN(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new MUL(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new MULI(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new MULN(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new NOP(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new NOT(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new STO(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new STON(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new SUB(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new SUBI(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		instr = new SUBN(proc, data);
		instructionSet.put(instr.getOpCode(), instr);
		createAndShowGUI();
	}

	/**
	 * Package visible constructor for testing only
	 * @param string parameter to distinguish the test constructor
	 * from the working constructor
	 */
	Machine(String string) {
	}

	/**
	 * Clears the machine completely:
	 * 
	 * Clear the array in code by calling clearCode
	 * Clear the array in data by calling clearData
	 * Set the ip and acc of the processor to 0
	 * Set the state to NOTHING_LOADED
	 * Call enter on this state
	 * Call setChanged 
	 * Call notifyObservers("Clear")
	 */
	public void clearAll() {
		code.clearCode();
		data.clearData();
		proc.setAcc(0);
		proc.setIp(0);
		state = state.NOTHING_LOADED;
		state.enter();
		setChanged();
		notifyObservers("Clear");
	}

	/**
	 * Method that sets up the whole GUI and locates the individual
	 * components into place. Also sets up the Menu bar. Starts a 
	 * swing timer ticking.
	 */
	private void createAndShowGUI() {
		codeViewPanel = new CodeViewPanel(this);
		dataViewPanel = new DataViewPanel(this);
		controlPanel = new ControlPanel(this);
		processorPanel = new ProcessorViewPanel(this);
		menuBuilder = new MenuBarBuilder(this);
		frame = new JFrame("Pippin Simulator");
		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout(1,1));
		content.setBackground(Color.BLACK);
		frame.setSize(1100,600);

		frame.add(codeViewPanel.createCodeDisplay(), BorderLayout.CENTER);
		frame.add(dataViewPanel.createDataDisplay(), BorderLayout.LINE_END);
		frame.add(controlPanel.createControlDisplay(), BorderLayout.PAGE_END);
		frame.add(processorPanel.createProcessorDisplay(), BorderLayout.PAGE_START);

		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);

		bar.add(menuBuilder.createMenu());

		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new ExitAdapter());
		state = States.NOTHING_LOADED;
		state.enter();
		setChanged();
		notifyObservers();
		javax.swing.Timer timer = new javax.swing.Timer(TICK, new TimerListener());
		timer.start();
		frame.setVisible(true);
	}

	public void exit() { // method executed when user exits the program
		int decision = JOptionPane.showConfirmDialog(
				frame, 
				"Do you really wish to exit?",
				"Confirmation",
				JOptionPane.YES_NO_OPTION);
		if (decision == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public int getAcc() {
		return proc.getAcc();
	}

	public int getIp() {
		return proc.getIp();
	}

	public Instruction getInstruction(int location) throws CodeAccessException {
		return code.getInstruction(location);
	}

	public String getInstructionSource(int location) throws CodeAccessException {
		return code.getInstructionSource(location);
	}

	public String getInstructionBinaryForm(int location)
			throws CodeAccessException {
		return code.getInstructionBinaryForm(location);
	}

	public int getArgument(int location) throws CodeAccessException {
		return code.getArgument(location);
	}

	public void setInstruction(int location, Instruction instr, int arg,
			String binaryForm, String sourceForm) throws CodeAccessException {
		code.setInstruction(location, instr, arg, binaryForm, sourceForm);
	}

	public int getData(int location) throws DataAccessException {
		return data.getData(location);
	}

	public String getDataBinary(int location) throws DataAccessException {
		return data.getDataBinary(location);
	}

	public boolean getClearActive() {
		return state.getClearActive();
	}

	public boolean getLoadFileActive() {
		return state.getLoadFileActive();
	}

	public boolean getReloadActive() {
		return state.getReloadActive();
	}

	public boolean getRunSuspendActive() {
		return state.getRunSuspendActive();
	}

	public boolean getStepActive() {
		return state.getStepActive();
	}

	public boolean getTranslateFileActive() {
		return state.getTranslateFileActive();
	}

	public void setData(int location, int value) throws DataAccessException {
		data.setData(location, value);
	}
	/**
	 * Getter method for autoStepOn
	 * @return the value of the autoStepOn flag
	 */
	public boolean isAutoStepOn() {
		return autoStepOn;
	}

	/**
	 * Getter method for running. Package visible for
	 * JUnit testing only.
	 * @return the value of the running flag
	 */
	boolean isRunning() {
		return running;
	}

	public void loadFile() {
		try{
			// CODE TO REMEMBER PREVIOUS FILE USED
			File lfu = new File("lastfileused.txt");
			File f = null;
			String lastFile = "";
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Pippin Executable Files", "pxe");
			chooser.setFileFilter(filter);
			if (lfu.exists()) {
				Scanner sc = new Scanner(lfu); 
				lastFile = sc.nextLine();
				sc.close();
				chooser.setSelectedFile(new File(lastFile));
			}
			// CODE TO LOAD DESIRED FILE
			int openOK = chooser.showOpenDialog(null);
			if(openOK == JFileChooser.APPROVE_OPTION) {
				f = chooser.getSelectedFile();
			}
			// CODE TO SAVE WHICH FILE WAS SELECTED
			if (f != null) {
				PrintWriter pw = new PrintWriter("lastfileused.txt");
				pw.println(f.getAbsolutePath());
				pw.close();
				clearAll();
				currentlyExecutingFile = f;
				Scanner input = new Scanner(f);
				Loader.load(code,data,instructionSet,input);
				state = States.PROGRAM_LOADED_NOT_AUTOSTEPPING;
				state.enter();
				proc.setIp(0);
				setChanged();
				notifyObservers("New Program");
			}
		} catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(
					frame, 
					"The file \"lastfileused.txt\" or the " +
							"file being selected has problems",
							"Warning",
							JOptionPane.OK_OPTION);
		} catch (IllegalBinaryFormat e) {
			JOptionPane.showMessageDialog(frame, "File does not contain a legal program", "Warning", JOptionPane.OK_OPTION);
		}
	}

	/**
	 * Reload a program:
	 * 
	 * First apply clearAll
	 * Next load the program again from the field
	 * "currentlyExecutingFile," which stores the current file. 
	 * 
	 * Set the state and notify observers in the same way as
	 * the original load of the file, i.e. the part of the loadFile
	 * method in the if(f != null) block.
	 */
	public void reload() {
		/*
		 * PrintWriter pw = new PrintWriter("lastfileused.txt");
				pw.println(f.getAbsolutePath());
				pw.close();
				currentlyExecutingFile = f;
				Scanner input = new Scanner(f);
				Loader.load(code,data,instructionSet,input);
				state = States.PROGRAM_LOADED_NOT_AUTOSTEPPING;
				state.enter();
				setChanged();
				notifyObservers("New Program");
		 */
		clearAll();
		loadFile();
		state = States.PROGRAM_LOADED_NOT_AUTOSTEPPING;
		state.enter();
		proc.setIp(0);
		setChanged();
		notifyObservers("New Program");
	}

	/**
	 * Setter method for the running flag also changes the
	 * current state of the Machine and notifies observers.
	 * @param b new value for the running field
	 */
	public void setRunning(boolean b) {
		running = b;
		if(running) {
			state = States.PROGRAM_LOADED_NOT_AUTOSTEPPING;
			state.enter();
			setChanged();
			notifyObservers();
		} else {
			autoStepOn = false;
			state = States.PROGRAM_HALTED;
			state.enter();
			setChanged();
			notifyObservers();			
		}
	}

	/**
	 * Setter method for the autoStepOn flag also changes the
	 * current state of the Machine and notifies observers.
	 * @param b new value for the autoStepOn field
	 */
	public void setAutoStepOn(boolean b) {
		autoStepOn = b;
		if(autoStepOn) {
			state = States.AUTO_STEPPING;
			state.enter();
			setChanged();
			notifyObservers();
		} else {
			autoStepOn = false;
			state = States.PROGRAM_LOADED_NOT_AUTOSTEPPING;
			state.enter();
			setChanged();
			notifyObservers();			
		}
	}		


	/**
	 * Single step of the simulation, which executes the instruction
	 * at the current instruction pointer value. If there is an
	 * error in the program the instruction pointer may be the index
	 * of a null value.
	 * If there is an exception (CodeAccessException, DataAccessException
	 * or NullPointerException)
	 */
	public void step() {
		Instruction instr;
		try {
			instr = code.getInstruction(proc.getIp());
			int arg = code.getArgument(proc.getIp());
			// the following 9 lines are for use when grading.
			// please do not remove it
			String oper = instr.getName();
			String argstr = Integer.toHexString(arg).toUpperCase();
			if (oper.endsWith("#")) {
				System.out.println(oper + argstr);				
			} else if (oper.endsWith("&")) {
				System.out.println(oper + argstr);				
			} else {
				System.out.println(instr.getName()+" "+argstr);
			}
			//-------------------------
			instr.execute(arg);
			setChanged();
			notifyObservers("Step");
		} catch (CodeAccessException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Warning", JOptionPane.OK_OPTION);
			autoStepOn = false;
			running = false;
			state = States.PROGRAM_HALTED;
			state.enter();
			setChanged();
			notifyObservers();	
			// TODO
			// show a JOptionPane with the error with a good
			// explanation and halt the execution
		} catch (DataAccessException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Warning", JOptionPane.OK_OPTION);
			autoStepOn = false;
			running = false;
			state = States.PROGRAM_HALTED;
			state.enter();
			setChanged();
			notifyObservers();	
			// TODO
			// show a JOptionPane with the error with a good
			// explanation and halt the execution
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Warning", JOptionPane.OK_OPTION);
			autoStepOn = false;
			running = false;
			state = States.PROGRAM_HALTED;
			state.enter();
			setChanged();
			notifyObservers();	
			// TODO
			// show a JOptionPane with the error with a good
			// explanation and halt the execution
		} catch (DivideByZeroError e){
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Warning", JOptionPane.OK_OPTION);
			autoStepOn = false;
			running = false;
			state = States.PROGRAM_HALTED;
			state.enter();
			setChanged();
			notifyObservers();	
		}
	}

	/**
	 * Translate method reads a source pippin file and saves the
	 * file with the extension pxe. Saves the most recently opened file.
	 * 
	 */
	public void translate() {
		try{
			// CODE TO REMEMBER PREVIOUS FILE USED
			File lfu = new File("lastfileused.txt");
			File f = null;
			String lastFile = "";
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Pippin Source Files", "pxs");
			chooser.setFileFilter(filter);
			if (lfu.exists()) {
				Scanner sc = new Scanner(lfu); 
				lastFile = sc.nextLine();
				sc.close();
				chooser.setSelectedFile(new File(lastFile));
			}
			// CODE TO LOAD DESIRED FILE
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				f = chooser.getSelectedFile();
			}
			// CODE TO SAVE WHICH FILE WAS SELECTED
			if (f != null) {
				PrintWriter pw = new PrintWriter("lastfileused.txt");
				String fileName = f.getAbsolutePath(); 
				pw.println(fileName);
				pw.close();
				int periodLoc = fileName.lastIndexOf('.');
				String execFileName = fileName.substring(0,periodLoc+1) + "pxe";
				String errFileName = fileName.substring(0,periodLoc+1) + "err";
				Translate.translate(fileName, execFileName, errFileName);
			}
		} catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(
					frame, 
					"The file \"lastfileused.txt\" or the " +
							"file being selected has problems",
							"Warning",
							JOptionPane.OK_OPTION);
		}
	}
	public void run() {
		running = true;
		while(running) {
			silentStep();
		}        
	}

	public void silentStep() {
		Instruction instr;
		try {
			instr = code.getInstruction(proc.getIp());
			int arg = code.getArgument(proc.getIp());
			// the following 9 lines are for use when grading.
			// please do not remove it
			String oper = instr.getName();
			String argstr = Integer.toHexString(arg).toUpperCase();
			if (oper.endsWith("#")) {
				System.out.println(oper + argstr);                
			} else if (oper.endsWith("&")) {
				System.out.println(oper + argstr);                
			} else {
				System.out.println(instr.getName()+" "+argstr);
			}
			//-------------------------
			instr.execute(arg);
		} catch (CodeAccessException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Warning", JOptionPane.OK_OPTION);
			autoStepOn = false;
			running = false;
			state = States.PROGRAM_HALTED;
			state.enter();
			setChanged();
			notifyObservers();	
			// TODO
			// show a JOptionPane with the error with a good
			// explanation and halt the execution
		} catch (DataAccessException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Warning", JOptionPane.OK_OPTION);
			autoStepOn = false;
			running = false;
			state = States.PROGRAM_HALTED;
			state.enter();
			setChanged();
			notifyObservers();	
			// TODO
			// show a JOptionPane with the error with a good
			// explanation and halt the execution
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Warning", JOptionPane.OK_OPTION);
			autoStepOn = false;
			running = false;
			state = States.PROGRAM_HALTED;
			state.enter();
			setChanged();
			notifyObservers();	
			// TODO
			// show a JOptionPane with the error with a good
			// explanation and halt the execution
		} catch (DivideByZeroError e){
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Warning", JOptionPane.OK_OPTION);
			autoStepOn = false;
			running = false;
			state = States.PROGRAM_HALTED;
			state.enter();
			setChanged();
		}
	}
	/**
	 * Main method that drives the whole simulator
	 * @param args command line arguments are not used
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Machine(); 
			}
		});
	}

	private class ExitAdapter extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			exit();
		}
	}

	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(autoStepOn) {
				step();
			}
		}
	}
}
