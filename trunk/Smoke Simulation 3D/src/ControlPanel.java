import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ControlPanel extends JPanel
	implements ActionListener
{
	private SmokePanel smoke;
	private JButton btnReset, btnNext, btnAnimate;
	
	private boolean isAnimate = false;
	
	public ControlPanel(SmokePanel smoke)
	{
		this.smoke = smoke;
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(this);
		add(btnReset);
		
		btnNext = new JButton("Next Step");
		btnNext.addActionListener(this);
		add(btnNext);
		
		btnAnimate = new JButton("Animate ON");
		btnAnimate.addActionListener(this);
		add(btnAnimate);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if (arg0.getSource() == btnAnimate)
		{
			if (!isAnimate)
			{
				btnAnimate.setLabel("Animate OFF");
				isAnimate = true;
				smoke.start();
			}
			else
			{
				btnAnimate.setLabel("Animate ON");
				isAnimate = false;
				smoke.stop();
			}
		}
		else if (arg0.getSource() == btnNext)
		{
			smoke.nextStep();
		}
		else if (arg0.getSource() == btnReset)
		{
			smoke.reset();
		}
	}
}
