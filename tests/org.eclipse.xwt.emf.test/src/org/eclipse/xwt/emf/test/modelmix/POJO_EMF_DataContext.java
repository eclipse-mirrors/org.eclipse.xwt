/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.emf.test.modelmix;

import java.net.URL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.emf.EMFBinding;
import org.eclipse.xwt.emf.EMFDataModelService;
import org.eclipse.xwt.emf.EMFDataProvider;
import org.eclipse.xwt.emf.EMFDataProviderFactory;

/**
 * @author yyang (yves.yang@soyatec.com)
 */
public class POJO_EMF_DataContext {
	static EClass bookClass;
	
	public static void main(String[] args) {
		EMFBinding.initialze();
		XWT.addDataProviderFactory(EMFDataProviderFactory.EMF_DATA_PROVIDER_FACTORY, new EMFDataProviderFactory() {
			@Override
			protected EMFDataProvider createEMFDataProvider() {
				return new EMFDataProvider(new EMFDataModelService() {
					@Override
					public Object loadModelType(String className) {
						if (className.equals("Book")) {
							return bookClass;
						}
						return super.loadModelType(className);
					}
				});
			}
		});
		
		URL url = POJO_EMF_DataContext.class
				.getResource(POJO_EMF_DataContext.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url, createAuthor());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static Author createAuthor() {
		Author author = new Author();
		author.setContent(createBook());
		author.setName("Author");
		return author;
	}
		
	protected static EObject createBook() {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName("test");

		bookClass = EcoreFactory.eINSTANCE.createEClass();
		ePackage.getEClassifiers().add(bookClass);
		bookClass.setName("Book");

		EAttribute authorFeature = EcoreFactory.eINSTANCE.createEAttribute();
		authorFeature.setName("author");
		authorFeature.setEType(EcorePackage.eINSTANCE.getEString());
		bookClass.getEStructuralFeatures().add(authorFeature);

		EAttribute priceFeature = EcoreFactory.eINSTANCE.createEAttribute();
		priceFeature.setName("price");
		priceFeature.setEType(EcorePackage.eINSTANCE.getEDouble());
		bookClass.getEStructuralFeatures().add(priceFeature);

		EAttribute yearFeature = EcoreFactory.eINSTANCE.createEAttribute();
		yearFeature.setName("year");
		yearFeature.setEType(EcorePackage.eINSTANCE.getEInt());
		bookClass.getEStructuralFeatures().add(yearFeature);

		EClass titleClass = EcoreFactory.eINSTANCE.createEClass();
		ePackage.getEClassifiers().add(titleClass);
		titleClass.setName("Title");

		EAttribute lanFeature = EcoreFactory.eINSTANCE.createEAttribute();
		lanFeature.setName("lan");
		lanFeature.setEType(EcorePackage.eINSTANCE.getEString());
		titleClass.getEStructuralFeatures().add(lanFeature);

		EAttribute textFeature = EcoreFactory.eINSTANCE.createEAttribute();
		textFeature.setName("text");
		textFeature.setEType(EcorePackage.eINSTANCE.getEString());
		titleClass.getEStructuralFeatures().add(textFeature);

		EReference titleFeature = EcoreFactory.eINSTANCE.createEReference();
		titleFeature.setName("title");
		titleFeature.setEType(titleClass);
		bookClass.getEStructuralFeatures().add(titleFeature);

		EObject harryPotter = EcoreUtil.create(bookClass);

		EObject title = EcoreUtil.create(titleClass);

		title.eSet(lanFeature, "en");
		title.eSet(textFeature, "Harry Potter");
		harryPotter.eSet(titleFeature, title);
		harryPotter.eSet(authorFeature, "Neal Stephenson");
		harryPotter.eSet(priceFeature, 29.99);
		harryPotter.eSet(yearFeature, 2005);

		return harryPotter;
	}
}
