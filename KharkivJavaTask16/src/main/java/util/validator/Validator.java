package util.validator;


import annotation.ValidatorAnnotation;
import entity.formbean.RegistrationFormBean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Arsalan
 */
public class Validator {

    private RegistrationFormBean formBean;

    public Validator() {
    }

    public Map<String, String> validate() {
        Map<String, String> result = new HashMap<>();
        Field[] fields = formBean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(ValidatorAnnotation.Pattern.class) != null) {
                ValidatorAnnotation.Pattern annotation = field.getAnnotation(ValidatorAnnotation.Pattern.class);
                ValidatorAnnotation.GetMethod getMethod = field.getAnnotation(ValidatorAnnotation.GetMethod.class);
                Pattern pattern = Pattern.compile(annotation.pattern());
                Matcher matcher = null;
                try {
                    matcher = pattern.matcher((CharSequence) formBean.getClass().getMethod(getMethod.method()).invoke(formBean));
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                if (!matcher.find()) {
                    result.put(field.getName(), annotation.errorMessage());
                }
            }
        }
        return result;
    }

    public void setFormBean(RegistrationFormBean formBean) {
        this.formBean = formBean;
    }
}
