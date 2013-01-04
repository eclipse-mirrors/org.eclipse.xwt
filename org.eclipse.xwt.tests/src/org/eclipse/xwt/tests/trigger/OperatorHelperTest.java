/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.trigger;

import java.math.BigDecimal;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.xwt.core.Operator;

/**
 * This class test the function about Operator
 * 
 * @author YaHong.Song(yahong.song@soyatec.com)
 * 
 */
public class OperatorHelperTest extends TestCase {

	/**
	 * The testcase for EQ test
	 * 
	 * @throws Exception
	 */
	public void testEQ() throws Exception {
		// -------- For boolean type EQ test --------
		// not equal
		assertEquals(Operator.compare(true, Operator.EQ, false), false);
		assertEquals(Operator.compare(true, Operator.EQ, Boolean.FALSE), false);
		assertEquals(Operator.compare(Boolean.TRUE, Operator.EQ, false), false);
		assertEquals(
				Operator.compare(Boolean.TRUE, Operator.EQ, Boolean.FALSE),
				false);

		// equal
		assertEquals(Operator.compare(Boolean.TRUE, Operator.EQ, Boolean.TRUE),
				true);
		assertEquals(Operator
				.compare(Boolean.FALSE, Operator.EQ, Boolean.FALSE), true);

		// -------- For integer type EQ test --------
		Integer firstInt = new Integer(5);
		Integer secondInt = new Integer(5);
		Integer thirdInt = new Integer(6);
		Integer copyFirstInt = firstInt;
		// not equal
		assertEquals(Operator.compare(firstInt, Operator.EQ, thirdInt), false);
		// equal
		assertEquals(Operator.compare(firstInt, Operator.EQ, copyFirstInt),
				true);
		assertEquals(Operator.compare(firstInt, Operator.EQ, secondInt), true);

		// -------- For String type EQ test --------
		String firstStr = new String("hello world");
		String secondStr = new String("hello world");
		String thirdStr = new String("Hello World");
		String copyFirstStr = firstStr;
		// not equal
		assertEquals(Operator.compare(firstStr, Operator.EQ, thirdStr), false);
		// equal
		assertEquals(Operator.compare(firstStr, Operator.EQ, copyFirstStr),
				true);
		assertEquals(Operator.compare(firstStr, Operator.EQ, secondStr), true);

		// -------- For Short type EQ test --------
		Short firstShort = new Short((short) 5);
		Short secondShort = new Short((short) 5);
		Short thirdShort = new Short((short) 6);
		Short copyFirstShort = firstShort;
		// not equal
		assertEquals(Operator.compare(firstShort, Operator.EQ, thirdShort),
				false);
		// equal
		assertEquals(Operator.compare(firstShort, Operator.EQ, copyFirstShort),
				true);
		assertEquals(Operator.compare(firstShort, Operator.EQ, secondShort),
				true);

		// -------- For Character type EQ test --------
		Character firstCharacter = new Character((char) 5);
		Character secondCharacter = new Character((char) 5);
		Character thirdCharacter = new Character((char) 6);
		Character copyFirstCharacter = firstCharacter;
		// not equal
		assertEquals(Operator.compare(firstCharacter, Operator.EQ,
				thirdCharacter), false);
		// equal
		assertEquals(Operator.compare(firstCharacter, Operator.EQ,
				copyFirstCharacter), true);
		assertEquals(Operator.compare(firstCharacter, Operator.EQ,
				secondCharacter), true);

		// -------- For Long type EQ test --------
		Long firstLong = new Long(5);
		Long secondLong = new Long(5);
		Long thirdLong = new Long(6);
		Long copyFirstLong = firstLong;
		// not equal
		assertEquals(Operator.compare(firstLong, Operator.EQ, thirdLong), false);
		// equal
		assertEquals(Operator.compare(firstLong, Operator.EQ, secondLong), true);
		assertEquals(Operator.compare(firstLong, Operator.EQ, copyFirstLong),
				true);

		// -------- For Byte type EQ test --------
		Byte firstByte = new Byte("5");
		Byte secondByte = new Byte("5");
		Byte thirdByte = new Byte("6");
		Byte copyFirstByte = firstByte;
		// not equal
		assertEquals(Operator.compare(firstByte, Operator.EQ, thirdByte), false);

		// equal
		assertEquals(Operator.compare(firstByte, Operator.EQ, copyFirstByte),
				true);
		assertEquals(Operator.compare(firstByte, Operator.EQ, secondByte), true);

		// -------- For Float type EQ test --------
		Float firstFloat = new Float(5);
		Float secondFloat = new Float(5);
		Float thirdFloat = new Float(6);
		Float copyFirstFloat = firstFloat;
		// not equal
		assertEquals(Operator.compare(firstFloat, Operator.EQ, thirdFloat),
				false);
		// equal
		assertEquals(Operator.compare(firstFloat, Operator.EQ, copyFirstFloat),
				true);
		assertEquals(Operator.compare(firstFloat, Operator.EQ, secondFloat),
				true);

		// -------- For Double type EQ test --------
		Double firstDouble = new Double(5);
		Double secondDouble = new Double(5);
		Double thirdDouble = new Double(6);
		Double copyFirstDouble = firstDouble;
		// not equal
		assertEquals(Operator.compare(firstDouble, Operator.EQ, thirdDouble),
				false);
		// equal
		assertEquals(Operator
				.compare(firstDouble, Operator.EQ, copyFirstDouble), true);
		assertEquals(Operator.compare(firstDouble, Operator.EQ, secondDouble),
				true);

		// -------- For BigDecimal type EQ test --------
		BigDecimal firstBigDecimal = new BigDecimal(5);
		BigDecimal secondBigDecimal = new BigDecimal(5);
		BigDecimal thirdBigDecimal = new BigDecimal(6);
		BigDecimal copyFirstBigDecimal = firstBigDecimal;
		// not equal
		assertEquals(Operator.compare(firstBigDecimal, Operator.EQ,
				thirdBigDecimal), false);
		// equal
		assertEquals(Operator.compare(firstBigDecimal, Operator.EQ,
				copyFirstBigDecimal), true);
		assertEquals(Operator.compare(firstBigDecimal, Operator.EQ,
				secondBigDecimal), true);

		// test for null and object EQ
		String anObject = new String("hello");
		Object nullObject = null;
		// equal
		assertEquals(Operator.compare(anObject, Operator.EQ, nullObject), false);
		// not equal
		assertEquals(Operator.compare(nullObject, Operator.EQ, nullObject),
				true);

	}

