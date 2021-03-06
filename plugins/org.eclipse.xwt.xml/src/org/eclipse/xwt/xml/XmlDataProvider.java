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
package org.eclipse.xwt.xml;

import java.io.ByteArrayInputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.xwt.dataproviders.AbstractDataProvider;
import org.eclipse.xwt.internal.core.UpdateSourceTrigger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class XmlDataProvider extends AbstractDataProvider implements
		IXmlDataProvider {
	static DataModelService dataModelService = new DataModelService() {
		@Override
		public Object toModelType(Object data) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Object loadModelType(String className) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Object toModelPropertyType(Object object, String propertyName) {
			throw new UnsupportedOperationException();
		}
	};

	static final String XDATA = "XData";

	private URL source;

	private String path;

	private Document document;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.dataproviders.IXmlDataProvider#getDocument()
	 */
	public Document getDocument() {
		if (document == null) {
			try {
				DocumentBuilderFactory domFactory = DocumentBuilderFactory
						.newInstance();
				domFactory.setNamespaceAware(true); // never forget this!
				DocumentBuilder builder = domFactory.newDocumentBuilder();
				if (source != null) {
					document = builder.parse(source.openStream());
				}
				String xdata = getXDataContent();
				if (xdata != null) {
					try {
						document = builder.parse(new ByteArrayInputStream(xdata
								.getBytes()));
					} catch (Exception e) {
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return document;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.dataproviders.IXmlDataProvider#getSource()
	 */
	@Override
	public URL getSource() {
		return source;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.dataproviders.IXmlDataProvider#getXPath()
	 */
	@Override
	public String getPath() {
		return path;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.xwt.dataproviders.IXmlDataProvider#setSource(java.io.
	 * InputStream)
	 */
	@Override
	public void setSource(URL xmlSource) {
		this.source = xmlSource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.dataproviders.IXmlDataProvider#setXPath(java.lang.
	 * String)
	 */
	@Override
	public void setPath(String path) {
		this.path = path;
	}

	private Object getRoot() {
		Document doc = getDocument();
		if (doc == null) {
			return null;
		}
		if (path != null) {
			return selectSingleNode(doc, path);
		}
		return doc;
	}

	/**
	 * @param node
	 * @param path
	 * @return
	 */
	private Object selectSingleNode(Node node, String path) {
		try {
			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			XPathExpression expr = xpath.compile(path);
			return expr.evaluate(node, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.dataproviders.IDataProvider#getData()
	 */
	@Override
	public Object getData(Object object, String path) {
		if (object == null || path == null) {
			return null;
		}
		if (object instanceof Node) {
			Object selectObject = selectSingleNode((Node) object, path);
			return selectObject;
		}
		return object;
	}

	@Override
	public Object getData(String path) {
		return getData(getRoot(), path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.dataproviders.IDataProvider#getData()
	 */
	@Override
	public void setData(Object object, String path, Object value) {
		// TODO
	}

	@Override
	public void setData(String path, Object value) {
		// TODO
	}

	@Override
	public Class<?> getDataType(String path) {
		Object data = getData(path);
		if (data == null) {
			return null;
		}
		return data.getClass();
	}

	public IValueProperty observeValueProperty(Object valueType, String path,
			UpdateSourceTrigger updateSourceTrigger) {
		return null; // TODOD
	}

	@Override
	protected IObservableValue observeValue(Object bean, String propertyName) {
		Object data = getData(propertyName);
		if (data != null && data instanceof Node) {
			Class<?> valueType = data.getClass();
			return new XmlObservableValue(valueType, (Node) data, path);
		}
		return null;
	}

	@Override
	protected IObservableValue observeDetailValue(IObservableValue bean,
			Object ownerType, String propertyName, Object propertyType) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.dataproviders.IXmlDataProvider#getXDataContent()
	 */
	protected String getXDataContent() {
		Object xDataProperty = getProperty(XDATA);
		if (xDataProperty != null) {
			return xDataProperty.toString();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.dataproviders.IXmlDataProvider#setXDataContent(java
	 * .lang.String)
	 */
	protected void setXDataContent(Object content) {
		setProperty(XDATA, content);
	}

	@Override
	public DataModelService getModelService() {
		return dataModelService;
	}
}
