(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            method: 'GET',
            url: '/zoo/api/lugar',
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                // División de la fila
                var nombre = $('<td>');
                nombre.tex(data[i].nombre);

                var acciones = $('<td>');
                var botonEliminar = $('<button>').addClass('btn btn-danger');
                botonEliminar.text('Eliminar').attr('data-id', data[i].id);
                botonEliminar.click(eliminar);
                var botonActualizar = $('<a href="/zoo/crearLugar.html?id=' + data[i].id + '">').addClass('btn btn-primary');
                botonActualizar.text('Actualizar');

                acciones.append(botonEliminar);
                acciones.append(botonActualizar);

                tableRow.append(nombre);
                tableRow.append(acciones);

                $('#tableLugar table tbody').append(tableRow);
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });
    
        function eliminar(event) {
        $.ajax({
            method: 'DELETE',
            url: '/Zoo/api/lugar/' + $(this).attr('data-id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            console.log("Elemento eliminado");
            window.location.reload();
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    }
})(jQuery);