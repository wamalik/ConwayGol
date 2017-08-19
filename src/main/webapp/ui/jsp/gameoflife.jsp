<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="golApp">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Conway's Game of Life</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-beta.2/angular-sanitize.js"></script>
    <script src="ui/js/gol.js"></script>
</head>
<body ng-app="golApp">

<div class="bs-component" ng-controller="golController">

    <div>
        <center>
            Please enter the number of Generations:<input type="text" placeholder="generations" ng-model="nbrOfGen">
            <input type="button" value="play" ng-click="playGame()"/>
        </center>
    </div>
    <div ng-repeat="x in generations">
        <center>
           <h1> {{x.num}} </h1>
            <table border="1">
                <tr >
                    <td ng-bind-html="x.view"></td>
                </tr>
            </table>
        <p ng-bind-html="content">

        </p>
        </center>
    </div>

</div>





</body>
</html>