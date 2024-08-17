package api.endpoints;
//maintain only the URLs

/*
 Swagger URI >> https://petstore.swagger.io >> acutual root
 Create user (Post) : https://petstore.swagger.io/v2/user >> after / those are entpoints or base URL and endpoint
 Create user (Get) : https://petstore.swagger.io/v2/user/{username}
 Create user (Put) : https://petstore.swagger.io/v2/user/{username}
 Create user (Delete) : https://petstore.swagger.io/v2/user/{username}
 
 https://petstore.swagger.io/v2/user >> base URL (common in multiple request)
 /user/{username} >> endpoints
 */
public class Routes {
	
	public static String base_url ="https://petstore.swagger.io/v2"; //public meand this should be accesible throughout and static we can use the directly by class name  witohut using any onject

	//User Module
	public static String post_url= base_url+"/user";  // create a user
	public static String get_url= base_url+"/user/{username}";
	public static String update_url= base_url+"/user/{username}";
	public static String delete_url= base_url+"/user/{username}";
	
	//Store module
	// Here you will create Store module URL's
	
	
	//Pet module
		// Here you will create Pet module URL's
}
