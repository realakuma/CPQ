//inject angular file upload directives and services.
var app = angular.module('fileUpload', ['ngFileUpload']);

app.controller('MyCtrl', ['$scope', 'Upload', '$timeout', function ($scope, Upload, $timeout) {
    $scope.uploadPic = function(file) {
    	$scope.returnMsg="上传中......";
    file.upload = Upload.upload({
      url: '/upload',
      data: {username: $scope.username, file: file},
    });
    
    file.start="start";

    file.upload.then(function (response) {
      $timeout(function () {
        file.result = response.data;
        $scope.returnMsg="上传成功!!! 访问连接为"+response.data.result;
      });
    }, function (response) {
      if (response.status > 0)
        $scope.errorMsg = response.status + ': ' + response.data;
    }, function (evt) {
      // Math.min is to fix IE which reports 200% sometimes
      file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
    });
    }
}]);