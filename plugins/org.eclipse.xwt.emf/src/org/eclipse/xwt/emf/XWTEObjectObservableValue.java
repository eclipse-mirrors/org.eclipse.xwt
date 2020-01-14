package org.eclipse.xwt.emf;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EObjectObservableValue;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

public class XWTEObjectObservableValue extends EObjectObservableValue {

	public XWTEObjectObservableValue(Realm realm, EObject eObject,
			EStructuralFeature eStructuralFeature) {
		super(realm, eObject, eStructuralFeature);
	}

	public XWTEObjectObservableValue(EObject eObject,
			EStructuralFeature eStructuralFeature) {
		super(eObject, eStructuralFeature);
	}

	@Override
	protected void doSetValue(Object value) {
		EClassifier classifier = eStructuralFeature.getEType();
		if (value == null) {
			Class<?> javaClass = classifier.getInstanceClass();
			if (javaClass == boolean.class 
					|| javaClass == float.class 
					|| javaClass == double.class
					|| javaClass == int.class
					|| javaClass == byte.class
					|| javaClass == char.class
					|| javaClass == long.class
					|| javaClass == short.class
					|| javaClass == Boolean.class 
					|| javaClass == Float.class 
					|| javaClass == Double.class
					|| javaClass == Integer.class
					|| javaClass == Byte.class
					|| javaClass == Character.class
					|| javaClass == Long.class
					|| javaClass == Short.class
					|| javaClass == BigDecimal.class
					|| javaClass == BigInteger.class) {
				return;
			}
		}
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		Command command = new SetCommand(editingDomain, eObject, eStructuralFeature, value);
		editingDomain.getCommandStack().execute(command);
		//eObject.eSet(eStructuralFeature, value);
	}
}