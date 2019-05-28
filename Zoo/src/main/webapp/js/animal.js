(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            method: 'GET',
            url: '/zoo/api/animales',
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                // División de la fila
                var nombreEmpleado = $('<td>');
                nomAnimal.tex(data[i].nomAnimal);
                var nomCienfitico = $('<td>');
                nomCienfitico.text(data[i].nomCienfitico);
                var especie = $('<td>');
                especie.text(data[i].especie);
                var tipoAnimal = $('<td>');
                tipoAnimal.text(data[i].tipoAnimal);
                var descripcion = $('<td>');
                descripcion.text(data[i].descripcion);

                var acciones = $('<td>');
                var botonEliminar = $('<button>').addClass('btn btn-danger');
                botonEliminar.text('Eliminar').attr('data-id', data[i].id);
                botonEliminar.click(eliminar);
                var botonActualizar = $('<a href="/Zoo/crearAnimal.html?id=' + data[i].id + '">').addClass('btn btn-primary');
                botonActualizar.text('Actualizar');

                acciones.append(botonEliminar);
                acciones.append(botonActualizar);

                tableRow.append(nomAnimal);
                tableRow.append(nomCienfitico);
                tableRow.append(especie);
                tableRow.append(tipoAnimal);
                tableRow.append(descripcion);
                tableRow.append(acciones);

                $('#tableAnimales table tbody').append(tableRow);
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

    function eliminar(event) {
        $.ajax({
            method: 'DELETE',
            url: '/Zoo/api/animales/' + $(this).attr('data-id'),
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