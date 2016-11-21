package shop.entity.product.annot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Arsalan
 */
public @interface ProductAnnotations {

    public static final String enProperties = "resources_en";
    public static final String ruProperties = "resources_ru";

    @Target(value = ElementType.FIELD)
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface FriendlyName {
        String value();
    }

    @Target(value = ElementType.METHOD)
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface Set {
        String value();
    }
}