	/**
	 * The testcase for NE test
	 * 
	 * @throws Exception
	 */
	public void testNE() throws Exception {
		// -------- For integer type NE test --------
		Integer firstInt = new Integer(5);
		Integer secondInt = new Integer(5);
		Integer thirdInt = new Integer(6);
		Integer copyFirstInt = firstInt;
		// not equal
		assertEquals(Operator.compare(firstInt, Operator.NE, thirdInt), true);
		// equal
		assertEquals(Operator.compare(firstInt, Operator.NE, copyFirstInt),
				false);
		assertEquals(Operator.compare(firstInt, Operator.NE, secondInt), false);

		// -------- For String type NE test --------
		String firstStr = new String("hello world");
		String secondStr = new String("hello world");
		String thirdStr = new String("Hello World");
		String copyFirstStr = firstStr;
		// not equal
		assertEquals(Operator.compare(firstStr, Operator.NE, thirdStr), true);
		// equal
		assertEquals(Operator.compare(firstStr, Operator.NE, copyFirstStr),
				false);
		assertEquals(Operator.compare(firstStr, Operator.NE, secondStr), false);

		// -------- For Short type NE test --------
		Short firstShort = new Short((short) 5);
		Short secondShort = new Short((short) 5);
		Short thirdShort = new Short((short) 6);
		Short copyFirstShort = firstShort;
		// not equal
		assertEquals(Operator.compare(firstShort, Operator.NE, thirdShort),
				true);
		// equal
		assertEquals(Operator.compare(firstShort, Operator.NE, copyFirstShort),
				false);
		assertEquals(Operator.compare(firstShort, Operator.NE, secondShort),
				false);

		// -------- For Character type NE test --------
		Character firstCharacter = new Character((char) 5);
		Character secondCharacter = new Character((char) 5);
		Character thirdCharacter = new Character((char) 6);
		Character copyFirstCharacter = firstCharacter;
		// not equal
		assertEquals(Operator.compare(firstCharacter, Operator.NE,
				thirdCharacter), true);
		// equal
		assertEquals(Operator.compare(firstCharacter, Operator.NE,
				copyFirstCharacter), false);
		assertEquals(Operator.compare(firstCharacter, Operator.NE,
				secondCharacter), false);

		// -------- For Long type NE test --------
		Long firstLong = new Long(5);
		Long secondLong = new Long(5);
		Long thirdLong = new Long(6);
		Long copyFirstLong = firstLong;
		// equal
		assertEquals(Operator.compare(firstLong, Operator.NE, thirdLong), true);
		// not equal
		assertEquals(Operator.compare(firstLong, Operator.NE, secondLong),
				false);
		assertEquals(Operator.compare(firstLong, Operator.NE, copyFirstLong),
				false);

		// -------- For Byte type NE test --------
		Byte firstByte = new Byte("5");
		Byte secondByte = new Byte("5");
		Byte thirdByte = new Byte("6");
		Byte copyFirstByte = firstByte;
		// equal
		assertEquals(Operator.compare(firstByte, Operator.NE, thirdByte), true);
		// not equal
		assertEquals(Operator.compare(firstByte, Operator.NE, secondByte),
				false);
		assertEquals(Operator.compare(firstByte, Operator.NE, copyFirstByte),
				false);

		// -------- For Float type NE test --------
		Float firstFloat = new Float(5);
		Float secondFloat = new Float(5);
		Float thirdFloat = new Float(6);
		Float copyFirstFloat = firstFloat;
		// equal
		assertEquals(Operator.compare(firstFloat, Operator.NE, thirdFloat),
				true);
		// not equal
		assertEquals(Operator.compare(firstFloat, Operator.NE, secondFloat),
				false);
		assertEquals(Operator.compare(firstFloat, Operator.NE, copyFirstFloat),
				false);

		// -------- For Double type NE test --------
		Double firstDouble = new Double(5);
		Double secondDouble = new Double(5);
		Double thirdDouble = new Double(6);
		Double copyFirstDouble = firstDouble;
		// equal
		assertEquals(Operator.compare(firstDouble, Operator.NE, thirdDouble),
				true);
		// not equal
		assertEquals(Operator.compare(firstDouble, Operator.NE, secondDouble),
				false);
		assertEquals(Operator
				.compare(firstDouble, Operator.NE, copyFirstDouble), false);

		// -------- For BigDecimal type NE test --------
		BigDecimal firstBigDecimal = new BigDecimal(5);
		BigDecimal secondBigDecimal = new BigDecimal(5);
		BigDecimal thirdBigDecimal = new BigDecimal(6);
		BigDecimal copyFirstBigDecimal = firstBigDecimal;
		// equal
		assertEquals(Operator.compare(firstBigDecimal, Operator.NE,
				thirdBigDecimal), true);
		// not equal
		assertEquals(Operator.compare(firstBigDecimal, Operator.NE,
				secondBigDecimal), false);
		assertEquals(Operator.compare(firstBigDecimal, Operator.NE,
				copyFirstBigDecimal), false);

		// test for null and object NE
		String anObject = new String("hello");
		Object nullObject = null;
		// equal
		assertEquals(Operator.compare(anObject, Operator.NE, nullObject), true);
		// not equal
		assertEquals(Operator.compare(nullObject, Operator.NE, nullObject),
				false);
	}

