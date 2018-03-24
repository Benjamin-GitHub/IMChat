/*
import java.util.UUID;
import com.alibaba.idst.nls.NlsClient;
import com.alibaba.idst.nls.NlsFuture;
import com.alibaba.idst.nls.event.NlsEvent;
import com.alibaba.idst.nls.event.NlsListener;
import com.alibaba.idst.nls.protocol.GdsContent.GdsContent;
import com.alibaba.idst.nls.protocol.NlsRequest;
import com.alibaba.idst.nls.protocol.NlsResponse;
public class DialogDemo implements NlsListener {
    private static NlsClient client = new NlsClient();
    private final String APP_KEY = "您自己的AppKey";
    private final String ACCESS_KEY_ID = "您自己的AccessKeyId";
    private final String ACCESS_KEY_SECRET = "您自己的AccessKeySecret";
    public void init() {
        client.init();
    }
    public void close() {
        client.close();
    }
    public void ask(String sessionId, String question) throws Exception {
        NlsRequest request = new NlsRequest();
        request.authorize(ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        request.setApp_key(APP_KEY);
        request.setAsr_fake(question);
        request.setGds_content(createGdsContent(sessionId));
        NlsFuture future = client.createNlsFuture(request, this);
        // 设置服务端结果返回的超时时间
        future.await(10000);
    }
    @Override
    public void onMessageReceived(NlsEvent event) {
        NlsResponse response = event.getResponse();
        String result = "";
        if (response.getAsr_ret() != null) {
            result += "asr result: " + response.getAsr_ret();
        }
        if (response.getTts_ret() != null) {
            result += "\ntts result: " + response.getTts_ret();
        }
        if(response.getUds_ret() != null) {
            result += "\ndialog result: " + response.getUds_ret();
        }
        if (result != null) {
            System.out.println(result);
        }
    }
    @Override
    public void onOperationFailed(NlsEvent nlsEvent) {
        //调用失败
    }
    @Override
    public void onChannelClosed(NlsEvent nlsEvent) {
        //连接关闭
    }
    private GdsContent createGdsContent(String sessionId) {
        GdsContent content = new GdsContent();
        content.setQuery_type("text");
        content.setConversation_id(sessionId);
        content.setTurn_id(1);
        return content;
    }
    public static void main(String[] args) throws Exception {
        String sessionId = UUID.randomUUID().toString();
        DialogDemo dialogDemo = new DialogDemo();
        dialogDemo.init();
        dialogDemo.ask(sessionId, "北京明天天气怎么样");
        dialogDemo.close();
    }
}*/
