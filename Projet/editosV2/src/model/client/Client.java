package model.client;

import model.receiver.MoteurEditionimpl;

import java.util.HashMap;

import model.observer.IHMObserver;
import model.Memento.*;
import model.command.*;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Client
{	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public static MoteurEditionimpl mot;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public static IHMObserver ihm;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public static EnregistreurImpl enr;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public static HashMap<String, Command> com;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public static HashMap<String, CommandEnregistrable> comEnr;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * 
	 * @generated
	 */
	
	public static void main(String[] args) throws Exception {
		mot = new MoteurEditionimpl();
		ihm = new IHMObserver(mot);
		com = new HashMap<String, Command>();
		comEnr = new HashMap<String, CommandEnregistrable>();
		enr = new EnregistreurImpl();
		
		CommandEnregistrable copier = new CopierEnregistrable(mot, enr);
		CommandEnregistrable coller = new CollerEnregistrable(mot, enr);
		CommandEnregistrable couper = new CouperEnregistrable(mot, enr);
		CommandEnregistrable effacer = new EffacerEnregistrable(mot, enr);
		CommandEnregistrable ecrire = new EcrireEnregistrable(ihm, mot, enr);
		
		com.put("copier", (Command) copier);
		comEnr.put("copier", copier);
		com.put("coller", (Command) coller);
		comEnr.put("coller", coller);
		com.put("couper", (Command) couper);
		comEnr.put("couper", couper);
		com.put("effacer", (Command) effacer);
		comEnr.put("effacer", effacer);
		com.put("ecrire", (Command) ecrire);
		comEnr.put("ecrire", ecrire);
		com.put("selectionner", new Selectionner(ihm, mot));
		com.put("enregistrer", new Enregistrer(enr));
		com.put("arreter", new Arreter(enr));
		com.put("rejouer", new Rejouer(enr));
		
		mot.addObserver(ihm);
		enr.setCommandes(comEnr);
		ihm.setCommands(com);
		ihm.setButtons();
		ihm.setZDT(30, 90);
		ihm.display();
	}
	
}