	/**
	 * The testcase for GE test
	 * 
	 * @throws Exception
	 */
	public void testGE() throws Exception {
		// -------- For integer type GE test --------
		Integer firstInt = new Integer(5);
		Integer secondInt = new Integer(8);
		// equal
		assertEquals(Operator.compare(firstInt, Operator.GE, firstInt), true);
		// first is smaller than second
		assertEquals(Operator.compare(firstInt, Operator.GE, secondInt), false);
		// first is larger than second
		assertEquals(Operator.compare(secondInt, Operator.GE, firstInt), true);

		// -------- For Short type GE test --------
		Short firstShort = new Short((short) 5);
		Short secondShort = new Short((short) 8);
		// equal
		assertEquals(Operator.compare(firstShort, Operator.GE, firstShort),
				true);
		// first is smaller than second
		assertEquals(Operator.compare(firstShort, Operator.GE, secondShort),
				false);
		// first is larger than second
		assertEquals(Operator.compare(secondShort, Operator.GE, firstShort),
				true);

		// -------- For Character type GE test --------
		Character firstCharacter = new Character('5');
		Character secondCharacter = new Character('8');
		// equal
		assertEquals(Operator.compare(firstCharacter, Operator.GE,
				firstCharacter), true);
		// first is smaller than second
		assertEquals(Operator.compare(firstCharacter, Operator.GE,
				secondCharacter), false);
		// first is larger than second
		assertEquals(Operator.compare(secondCharacter, Operator.GE,
				firstCharacter), true);

		// -------- For Long type GE test --------
		Long firstLong = new Long(5);
		Long secondLong = new Long(8);
		// equal
		assertEquals(Operator.compare(firstLong, Operator.GE, firstLong), true);
		// first is smaller than second
		assertEquals(Operator.compare(firstLong, Operator.GE, secondLong),
				false);
		// first is larger than second
		assertEquals(Operator.compare(secondLong, Operator.GE, firstLong), true);

		// -------- For Byte type GE test --------
		Byte firstByte = new Byte("5");
		Byte secondByte = new Byte("8");
		// equal
		assertEquals(Operator.compare(firstByte, Operator.GE, firstByte), true);
		// first is smaller than second
		assertEquals(Operator.compare(firstByte, Operator.GE, secondByte),
				false);
		// first is larger than second
		assertEquals(Operator.compare(secondByte, Operator.GE, firstByte), true);

		// -------- For Float type GE test --------
		Float firstFloat = new Float(5);
		Float secondFloat = new Float(8);
		// equal
		assertEquals(Operator.compare(firstFloat, Operator.GE, firstFloat),
				true);
		// first is smaller than second
		assertEquals(Operator.compare(firstFloat, Operator.GE, secondFloat),
				false);
		// first is larger than second
		assertEquals(Operator.compare(secondFloat, Operator.GE, firstFloat),
				true);

		// -------- For Double type GE test --------
		Double firstDouble = new Double(5);
		Double secondDouble = new Double(8);
		// equal
		assertEquals(Operator.compare(firstDouble, Operator.GE, firstDouble),
				true);
		// first is smaller than second
		assertEquals(Operator.compare(firstDouble, Operator.GE, secondDouble),
				false);
		// first is larger than second
		assertEquals(Operator.compare(secondDouble, Operator.GE, firstDouble),
				true);

		// -------- For BigDecimal type GE test --------
		BigDecimal firstBigDecimal = new BigDecimal(5);
		BigDecimal secondBigDecimal = new BigDecimal(8);
		// equal
		assertEquals(Operator.compare(firstBigDecimal, Operator.GE,
				firstBigDecimal), true);
		// first is smaller than second
		assertEquals(Operator.compare(firstBigDecimal, Operator.GE,
				secondBigDecimal), false);
		// first is larger than second
		assertEquals(Operator.compare(secondBigDecimal, Operator.GE,
				firstBigDecimal), true);

		// -------- For different type GE test --------
		Double doubleOperant = new Double(4);
		Integer intOperant = new Integer(5);
		Short shortOperant = new Short((short) 5);
		Character characterOperant = new Character('8');
		BigDecimal bigDecimalOperant = new BigDecimal(8);
		Byte byteOperant = new Byte("5");
		Long longOperant = new Long(8);
		Float floatOperant = new Float(4);
		// equal
		assertEquals(Operator.compare(intOperant, Operator.GE, shortOperant),
				true);
		// first is smaller than second
		assertEquals(Operator.compare(shortOperant, Operator.GE,
				characterOperant), false);
		// first is smaller than second
		assertEquals(Operator.compare(intOperant, Operator.GE,
				bigDecimalOperant), false);
		// first is smaller than second
		assertEquals(Operator.compare(shortOperant, Operator.GE,
				bigDecimalOperant), false);
		// first is larger than second
		assertEquals(Operator.compare(bigDecimalOperant, Operator.GE,
				byteOperant), true);
		// first is smaller than second
		assertEquals(Operator.compare(byteOperant, Operator.GE, longOperant),
				false);
		// first is larger than second
		assertEquals(Operator.compare(longOperant, Operator.GE, floatOperant),
				true);
		// first is larger than second
		assertEquals(Operator.compare(byteOperant, Operator.GE, doubleOperant),
				true);

	}

