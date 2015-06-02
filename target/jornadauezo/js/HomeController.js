principal.controller('HomeController', function($scope, $http) { 
	$scope.$watch('matricula', function(oldValue, newValue) { 
		var matricula = $scope.matricula;

		var ano = formatarMatricula(matricula, 0, 2);
		if(ano)
			$scope.ano = ano;

		var semestre = formatarMatricula(matricula, 2, 3);
		if(semestre)
			$scope.semestre = semestre;

		var curso = formatarMatricula(matricula, 3, 6);
		if(curso)
			$scope.curso = curso;
				
	});
	
	$scope.manda = function() { 
		var usuario = {nome : $scope.nome};
		$http.post("usuario", usuario).success(function() { 
			alert('ok');
		});
		
		
	}
	
	
		
});

function formatarMatricula(matricula, min, max) {
	if(matricula && matricula.length == max) {
		var sub = matricula.substring(min, max);			
		return sub;
	}
}