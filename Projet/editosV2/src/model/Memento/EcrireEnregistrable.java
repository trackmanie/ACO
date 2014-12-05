package model.Memento;
import model.command.Ecrire;
import model.receiver.MoteurEditionimpl;
import model.invoker.IHMImpl;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class EcrireEnregistrable extends Ecrire implements CommandEnregistrable
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
	public EcrireEnregistrable(IHMImpl i, MoteurEditionimpl e, EnregistreurImpl enr){
		super(i, e);
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
	public Memento getMemento() {
		MementoEcrire m = new MementoEcrire();
		m.setState("" + iHMImpl.getLastChar());
		return m;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@Override
	public void setMemento(Memento m) {
		char c = ((MementoEcrire) m).getState().charAt(0);
		moteurEditionimpl.ecrire(c);
	}
	
}

