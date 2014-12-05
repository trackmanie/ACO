package model.Memento;
import model.command.Copier;
import model.receiver.MoteurEditionimpl;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class CopierEnregistrable extends Copier implements CommandEnregistrable
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
	public CopierEnregistrable(MoteurEditionimpl e, EnregistreurImpl enr){
		super(e);
		enregistreurImpl = enr;
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
		return new MementoCopier();	
	}
	
}

