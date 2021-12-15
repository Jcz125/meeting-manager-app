package eu.telecomnancy.junit;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReflectionAssertions {

    public static void assertInstanceOf(final String expectedClassName, final Object obj) {
        try {
            final Class<?> expectedClass = forName(expectedClassName);
            expectedClass.cast(obj);
        } catch (ClassCastException | ClassNotFoundException ex) {
            fail(obj + " is not an instanceof " + expectedClassName);
        }
    }


    public static void assertDeclaredMethod(final String className, final String methodName, final String[] parametersTypesNames, final String message) {
        final Class<?>[] parametersTypes = Arrays.stream(parametersTypesNames).map(ReflectionAssertions::getClassFromParameterName).toArray(Class<?>[]::new);
        assertDeclaredMethod(className, methodName, parametersTypes, message);
    }


    public static void assertDeclaredMethod(final String className, final String methodName, final Class<?>[] parametersTypes, final String message) {
        try {
            final Class<?> testedClass = Class.forName(className);
            final Method m = testedClass.getMethod(methodName, parametersTypes);
        } catch (final ClassNotFoundException cause) {
            fail("Could not found " + className, cause);
        } catch (final NoSuchMethodException cause) {
            fail(cause);
        }
    }


    public static void assertDeclaredMethodWithReturnType(final String className, final String methodName, final String[] parametersTypesNames, final String returnTypeName, final String message) {
        final Class<?>[] parametersTypes = Arrays.stream(parametersTypesNames).map(ReflectionAssertions::getClassFromParameterName).toArray(Class<?>[]::new);
        assertDeclaredMethodWithReturnType(className, methodName, parametersTypes, returnTypeName, message);
    }


    public static void assertDeclaredMethodWithReturnType(final String className, final String methodName, final Class<?>[] parametersTypes, final String returnTypeName, final String message) {
        try {
            assertDeclaredMethodWithReturnType(className, methodName, parametersTypes, ReflectionAssertions.forName(returnTypeName), message);
        } catch (final ClassNotFoundException cause) {
            fail("Could not found expected return class " + className, cause);
        }
    }


    public static void assertDeclaredMethodWithReturnType(final String className, final String methodName, final String[] parametersTypesNames, final Class<?> returnTypeName, final String message) {
        final Class<?>[] parametersTypes = Arrays.stream(parametersTypesNames).map(ReflectionAssertions::getClassFromParameterName).toArray(Class<?>[]::new);
        assertDeclaredMethodWithReturnType(className, methodName, parametersTypes, returnTypeName, message);
    }


    public static void assertDeclaredMethodWithReturnType(final String className, final String methodName, final Class<?>[] parametersTypes, final Class<?> returnType, final String message) {
        try {
            final Class<?> testedClass = Class.forName(className);
            final Method m = testedClass.getMethod(methodName, parametersTypes);

            final Object expected = returnType;
            final Object actual = m.getReturnType();

            assertEquals(expected, actual, "wrong return type");
        } catch (final ClassNotFoundException cause) {
            fail("Could not found " + className, cause);
        } catch (final NoSuchMethodException cause) {
            fail(cause);
        }
    }


    private static Class<?> getClassFromParameterName(final String parameterClassName) {
        try {
            return ReflectionAssertions.forName(parameterClassName);
        } catch (final ClassNotFoundException cause) {
            fail("Could not found the expected parameter class " + parameterClassName, cause);
        }
        return null;
    }


    public static void assertDeclaredConstructor(final String className, final String[] parametersTypesNames, final String message) {
        final Class<?>[] parametersTypes = Arrays.stream(parametersTypesNames).map(ReflectionAssertions::getClassFromParameterName).toArray(Class<?>[]::new);
        assertDeclaredConstructor(className, parametersTypes, message);
    }


    public static void assertDeclaredConstructor(final String className, final Class<?>[] parametersTypes, final String message) {
        try {
            final Class<?> testedClass = Class.forName(className);
            final Constructor<?> c = testedClass.getConstructor(parametersTypes);
        } catch (final ClassNotFoundException cause) {
            fail(cause);
        } catch (final NoSuchMethodException cause) {
            fail(cause);
        }
    }


    private static Class<?> getClassFromFieldTypeName(final String fieldClassName) {
        try {
            return ReflectionAssertions.forName(fieldClassName);
        } catch (final ClassNotFoundException cause) {
            fail("Could not found the expected field class " + fieldClassName, cause);
        }
        return null;
    }


    public static void assertDeclaredField(final String className, final String fieldName, final String fieldTypeName, final String message) {
        final Class<?> fieldType = getClassFromFieldTypeName(fieldTypeName);
        assertDeclaredField(className, fieldName, fieldType, message);
    }


    public static void assertDeclaredField(final String className, final String fieldName, final Class<?> fieldType, final String message) {
        try {
            final Class<?> testedClass = Class.forName(className);
            final Field f = testedClass.getDeclaredField(fieldName);
            assertEquals(f.getType(), fieldType);
        } catch (final ClassNotFoundException cause) {
            fail("Could not found " + className, cause);
        } catch (final NoSuchFieldException cause) {
            fail(cause);
        }
    }


    private static final Map<String, Class<?>> primitiveTypeNameMap = new HashMap<>(8);

    static {
        primitiveTypeNameMap.put("boolean", boolean.class);
        primitiveTypeNameMap.put("byte", byte.class);
        primitiveTypeNameMap.put("char", char.class);
        primitiveTypeNameMap.put("double", double.class);
        primitiveTypeNameMap.put("float", float.class);
        primitiveTypeNameMap.put("int", int.class);
        primitiveTypeNameMap.put("long", long.class);
        primitiveTypeNameMap.put("short", short.class);
        primitiveTypeNameMap.put("void", void.class);
    }

    private static Class<?> resolvePrimitiveClassName(final String name) {
        return primitiveTypeNameMap.get(name);
    }


    public static Class<?> forName(final String name) throws ClassNotFoundException {
        final Class<?> primitiveType = resolvePrimitiveClassName(name);
        if (primitiveType != null) {
            return primitiveType;
        }
        return Class.forName(name);
    }

}
