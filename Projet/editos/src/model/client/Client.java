package model.client;

import model.receiver.MoteurEditionimpl;

import java.util.HashMap;

import model.observer.IHMObserver;
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
	
	public static HashMap<String, Command> com;
	
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
		
		com.put("copier", new Copier(mot));
		com.put("coller", new Coller(mot));
		com.put("couper", new Couper(mot));
		com.put("effacer", new Effacer(mot));
		com.put("ecrire", new Ecrire(ihm, mot));
		com.put("selectionner", new Selectionner(ihm, mot));
		
		mot.addObserver(ihm);
		
		ihm.setCommands(com);
		ihm.setButtons();
		ihm.setZDT(30, 90);
		ihm.display();
	}
	
}

