package model.observer;
import model.invoker.IHMImpl;
import model.receiver.MoteurEditionimpl;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class IHMObserver extends IHMImpl implements Observer
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	public Subject subject;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	
	public IHMObserver(Subject sub){
		subject = sub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	@Override
	public void notifyMe() {
		MoteurEditionimpl mot = (MoteurEditionimpl) subject;
		zoneDeTexte.refresh(mot.getTexte(), mot.buffer.getSel().debut, mot.buffer.getSel().longueur);
	}

}

