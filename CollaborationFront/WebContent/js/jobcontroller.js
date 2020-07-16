/**
 * 
 */

angular
		.module('frontApp')
		.controller(
				'jcontrol',
				function($scope,$location,$http) {
					var mydata = this;
					mydata.job= {
						job_Title : "",
						job_Description:"",
						salary:"",
						skillset:"",
						vacancy:0,
						last_Date:""
					};
					mydata.createUser = createUser;
					mydata.approveJob = approveJob;
					getUsers();
					function createUser() {
						alert(mydata.job.vacancy);
						$http
								.post(
										'http://localhost:8088/CollaborationMiddleware/job/addjob',
										mydata.job)
								.then(function(response) {
									alert("Added Successful");
									$location.path("/job");
								}, function(errresponse) {
									alert(" Not Successful");
								})
					}

				
				function getUsers()
					{
						$http
						.get('http://localhost:8088/CollaborationMiddleware//job/adminapproval')
								.then(function(response){
									mydata.customers=null;
									
								},function(errresponse){
									mydata.customers=errresponse.data;
									console.log(mydata.customers);
								})
								
					}

				function approveJob(job_Id) {
					$http
							.get(
									'http://localhost:8088/CollaborationMiddleware/job/updatejobstatus?job_Id=job_Id')
							.then(function(response) {
								alert("Jobstatus updated");
							}, function(errresponse) {
								alert("Jobstatus not updated" );
							});

				}
				});
