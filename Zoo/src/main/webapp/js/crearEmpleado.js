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

    if (getUrlParameter('id{')){
        $.ajax({
            method: 'GET',
            url: '/Zoo/api/empleados/' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            var nomEmpleado = $('#nomEmpleado').val(data.nomEmpleado);
            var cargoEmpleado = $('#cargoEmpleado').val(data.cargoEmpleado);
            var id = data.id;
            $('#crearBoton').text("Actualizar").click(function (event) {
                var nomEmpleado1 = $('#nomEmpleado').val();
                var cargoEmpleado1 = $('#cargoEmpleado').val();
                $.ajax({
                    method: 'PUT',
                    url: '/Zoo/api/empleados/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        id:id,
                        nomEmpleado: nomEmpleado1,
                        cargoEmpleado: cargoEmpleado1                       
                    })
                }).done(function (data) {
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
            var nomEmpleado = $('#nomEmpleado').val();
            var cargoEmpleado = $('#cargoEmpleado').val();
            $.ajax({
                method: 'POST',
                url: '/Zoo/api/empleados',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                    nomEmpleado: nomEmpleado,
                    cargoEmpleado: cargoEmpleado
                })
            }).done(function (data) {
                window.location.href = '/Zoo';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);