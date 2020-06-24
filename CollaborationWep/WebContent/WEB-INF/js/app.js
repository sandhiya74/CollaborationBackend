/**
 * 
 */

var myApp=anglar.smodule("frontApp",["ngRoute"]);
myApp.config(function($routeProvider)
		{
	$routeProvider.when("/",{templateUrl:"home.html"})
	.when("/aboutus",{templateUrl:"aboutus.html"})
	.when("/contactus",{templateUrl:"contactus.html"});
		});