package com.javarush.task.task36.task3606;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/

public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");

        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File dir = new File(packageName);
        ClassLoader classLoader = Solution.class.getClassLoader();
        for (String fileName : dir.list()) {
            if (fileName.endsWith(".class")) {
                String className = packageName.replaceAll("[/\\\\]", ".").substring(packageName.lastIndexOf("ru/")) + "." + fileName.substring(0, fileName.length() - 6);
                Class<?> aClass = classLoader.loadClass(className);
                hiddenClasses.add(aClass);
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        String lowerKey = key.toLowerCase();
        try {
            Class resultClass = null;
            for (Class aClass : hiddenClasses) {
                if (aClass.getSimpleName().toLowerCase().startsWith(lowerKey)) {
                    resultClass = aClass;
                    Constructor<?> declaredConstructor = resultClass.getDeclaredConstructor();
                    declaredConstructor.setAccessible(true);
                    return (HiddenClass) declaredConstructor.newInstance();
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
/*
    public void scanFileSystem() throws ClassNotFoundException {
        File f = Paths.get(packageName.substring(1)).toFile();
        MyLoader loader = new MyLoader(packageName, Solution.class.getClassLoader());
        for (String file : f.list()) {
            hiddenClasses.add(loader.loadClass(file.split(".class")[0]));
        }

    }


    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class aClass : hiddenClasses) {
            if (aClass.getSimpleName().toLowerCase().contains(key.toLowerCase())) {
                try {
                    Constructor constructor = aClass.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    return (HiddenClass) constructor.newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                         NoSuchMethodException e) {
                }
            }
        }
        return null;
    }
}

class MyLoader extends ClassLoader {
    private String pathtobin;

    public MyLoader(String pathtobin, ClassLoader parent) {
        super(parent);
        this.pathtobin = pathtobin;
    }

    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            byte[] b = fetchClassFromFS(pathtobin.substring(1) + "/" + className + ".class");
            return defineClass(null, b, 0, b.length);
        } catch (FileNotFoundException ex) {
            return super.findClass(className);
        } catch (IOException ex) {
            return super.findClass(className);
        }

    }

    private byte[] fetchClassFromFS(String path) throws FileNotFoundException, IOException {
        InputStream is = Files.newInputStream(new File(path).toPath());
        long length = new File(path).length();
        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + path);
        }

        is.close();
        return bytes;
    }
}

 */
