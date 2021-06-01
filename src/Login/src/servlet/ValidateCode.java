package Login.src.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * Servlet implementation class ValidateCode
 */
public class ValidateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final char[] CHARS={'2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','J','K','L','M','N','O','P','Q','R','S','T','V','U','W','X','Y','Z'};
	public static Random random=new Random();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String buffer=getRandomString();
		
		int width=100;
		int height=30;
		Color bgColor=getRandomColor();
		Color frontColor=getReverseColor(bgColor);
		BufferedImage bi=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g=bi.createGraphics();
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		g.setColor(bgColor);
		g.fillRect(0,0,width,height);
		g.setColor(frontColor);
		g.drawString(buffer,18,20);
	for(int i=0,n=random.nextInt(100);i<n;++i){
g.drawRect(random.nextInt(width),random.nextInt(height),1,1);
	}
	ServletOutputStream identifyPic=response.getOutputStream();
	JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(identifyPic);
	encoder.encode(bi);
	identifyPic.flush();
	request.getSession().setAttribute("validate_code",buffer);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static String getRandomString(){
		StringBuilder buffer=new StringBuilder();
		for(int i=0;i<4;++i){
	buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
		}
		public static Color getRandomColor(){
	return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
	
		}
		public static Color getReverseColor(Color c){
		return new Color(255-c.getRed(),255-c.getGreen(),255-c.getBlue());
		}
		
}
