package com.xavier.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 表数据变更信息
 *
 * @author NewGr8Player
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BinLogData {

	/**
	 * 变化类型
	 */
	private String operType;

	/**
	 * 变化前数据行
	 */
	private List beforeDataList;

	/**
	 * 变化后数据行
	 */
	private List afterDatalist;
}
