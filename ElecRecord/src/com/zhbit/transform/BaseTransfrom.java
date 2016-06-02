package com.zhbit.transform;

import java.util.List;

public interface BaseTransfrom {
	
	public List<Object> toDBEntity(List excelObjs);
	public List<Object> toExcelObj(List dbObjs);

}
