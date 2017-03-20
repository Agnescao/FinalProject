package dao;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;





import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import dao.CategoryDAO;
import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class createProductServlet
 */
@WebServlet("/createProductServlet")
//@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class createProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  
    private static final String UPLOAD_DIRECTORY = "FinalProject/FinalProjectSportingGoods/WebContent/imageproduct";
    private static final int THRESHOLD_SIZE     = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // checks if the request actually contains upload file
    	String filePath=null;
        if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter writer = response.getWriter();
            writer.println("Request does not contain upload data");
            writer.flush();
            return;
        }   
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(THRESHOLD_SIZE);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
         
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);	         
       
        String disk="F:";
        String uploadPath=disk+ "/" + UPLOAD_DIRECTORY;
        System.out.println(uploadPath);
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }	         
        try {
        	 // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);
      	
            // Process the uploaded file items
            Iterator i = fileItems.iterator();
             
            // iterates over form's fields
            while (i.hasNext()) {
                FileItem item = (FileItem) i.next();
                // processes only fields that are not form fields
                if (!item.isFormField()) {
                    String fileName = new File(item.getName()).getName();
                    
                    System.out.println(fileName);
                   // filePath = uploadPath + File.separator + fileName;
                    filePath = uploadPath + "/" + fileName;
                    File storeFile = new File(filePath);  
                    // saves the file on disk
                    item.write(storeFile);
                   
                }
            }  } catch (Exception ex) {
            	 System.out.println(ex);
	        }
	      

		
		String name = request.getParameter("name") ;
		System.out.println(name);
		Double price=0.00;
		try {
			 
			String priceString=request.getParameter("price");
			
			 price = Double.parseDouble(priceString ) ;
			System.out.println(price);
			}
		catch(NumberFormatException e) {
		    e.printStackTrace();
		  
		}
		
		String description= request.getParameter("description") ;
		String categoryName = request.getParameter("categoryName");
		System.out.println(categoryName);
		int cid=CategoryDAO.instance.getId(categoryName);
		System.out.println(cid);
		//upload image part
				InputStream inputStream = null; // input stream of the upload file
		        
		        // obtains the upload file part in this multipart request
		        Part filePart = request.getPart("images");
		        if (filePart != null) {
		            // prints out some information for debugging
		            System.out.println(filePart.getName());
		            System.out.println(filePart.getSize());
		            System.out.println(filePart.getContentType());
		             
		            // obtains input stream of the upload file
		            inputStream = filePart.getInputStream();
		        }
		Product product=new Product(name,price,description,cid,inputStream);
		ProductDAO.instance.uploadProduct(product);
		
        
        
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
