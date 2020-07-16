/**
 * 
 */

angular
		.module('frontApp')
		.controller(
				'rcontrol',
				function($scope,$location,$http) {
					var mydata = this;
					mydata.customer = {
						cust_Name : "",
						cust_Email : "",
						cust_Phno:"",
						cust_Password : "",
						cust_Role : ""
					};
					mydata.createUser = createUser;
				
					function createUser() {
						$http
								.post(
										'http://localhost:8088/CollaborationMiddleware/customer',
										mydata.customer)
								.then(function(response) {
									alert("Registration Successful");
									$location.path("/login");
								}, function(errresponse) {
									alert("Registration not Successful");
								});
					}
					
				})