	/**
	 * The testcase for GT test
	 * 
	 * @throws Exception
	 */
	public void testGT() throws Exception {
		// -------- For integer type GT test --------
		Integer firstInt = new Integer(5);
		Integer secondInt = new Integer(8);
		// equal
		assertEquals(Operator.compare(firstInt, Operator.GT, firstInt), false);
		// first is smaller than second
		assertEquals(Operator.compare(firstInt, Operator.GT, secondInt), false);
		// first is larger than second
		assertEquals(Operator.compare(secondInt, Operator.GT, firstInt), true);

		// -------- For Short type GT test --------
		Short firstShort = new Short((short) 5);
		Short secondShort = new Short((short) 8);
		// equal
		assertEquals(Operator.compare(firstShort, Operator.GT, firstShort),
				false);
		// first is smaller than second
		assertEquals(Operator.compare(firstShort, Operator.GT, secondShort),
				false);
		// first is larger than second
		assertEquals(Operator.compare(secondShort, Operator.GT, firstShort),
				true);

		// -------- For Character type GT test --------
		Character firstCharacter = new Character('5');
		Character secondCharacter = new Character('8');
		// equal
		assertEquals(Operator.compare(firstCharacter, Operator.GT,
				firstCharacter), false);
		// first is smaller than second
		assertEquals(Operator.compare(firstCharacter, Operator.GT,
				secondCharacter), false);
		// first is larger than second
		assertEquals(Operator.compare(secondCharacter, Operator.GT,
				firstCharacter), true);

		// -------- For Long type GT test --------
		Long firstLong = new Long(5);
		Long secondLong = new Long(8);
		// equal
		assertEquals(Operator.compare(firstLong, Operator.GT, firstLong), false);
		// first is smaller than second
		assertEquals(Operator.compare(firstLong, Operator.GT, secondLong),
				false);
		// first is larger than second
		assertEquals(Operator.compare(secondLong, Operator.GT, firstLong), true);

		// -------- For Byte type GT test --------
		Byte firstByte = new Byte("5");
		Byte secondByte = new Byte("8");
		// equal
		assertEquals(Operator.compare(firstByte, Operator.GT, firstByte), false);
		// first is smaller than second
		assertEquals(Operator.compare(firstByte, Operator.GT, secondByte),
				false);
		// first is larger than second
		assertEquals(Operator.compare(secondByte, Operator.GT, firstByte), true);

		// -------- For Float type GT test --------
		Float firstFloat = new Float(5);
		Float secondFloat = new Float(8);
		// equal
		assertEquals(Operator.compare(firstFloat, Operator.GT, firstFloat),
				false);
		// first is smaller than second
		assertEquals(Operator.compare(firstFloat, Operator.GT, secondFloat),
				false);
		// first is larger than second
		assertEquals(Operator.compare(secondFloat, Operator.GT, firstFloat),
				true);

		// -------- For Double type GT test --------
		Double firstDouble = new Double(5);
		Double secondDouble = new Double(8);
		// equal
		assertEquals(Operator.compare(firstDouble, Operator.GT, firstDouble),
				false);
		// first is smaller than second
		assertEquals(Operator.compare(firstDouble, Operator.GT, secondDouble),
				false);
		// first is larger than second
		assertEquals(Operator.compare(secondDouble, Operator.GT, firstDouble),
				true);

		// -------- For BigDecimal type GT test --------
		BigDecimal firstBigDecimal = new BigDecimal(5);
		BigDecimal secondBigDecimal = new BigDecimal(8);
		// equal
		assertEquals(Operator.compare(firstBigDecimal, Operator.GT,
				firstBigDecimal), false);
		// first is smaller than second
		assertEquals(Operator.compare(firstBigDecimal, Operator.GT,
				secondBigDecimal), false);
		// first is larger than second
		assertEquals(Operator.compare(secondBigDecimal, Operator.GT,
				firstBigDecimal), true);

		// -------- For different type GT test --------
		Double doubleOperant = new Double(4);
		Integer intOperant = new Integer(5);
		Short shortOperant = new Short((short) 5);
		Character characterOperant = new Character('8');
		BigDecimal bigDecimalOperant = new BigDecimal(8);
		Byte byteOperant = new Byte("5");
		Long longOperant = new Long(8);
		Float floatOperant = new Float(4);
		// equal
		assertEquals(Operator.compare(intOperant, Operator.GT, shortOperant),
				false);
		// first is smaller than second
		assertEquals(Operator.compare(shortOperant, Operator.GT,
				characterOperant), false);
		// first is smaller than second
		assertEquals(Operator.compare(intOperant, Operator.GT,
				bigDecimalOperant), false);
		// first is smaller than second
		assertEquals(Operator.compare(shortOperant, Operator.GT,
				bigDecimalOperant), false);
		// first is larger than second
		assertEquals(Operator.compare(bigDecimalOperant, Operator.GT,
				byteOperant), true);
		// first is smaller than second
		assertEquals(Operator.compare(byteOperant, Operator.GT, longOperant),
				false);
		// first is larger than second
		assertEquals(Operator.compare(longOperant, Operator.GT, floatOperant),
				true);
		// first is larger than second
		assertEquals(Operator.compare(byteOperant, Operator.GT, doubleOperant),
				true);
	}

