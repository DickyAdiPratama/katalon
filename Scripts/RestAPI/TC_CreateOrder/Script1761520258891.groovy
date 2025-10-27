import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import groovy.json.JsonOutput


String id = "A-" + System.currentTimeMillis()
def body = [id:id, amount:amount, currency:currency, status:status]



RequestObject req = new RequestObject('POST_orders')
req.setRestUrl('http://localhost:3000/orders')
req.setRestRequestMethod('POST')
req.setBodyContent(new HttpTextBodyContent(JsonOutput.toJson(body),'UTF-8','application/json'))

def resp = WS.sendRequest(req)
WS.verifyResponseStatusCode(resp, 201)
WS.verifyElementPropertyValue(resp, 'id', id)
