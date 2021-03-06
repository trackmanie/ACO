package model.command;
import model.receiver.MoteurEditionimpl;

public class Effacer implements Command {
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
	public Effacer(MoteurEditionimpl mot){
		this.moteurEditionimpl = mot;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@Override
	public void execute (){
		moteurEditionimpl.effacer();
	}
	
}
