package model.Memento;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class ConcreteMemento implements Memento
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private String etat;
	//private int deb;
	//private int lg;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String getState() {
		return etat;	
	}
	
	//public int getDeb(){
	//	return deb;
	//}
	
	//public int getLg(){
	//	return lg;
	//}
	
	//public void setDeb(int a) {
	//	deb = a;	
	//}
	
	//public void setLg(int a) {
	//	lg = a;	
	//}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void setState(String s) {
		etat = s;	
	}
	
}

