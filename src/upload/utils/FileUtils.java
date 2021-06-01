package upload.utils;

import java.io.File;

public class FileUtils {

	public static void delFolder(String folderPath){
		try{
			delAllFile(folderPath);
			String filePath=folderPath;
			filePath=filePath.toString();
			java.io.File myFilePath=new java.io.File(filePath);
			myFilePath.delete();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static boolean delAllFile(String path) {
		// TODO Auto-generated method stub
		boolean flag=false;
		File file=new File(path);
		if(!file.exists()){
			return flag;
		}
		if(!file.isDirectory()){
			return flag;
		}
		String[] tempList=file.list();
		File temp=null;
		for(int i =0;i<tempList.length;i++){
			if(path.endsWith(File.separator)){
				temp=new File(path+tempList[i]);
				
			}else{
				temp=new File(path+File.separator+tempList[i]);
			}
			if(temp.isFile()){
				temp.delete();
			}
			if(temp.isDirectory()){
				delAllFile(path+"/"+tempList[i]);
				delFolder(path+"/"+tempList[i]);
				flag=true;
			}
		}
		
		
		return flag;
	}
}
