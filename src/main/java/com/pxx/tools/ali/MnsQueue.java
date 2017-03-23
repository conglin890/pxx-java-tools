package com.pxx.tools.ali;


import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudQueue;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.model.Message;

public class MnsQueue {


    private MNSClient client;
    private String queueName;


    public MnsQueue(String accessId, String accessKey, String  endpoint, String queueName) {
        CloudAccount account =  new CloudAccount(accessId, accessKey, endpoint);
        this.client =  account.getMNSClient();
        this.queueName = queueName;
    }


    public void sendMessage(String msg){
        CloudQueue queue =  this.client.getQueueRef(this.queueName);
        Message message = new Message();
        message.setMessageBody(msg);
        Message putMsg = queue.putMessage(message);
    }



    protected void finalize() {
        this.client.close();
    }

}
