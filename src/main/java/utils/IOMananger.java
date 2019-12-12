package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOMananger {
    public static void saveToFile(String fileDir,String FileName,String content){
        File destDir=new File(fileDir);
        if(!destDir.exists()){
            destDir.mkdirs();
        }
        String Path=fileDir+"/"+FileName+".txt";
        BufferedWriter bw=null;
        try{
            FileOutputStream fo=new FileOutputStream(Path,true);
            OutputStreamWriter ow=new OutputStreamWriter(fo);
            bw=new BufferedWriter(ow);
            bw.append(content);
            bw.newLine();
            bw.flush();
            bw.close();
        }catch(Exception e){
            System.out.println("写入数据失败");
        }finally{
            try{
                bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    public static List<String>readTxtFile(String filePath) throws FileNotFoundException{
        List<String> txt=new ArrayList<String>();
        Scanner in =new Scanner(new File(filePath));
        while(in.hasNext()){
            String str=in.nextLine();
            if(!str.isEmpty()){
                txt.add(str.toString());
            }
            in.close();
            return txt;
        }
        in.close();
        return txt;
    }
    public static void deleteFile(File Path){
        if(Path.isDirectory()){
            File[] files=Path.listFiles();
            for(File file:files){
                deleteFile(file);
            }
        }else{
            Path.delete();
        }
    }
    public static void deleteFile(String[] Paths){
        for(String path:Paths){
            try{
                File file=new File(path);
                if(file.exists()){
                    file.delete();
                }
            }catch(Exception e){
                System.out.println("删除文件失败，文件路径："+path);
            }
        }
    }

}
