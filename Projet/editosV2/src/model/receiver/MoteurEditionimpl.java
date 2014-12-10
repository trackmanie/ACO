package model.receiver;
import model.observer.Subject;
import model.observer.Observer;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class MoteurEditionimpl extends Subject implements MoteurEdition
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Buffer buffer;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public PressPapier pressPapier;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public MoteurEditionimpl(){
		observer = new ArrayList<Observer>();
		buffer = new Buffer();
		pressPapier = new PressPapier();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@Override
	public void addObserver(Observer o) {
		observer.add(o);
		
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@Override
	public void removeObserver(Observer o) {
		observer.remove(o);
		
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	@Override
	public void notifyObserver() {
		Iterator<Observer> it = observer.iterator(); 
		while (it.hasNext()) {
			Observer o = it.next();
			o.notifyMe();
			}
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String getTexte() {
		return buffer.getTexte();

	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void copier() {
		pressPapier.texte = new String(buffer.getContenu());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void ecrire(char c) {
		buffer.checkSel();
		buffer.ecrire(c);
		buffer.setSel(buffer.getSel().debut + 1, 0);
		notifyObserver();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void effacer() {
		Selection sel = buffer.getSel();
		buffer.checkSel();
		if (sel.longueur != 0){
			buffer.texte = buffer.texte.substring(0, sel.debut)+buffer.texte.substring(sel.debut+sel.longueur);
			buffer.setSel(sel.debut, 0);
		}
		else{
			buffer.texte = buffer.texte.substring(0,  sel.debut-1)+buffer.texte.substring(sel.debut);
			buffer.setSel(sel.debut-1, 0);
		}
		notifyObserver();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void select(int deb, int lg) {
		buffer.setSel(deb, lg);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void couper() {
		Selection sel = buffer.getSel();
		buffer.checkSel();
		if (sel.longueur !=0){	
			pressPapier.texte = new String(buffer.getContenu());
			buffer.texte = buffer.texte.substring(0, sel.debut)+buffer.texte.substring(sel.debut+sel.longueur);
			buffer.setSel(sel.debut, 0);
			notifyObserver();
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void coller() {
		Selection sel = buffer.getSel();
		int d = buffer.getTexte().length();
		buffer.checkSel();
		String s = new String(pressPapier.texte);
		buffer.texte = buffer.texte.substring(0, sel.debut)+s+buffer.texte.substring(sel.debut+sel.longueur);
		buffer.setSel(buffer.getSel().debut + s.length(), 0);
		notifyObserver();
	}

}

