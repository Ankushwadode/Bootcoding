package org.example;

import java.io.File;

public class Directory_read {

    public void listAllFolder(String path){
        File file = new File(path);

        if(file.isDirectory()){
            String[] list = file.list();
            File[] files = file.listFiles();
            for (File f:files) {
                if (!f.getName().startsWith(".")){
                    if (f.isDirectory()){
                        listAllFolder(f.getPath());
                    }else {
                        print(f);
                    }
                }
            }
        }else {
            print(file);
        }
    }

    private void print(File file){
        System.out.println(file.getPath() + "/" + file.getName());
    }

}
