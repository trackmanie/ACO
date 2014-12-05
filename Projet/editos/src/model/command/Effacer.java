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
	
	
	public Effacer(MoteurEditionimpl mot){
		this.moteurEditionimpl = mot;
	}
	
	@Override
	public void execute (){
		moteurEditionimpl.effacer();
	}
	
}
