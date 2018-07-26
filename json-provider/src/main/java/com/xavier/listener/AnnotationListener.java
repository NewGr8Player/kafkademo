package com.xavier.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.BinLogData;
import com.xavier.starter.canal.annotation.CanalEventListener;
import com.xavier.starter.canal.annotation.ListenPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bin-log抽取监听
 *
 * @author NewGr8Player
 */
@CanalEventListener
public class AnnotationListener {

	@Value("${spring.kafka.topic}")
	private String topic;

	@Autowired
	private KafkaTemplate kafkaTemplate;

	@ListenPoint(destination = "example", schema = "blogx", table = "tbl_test")
	public void testListener(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
		this.kafkaTemplate.send(topic, JSON.toJSONString(new BinLogData(eventType.name(), dataEtl(rowData.getBeforeColumnsList()), dataEtl(rowData.getAfterColumnsList()))));
	}

	private List<Map> dataEtl(List<CanalEntry.Column> list) {
		if (list.size() == 0) {
			return null;
		}
		List<Map> listMap = new ArrayList<>();
		for (CanalEntry.Column e : list) {
			Map map = new HashMap();
			map.put("name", e.getName());
			map.put("value", e.getValue());
			listMap.add(map);
		}
		return listMap;
	}
}
