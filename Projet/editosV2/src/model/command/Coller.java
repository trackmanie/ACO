package model.command;
import model.receiver.MoteurEditionimpl;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Coller implements Command
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public MoteurEditionimpl moteurEditionimpl;	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Coller(MoteurEditionimpl mot){
		this.moteurEditionimpl = mot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@Override
	public void execute() {
		moteurEditionimpl.coller();	
	}

}

