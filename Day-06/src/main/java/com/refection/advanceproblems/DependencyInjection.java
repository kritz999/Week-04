package com.refection.advanceproblems;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class DependencyInjection {

        private Map<Class<?>, Object> instances = new HashMap<>();

        public <T> T getInstance(Class<T> clazz) throws Exception {
            if (instances.containsKey(clazz)) {
                return clazz.cast(instances.get(clazz));
            }

            // Create a new instance
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Inject dependencies into fields marked with @Inject
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    Class<?> fieldType = field.getType();
                    Object dependency = getInstance(fieldType);  // Recursively resolve dependencies

                    field.setAccessible(true);
                    field.set(instance, dependency);
                }
            }

            // Store instance for reuse
            instances.put(clazz, instance);
            return instance;
        }
    }