	/**
	 * The testcase for LE test
	 * 
	 * @throws Exception
	 */
	public void testLE() throws Exception {
		// -------- For integer type LE test --------
		Integer firstInt = new Integer(5);
		Integer secondInt = new Integer(8);
		// equal
		assertEquals(Operator.compare(firstInt, Operator.LE, firstInt), true);
		// first is smaller than second
		assertEquals(Operator.compare(firstInt, Operator.LE, secondInt), true);
		// first is larger than second
		assertEquals(Operator.compare(secondInt, Operator.LE, firstInt), false);

		// -------- For Short type LE test --------
		Short firstShort = new Short((short) 5);
		Short secondShort = new Short((short) 8);
		// equal
		assertEquals(Operator.compare(firstShort, Operator.LE, firstShort),
				true);
		// first is smaller than second
		assertEquals(Operator.compare(firstShort, Operator.LE, secondShort),
				true);
		// first is larger than second
		assertEquals(Operator.compare(secondShort, Operator.LE, firstShort),
				false);

		// -------- For Character type LE test --------
		Character firstCharacter = new Character('5');
		Character secondCharacter = new Character('8');
		// equal
		assertEquals(Operator.compare(firstCharacter, Operator.LE,
				firstCharacter), true);
		// first is smaller than second
		assertEquals(Operator.compare(firstCharacter, Operator.LE,
				secondCharacter), true);
		// first is larger than second
		assertEquals(Operator.compare(secondCharacter, Operator.LE,
				firstCharacter), false);

		// -------- For Long type LE test --------
		Long firstLong = new Long(5);
		Long secondLong = new Long(8);
		// equal
		assertEquals(Operator.compare(firstLong, Operator.LE, firstLong), true);
		// first is smaller than second
		assertEquals(Operator.compare(firstLong, Operator.LE, secondLong), true);
		// first is larger than second
		assertEquals(Operator.compare(secondLong, Operator.LE, firstLong),
				false);

		// -------- For Double type LE test --------
		Double firstDouble = new Double(5);
		Double secondDouble = new Double(8);
		// equal
		assertEquals(Operator.compare(firstDouble, Operator.LE, firstDouble),
				true);
		// first is smaller than second
		assertEquals(Operator.compare(firstDouble, Operator.LE, secondDouble),
				true);
		// first is larger than second
		assertEquals(Operator.compare(secondDouble, Operator.LE, firstDouble),
				false);

		// -------- For Byte type LE test --------
		Byte firstByte = new Byte("5");
		Byte secondByte = new Byte("8");
		// equal
		assertEquals(Operator.compare(firstByte, Operator.LE, firstByte), true);
		// first is smaller than second
		assertEquals(Operator.compare(firstByte, Operator.LE, secondByte), true);
		// first is larger than second
		assertEquals(Operator.compare(secondByte, Operator.LE, firstByte),
				false);

		// -------- For Float type LE test --------
		Float firstFloat = new Float(5);
		Float secondFloat = new Float(8);
		// equal
		assertEquals(Operator.compare(firstFloat, Operator.LE, firstFloat),
				true);
		// first is smaller than second
		assertEquals(Operator.compare(secondFloat, Operator.LE, secondFloat),
				true);
		// first is larger than second
		assertEquals(Operator.compare(secondFloat, Operator.LE, firstFloat),
				false);

		// -------- For BigDecimal type LE test --------
		BigDecimal firstBigDecimal = new BigDecimal(5);
		BigDecimal secondBigDecimal = new BigDecimal(8);
		// equal
		assertEquals(Operator.compare(firstBigDecimal, Operator.LE,
				firstBigDecimal), true);
		// first is smaller than second
		assertEquals(Operator.compare(firstBigDecimal, Operator.LE,
				secondBigDecimal), true);
		// first is larger than second
		assertEquals(Operator.compare(secondBigDecimal, Operator.LE,
				firstBigDecimal), false);

		// -------- For different type LT test --------
		Integer intOperant = new Integer(5);
		Short shortOperant = new Short((short) 5);
		Character characterOperant = new Character('8');
		BigDecimal bigDecimalOperant = new BigDecimal(8);
		Byte byteOperant = new Byte("5");
		Long longOperant = new Long(8);
		Float floatOperant = new Float(4);
		Double doubleOperant = new Double(4);
		// equal
		assertEquals(Operator.compare(intOperant, Operator.LE, shortOperant),
				true);
		// first is smaller than second
		assertEquals(Operator.compare(shortOperant, Operator.LE,
				characterOperant), true);
		// first is smaller than second
		assertEquals(Operator.compare(intOperant, Operator.LE,
				bigDecimalOperant), true);
		// first is smaller than second
		assertEquals(Operator.compare(shortOperant, Operator.LE,
				bigDecimalOperant), true);
		// first is larger than second
		assertEquals(Operator.compare(bigDecimalOperant, Operator.LE,
				byteOperant), false);
		// first is smaller than second
		assertEquals(Operator.compare(byteOperant, Operator.LE, longOperant),
				true);
		// first is larger than second
		assertEquals(Operator.compare(longOperant, Operator.LE, floatOperant),
				false);
		// first is larger than second
		assertEquals(Operator.compare(byteOperant, Operator.LE, doubleOperant),
				false);
	}

