package kafka;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by zenith on 2015/12/26.
 */
public class KafkaUtil {

    private Producer<String,String> stringProducer;


    public void initProducer() throws IOException {

        Properties prop=new Properties();
        prop.load(KafkaUtil.class.getClassLoader().getResourceAsStream("producer.properties"));
        stringProducer=new Producer<String, String>(new ProducerConfig(prop));

    }

   public void produceData(String topic,String key,String value) throws IOException {

       if (null==key){
           stringProducer.send(new KeyedMessage<String, String>(topic,value));
       }else {
           stringProducer.send(new KeyedMessage<String, String>(topic, key, value));
       }
   }

    public List<KafkaStream<byte[], byte[]>> getConsumer(Integer consumerNum,String topic) throws IOException {

        //加载和配置文件
        Properties prop=new Properties();
        prop.load(KafkaUtil.class.getClassLoader().getResourceAsStream("consumer.properties"));

        //创建连接
        ConsumerConnector connector= Consumer.createJavaConsumerConnector(new ConsumerConfig(prop));

        Map<String,Integer> topicCountMap=new HashMap<String,Integer>();

        topicCountMap.put(topic,consumerNum);

        Map<String, List<KafkaStream<byte[], byte[]>>> topicMessageStreams
                =connector.createMessageStreams(topicCountMap);
       return topicMessageStreams.get(topic);
    }


    public static void main(String[] args) throws IOException {
//        KafkaUtil kafkaUtil=new KafkaUtil();
//       // kafkaUtil.initProducer();
//        //kafkaUtil.produceData("crxy","newkey","newvalue");
//
//
//        List<KafkaStream<byte[], byte[]>> kafkaStreams=kafkaUtil.getConsumer(1, "crxy");
//        ConsumerIterator<byte[], byte[]> it = kafkaStreams.get(0).iterator();
//        while(it.hasNext()){
//            MessageAndMetadata<byte[],byte[]> item = it.next();
//            System.out.println(String.format("thread:%s   partition:%s    offset:%s   message:%s",Thread.currentThread().getName(),item.partition(),item.offset(),new String(item.message())));
//        }



    }

}
