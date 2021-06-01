package upload.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import upload.bean.FileUploadBean;
import upload.db.UploadFileDao;
import upload.excption.InvalidExtNameException;
import upload.utils.FileUploadAppProperties;
import upload.utils.FileUtils;



/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String FILE_PATH ="/mp3";
	
	private static final String TEMP_DIR="d:\\tempDirectory";
	
	private UploadFileDao dao=new UploadFileDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String path=null;
		ServletFileUpload upload = getServletFileUpload();
	    
	    try{
	    	
	    	Map<String,FileItem> uploadFiles=new HashMap<String,FileItem>();
	    	
	    	List<FileItem> items=upload.parseRequest(request);
	    	
	    	List<FileUploadBean> beans=buildFileUploadBean(items,uploadFiles);
	    	
	    	vaidateExtName(beans);
	    	
	    	upload(uploadFiles);
	    	
	    	saveBeans(beans);
	    	
	    	FileUtils.delAllFile(TEMP_DIR);
	    	
	    	path="/app/success.jsp";
	    }catch(Exception e){
	    	e.printStackTrace();
	    	path="/app/error.jsp";
	    	request.setAttribute("message",e.getMessage());
	    	
	    }
	    request.getRequestDispatcher(path).forward(request, response);
	    }

	private void saveBeans(List<FileUploadBean> beans) {
		// TODO Auto-generated method stub

		dao.save(beans);
		
	}

	private void upload(Map<String, FileItem> uploadFiles) throws IOException {
		// TODO Auto-generated method stub
		
		for(Map.Entry<String,FileItem> uploadFile: uploadFiles.entrySet()){
			String filePath=uploadFile.getKey();
			FileItem item=uploadFile.getValue();
			upload(filePath,item.getInputStream());
		}
		
	
		
	}

	private void upload(String filePath, InputStream inputStream) throws IOException {
		// TODO Auto-generated method stub
		OutputStream out=new FileOutputStream(filePath);
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=inputStream.read(buffer))!=-1){
			out.write(buffer,0,len);
		}
		inputStream.close();
		out.close();
	
	}

	private void vaidateExtName(List<FileUploadBean> beans) {
		// TODO Auto-generated method stub
		String exts =FileUploadAppProperties.getInstance().getProperty("exts");
		List<String> extList=Arrays.asList(exts.split(","));
		for(FileUploadBean bean: beans){
			String fileName=bean.getFileName();
			String extName=fileName.substring(fileName.lastIndexOf(".")+1);
			if(!extList.contains(extName)){
				throw new InvalidExtNameException(fileName+"文件拓展名不合法");
			}
		}
	}

	private List<FileUploadBean> buildFileUploadBean(List<FileItem> items, Map<String, FileItem> uploadFiles) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		List<FileUploadBean> beans=new ArrayList<>();
		
		Map<String,String> descs=new HashMap<>();
		for(int i=0;i<items.size();i++){
			FileItem item=items.get(i);
			
			if(item.isFormField()){
				String fieldName=item.getFieldName();
				String desc = item.getString();
				descs.put(fieldName, desc);
			}
		}
		for(int i=0;i<items.size();i++){
			FileItem item=items.get(i);
			FileUploadBean bean=null;
			
			if(!item.isFormField()){
				String fieldName=item.getFieldName();
			String descName="desc"+fieldName.substring(fieldName.length()-1);
			
			String fileName=item.getName();
			
			int index=fileName.lastIndexOf("\\");
			if(index!=-1) {
				fileName=fileName.substring(index+1);
				
			}
		
			String desc=descs.get(descName);
			String filePath=getFilePath(fileName);
		    
			bean=new FileUploadBean(fileName,filePath,desc);
			System.out.println(fileName);
			System.out.println(filePath);
			System.out.println(desc);
			System.out.println(fieldName);
		    beans.add(bean);
		    
		    uploadFiles.put(filePath, item);
			
			}
		}
		
		return beans;
		
	}

	private String getFilePath(String fileName) {
		// TODO Auto-generated method stub
		
		String extName=fileName.substring(fileName.lastIndexOf("."));
		
		Random random=new Random();
		int randomNumber=random.nextInt(100000);
		
		String filePath=getServletContext().getRealPath(FILE_PATH)+"\\"+System.currentTimeMillis()+randomNumber+extName;
		
		return filePath;
	}

	private ServletFileUpload getServletFileUpload() {
		String exts=FileUploadAppProperties.getInstance().getProperty("exts");
		String fileMaxSize=FileUploadAppProperties.getInstance().getProperty("file.max.size");
		String totalFileMaxSize=FileUploadAppProperties.getInstance().getProperty("total.file.max.size");
		
		DiskFileItemFactory factory=new DiskFileItemFactory();
	    factory.setSizeThreshold(1024*500);
	    File tempDirectory=new File(TEMP_DIR);
	    factory.setRepository(tempDirectory);
	    ServletFileUpload upload=new ServletFileUpload(factory);
	    upload.setSizeMax(Integer.parseInt(totalFileMaxSize));
	    upload.setFileSizeMax(Integer.parseInt(fileMaxSize));
		return upload;
	}

}
