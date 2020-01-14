package org.eclipse.xwt.emf;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EObjectObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class XWTEMFObservables{
	
	/**
	   * Returns an observable value for the given feature of the object.
	   * @param eObject the object to observe.
	   * @param eStructuralFeature the feature of the object to observe.
	   * @return an observable value for the given feature of the object.
	   */
	  public static IObservableValue observeValue(EObject eObject, EStructuralFeature eStructuralFeature)
	  {
	    return new XWTEObjectObservableValue(eObject, eStructuralFeature);
	  }

	  /**
	   * Returns an observable value for the given feature of the object.
	   * @param realm the realm in which to observe.
	   * @param eObject the object to observe.
	   * @param eStructuralFeature the feature of the object to observe.
	   * @return an observable value for the given feature of the object.
	   */
	  public static IObservableValue observeValue(Realm realm, EObject eObject, EStructuralFeature eStructuralFeature)
	  {
	    return new XWTEObjectObservableValue(realm, eObject, eStructuralFeature);
	  }

}
