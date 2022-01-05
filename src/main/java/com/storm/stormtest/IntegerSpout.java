package com.storm.stormtest;

import java.util.Map;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

public class IntegerSpout extends BaseRichSpout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SpoutOutputCollector spoutOutputCollector;
	private Integer index = 0;

	@Override
	public void nextTuple() {
		if (index < 100) {
			this.spoutOutputCollector.emit(new Values(index));
			index++;
		}

	}

	@Override
	public void open(Map<String, Object> conf, TopologyContext topologyContext,
			SpoutOutputCollector spoutOutputCollector) {
		this.spoutOutputCollector = spoutOutputCollector;

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
		outputFieldsDeclarer.declare(new Fields("field"));

	}

}
