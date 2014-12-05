package model.command;
import model.Memento.EnregistreurImpl;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Enregistrer implements Command
{	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public EnregistreurImpl enregistreurImpl;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Enregistrer(EnregistreurImpl e){
		enregistreurImpl = e;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
    @Override
	public void execute() {
    	enregistreurImpl.enregistrer();
	}
	
}

