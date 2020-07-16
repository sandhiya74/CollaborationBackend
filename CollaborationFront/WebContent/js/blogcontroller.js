/**
 * 
 */

angular
		.module('frontApp')
		.controller(
				'bcontrol',
				function($scope, $location, $http) {
					var mydata = this;
					mydata.blog = {
						blog_Content : "",
						blog_Title : ""
					};
					mydata.createUser = createUser;
					mydata.approveBlog = approveBlog;
					getUsers();// this s to call my function call statement.
					function createUser() {
						$http
								.post(
										'http://localhost:8088/CollaborationMiddleware/blog/addblog',
										mydata.blog).then(function(response) {
									alert("Added Successful");
									$location.path("/addblog");
								}, function(errresponse) {
									alert(" Not Successful");
								});
					}
					function getUsers() {
						$http
								.get(
										'http://localhost:8088/CollaborationMiddleware/blog/adminapproval')
								.then(function(response) {
									mydata.customers = null;

								}, function(errresponse) {
									mydata.customers = errresponse.data;
									console.log(mydata.customers);
								})

					}
					function approveBlog(blogid) {
						$http
								.get(
										'http://localhost:8088/CollaborationMiddleware/blog/updatestatus?blogid=blogid')
								.then(function(response) {
									alert("Status updated");
								}, function(errresponse) {
									alert("Status not updated" );
								});

					}

				});
