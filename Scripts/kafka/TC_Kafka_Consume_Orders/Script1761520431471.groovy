import static org.junit.Assert.*
import kafka.KafkaUtils

boolean ok = KafkaUtils.consumeContains('orders', '"status":"PAID"', 10)
assertTrue('Expected at least one Kafka message with status=PAID', ok)
