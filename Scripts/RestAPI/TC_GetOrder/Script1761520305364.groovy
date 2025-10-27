import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject

RequestObject req = new RequestObject('GET_order_id')
req.setRestUrl("http://localhost:3000/orders/${orderId}")
req.setRestRequestMethod('GET')

def resp = WS.sendRequest(req)
WS.verifyResponseStatusCode(resp, 200)