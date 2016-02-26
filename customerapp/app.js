var myApp = angular.module( 'myApp', ['ui.router','ngResource',
   'myApp.account',
   'myApp.customer',
   'satellizer'
]);
	

myApp.config( function myAppConfig ( $stateProvider, $urlRouterProvider, $authProvider) {
  $urlRouterProvider.otherwise( '/account' );
   
  $authProvider.httpInterceptor = function() { return true; },
  $authProvider.withCredentials = true;
  $authProvider.tokenRoot = null;
  $authProvider.cordova = false;
  $authProvider.baseUrl = '/';
  $authProvider.loginUrl = '/basic-web-app-0.0.1-SNAPSHOT/rest/accounts/login';
  $authProvider.signupUrl = '/basic-web-app-0.0.1-SNAPSHOT/rest/accounts/add';
  $authProvider.unlinkUrl = '/auth/unlink/';
  $authProvider.tokenName = 'token';
  $authProvider.tokenPrefix = 'satellizer';
  $authProvider.authHeader = 'Authorization';
  $authProvider.authToken = 'Bearer';
  $authProvider.storageType = 'localStorage'
 

  $authProvider.facebook({
      	clientId: 'Facebook App ID',
      	name: 'facebook',
  		url: '/auth/facebook',
  		authorizationEndpoint: 'https://www.facebook.com/v2.5/dialog/oauth',
  		redirectUri: window.location.origin + '/',
  		requiredUrlParams: ['display', 'scope'],
  		scope: ['email'],
  		scopeDelimiter: ',',
  		display: 'popup',
  		type: '2.0',
  		popupOptions: { width: 580, height: 400 }
   });

   $authProvider.google({
        clientId: 'Google Client ID',
        url: '/auth/google',
  	    authorizationEndpoint: 'https://accounts.google.com/o/oauth2/auth',
        redirectUri: window.location.origin,
        requiredUrlParams: ['scope'],
        optionalUrlParams: ['display'],
        scope: ['profile', 'email'],
        scopePrefix: 'openid',
        scopeDelimiter: ' ',
        display: 'popup',
        type: '2.0',
        popupOptions: { width: 452, height: 633 }
    });

   $authProvider.github({
        clientId: 'GitHub Client ID',
        url: '/auth/github',
        authorizationEndpoint: 'https://github.com/login/oauth/authorize',
        redirectUri: window.location.origin,
        optionalUrlParams: ['scope'],
        scope: ['user:email'],
        scopeDelimiter: ' ',
        type: '2.0',
        popupOptions: { width: 1020, height: 618 }
    });

   $authProvider.linkedin({
      clientId: 'LinkedIn Client ID',
      url: '/auth/linkedin',
      authorizationEndpoint: 'https://www.linkedin.com/uas/oauth2/authorization',
      redirectUri: window.location.origin,
      requiredUrlParams: ['state'],
      scope: ['r_emailaddress'],
      scopeDelimiter: ' ',
      state: 'STATE',
      type: '2.0',
      popupOptions: { width: 527, height: 582 }

    });

   $authProvider.instagram({
      clientId: 'Instagram Client ID',
      name: 'instagram',
      url: '/auth/instagram',
      authorizationEndpoint: 'https://api.instagram.com/oauth/authorize',
      redirectUri: window.location.origin,
      requiredUrlParams: ['scope'],
      scope: ['basic'],
      scopeDelimiter: '+',
      type: '2.0'
    });

    $authProvider.yahoo({
       clientId: 'Yahoo Client ID / Consumer Key',
       url: '/auth/yahoo',
       authorizationEndpoint: 'https://api.login.yahoo.com/oauth2/request_auth',
       redirectUri: window.location.origin,
       scope: [],
       scopeDelimiter: ',',
       type: '2.0',
       popupOptions: { width: 559, height: 519 }
    });

    $authProvider.live({
       clientId: 'Microsoft Client ID',
       url: '/auth/live',
       authorizationEndpoint: 'https://login.live.com/oauth20_authorize.srf',
       redirectUri: window.location.origin,
       requiredUrlParams: ['display', 'scope'],
       scope: ['wl.emails'],
       scopeDelimiter: ' ',
       display: 'popup',
       type: '2.0',
       popupOptions: { width: 500, height: 560 }
    });

    $authProvider.twitch({
      clientId: 'Twitch Client ID',
      url: '/auth/twitch',
      authorizationEndpoint: 'https://api.twitch.tv/kraken/oauth2/authorize',
      redirectUri: window.location.origin,
      requiredUrlParams: ['scope'],
      scope: ['user_read'],
      scopeDelimiter: ' ',
      display: 'popup',
      type: '2.0',
      popupOptions: { width: 500, height: 560 }
    });

    $authProvider.bitbucket({
      clientId: 'Bitbucket Client ID',
      url: '/auth/bitbucket',
      authorizationEndpoint: 'https://bitbucket.org/site/oauth2/authorize',
      redirectUri: window.location.origin + '/',
      optionalUrlParams: ['scope'],
      scope: ['email'],
      scopeDelimiter: ' ',
      type: '2.0',
      popupOptions: { width: 1020, height: 618 }
    });

    $authProvider.oauth2({
      /*name: 'foursquare',
      url: '/auth/foursquare',
      clientId: 'Foursquare Client ID',
      redirectUri: window.location.origin,
      authorizationEndpoint: 'https://foursquare.com/oauth2/authenticate',*/
      name: null,
      url: null,
      clientId: null,
      redirectUri: null,
      authorizationEndpoint: null,
      defaultUrlParams: ['response_type', 'client_id', 'redirect_uri'],
      requiredUrlParams: null,
      optionalUrlParams: null,
      scope: null,
      scopePrefix: null,
      scopeDelimiter: null,
      state: null,
      type: null,
      popupOptions: null,
      responseType: 'code',
      responseParams: {
        code: 'code',
        clientId: 'clientId',
        redirectUri: 'redirectUri'
      }
    });

});

myApp.run( function run () {
});


myApp.controller( 'AppCtrl', function AppCtrl ( $scope, $location, $auth, $state) {
  $scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
    if ( angular.isDefined( toState.data.pageTitle ) ) {
      $scope.pageTitle = toState.data.pageTitle ;
    }
  });
  $scope.isAuthenticated = function() {
        /*alert("Auth was called!!");*/
        return $auth.isAuthenticated();
  };
  $scope.logout = function() {
      $auth.logout();
      $state.go("login");
  };
});