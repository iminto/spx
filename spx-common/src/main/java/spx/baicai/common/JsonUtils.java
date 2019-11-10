package spx.baicai.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtils {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    private JsonUtils() {
    }

    public static String encode(Object obj) {
        if(obj==null) return null;
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("encode(Object)", e);
        }
        return null;
    }

    public static <T> T decode(String jsonString, Class<T> valueType) {
        if (jsonString == null || "".equals(jsonString)) {
            return null;
        }
        try {
            return objectMapper.readValue(jsonString, valueType);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static <T> T readValue(String jsonString, TypeReference<T> valueTypeRef){
        if (jsonString == null || "".equals(jsonString)) {
            return null;
        }
        try {
            return objectMapper.readValue(jsonString, valueTypeRef);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
