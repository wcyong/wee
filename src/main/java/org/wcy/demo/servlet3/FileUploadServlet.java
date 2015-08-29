package org.wcy.demo.servlet3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 文件上传
 * 
 * 在Servlet3.0中上传文件变得非常简单。我们只需通过request的getPart(String partName)获取到上传的对应
 * 文件对应的Part或者通过getParts()方法获取到所有上传文件对应的Part。之后我们就可以通过part的write(String fileName)方法
 * 把对应文件写入到磁盘。或者通过part的getInputStream()方法获取文件对应的输入流，然后再对该输入流进行操作。
 * 要使用request的getPart()或getParts()方法对上传的文件进行操作的话，有两个要注意的地方。首先，
 * 用于上传文件的form表单的enctype必须为multipart/form-data；其次，对于使用注解声明的Servlet，我们必须在其对应类
 * 上使用@MultipartConfig进行标注，而对于在web.xml文件进行配置的Servlet我们也需要指定其multipart-config属性，如：
 *    <servlet>
 *    	<servlet-name>xxx</servlet-name>
 *    	<servlet-class>xxx.xxx</servlet-class>
 *    	<multipart-config></multipart-config>
 *    </servlet>
 *    <servlet-mapping>
 *    	<servlet-name>xxx</servlet-name>
 *    	<url-pattern>/servlet/xxx</url-pattern>
 *    </servlet-mapping>
 *    
 * 不管是基于注解的@MultipartConfig，还是基于web.xml文件配置的multipart-config，我们都可以给它们设置几个属性。
 * >> file-size-threshold：数字类型，当文件大小超过指定的大小后将写入到硬盘上。默认是0，表示所有大小的文件上传后都会
 * 		作为一个临时文件写入到硬盘上。
 * >> location：指定上传文件存放的目录。当我们指定了location后，我们在调用Part的write(String fileName)方法把
 * 		文件写入到硬盘的时候可以，文件名称可以不用带路径，但是如果fileName带了绝对路径，那将以fileName所带路径为准把文件写入磁盘。
 * >> max-file-size：数值类型，表示单个文件的最大大小。默认为-1，表示不限制。当有单个文件的大小超过了max-file-size指定的
 * 值时将抛出IllegalStateException异常。
 * >> max-request-size：数值类型，表示一次上传文件的最大大小。默认为-1，表示不限制。当上传时所有文件的大小超
 * 过了max-request-size时也将抛出IllegalStateException异常。
 * 上面的属性是针对于web.xml中配置Servlet而言的，其中的每一个属性都对应了multipart-config元素下的一个子元素。
 * 对于基于注解配置的Servlet而言，@MultipartConfig的属性是类型的，我们只需把上述对应属性中间的杠去掉，
 * 然后把对应字母大写即可，如maxFileSize。
 * 
 * 对于Servlet3.0中的文件上传还有一个需要注意的地方，当我们把Part写入到硬盘以后，我们原先的Part（也就是之前的临时文件）可能已经删了，
 * 这个时候如果我们再次去访问Part的内容的话，那它就是空的，系统会抛出异常说找不到对应的文件
 * 
 * @author wcyong
 *
 * date    2015年8月29日
 */

@WebServlet(value="/servlet/upload")
//@MultipartConfig(location="E:\\hadoop\\wee\\src\\main\\webapp\\upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain;charset=utf-8");
		Part part = req.getPart("upload");
		//Servlet3没有提供直接获取文件名的方法,需要从请求头中解析出来
		String disposition = part.getHeader("content-disposition");
		//form-data; name="upload"; filename="aaaaa.zip"
		System.out.println(disposition);
		//文件名
		String fileName = disposition.substring(disposition.lastIndexOf("=")+2, disposition.length()-1);
		//文件类型
		String fileType = part.getContentType();
		//文件大小
		long fileSize = part.getSize();
		
		System.out.println("fileName:"+fileName);
		System.out.println("fileType:"+fileType);
		System.out.println("fileSize:"+fileSize);
		
		//文件上传路径
		String uploadPath = getServletContext().getRealPath("/upload");
		System.out.println("uploadPath:"+uploadPath);
		
		/*InputStream is = part.getInputStream();
		FileOutputStream fos = new FileOutputStream(uploadPath + File.separator + fileName);
		byte[] buf = new byte[4096];
		int len = 0;
		while((len=is.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
		fos.flush();
		fos.close();
		fos.close();*/
		
		//把文件写到指定路径
		//TODO
		//在没有指定location时，文件未上传到指定目录下,该处测试未通过
		part.write(uploadPath + File.separator + fileName);
		
		//如果@MultipartConfig(location="E:\\hadoop\\wee\\src\\main\\webapp\\upload")增加location时可以成功
		//part.write(fileName);
		
		PrintWriter out = resp.getWriter();
		out.println("上传成功");
		out.flush();
		out.close();
		
	}

}
