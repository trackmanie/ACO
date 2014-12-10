package model.Memento;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

import model.command.Command;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class EnregistreurImpl implements Enregistreur
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private Boolean stateEnr;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public HashMap<String, CommandEnregistrable> commandes;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private Queue<Memento> mementos;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public EnregistreurImpl(){
		commandes = new HashMap<String, CommandEnregistrable>();
		mementos = new LinkedList<Memento>();
		stateEnr = false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void rejouer() {
		if (!stateEnr){
			for (Iterator<Memento> it = mementos.iterator(); it.hasNext();){
				Memento m = it.next();
				commandes.get(m.getType()).setMemento(m);
			}
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void enregistrer() {
			mementos.clear();
			stateEnr = true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void sauvegarder(CommandEnregistrable c) {
		if (stateEnr) {
			mementos.add(c.getMemento());
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void arreter() {
		stateEnr = false;
	}
	
	public void setCommandes(HashMap<String, CommandEnregistrable> h) throws Exception {
		if (h.get("couper") == null) throw new Exception("erreur commande \"couper\" dans l'enregistreur");
		if (h.get("copier")== null) throw new Exception("erreur commande \"copier\"dans l'enregistreur");
		if (h.get("coller") == null) throw new Exception("erreur commande \"coller\"dans l'enregistreur");
		if (h.get("ecrire") == null) throw new Exception("erreur commande \"ecrire\"dans l'enregistreur");
		if (h.get("selectionner") == null) throw new Exception("erreur commande \"selectionner\"dans l'enregistreur");
		if (h.get("effacer") == null) throw new Exception("erreur commande \"effacer\"dans l'enregistreur");
		commandes = h;
		
	}
	
}

