package model.invoker;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import model.command.Command;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class IHMImpl implements IHM
{
	
	private JFrame frame;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private Command copier;
	private Command coller;
	private Command couper;
	private Command selectionner;
	private Command effacer;
	private Command ecrire;
	
	private Collection<Button> buttons;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	protected ZoneDeTexte zoneDeTexte;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public IHMImpl(){
		frame = new JFrame("V1");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		buttons = new ArrayList<Button>();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int getDebut(){
		return zoneDeTexte.getDebut();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int getLongueur(){
		return zoneDeTexte.getLongueur();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public char getLastChar(){
		return zoneDeTexte.getLastChar();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void display(){
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private void setButton(String nom, Command com){
		Button butt = new Button(nom, com);
		buttons.add(butt);
		butt.setMaximumSize(new Dimension(Short.MAX_VALUE, butt.getPreferredSize().height));
		butt.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		butt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				zoneDeTexte.requestFocusInWindow();
			}
		});
		frame.add(butt);
}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void setButtons() {
		setButton("copier", copier);
		setButton("coller", coller);
		setButton("couper", couper);		
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @throws Exception 
	 * @ordered
	 */
	
	public void setCommands(HashMap<String, Command> h) throws Exception {
		this.couper = h.get("couper");
		if (this.couper == null) throw new Exception("erreur commande \"couper\"");
		this.copier = h.get("copier");
		if (this.copier == null) throw new Exception("erreur commande \"copier\"");
		this.coller = h.get("coller");
		if (this.coller == null) throw new Exception("erreur commande \"coller\"");
		this.selectionner = h.get("selectionner");
		if (this.selectionner == null) throw new Exception("erreur commande \"selectionner\"");
		this.ecrire = h.get("ecrire"); 
		if (this.ecrire == null) throw new Exception("erreur commande \"ecrire\"");
		this.effacer = h.get("effacer");
		if (this.effacer == null) throw new Exception("erreur commande \"effacer\"");
		}
	
	public void setZDT(int row, int col) {
		HashMap<String, Command> h = new HashMap<String, Command>();
		h.put("selectionner", selectionner);
		h.put("ecrire", ecrire);
		h.put("effacer", effacer);
		zoneDeTexte = new ZoneDeTexte(h);
		zoneDeTexte.setRows(row);
		zoneDeTexte.setColumns(col);
		JScrollPane scroll = new JScrollPane(zoneDeTexte);
		frame.add(scroll);	
	}
}

