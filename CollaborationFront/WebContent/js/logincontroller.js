/**
 * 
 */

angular
		.module('frontApp')
		.controller(
				'lcontrol',
				function($scope,$location,$http,$rootScope) {
					var mydata = this;
					mydata.customer = {
						cust_Email : "",
						cust_Password : ""
					};
					mydata.onlineuser = {
							cust_Name : "",
							cust_Email : "",
							cust_Phno:"",
							cust_Password : "",
							cust_Role : ""
						};
					mydata.loginUser = loginUser;
				
					function loginUser() {
						$http
								.post(
										'http://localhost:8088/CollaborationMiddleware/login',
										mydata.customer)
								.then(function(response) {
									alert("LoginSuccessful");
									mydata.onlineuser=response.data;
									$rootScope.loggeduser=mydata.onlineuser.cust_Role;
									//$cookieStore.put('loggeduser',$rootScope.loggeduser);
									$rootScope.loggedin=true;
							       // $cookieStore.put('loggedin',$rootScope.loginstatus);
									if(mydata.onlineuser.cust_Role=='Employee'){
										$location.path("/home");
									}
									else if(mydata.onlineuser.cust_Role=='Employer'){
										$location.path("/aboutus");
									} else {
										$location.path("/contactus");
									}
								}, function(errresponse){
									alert("Login not Successful");
								});
					}
				});
