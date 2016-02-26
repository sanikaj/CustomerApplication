angular.module('myApp.account', ['ui.router','satellizer'])
.config(function($stateProvider) {
    $stateProvider.state('login', {
        url:'/login',
        views: {
            'main': {
                templateUrl:'account/login.tpl.html',
                controller: 'LoginCtrl'
            }
        },
        data : { pageTitle : "Login" }
    })
    .state('register', {
            url:'/register',
            views: {
                'main': {
                    templateUrl:'account/register.tpl.html',
                    controller : 'RegisterCtrl'
                   
                }
            },
            data : { pageTitle : "Registration" }
            }
    );
})

.factory('accountService', function($resource) {
    var service = {};
    service.register = function(account, success, failure) {
        var Account = $resource("/basic-web-app-0.0.1-SNAPSHOT/rest/accounts/register");
        Account.save({}, account, success, failure);
    };
    
    return service;
})


.controller("LoginCtrl", function($scope, $state, $auth) {
    $scope.login = function() {
            console.log($scope.user + "In the login function");
            $auth.login($scope.user) 
            .then(function(resp) {
                    /*toastr.success('You have successfully signed in!');*/
                   
                        var obj = JSON.stringify(resp);
                        var id= resp['data'].id;
                        alert('You have successfully logged in!' +  resp['data'].id + " Email" +  resp['data'].email);
                        alert("Object is" + obj);
                        $auth.setToken(obj);
                        console.log("Authentication Token" + $auth.getToken());                
                        alert("Authentication Token" + $auth.getToken());
                    $state.go("customer",{accountId: id,accountName: resp['data'].email});
            })
            .catch(function(error) {
                    /*toastr.error(error.data.message, error.status);*/
                    alert("Kindly enter the correct username and password");
            });
              
    };
    
    
    
    /*Authenticate according to the provider*/
    $scope.authenticate = function(provider) {
        $auth.authenticate(provider).success(function(result) {
            $state.go("customer");
        }).error(function(data,status) {
            console.log(data + ' Status ' + status);
        });
    };
})
.controller("RegisterCtrl", function($scope, $state, $auth) {
    /*var user = {
        email: $scope.email,
        password: $scope.password
    };*/
    
    $scope.signup = function() {
      $auth.signup($scope.user)
        .then(function(response) {
          console.log($scope.user);
          /*alert(JSON.stringify(response));*/
          $auth.setToken(JSON.stringify(response));
          alert("Token" + $auth.getToken());
          $state.go("customer");
          /*toastr.info('You have successfully created a new account and have been signed-in');*/
          alert('You have successfully created a new account and have been signed-in');
        })
        .catch(function(response) {
          /*toastr.error(response.data.message);*/
          alert("Error message");
        });
    };
        /*accountService.register($scope.account,
        function(returnedData) {
            /*sessionService.login($scope.account).then(function() {
                $state.go("customer");
            });*/
        /*},
        function() {
            alert("Error registering user");
        });*/

});