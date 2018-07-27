package com.jck.travel.flight.util.component;

import com.jck.travel.flight.util.enumeration.ApiTag;
import com.jck.travel.flight.util.exception.APITagNotFoundException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

@Component
public class DataBinding {

    private static Map<ApiTag, Properties> mappingProperties = new LinkedHashMap<>();

    public void loadProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));

        for (String fileName : properties.getProperty("api.mappings").split(",")) {
            Properties mappingProperties = new Properties();
            mappingProperties.load(getClass().getClassLoader().getResourceAsStream(fileName));
            setMappingProperty(fileName, mappingProperties);
        }
    }

    public Map<String, ?> getProperties(ApiTag tag) throws APITagNotFoundException {
        if (mappingProperties.containsKey(tag)) {

            Map<String, Object> properties = new LinkedHashMap<>();
            Properties propertiesFile = mappingProperties.get(tag);
            Enumeration<?> keys = propertiesFile.keys();

            while (keys.hasMoreElements()) {
                Object key = keys.nextElement();
                String data = propertiesFile.getProperty(key.toString());
                System.out.println("key :" + key + " Value :" + data);
                properties.put(key.toString(), propertiesFile.getProperty(key.toString()));
            }

            return properties;
        } else
            throw new APITagNotFoundException("API Tag not found in \"BindPropertiesServiceImpl -> getProperties\"");
    }

    public Map<ApiTag, Properties> getAllMappings() {
        return mappingProperties;
    }

    private void setMappingProperty(String fileName, Properties mappingProperty) {
        if (fileName.contains("TBO") || fileName.contains("tbo"))
            mappingProperties.put(ApiTag.TBO, mappingProperty);
    }
}
