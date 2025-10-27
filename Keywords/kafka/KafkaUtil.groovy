package kafka

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.common.serialization.StringDeserializer
import java.time.Duration

class KafkaUtils {
    static KafkaConsumer<String,String> buildConsumer(String bootstrap='localhost:9092', String groupId='katalon-consumer') {
        Properties props = new Properties()
        props.put('bootstrap.servers', System.getenv('KAFKA_BOOTSTRAP') ?: bootstrap)
        props.put('group.id', groupId)
        props.put('enable.auto.commit', 'true')
        props.put('auto.offset.reset', 'earliest')
        props.put('key.deserializer', StringDeserializer.getName())
        props.put('value.deserializer', StringDeserializer.getName())
        return new KafkaConsumer<>(props)
    }
    static boolean consumeContains(String topic, String mustContain, int timeoutSec=10) {
        def c = buildConsumer()
        c.subscribe(java.util.Arrays.asList(topic))
        ConsumerRecords<String,String> recs = c.poll(Duration.ofSeconds(timeoutSec))
        c.close()
        if (recs.count() == 0) return false
        return recs.any { it.value().contains(mustContain) }
    }
}
