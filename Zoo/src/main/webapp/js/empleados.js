(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            method: 'GET',
            url: '/Zoo/api/empleados',
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                // División de la fila
                var nomEmpleado = $('<td>');
                nomEmpleado.text(data[i].nomEmpleado);
                var cargoEmpleado = $('<td>');
                cargoEmpleado.text(data[i].cargoEmpleado);

                var acciones = $('<td>');
                var botonEliminar = $('<button>').addClass('btn btn-danger');
                botonEliminar.text('Eliminar').attr('data-id', data[i].idCodEmpleado);
                botonEliminar.click(eliminar);
                var botonActualizar = $('<a href="/Zoo/crearEmpleados.html?id=' + data[i].idCodEmpleado + '">').addClass('btn btn-primary');
                botonActualizar.text('Actualizar');

                acciones.append(botonEliminar);
                acciones.append(botonActualizar);

                tableRow.append(nomEmpleado);
                tableRow.append(cargoEmpleado);
                tableRow.append(acciones);

                $('#tableEmpleados table tbody').append(tableRow);
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

    function eliminar(event) {
        $.ajax({
            method: 'DELETE',
            url: '/Zoo/api/empleados/' + $(this).attr('data-id'),
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