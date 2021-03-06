package tnmk.common.util;

import tnmk.common.exception.BadArgumentException;
import tnmk.el.app.common.entity.json.DeserializerEnumByField;

/**
 * @author khoi.tran on 8/31/16.
 */
public class EnumUtil {
    public static <T extends Enum<T>> T validateExistEnum(Class<T> enumClass, String enumName) {
        try {
            return Enum.valueOf(enumClass, enumName);
        } catch (IllegalArgumentException ex) {
            String msg = String.format("Not found enum instance. enumClass: %s, enumName: %s", enumClass, enumName);
            throw new BadArgumentException(msg, ex);
        }
    }

    public static <T extends Enum<T>> T validateExistEnum(Class<T> enumClass, String enumFieldName, String enumFieldValue) {
        try {
            T enumObject = DeserializerEnumByField.deserialize(enumClass, enumFieldName, enumFieldValue);
            if (enumObject == null) {
                String msg = String.format("Not found enum instance. enumClass: %s, enumFieldName: %s, enumFieldValue: %s", enumClass, enumFieldName, enumFieldValue);
                throw new BadArgumentException(msg);
            }
            return enumObject;
        } catch (IllegalArgumentException ex) {
            String msg = String.format("Not found enum instance. enumClass: %s, enumFieldName: %s, enumFieldValue: %s", enumClass, enumFieldName, enumFieldValue);
            throw new BadArgumentException(msg, ex);
        }
    }
}
