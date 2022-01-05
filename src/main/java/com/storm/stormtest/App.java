package com.storm.stormtest;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

/**
 * Hello world!
 *
 */
public class App {
	private static LocalCluster cluster;

	public static void main(String[] args) throws Exception {
		//build topology
		
		//create topology builder 
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("IntegerSpout", new IntegerSpout());
		builder.setBolt("MultiplierBolt", new MultiplierBolt()).shuffleGrouping("IntegerSpout");
		
		//conf
		Config config = new Config();
//		config.setDebug(true);
		
		cluster = new LocalCluster();
		cluster.submitTopology("hellotopology", config, builder.createTopology());
		Thread.sleep(10000);
	}
}
