package util;


import annotations.ValidatorAnnotation;
import formbean.RegistrationFormBean;

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

    public Validator(RegistrationFormBean formBean) {
        this.formBean = formBean;
    }

    public Map<String, String> validate() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<String, String> result = new HashMap<>();
        Field[] fields = formBean.getClass().getDeclaredFields();
        for (Field field: fields) {
            if (field.getAnnotation(ValidatorAnnotation.Pattern.class) != null) {
                ValidatorAnnotation.Pattern annotation = field.getAnnotation(ValidatorAnnotation.Pattern.class);
                ValidatorAnnotation.GetMethod getMethod = field.getAnnotation(ValidatorAnnotation.GetMethod.class);
                Pattern pattern = Pattern.compile(annotation.pattern());
                Matcher matcher = pattern.matcher((CharSequence) formBean.getClass().getMethod(getMethod.method()).invoke(formBean));
                if(!matcher.find()){
                    result.put(field.getName(), annotation.errorMessage());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        RegistrationFormBean bean = new RegistrationFormBean("a","b","a","a","01");
        Validator validator = new Validator(bean);
        System.out.println(validator.validate());
    }
}
