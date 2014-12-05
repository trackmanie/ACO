package model.Memento;
import model.command.Effacer;
import model.receiver.MoteurEditionimpl;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class EffacerEnregistrable extends Effacer implements CommandEnregistrable
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
	public EffacerEnregistrable(MoteurEditionimpl mot, EnregistreurImpl enr){
		super(mot);
		enregistreurImpl= enr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@Override
	public void execute() {
		enregistreurImpl.sauvegarder(this);
		super.execute();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@Override
	public void setMemento(Memento m) {
		super.execute();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@Override
	public Memento getMemento() {
		return new MementoEffacer();	
	}
	
}

