var app = angular.module("famcoins", []);
app.controller("controller", function ($scope, $http) {
    $scope.readAmount = function ()
    {
        if ($scope.owner != "" && $scope.unit != "")
        {
            $http.get("api/amount/" + $scope.owner + "/" + $scope.unit)
                .then(function success (response) {
                    $scope.amount = String(response.data);
                }, function error (response) {
                    console.log(response.error);
                });
        }
    };

    $scope.owner = "Jonathan";
    $scope.unit = "Sachgeschichtengutschein";
    $scope.amount = "---";
    $scope.login = function () {
        $scope.readAmount();
    }

    $scope.removeValue = 0;
    $scope.remove = function ()
    {
        if ($scope.owner != "" && $scope.unit != "" && $scope.removeValue > 0)
        {
            $http.post("api/remove/" + $scope.owner + "/" + $scope.unit + "/" + $scope.removeValue)
                .then(function success (response) {
                    $scope.readAmount();
                }, function error (response) {
                    console.log(response.error);
                });
        }
    };
});