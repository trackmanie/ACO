package model.Memento;
import model.command.Selectionner;
import model.receiver.MoteurEditionimpl;
import model.invoker.IHMImpl;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class SelectionnerEnregistrable extends Selectionner implements CommandEnregistrable
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
	public SelectionnerEnregistrable (IHMImpl ihm, MoteurEditionimpl mot, EnregistreurImpl enr){
		super(ihm, mot);
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
		MementoSelectionner m = new MementoSelectionner();
		m.setState(""+iHMImpl.getDebut()+" "+iHMImpl.getLongueur());
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
		String tmp = ((MementoSelectionner) m).getState();
		int space = tmp.indexOf(' ');
		String deb = tmp.substring(0, space);
		String lg = tmp.substring(space+1);
		moteurEditionimpl.select(Integer.parseInt(deb), Integer.parseInt(lg));	
	}
	
}

