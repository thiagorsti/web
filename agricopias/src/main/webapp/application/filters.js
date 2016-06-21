app.filter('yesNo', function() {
    return function(input) {
        return input ? 'Sim' : 'Não';
    };
}).

filter('tipoPessoa', function(){
	return function(input) {
		return input === 'FISICA' ? 'Pessoa Física' : input === 'JURIDICA' ? 'Pessoa Jurídica' : '';
	};
});