	/**
	 * The testcase for LT test
	 * 
	 * @throws Exception
	 */
	public void testLT() throws Exception {
		// -------- For integer type LT test --------
		Integer firstInt = new Integer(5);
		Integer secondInt = new Integer(8);
		// equal
		assertEquals(Operator.compare(firstInt, Operator.LT, firstInt), false);
		// first is smaller than second
		assertEquals(Operator.compare(firstInt, Operator.LT, secondInt), true);
		// first is larger than second
		assertEquals(Operator.compare(secondInt, Operator.LT, firstInt), false);

		// -------- For Short type LT test --------
		Short firstShort = new Short((short) 5);
		Short secondShort = new Short((short) 8);
		// equal
		assertEquals(Operator.compare(firstShort, Operator.LT, firstShort),
				false);
		// first is smaller than second
		assertEquals(Operator.compare(firstShort, Operator.LT, secondShort),
				true);
		// first is larger than second
		assertEquals(Operator.compare(secondShort, Operator.LT, firstShort),
				false);

		// -------- For Character type LT test --------
		Character firstCharacter = new Character('5');
		Character secondCharacter = new Character('8');
		// equal
		assertEquals(Operator.compare(firstCharacter, Operator.LT,
				firstCharacter), false);
		// first is smaller than second
		assertEquals(Operator.compare(firstCharacter, Operator.LT,
				secondCharacter), true);
		// first is larger than second
		assertEquals(Operator.compare(secondCharacter, Operator.LT,
				firstCharacter), false);

		// -------- For Long type LT test --------
		Long firstLong = new Long(5);
		Long secondLong = new Long(8);
		// equal
		assertEquals(Operator.compare(firstLong, Operator.LT, firstLong), false);
		// first is smaller than second
		assertEquals(Operator.compare(firstLong, Operator.LT, secondLong), true);
		// first is larger than second
		assertEquals(Operator.compare(secondLong, Operator.LT, firstLong),
				false);

		// -------- For Byte type LT test --------
		Byte firstByte = new Byte("5");
		Byte secondByte = new Byte("8");
		// equal
		assertEquals(Operator.compare(firstByte, Operator.LT, firstByte), false);
		// first is smaller than second
		assertEquals(Operator.compare(firstByte, Operator.LT, secondByte), true);
		// first is larger than second
		assertEquals(Operator.compare(secondByte, Operator.LT, firstByte),
				false);

		// -------- For Float type LT test --------
		Float firstFloat = new Float(5);
		Float secondFloat = new Float(8);
		// equal
		assertEquals(Operator.compare(firstFloat, Operator.LT, firstFloat),
				false);
		// first is smaller than second
		assertEquals(Operator.compare(firstFloat, Operator.LT, secondFloat),
				true);
		// first is larger than second
		assertEquals(Operator.compare(secondFloat, Operator.LT, firstFloat),
				false);

		// -------- For Double type LT test --------
		Double firstDouble = new Double(5);
		Double secondDouble = new Double(8);
		// equal
		assertEquals(Operator.compare(firstDouble, Operator.LT, firstDouble),
				false);
		// first is smaller than second
		assertEquals(Operator.compare(firstDouble, Operator.LT, secondDouble),
				true);
		// first is larger than second
		assertEquals(Operator.compare(secondDouble, Operator.LT, firstDouble),
				false);

		// -------- For BigDecimal type LT test --------
		BigDecimal firstBigDecimal = new BigDecimal(5);
		BigDecimal secondBigDecimal = new BigDecimal(8);
		// equal
		assertEquals(Operator.compare(firstBigDecimal, Operator.LT,
				firstBigDecimal), false);
		// first is smaller than second
		assertEquals(Operator.compare(firstBigDecimal, Operator.LT,
				secondBigDecimal), true);
		// first is larger than second
		assertEquals(Operator.compare(secondBigDecimal, Operator.LT,
				firstBigDecimal), false);

		// -------- For different type LT test --------
		Integer intOperant = new Integer(5);
		Short shortOperant = new Short((short) 5);
		Character characterOperant = new Character('8');
		BigDecimal bigDecimalOperant = new BigDecimal(8);
		Byte byteOperant = new Byte("5");
		Long longOperant = new Long(8);
		Float floatOperant = new Float(4);
		Double doubleOperant = new Double(4);
		// equal
		assertEquals(Operator.compare(intOperant, Operator.LT, shortOperant),
				false);
		// first is smaller than second
		assertEquals(Operator.compare(shortOperant, Operator.LT,
				characterOperant), true);
		// first is smaller than second
		assertEquals(Operator.compare(intOperant, Operator.LT,
				bigDecimalOperant), true);
		// first is smaller than second
		assertEquals(Operator.compare(shortOperant, Operator.LT,
				bigDecimalOperant), true);
		// first is larger than second
		assertEquals(Operator.compare(bigDecimalOperant, Operator.LT,
				byteOperant), false);
		// first is smaller than second
		assertEquals(Operator.compare(byteOperant, Operator.LT, longOperant),
				true);
		// first is larger than second
		assertEquals(Operator.compare(longOperant, Operator.LT, floatOperant),
				false);
		// first is larger than second
		assertEquals(Operator.compare(byteOperant, Operator.LT, doubleOperant),
				false);
	}

