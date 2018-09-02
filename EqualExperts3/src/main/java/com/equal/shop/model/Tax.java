package com.equal.shop.model;

import java.util.ArrayList;
import java.util.List;

import com.main.config.TaxEnum;

/**
 * Model class that correspond to the total tax applicable.It contains a list of
 * various tax applicable.
 */
public class Tax {
	List<TaxEnum> taxList;

	public Tax(List<TaxEnum> taxList) {
		super();
		this.taxList = new ArrayList<>(taxList);
	}

	public void addTax(TaxEnum taxObj) {
		if (null == taxObj)
			return;
		taxList.add(taxObj);
	}

	public List<TaxEnum> getTaxList() {
		return taxList;
	}

}
