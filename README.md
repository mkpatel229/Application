# Spring-boot-Shopping_cart_Application

*  **In this Spring Boot Application I have implemented three themes as mentioned in 'Microservices_Project.xlsx' file.**
    
    1) Product
    2) Account
    3) Authentication & Authorization
    
*  **Technologies/dependencies used in this project are:** 
Spring boot web, Spring boot security, JPA, Postgre sql server, JWT

* **Authentication** : 
    *   I'm using JWT token based authentication and authorization for this application.
    *   when user loges in whith /login api JWT token will be generated.
    *   To access protected url user need to pass this token in header as bearer token along with request.
    *   This token also contain expiration time and user Role information.
    *   Role is used for authorization purpose in this application.
    
* **Following are REST end-points which are not protected with JWT:**
 
    1) Home page : GET http://localhost:5000/Welcome
    
    2) Get list of products : GET http://localhost:5000/product
    
    3) Get product details by id : GET http://localhost:5000/{prodId}/details
    
    4) Seach product by name : GET http://localhost:5000/searchproduct/{name}
    
    5) Get today's top deals : GET http://localhost:5000/deals
    
    6) User/Customer sign up : POST http://localhost:5000/signup
        
        Sample PayLoad :   
        
                {
                    "name" : "Mitesh",
                    "gender" : "Male",
                    "dob": "1995-09-22",
                    "user" : {
                        "userId" : "mkpatel221",
                        "password" : "MKP1995"
                    } 	
                  }
     
     7) User/Customer Login : POST http://localhost:5000/login
     
        Sample PayLoad :   
            
                    {
                        "username":"Admin",
                        "password" : "admin"
                    }
 
 * **Following are JWT protected REST end-points.**
 
    1) Add product : POST http://localhost:5000/product
        * Only user with 'ADMIN' role is authorize for this url
        
        Sample PayLoad :   
                    
                    {
                        "name" : "One Plus 7t pro",
                        "shortDesc" : "Mobile",
                        "description" : "new in display finger print scanner",
                        "price" : "60000",
                        "category": "Electronics",
                        "discount" : "0",
                        "deliveryCharge" : "50",
                        "seller" : "Green star",
                        "avgRating" : 4.2
                    }
                    
     2) Update product : PUT http://localhost:5000/product/{prodid}            
           * Only user with 'ADMIN' role is authorize for this url
             
         Sample PayLoad :   
                     
                     {
                         "name" : "One Plus 7t pro",
                         "shortDesc" : "Mobile",
                         "description" : "new in display finger print scanner",
                         "price" : "60000",
                         "category": "Electronics",
                         "discount" : "0",
                         "deliveryCharge" : "50",
                         "seller" : "Green star",
                         "avgRating" : 4.2
                     }        
        
      3) Update user detail : PUT http://localhost:5000/{customerId}/update                
           * Any Role can access
                   
           Sample PayLoad :   
                       
               {
                    "name" : "Mitesh k Patel",
                    "password" : "mitesh@1995"
               }
               
* **NOTE** :
    *   Credential for Admin
        * User name : Admin
        * Password : admin
        
     *   Credential for User
         * User name : User
         * Password : user
     
     * To configure your own Postgre sql database change following details in 'src\main\resources\application.properties' file
        
        * spring.datasource.url=jdbc:postgresql://localhost/ShoppingCart
        * spring.datasource.username=postgres
        * spring.datasource.password=mitesh1995