package storm.bbs;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import backtype.storm.Config;
import backtype.storm.Constants;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class MyBoltCount extends BaseRichBolt {
	private OutputCollector collector;
	@Override
	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		this.collector = collector;
	}
	
	//对指定时间之内的数据进行局部汇总
	HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
	@Override
	public void execute(Tuple input) {
		if(input.getSourceComponent().equals(Constants.SYSTEM_COMPONENT_ID)){
			for (Entry<String, Integer> entry : hashMap.entrySet()) {
				//TODO--需要使用mysql的批量入库，在这是一mysql的update方法来模拟
				MyDbUtils.update("insert into city_view(city,count,time) values(?,?,?)", entry.getKey(),entry.getValue(),MyDateUtils.formatDate2(new Date()));
			}
			System.out.println("定时任务执行结束...");
			//注意：存储完之后需要把hashmap中的数据清空
			hashMap.clear();
		}else{
			String city = input.getStringByField("city");
			Integer count = hashMap.get(city);
			if(count==null){
				count=0;
			}
			count++;
			hashMap.put(city, count);
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		
	}

	/**
	 * 设置定时任务
	 */
	@Override
	public Map<String, Object> getComponentConfiguration() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put(Config.TOPOLOGY_TICK_TUPLE_FREQ_SECS, 5);
		return hashMap;
	}
	
	

}
