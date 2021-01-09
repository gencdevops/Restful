package org.javaturk.soap.currencyconverter.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Conversions {
	private List<Conversion> conversions = Collections.synchronizedList(new ArrayList<>());

	public Conversions() {
	}

	public void addConversion(Conversion conversion) {
		conversions.add(conversion);
//		System.out.println("Adding a new conversion and size: " + conversions.size());
	}

	public List<Conversion> getConversions() {
		return conversions;
	}

	public void setConversions(List<Conversion> list) {
		conversions = list;
	}
}
