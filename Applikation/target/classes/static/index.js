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
    
    $scope.transact1 = function (owner, unit, amount, action) {
        if (owner != "" && unit != "" && amount > 0)
        {
            $http.post("api/" + action + "/" + owner + "/" + unit + "/" + amount)
                .then(function success (response) {
                    $scope.readAmount();
                }, function error (response) {
                    console.log(response.error);
                });
        }
    };

    $scope.transact2 = function (from, to, amount, unit) {
        if (from != "" && to != "" && unit != "" && amount > 0)
        {
            $http.post("api/transfer/" + from + "/" + to + "/" + unit + "/" + amount)
                .then(function success (response) {
                    $scope.readAmount();
                }, function error (response) {
                    console.log(response.error);
                });
        }
    };

    $scope.owner = "";
    $scope.unit = "";
    $scope.amount = "---";

    $scope.selectedAction = "Bitte auswählen...";
    $scope.giveSelected = function () {
        alert($scope.selectedAction);
    };
    $scope.transact1Amount = 0;
    $scope.flexibleAction = function () {
        if ($scope.selectedAction == "Hinzufügen")
        {
            $scope.transact1($scope.owner, $scope.unit, $scope.transact1Amount, "add");
        }
        else if ($scope.selectedAction == "Abziehen")
        {
            $scope.transact1($scope.owner, $scope.unit, $scope.transact1Amount, "remove");
        }
        else alert("Fehler!");
    };

    $scope.newOwner = "";
    $scope.newUnit = "";
    $scope.createAccount = function () {
        $http.post ("/api/account", {
            "owner" : $scope.newOwner, 
            "unit" : $scope.newUnit
        }).then (function success (response) {
            console.log ("Account erstellt.");
            $scope.owner = $scope.newOwner;
            $scope.unit = $scope.newUnit;
            $scope.readAmount();
        }, function error (response) {
            console.log ("Account konnte nicht erstellt werden. ");
            console.log (response.error);
        });
    };

    $scope.transferFrom = "";
    $scope.transferTo = "";
    $scope.transferUnit = "";
    $scope.transferAmount = "";
    $scope.transfer = function() {
        console.log ("hit transfer");
        $scope.transact2 ($scope.transferFrom, $scope.transferTo, $scope.transferAmount, $scope.transferUnit);
    };
});