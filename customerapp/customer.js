var myCustomerApp = angular.module('myApp.customer', ['ui.router']);
myCustomerApp.config(function($stateProvider) {
    $stateProvider.state('customer', {
            url:'/customer/:accountId/:accountName',
            views: {
                'main': {
                    templateUrl:'customer/customer.tpl.html',
                    controller: 'CustomerCtrl'
                }
            },
            resolve: {
               
            },
            data : { pageTitle : "Customers" }
    });
});

myCustomerApp.controller("CustomerCtrl", function($scope, $http, $stateParams, $resource, $timeout) {
   console.log("Logging Account id" + $stateParams.accountId + "Name" + $stateParams.accountName);
   $scope.customers ={};
   $scope.accountName = $stateParams.accountName;
   
   $scope.reload = function () {
    $http.get("http://localhost:8080/basic-web-app-0.0.1-SNAPSHOT/rest/accounts/getCustomers/"+$stateParams.accountId)
    .success(function(result) {
       $scope.customers = result;
       $scope.editingData = {};
       console.log(JSON.stringify($scope.customers));
       /*Modify and update the individual rows in the table*/
       for (var i = 0, length = $scope.customers.length; i < length; i++) {
         $scope.editingData[$scope.customers[i].id] = false;
       }
    }).error(function(data,status) {
      $scope.customers ={};
      console.log("In the get method" + data + "d" + status);
    });
    
    $timeout(function(){
      $scope.reload();
    },30000)
  };

    $scope.modify = function(customer){
      $scope.editingData[customer.customer_id] = true;
    };

    $scope.update = function(customer){
      /*Update in the controller*/
      var Customer = $resource("/basic-web-app-0.0.1-SNAPSHOT/rest/accounts/updateCustomer/"+$stateParams.accountId);
      Customer.save({}, customer);
      $scope.editingData[customer.customer_id] = false;
    };
   
    $scope.delete = function(customer) {
      var Customer = $resource("/basic-web-app-0.0.1-SNAPSHOT/rest/accounts/deleteCustomer");
      Customer.save({}, customer);
      $scope.reload();
    };

    $scope.addcustomer = function() {
      console.log("In the add customer function");
      console.log($scope.customer);
      var accountId = $stateParams.accountId;
      var Customer = $resource("/basic-web-app-0.0.1-SNAPSHOT/rest/accounts/createCustomer/"+$stateParams.accountId);
      Customer.save({}, $scope.customer);
      $scope.reload();
      $scope.customer = null;
      
    };
    
    $scope.reload();
});