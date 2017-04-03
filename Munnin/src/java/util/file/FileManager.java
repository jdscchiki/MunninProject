/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.Part;

/**
 *
 * @author Juan David Segura
 */
public class FileManager {

    private final static String SAVE_FOLDER = "C:"+File.separator+"MunninRepository";

    public static boolean saveFile(Part file) {
        return saveFile(file, SAVE_FOLDER);
    }

    public static boolean saveFile(Part file, String savePath) {
        boolean result = false;

        InputStream input = null;
        OutputStream output = null;
        try {
            input = file.getInputStream();

            if (checkFolder(savePath)) {
                output = new FileOutputStream(new File(savePath + File.separator + file.getSubmittedFileName()));
            }

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = input.read(bytes)) != -1) {
                output.write(bytes, 0, read);
            }
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (output != null) {
                try {
                    output.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return result;
    }

    public static boolean checkFolder(String path) {
        boolean result = false;

        File folder = new File(path);
        if (folder.exists()) {
            result = true;
        } else {
            if (folder.mkdirs()) {
                result = true;
            }
        }

        return result;
    }

    public static boolean saveFileMunninServer(Part file, String savePath) {
        return saveFile(file, SAVE_FOLDER + File.separator + savePath);
    }
}
