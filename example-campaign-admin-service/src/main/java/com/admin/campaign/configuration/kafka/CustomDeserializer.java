package com.admin.campaign.configuration.kafka;



import com.admin.campaign.event.CampaignProcessEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class CustomDeserializer implements Deserializer<Object> {

    @Override
    public void configure(Map<String ,?> configs, boolean isKey){

    }

    @Override
    public Object deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        Object object = null;
        try{
            object = mapper.readValue(bytes, CampaignProcessEvent.class);
        }catch (Exception e){
            System.out.println("Error While Deserialize " + e);
        }
        return object;
    }


    @Override
    public void close() {

    }


}
