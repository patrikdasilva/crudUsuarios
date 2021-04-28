
	$('document').ready(function(){

		$('.table .btn-editar').on('click',function(event){
						
			var href = $(this).attr('href');
			
			$.get(href, function(usuario){
				$('#id').val(usuario.id);
				$('#nomeEdit').val(usuario.nome);
				$('#telefoneEdit').val(usuario.telefone);
				
				event.preventDefault();
			});
			
				$('#editModal').modal();
			
			});
		
	});

	$(function(){
    $('.td ').mousemove(function(){
        $(".btn-escond").css("display", "block")
    });
	
});
	$(function(){
		$('.td ').mouseout(function(){
			$(".btn-escond").css("display", "none")
		});
	});


