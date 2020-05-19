package netcracker.annotations;

import netcracker.IO.PropertyFileLoader;
import netcracker.exceptions.MyException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import java.util.Properties;
import java.util.Set;


public class Injector {

    public static <T> T inject(T object) throws MyException {
        Class c;
        Properties property = PropertyFileLoader.readPropertyFile();
        Set<String> propertyNames = property.stringPropertyNames();
        Class cl = object.getClass();
        Field[] fields = cl.getDeclaredFields();
        for(Field f: fields) {
            if (f.getAnnotations() != null ) {
                for (Annotation annotation : f.getAnnotations()) {
                    if (annotation instanceof LabInjector) {
                        for(String p: propertyNames){
                            if(p.equals(f.getName())){
                                f.setAccessible(true);
                                try {
                                    c = Class.forName(property.getProperty(p));
                                } catch (ClassNotFoundException e) {
                                    throw new MyException(e);
                                }
                                try {
                                    f.set(c, c.newInstance());
                                } catch (IllegalAccessException e) {
                                    throw new MyException(e);
                                } catch (InstantiationException e) {
                                    throw new MyException(e);
                                }
                            }
                        }
                    }
                }
            }
        }
        return object;
    }

}
