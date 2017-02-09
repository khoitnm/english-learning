package tnmk.el.app.common.entity.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.BeanUtils;
import tnmk.common.exception.UnexpectedException;
import tnmk.common.util.StringUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author khoi.tran on 2/9/17.
 */
public class DeserializerEnumByField<T extends Enum<T>> extends StdDeserializer<T> {
    private final Class<T> enumClass;
    private final Method fieldGetter;

    /**
     * @param enumClass
     */
    public DeserializerEnumByField(Class<T> enumClass) {
        this(enumClass, "stringValue");
    }

    /**
     * @param enumClass
     * @param fieldName e.g. "stringValue"
     */
    public DeserializerEnumByField(Class<T> enumClass, String fieldName) {
        super(enumClass);
        this.enumClass = enumClass;
        this.fieldGetter = BeanUtils.getPropertyDescriptor(enumClass, fieldName).getReadMethod();
    }

    @Override
    public T deserialize(JsonParser jp, DeserializationContext dc) throws IOException {
        String enumLabel = jp.readValueAs(String.class);
        if (enumLabel == null) {
            return null;
        }
        try {
            for (T expressionType : enumClass.getEnumConstants()) {
                Object fieldValue = fieldGetter.invoke(enumClass);
                String fieldStringValue = StringUtil.toString(fieldValue);
                if (enumLabel.trim().equalsIgnoreCase(fieldStringValue)) {
                    return expressionType;
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new UnexpectedException("Cannot get value from " + enumClass + "." + fieldGetter.getName() + "()", e);
        }
        return null;
    }
}