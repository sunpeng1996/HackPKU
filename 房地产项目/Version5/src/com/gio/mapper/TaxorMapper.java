package com.gio.mapper;

import java.util.List;

import com.gio.po.Taxor;

public interface TaxorMapper {
	public List<Taxor> QueryTaxorByid(String tax_id);
}
