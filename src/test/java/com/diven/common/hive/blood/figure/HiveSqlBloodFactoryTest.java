package com.diven.common.hive.blood.figure;

import com.diven.common.hive.blood.factory.HiveSqlBloodFactory;
import com.diven.common.hive.blood.model.TableBlood;

import java.util.Arrays;

public class HiveSqlBloodFactoryTest extends BaseTest{

	/**
	 * 获取当前sql的表血缘
	 */
	public void testGetTableBlood() throws Exception{
		TableBlood tableBlood = HiveSqlBloodFactory.getTableBlood(Arrays.asList(hqls));
		printJsonString(tableBlood);
//		GraphUI.show(tableBlood);
//		System.in.read();
	}
	
}
