/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global results, buttonIn */
//var buttonIn = document.getElementById('button');
//function bookSearch() {
////console.log('This function runs');
//    var search = document.getElementById('search').value;
//    
//    document.getElementById('results').innerHTML = "";
//    console.log(search);
//
//    $.ajax({
//        url: "https://www.googleapis.com/books/v1/volumes?q=" + search,
//        dataType: "json",
//        success: function (data) {
//            console.log(data);
//            for (i = 0; i < 5; i++) {
//                results.innerHTML += '<h4>' + data.items[i].volumeInfo.title + '</h4>' +
//                        '<br></br>' +
//                        '<img src=' + '"' + data.items[i].volumeInfo.imageLinks.thumbnail + '"' + ' alt="blank" />' +
//                        '<br></br>' +
//                        '<p>' + '</p>';
//            }
//
//        },
//        type: 'GET'
//    }
//    );
//}
//buttonIn.addEventListener('click', bookSearch, false);
//angular.module('bookSearch').controller('bookController',
//[ '$scope', '$compile', 'Auth', 'Email','$location', '$http', '$document',
//				function($scope, $compile, Auth, Email, $location, $http, $document, $modalInstance) {
//                                    
//                                }

angular.module('manageBooks'.controller(
        'searchController', ['$scope', '$http', function ($scope, $http) {

        $scope.title;
        $scope.search = function (title) {
            var req = {
                method: 'GET',
                url: 'https://www.googleapis.com/books/v1/volumes?q=' + search,
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            $http(req).then(function (response) {
                //success callback

                if (response.status == 200 && !("Error" in response.data)) {

                    $scope.searchSuccess = true;
                    $scope.movieTitle = response.data.Title;

                } else {
                    alert("Error: Could not find the movie");
                    $scope.searchSuccess = false;

                }
            }, function (response) {
                //error callback
                alert("Error: Third party APIs are currently not reachable. ");
            });


        }
    }
]);