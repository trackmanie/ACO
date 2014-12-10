package model.receiver;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Buffer
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String texte;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private Selection selection;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Buffer(){
		texte = "";
		selection = new Selection();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String getContenu() {		
		int tmp = texte.length();
		checkSel();
		
		return texte.substring(selection.getDebut(), selection.getDebut()+selection.getLongueur());
	}
	
	public void checkSel(){
		Selection sel = getSel();
		int d = getTexte().length();
		
		if (sel.debut > d){
			setSel(d, 0);
		}		
		else if (sel.debut + sel.longueur > d){
			setSel(sel.debut, d- sel.debut);
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String getTexte(){
		return new String(texte);
	}
	
	public void ecrire(char c) {
			texte = texte.substring(0, selection.getDebut()) + c + texte.substring((selection.getDebut()+selection.getLongueur()));
	}
	
	public void setSel (int deb, int lg){
		selection.setDebut(deb);
		selection.setLongueur(lg);
	}
	
	public Selection getSel(){
		return selection;
	}
}

