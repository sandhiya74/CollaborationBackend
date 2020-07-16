/**
 * 
 */

angular
		.module('frontApp')
		.controller(
				'fcontrol',
				function($scope,$location,$http) {
					var mydata = this;
					mydata.forum= {
						forum_Title:""
					};
					mydata.createUser = createUser;
					getUsers();
					function createUser() {
						$http
								.post(
										'http://localhost:8088/CollaborationMiddleware/forum/addforum',
										mydata.forum)
								.then(function(response) {
									alert("Added Successful");
									$location.path("/forum");
								}, function(errresponse) {
									alert(" Not Successful");
								});
					}
					function getUsers()
					{
						$http
						.get('http://localhost:8088/CollaborationMiddleware/forum/allforum')
								.then(function(response){
									mydata.customers=null;
									
								},function(errresponse){
									mydata.customers=errresponse.data;
									console.log(mydata.customers);
								})
								
					}

				})