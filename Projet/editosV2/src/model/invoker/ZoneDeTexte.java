package model.invoker;
import java.util.HashMap;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import model.command.Command;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

@SuppressWarnings("serial")
public class ZoneDeTexte extends JTextArea
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int selDebut;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int selLongueur;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public char caractere;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String laststring;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String texteAffiche;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public IHMImpl iHMImpl;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public ZoneDeTexte(HashMap<String, Command> h){
		final Command selectionner = h.get("selectionner");
		final Command ecrire = h.get("ecrire");
		final Command effacer = h.get("effacer");
		
		addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				int i = Math.min(e.getDot(), e.getMark());
				int j = Math.max(e.getDot(), e.getMark());
				int l = j - i;
				if (i != getDebut() || l != getLongueur()) {
					setSelection(i, l);
					selectionner.execute();
				}
			}
		});
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				e.consume(); // annule le comportement par défaut
				char keyChar = e.getKeyChar();
				if (keyChar != '\b') {
					caractere = keyChar;
					ecrire.execute();
				}
				}
				@Override
				public void keyReleased(KeyEvent e) {}
				@Override
				public void keyPressed(KeyEvent e) {
					if (!e.isActionKey()) {// si la touche est un caractère "normal"
						e.consume(); // annule le comportement par défaut
						if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
							effacer.execute();
						}
					}
				}
			});
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int getDebut() {
		return selDebut;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int getLongueur() {
		return selLongueur;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void setSelection(int deb, int lg) {
		selDebut = deb;
		selLongueur = lg;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String getTexte() {
		return texteAffiche;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public char getLastChar(){
		return caractere;
	}
	
	public void setTexte(String texte) {
		texteAffiche = texte;
		setText(texte);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public char getChar() {
		return caractere;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void refresh(String texte, int deb, int lg) {
		setTexte(texte);
		setSelectionStart(deb);
		setSelectionEnd(deb+lg);
		setSelection(deb, lg);
		requestFocusInWindow();
	}
	
}

