package org.eclipse.xwt.emf;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EObjectObservableValue;
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
		
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		Command command = new SetCommand(editingDomain, eObject, eStructuralFeature, value);
		editingDomain.getCommandStack().execute(command);
		//eObject.eSet(eStructuralFeature, value);
	}

}