	/**
	 * The testcase for LIKE test
	 * 
	 * @throws Exception
	 */
	public void testLIKE() throws Exception {
		// -------- For LIKE test --------
		String firstQueryString = "hello world";
		String secondQueryString = "wo?ld";
		String thirdQueryString = "hell*";
		String fourthQueryString = "*wor*";
		String fifthQueryString = "*ll? wo?ld";
		String sixthQueryString = "soyatec";
		// full string
		String fullString = "hello world from eclipse";

		// the String does not include "?" and "*"
		Assert.assertEquals(Operator.compare(firstQueryString, Operator.LIKE,
				fullString), true);

		// the String includes "?"
		Assert.assertEquals(Operator.compare(secondQueryString, Operator.LIKE,
				fullString), true);

		// the String includes "*"
		Assert.assertEquals(Operator.compare(thirdQueryString, Operator.LIKE,
				fullString), true);

		// the String includes "*"
		Assert.assertEquals(Operator.compare(fourthQueryString, Operator.LIKE,
				fullString), true);

		// the String includes "*" and "?"
		Assert.assertEquals(Operator.compare(fifthQueryString, Operator.LIKE,
				fullString), true);

		// the String is not be included to another string
		Assert.assertEquals(Operator.compare(sixthQueryString, Operator.LIKE,
				fullString), false);
	}

	/**
	 * The testcase for ISA test
	 * 
	 * @throws Exception
	 */
	public void testISA() throws Exception {
		// -------- For ISA test --------
		String string = "hello";
		// the string is instance of the object
		Assert.assertEquals(Operator.compare(string, Operator.IS_A,
				Object.class), true);
		// the string is not instance of the bool
		Assert.assertEquals(Operator.compare(string, Operator.IS_A,
				Boolean.class), false);
	}

	/**
	 * The testcase for IS_KIND_OF test
	 * 
	 * @throws Exception
	 */
	public void testIS_KIND_OF() throws Exception {
		// -------- For ISA test --------
		String string = "";
		Boolean bool = new Boolean(true);
		Object object = new Object();
		// the string is instance of the object
		Assert.assertEquals(Operator.compare(string, Operator.IS_KIND_OF,
				object), true);
		// the string is not instance of the bool
		Assert.assertEquals(
				Operator.compare(string, Operator.IS_KIND_OF, bool), false);
	}
}
