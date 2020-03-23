package lukyanov.task3;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class CustomClassLoader extends ClassLoader {

    private String classPath;

    public CustomClassLoader(String classPath) {
        super();
        this.classPath = classPath;
    }

    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            //Get byte code from file and load class to runtime
            byte b[] = fetchClassFromFS(classPath + className + ".class");
            return defineClass(className, b, 0, b.length);
        } catch (FileNotFoundException e) {
            log.error("File wasn't found: " + classPath + className + ".class");
            return super.findClass(className);
        } catch (IOException e) {
            log.error(e.getMessage());
            return super.findClass(className);
        }

    }

    private byte[] fetchClassFromFS(String path) throws IOException {
        InputStream is = new FileInputStream(new File(path));

        long length = new File(path).length();

        if (length > Integer.MAX_VALUE) {
            log.error("File is too large!");
            throw new IOException("File is too large!");
        }

        // Byte array to hold the data
        byte[] bytes = new byte[(int) length];

        // Read all bytes
        int offset = 0;
        int numRead;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            log.error("Could not completely read file " + path);
            throw new IOException("Could not completely read file " + path);
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
    }
}