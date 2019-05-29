(function ($) {
    var getUrlParameter = function getUrlParameter(sParam) {
        var sPageURL = decodeURIComponent(window.location.search.substring(1)),
                sURLVariables = sPageURL.split('&'),
                sParameterName,
                i;
        for (i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split('=');
            if (sParameterName[0] === sParam) {
                return sParameterName [1] === undefined ? true : sParameterName[1];
            }
        }
    };

    if (getUrlParameter('id{')) {
        $.ajax({
            method: 'GET',
            url: '/zoo/api/animales/' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            var nomAnimal = $('#nomAnimal').val(data.nomAnimal);
            var nomCientifico = $('#nomCientifico').val(data.nomCientifico);
            var especie = $('#especie').val(data.especie);
            var tipoAnimal = $('#tipoAnimal').val(data.tipoAnimal);
            var descripcion = $('#descripcion').val(data.descripcion);
            var id = data.id;
            $('#crearBoton').text("Actualizar").click(function (event) {

                var nomAnimal1 = $('#nomAnimal').val(data.nomAnimal);
                var nomCientifico1 = $('#nomCientifico').val(data.nomCientifico);
                var especie1 = $('#especie').val(data.especie);
                var tipoAnimal1 = $('#tipoAnimal').val(data.tipoAnimal);
                var descripcion1 = $('#descripcion').val(data.descripcion);

                $.ajax({
                    method: 'PUT',
                    url: '/Zoo/api/animales/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        id: id,
                        nomAnimal: nomAnimal1,
                        nomCientifico: nomCientifico1,
                        especie : especie1,
                        tipoAnimal :tipoAnimal1,
                        descripcion :descripcion1
                    })
                }).done(function (data) {
                    console.log(data);
                    window.location.href = '/Zoo';
                }).fail(function (xhr, status, error) {
                    console.log.error;
                });
            });

        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#crearBoton').click(function (event) {
            var nomAnimal = $('#nomAnimal').val();
            var nomCientifico = $('#nomCientifico').val();
            var especie = $('#especie').val();
            var tipoAnimal = $('#tipoAnimal').val();
            var descripcion = $('#descripcion').val();
            $.ajax({
                method: 'POST',
                url: '/Zoo/api/animales',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                    nomCientifico: nomCientifico,
                    nomAnimal: nomAnimal,
                    especie: especie,
                    tipoAnimal: tipoAnimal,
                    descripcion: descripcion
                })
            }).done(function (data) {
                console.log(data);
                console.log(data.especie);
                console.log(data.nomCientifico);    
                //window.location.href = '/Zoo';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    };
    
})(jQuery);